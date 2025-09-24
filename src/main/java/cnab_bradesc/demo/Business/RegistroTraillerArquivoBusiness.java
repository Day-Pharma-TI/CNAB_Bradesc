package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.Registros.RegistroTraillerArquivo;
import cnab_bradesc.demo.Utils.ConstantesUtil;

public class RegistroTraillerArquivoBusiness {

    public RegistroTraillerArquivo criaTrailerArquivo(){
        RegistroTraillerArquivo regTraillerArquivo = new RegistroTraillerArquivo();

        regTraillerArquivo.setCodigoBanco(ConstantesUtil.CODIGO_CONVENIO_BANCO);
        regTraillerArquivo.setLoteServico("9999");
        regTraillerArquivo.setTipoRegistro("9");

        return regTraillerArquivo ;
    }
}