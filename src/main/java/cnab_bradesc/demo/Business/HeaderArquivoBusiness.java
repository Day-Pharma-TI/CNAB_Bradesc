package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.Registros.HeaderArquivo;
import cnab_bradesc.demo.Utils.ConstantesUtil;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class HeaderArquivoBusiness {

    public HeaderArquivo gerarHearArquivo(){
        HeaderArquivo headerArquivo = new HeaderArquivo();

        headerArquivo.setBanco(ConstantesUtil.CODIGO_BANCO);
        headerArquivo.setLote("0000");
        headerArquivo.setRegistro(0);
        headerArquivo.setTipoInscricaoEmpresa(ConstantesUtil.TIPO_INSCRICAO_EMRPESA);
        headerArquivo.setNumeroDeInscricaoEmpresa(ConstantesUtil.CNPJ_EMPRESA);
        headerArquivo.setCodigoConvenioBanco(ConstantesUtil.CODIGO_CONVENIO_BANCO);
        headerArquivo.setAgenciaMantedoraDaConta(ConstantesUtil.AGENCIA_CONTA_EMPRESA);
        headerArquivo.setDigitoVerificadorDaAgencia(ConstantesUtil.DIGITO_VERIFICADOR_AGENCIA_EMPRESA);
        headerArquivo.setNumeroDaContaCorrente(ConstantesUtil.CONTA_CORRENTE_EMPRESA);
        headerArquivo.setDigitoVerificadorDaConta(ConstantesUtil.DIGITO_VERIFICADOR_CONTA_EMPRESA);
        headerArquivo.setDigitoVerificadorDaAgOuConta(" "); // 1 espaco em branco
        headerArquivo.setNomeDaEmpresa(ConstantesUtil.NOME_EMPRESA);
        headerArquivo.setNomeDoBanco(ConstantesUtil.NOME_BANCO);
        headerArquivo.setCodigoRemessaRetorno(1);
        headerArquivo.setDataGeracaoArquivo(LocalDateTime.now());
        headerArquivo.setHoraDeGeracaoArquivo(LocalDateTime.now());
        headerArquivo.setNumeroSequencialArquvivo("000016");
        headerArquivo.setVersaoLayoutArquivo(ConstantesUtil.VERSAO_LEAYOUT_HEADER_ARQUIVO);
        headerArquivo.setDensidade(ConstantesUtil.DENSIDADE_ARQUIVO);
        headerArquivo.setReservadoBanco(ConstantesUtil.RESERVADO_BANCO);

        return headerArquivo;
    }
}
