package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.DTO.RegistroSegmentoABDTO;
import cnab_bradesc.demo.Registros.RegistroDetalheSegmentoA;
import cnab_bradesc.demo.Registros.RegistroDetalheSegmentoB;
import cnab_bradesc.demo.Utils.ConstantesUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegistroDetalheSegmentosBusiness {

    public List<RegistroSegmentoABDTO> geraRegistroDeSegmentoAb() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione o arquivo excel");

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos Excel (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filtro);

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

        File arquivoSelecionado = fileChooser.getSelectedFile();

        if (!arquivoSelecionado.getName().toLowerCase().endsWith(".xlsx")) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo .xlsx valido!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }

        // Perguntar uma vez só
        String[] options = {"Pagamento", "Adiantamento"};
        int escolha = JOptionPane.showOptionDialog(
                null,
                "Selecionar o tipo de operação",
                "Tipo de operação",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        boolean isPagamento = (escolha == 0); // true se Pagamento, false se Adiantamento

        List<RegistroSegmentoABDTO> listRegistrosSegmentoAeB = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream fis = new FileInputStream(arquivoSelecionado);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // primeira aba
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            int numeroSequencial = 1;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // começa em 1 para pular o cabeçalho
                Row row = sheet.getRow(i);
                if (row == null) continue;

                RegistroSegmentoABDTO registroSegmentoDTO = new RegistroSegmentoABDTO();

                RegistroDetalheSegmentoA segmentoA = criaRegistroSegmentoA(row, numeroSequencial, formatter, evaluator, isPagamento);
                numeroSequencial++;

                RegistroDetalheSegmentoB segmentoB = criaRegistroDetalheSegmentoB(row, numeroSequencial, formatter, evaluator);
                numeroSequencial++;

                registroSegmentoDTO.setSegmentoA(segmentoA);
                registroSegmentoDTO.setSegmentoB(segmentoB);

                listRegistrosSegmentoAeB.add(registroSegmentoDTO);

            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o arquivo Excel", e);
        }

        return listRegistrosSegmentoAeB;
    }

    private RegistroDetalheSegmentoA criaRegistroSegmentoA(Row row, int numeroSequencial, DataFormatter formatter, FormulaEvaluator evaluator, boolean isPagamento) {
        RegistroDetalheSegmentoA segA = new RegistroDetalheSegmentoA();

        segA.setCodigoBanco(ConstantesUtil.CODIGO_BANCO);
        segA.setLote(ConstantesUtil.LOTE_PADRAO);
        segA.setTipoRegistro(ConstantesUtil.TIPO_REGISTRO_DETALHE);
        segA.setNumeroSequencialRegistro(String.format("%05d", numeroSequencial));
        segA.setCodigoSegmento(ConstantesUtil.CODIGO_SEGMENTO_A);
        segA.setTipoMovimento(0);
        segA.setCodigoInstrucaoMovimento("00");
        segA.setCodigoCamaraCentralizadora("000");
        segA.setCodigoBancoFavorecido(ConstantesUtil.CODIGO_BANCO);


        String agencia = formatter.formatCellValue(row.getCell(14), evaluator).replaceAll("\\D", "");
        segA.setAgencia(String.format("%05d", agencia.isEmpty() ? 0 : Long.parseLong(agencia)));

        String digitoAgencia = formatter.formatCellValue(row.getCell(17), evaluator);
        segA.setDigitoAgencia(digitoAgencia);

        String numeroConta = formatter.formatCellValue(row.getCell(15), evaluator).replaceAll("\\D", "");
        segA.setNumeroContaCorrente(String.format("%012d", numeroConta.isEmpty() ? 0 : Long.parseLong(numeroConta)));

        String digitoConta = formatter.formatCellValue(row.getCell(18), evaluator);
        segA.setDigitoConta(digitoConta);

        segA.setDigitoAgenciaConta(" ");

        String nomeFavorecido = formatter.formatCellValue(row.getCell(4), evaluator);
        segA.setNomeFavorecido(String.format("%-30s", nomeFavorecido));

        segA.setSeuNumero(String.format("%-20s", "PAG SALARIO"));

        Cell cellPagamento = row.getCell(16);
        String dataPagamento;
        if (cellPagamento != null) {
            if (cellPagamento.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cellPagamento)) {
                Date date = cellPagamento.getDateCellValue();
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                dataPagamento = sdf.format(date);
            } else {
                dataPagamento = formatter.formatCellValue(cellPagamento, evaluator).replaceAll("[^0-9]", "");
            }
        } else {
            dataPagamento = "";
        }
        segA.setDataPagamento(String.format("%8s", dataPagamento));

        segA.setTipoMoeda(ConstantesUtil.TIPO_MOEDA);
        String quantidadeMoeda = String.format("%015d", 0);
        segA.setQuantidadeMoeda(quantidadeMoeda);

        // Aqui decide a célula do valor conforme a escolha
        Cell cellValorPag = isPagamento ? row.getCell(12) : row.getCell(7);

        String valorPag;
        if (cellValorPag != null) {
            CellValue eval = evaluator.evaluate(cellValorPag);
            if (eval != null && eval.getCellType() == CellType.NUMERIC) {
                double valor = eval.getNumberValue();
                long emCentavos = Math.round(valor * 100);
                valorPag = String.format("%015d", emCentavos);
            } else {
                String valorStr = formatter.formatCellValue(cellValorPag, evaluator).replaceAll("[^0-9,]", "").replace(",", ".");
                try {
                    double valor = Double.parseDouble(valorStr);
                    long emCentavos = Math.round(valor * 100);
                    valorPag = String.format("%015d", emCentavos);
                } catch (NumberFormatException e) {
                    valorPag = "000000000000000";
                }
            }
        } else {
            valorPag = "000000000000000";
        }

        segA.setValorPagamento(valorPag);
        segA.setNossoNumero(segA.getNossoNumero());
        segA.setDataEfetivacaoPagamento(segA.getDataEfetivacaoPagamento());
        segA.setValorRealEfetivacaoPagamento(segA.getValorRealEfetivacaoPagamento());
        segA.setAvisoFavorecido(0);

        return segA;
    }

    private RegistroDetalheSegmentoB criaRegistroDetalheSegmentoB(Row row, int numeroSequencial, DataFormatter formatter, FormulaEvaluator evaluator) {
        RegistroDetalheSegmentoB registroB = new RegistroDetalheSegmentoB();

        registroB.setCodigoBanco(ConstantesUtil.CODIGO_BANCO);
        registroB.setLote(ConstantesUtil.LOTE_PADRAO);
        registroB.setTipoRegistro(ConstantesUtil.TIPO_REGISTRO_DETALHE);
        registroB.setNumeroSequencialRegistro(String.format("%05d", numeroSequencial));
        registroB.setCodigoSegmento(ConstantesUtil.CODIGO_SEGMENTO_B);
        registroB.setTipoInscricaoFavorecido("1");

        String cpfDeQuemRecebeu = formatter.formatCellValue(row.getCell(13), evaluator).replaceAll("\\D", "");
        registroB.setNumeroInscricaoFavorecido(String.format("%014d", cpfDeQuemRecebeu.isEmpty() ? 0 : Long.parseLong(cpfDeQuemRecebeu)));

        Cell cellVencimento = row.getCell(16);
        String dataVencimento;
        if (cellVencimento != null) {
            if (cellVencimento.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cellVencimento)) {
                Date date = cellVencimento.getDateCellValue();
                SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                dataVencimento = sdf.format(date);
            } else {
                dataVencimento = formatter.formatCellValue(cellVencimento, evaluator).replaceAll("[^0-9]", "");
            }
        } else {
            dataVencimento = "";
        }
        registroB.setDataVencimento(String.format("%8s", dataVencimento));

        return registroB;
    }
}