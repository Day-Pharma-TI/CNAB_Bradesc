package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.Registros.RegistroTrailerLote;
import cnab_bradesc.demo.Utils.ConstantesUtil;
import org.springframework.stereotype.Service;

@Service
public class RegistroTrailerLoteBusiness {

    public RegistroTrailerLote geraTraillerLote(){
       RegistroTrailerLote registroTrailerArquivo = new RegistroTrailerLote();

        registroTrailerArquivo.setCodigoBanco(ConstantesUtil.CODIGO_BANCO);
        registroTrailerArquivo.setLote("0001");
        registroTrailerArquivo.setTipoRegistro(5);

        return registroTrailerArquivo;
    }
}
