package cnab_bradesc.demo.Utils;

import cnab_bradesc.demo.DTO.RegistroSegmentoABDTO;
import cnab_bradesc.demo.Registros.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CnabGeraArquivoTxt {

    private static final Logger log = LoggerFactory.getLogger(CnabGeraArquivoTxt.class);

    public void gerarArquivoTxt(HeaderArquivo header, HeaderLote headerLote, List<RegistroSegmentoABDTO> registros, RegistroTrailerLote registroTrailerLote) {

        StringBuilder arquivoFinal = new StringBuilder();

        StringBuilder headerArquivoTxt = montaHeaderArquivo(header);
        StringBuilder headerLoteTxt = montaHeaderLote(headerLote);
        StringBuilder detalhes = montaDetalhesSegmentos(registros);
        StringBuilder trailerLoteTxt = montaTrailerLote(registroTrailerLote, registros);

        int qtdRegistros = 1+1 + (registros.size() * 2 ) + 1 + 1;

        StringBuilder trailerArquivoTxt = montaTrailerArquivo(
                1,
                qtdRegistros,
                0
        );

        arquivoFinal.append(headerArquivoTxt).append("\n")
                .append(headerLoteTxt).append("\n")
                .append(detalhes)
                .append(trailerLoteTxt).append("\n")
                .append(trailerArquivoTxt);

        salvarEmArquivoTxt(arquivoFinal);
    }

    public StringBuilder montaHeaderArquivo(HeaderArquivo header){

        StringBuilder headerArquivoTxtLinha = new StringBuilder();

        headerArquivoTxtLinha.append(String.format("%03d", header.getBanco()));
        headerArquivoTxtLinha.append(String.format("%04d", Integer.parseInt(header.getLote())));
        headerArquivoTxtLinha.append(String.format("%01d", header.getRegistro()));
        headerArquivoTxtLinha.append(header.getNoveEspacos());
        headerArquivoTxtLinha.append(String.format("%01d", header.getTipoInscricaoEmpresa()));
        headerArquivoTxtLinha.append(String.format("%014d", Long.parseLong(header.getNumeroDeInscricaoEmpresa())));
        headerArquivoTxtLinha.append(String.format("%-20s", header.getCodigoConvenioBanco()));
        headerArquivoTxtLinha.append(String.format("%05d", Integer.parseInt(header.getAgenciaMantedoraDaConta())));
        headerArquivoTxtLinha.append(String.format("%1s", header.getDigitoVerificadorDaAgencia()));
        headerArquivoTxtLinha.append(String.format("%012d", Long.parseLong(header.getNumeroDaContaCorrente())));
        headerArquivoTxtLinha.append(String.format("%1s", header.getDigitoVerificadorDaConta()));
        headerArquivoTxtLinha.append(String.format("%1s", header.getDigitoVerificadorDaAgOuConta()));
        headerArquivoTxtLinha.append(String.format("%-30s", header.getNomeDaEmpresa()));
        headerArquivoTxtLinha.append(String.format("%-30s", header.getNomeDoBanco()));
        headerArquivoTxtLinha.append(header.getDezEspacos());
        headerArquivoTxtLinha.append(String.format("%01d", header.getCodigoRemessaRetorno()));
        headerArquivoTxtLinha.append(header.getDataGeracaoArquivo().format(DateTimeFormatter.ofPattern("ddMMyyyy")));
        headerArquivoTxtLinha.append(header.getHoraDeGeracaoArquivo().format(DateTimeFormatter.ofPattern("HHmmss")));
        headerArquivoTxtLinha.append(String.format("%06d", Integer.parseInt(header.getNumeroSequencialArquvivo())));
        headerArquivoTxtLinha.append(String.format("%03d", Integer.parseInt(header.getVersaoLayoutArquivo())));
        headerArquivoTxtLinha.append(String.format("%05d", Integer.parseInt(header.getDensidade())));
        headerArquivoTxtLinha.append(String.format("%-20s", header.getReservadoBanco()));
        headerArquivoTxtLinha.append(String.format("%-20s", header.getReservadoEmpresa()));
        headerArquivoTxtLinha.append(header.getEspacoFinal());

        return headerArquivoTxtLinha;
    }

    public StringBuilder montaHeaderLote(HeaderLote headerLote){

        StringBuilder headerLoteTxtLinha = new StringBuilder();

        headerLoteTxtLinha.append(String.format("%03d", headerLote.getBanco()));
        headerLoteTxtLinha.append(headerLote.getLote());
        headerLoteTxtLinha.append(String.format("%01d", headerLote.getTipoRegistro()));
        headerLoteTxtLinha.append(String.format("%1s", headerLote.getTipoOperacao()));
        headerLoteTxtLinha.append(String.format("%02d", headerLote.getTipoServico()));
        headerLoteTxtLinha.append(headerLote.getFormaLancamento());
        headerLoteTxtLinha.append(headerLote.getVersaoLayoutLote());
        headerLoteTxtLinha.append(headerLote.getCnab1());
        headerLoteTxtLinha.append(String.format("%01d", headerLote.getTipoInscricaoEmpresa()));
        headerLoteTxtLinha.append(String.format("%014d", Long.parseLong(headerLote.getNumeroInscricaoEmpresa())));
        headerLoteTxtLinha.append(String.format("%-20s", headerLote.getCodigoConvenio()));
        headerLoteTxtLinha.append(String.format("%05d", Integer.parseInt(headerLote.getAgencia())));
        headerLoteTxtLinha.append(String.format("%1s", headerLote.getDigitoAgencia()));
        headerLoteTxtLinha.append(String.format("%012d", Long.parseLong(headerLote.getContaCorrente())));
        headerLoteTxtLinha.append(String.format("%1s", headerLote.getDigitoConta()));
        headerLoteTxtLinha.append(String.format("%1s", headerLote.getDigitoAgenciaConta()));
        headerLoteTxtLinha.append(String.format("%-30s", headerLote.getNomeEmpresa()));
        headerLoteTxtLinha.append(String.format("%-40s", headerLote.getMensagem()));
        headerLoteTxtLinha.append(String.format("%-30s", headerLote.getLogradouro()));
        headerLoteTxtLinha.append(String.format("%05d", Integer.parseInt(headerLote.getNumeroEndereco())));
        headerLoteTxtLinha.append(String.format("%-15s", headerLote.getComplemento()));
        headerLoteTxtLinha.append(String.format("%-20s", headerLote.getCidade()));
        headerLoteTxtLinha.append(String.format("%05d", Integer.parseInt(headerLote.getCep())));
        headerLoteTxtLinha.append(String.format("%-3s", headerLote.getComplementoCep()));
        headerLoteTxtLinha.append(String.format("%-2s", headerLote.getEstado()));
        headerLoteTxtLinha.append(headerLote.getIndicativoFormaPagamento());
        headerLoteTxtLinha.append(headerLote.getCnab2());
        headerLoteTxtLinha.append(String.format("%-10s", headerLote.getOcorrencias()));

        return headerLoteTxtLinha;
    }

    public StringBuilder montaDetalhesSegmentos(List<RegistroSegmentoABDTO> registros) {
        StringBuilder detalhes = new StringBuilder();

        for (RegistroSegmentoABDTO r : registros) {
            RegistroDetalheSegmentoA segA = r.getSegmentoA();
            RegistroDetalheSegmentoB segB = r.getSegmentoB();

            StringBuilder linhaSegA = new StringBuilder();
            linhaSegA.append(segA.getCodigoBanco());
            linhaSegA.append(segA.getLote());
            linhaSegA.append(segA.getTipoRegistro());
            linhaSegA.append(segA.getNumeroSequencialRegistro());
            linhaSegA.append(segA.getCodigoSegmento());
            linhaSegA.append(segA.getTipoMovimento());
            linhaSegA.append(segA.getCodigoInstrucaoMovimento());
            linhaSegA.append(segA.getCodigoCamaraCentralizadora());
            linhaSegA.append(segA.getCodigoBancoFavorecido());
            linhaSegA.append(segA.getAgencia());
            linhaSegA.append(segA.getDigitoAgencia());
            linhaSegA.append(segA.getNumeroContaCorrente());
            linhaSegA.append(segA.getDigitoConta());
            linhaSegA.append(segA.getDigitoAgenciaConta());
            linhaSegA.append(segA.getNomeFavorecido());
            linhaSegA.append(segA.getSeuNumero());
            linhaSegA.append(segA.getDataPagamento());
            linhaSegA.append(segA.getTipoMoeda());
            linhaSegA.append(segA.getQuantidadeMoeda());
            linhaSegA.append(segA.getValorPagamento());
            linhaSegA.append(segA.getNossoNumero());
            linhaSegA.append(segA.getDataEfetivacaoPagamento());
            linhaSegA.append(segA.getValorRealEfetivacaoPagamento());
            linhaSegA.append(segA._GET52SPACE());
            linhaSegA.append(segA.getAvisoFavorecido());
            linhaSegA.append(segA._GET10SPACE());

            detalhes.append(linhaSegA).append("\n");

            StringBuilder linhaSegB = new StringBuilder();
            linhaSegB.append(segB.getCodigoBanco());
            linhaSegB.append(segB.getLote());
            linhaSegB.append(segB.getTipoRegistro());
            linhaSegB.append(segB.getNumeroSequencialRegistro());
            linhaSegB.append(segB.getCodigoSegmento());
            linhaSegB.append("   "); // 3 espaços em branco
            linhaSegB.append(segB.getTipoInscricaoFavorecido());
            linhaSegB.append(segB.getNumeroInscricaoFavorecido());
            linhaSegB.append(segB._GET85BRANCO());
            linhaSegB.append(segB._CEP());
            linhaSegB.append(segB._COMPLECEP());
            linhaSegB.append(segB.getDataVencimento());
            linhaSegB.append(segB._GET97ZEROCOMPLET());
            linhaSegB.append(segB._GET8BRANCO());

            detalhes.append(linhaSegB).append("\n");
        }

        return detalhes;
    }

    public StringBuilder montaTrailerLote(RegistroTrailerLote registroTrailerLote, List<RegistroSegmentoABDTO> registros) {
        StringBuilder trailer = new StringBuilder();

        long somaValores = registros.stream()
                .mapToLong(r -> Long.parseLong(r.getSegmentoA().getValorPagamento()))
                .sum();

        String somatoriaValoresFormatada = String.format("%018d", somaValores);

        trailer.append(registroTrailerLote.getCodigoBanco());
        trailer.append(registroTrailerLote.getLote());
        trailer.append(registroTrailerLote.getTipoRegistro());
        trailer.append(registroTrailerLote._GET9BRANCOS());

        int qtdLote = calculaQtdRegistrosDoLote(registros);
        trailer.append(String.format("%06d", qtdLote));
        trailer.append(somatoriaValoresFormatada);
        trailer.append(registroTrailerLote._GET24ZEROS());
        trailer.append(registroTrailerLote._GET176BRANCOS());

        return trailer;
    }

    public StringBuilder montaTrailerArquivo(int qtdLotes, int qtdRegistros, int qtdContas) {
        StringBuilder trailerArquivo = new StringBuilder();

        trailerArquivo.append(ConstantesUtil.CODIGO_BANCO); // Código do banco
        trailerArquivo.append("9999"); // Lote de serviço
        trailerArquivo.append("9");    // Tipo de registro
        trailerArquivo.append("         "); // 9 espaços
        trailerArquivo.append(String.format("%06d", qtdLotes));
        trailerArquivo.append(String.format("%06d", qtdRegistros));
        trailerArquivo.append(String.format("%06d", qtdContas)); // geralmente 000000
        trailerArquivo.append(String.format("%-205s", ""));
        trailerArquivo.append("\n"); // completa com espaços

        return trailerArquivo;
    }

    public int calculaQtdRegistrosDoLote(List<RegistroSegmentoABDTO> registros) {
        return 1 + (registros.size() * 2) + 1;
    }

    public void salvarEmArquivoTxt(StringBuilder conteudo) {

        File arquivo = cnab_bradesc.demo.View.SalvaArquivoView.escolherLocalSalvar();

        if(arquivo == null){
            log.info("Usuario cancelou a escolha do arquivo");
            return;
        }


        // Escreve no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write(conteudo.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("Arquivo salvo com sucesso em: {}", arquivo.getAbsolutePath());
    }
}
