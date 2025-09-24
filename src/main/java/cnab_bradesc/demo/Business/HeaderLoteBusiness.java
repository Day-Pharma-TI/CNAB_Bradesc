package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.Registros.HeaderLote;
import cnab_bradesc.demo.Utils.ConstantesUtil;
import org.springframework.stereotype.Service;

@Service
public class HeaderLoteBusiness {

    public HeaderLote gerarHeaderLote(){
    HeaderLote headerLote = new HeaderLote();

        headerLote.setBanco(ConstantesUtil.CODIGO_BANCO);
        headerLote.setLote("0001");
        headerLote.setTipoRegistro(1);
        headerLote.setTipoOperacao("C");
        headerLote.setTipoServico(30);
        headerLote.setFormaLancamento("01");
        headerLote.setVersaoLayoutLote("045");
        headerLote.getCnab1();
        headerLote.setTipoInscricaoEmpresa(2);
        headerLote.setNumeroInscricaoEmpresa(ConstantesUtil.CNPJ_EMPRESA);
        headerLote.setCodigoConvenio(ConstantesUtil.CODIGO_CONVENIO_BANCO);
        headerLote.setAgencia(ConstantesUtil.AGENCIA_CONTA_EMPRESA);
        headerLote.setDigitoAgencia("0");
        headerLote.setContaCorrente(ConstantesUtil.CONTA_CORRENTE_EMPRESA);
        headerLote.setDigitoConta("7");
        headerLote.setDigitoAgenciaConta(" ");
        headerLote.setNomeEmpresa(ConstantesUtil.NOME_EMPRESA);
        headerLote.setMensagem(ConstantesUtil.PAGAMENTO_SALARIO_TITLE);
        headerLote.setLogradouro(ConstantesUtil.LOGRADOURO_EMPRESA);
        headerLote.setNumeroEndereco(ConstantesUtil.NUMERO_ED_EMPRESA);
        headerLote.getComplemento();
        headerLote.setCidade(ConstantesUtil.CIDADE_EMPRESA);
        headerLote.setCep(ConstantesUtil.CEP_EMPRESA);
        headerLote.setComplementoCep(ConstantesUtil.COMPLEMENTO_CEP);
        headerLote.setEstado(ConstantesUtil.UF_ESTADO);
        headerLote.setIndicativoFormaPagamento("01");
        headerLote.getCnab2();
        headerLote.getOcorrencias();

        return headerLote;
    }
}
