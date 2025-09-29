package cnab_bradesc.demo.Business.implement;

import cnab_bradesc.demo.Business.CnabFolhaPagamentoBusiness;
import cnab_bradesc.demo.DTO.RegistroSegmentoABDTO;
import cnab_bradesc.demo.Registros.RegistroDetalheSegmentoA;
import cnab_bradesc.demo.Registros.RegistroDetalheSegmentoB;
import cnab_bradesc.demo.Utils.ConstantesUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CnabFolhaPagamentoBusinessImpl implements CnabFolhaPagamentoBusiness {

    @Override
    public List<RegistroSegmentoABDTO> geraRegistroDeSegmento(MultipartFile file, boolean tipoPagamento) {

        String nomeArquivo = file.getOriginalFilename();

        if (nomeArquivo == null || !nomeArquivo.toLowerCase().endsWith(".xls")) {
            System.out.println("Arquivo incorreto");
        }

        List<RegistroSegmentoABDTO> listRegistrosSegmentoAeB = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())){

            Sheet sheet = workbook.getSheetAt(0); // primeira aba
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

            int numeroSequencial = 1;

            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // começa em 1 para pular o cabeçalho
                Row row = sheet.getRow(i);
                if (row == null) continue;

                RegistroSegmentoABDTO registroSegmentoDTO = new RegistroSegmentoABDTO();

                RegistroDetalheSegmentoA segmentoA = criaRegistroSegmentoA(row, numeroSequencial, formatter, evaluator, tipoPagamento);
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
            dataPagamento = "Erro ao formatar a data de pagamento";
        }
        segA.setDataPagamento(String.format("%8s", dataPagamento));

        segA.setTipoMoeda(ConstantesUtil.TIPO_MOEDA);
        String quantidadeMoeda = String.format("%015d", 0);
        segA.setQuantidadeMoeda(quantidadeMoeda);


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
                    valorPag = "erro ao extrair o valor";
                }
            }
        } else {
            valorPag = "erro ao extrair o valor";
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
            dataVencimento = "Erro ao formatar a data de vencimento";
        }
        registroB.setDataVencimento(String.format("%8s", dataVencimento));

        return registroB;
    }

}
