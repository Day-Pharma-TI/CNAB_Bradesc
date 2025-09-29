package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.Registros.HeaderArquivo;
import cnab_bradesc.demo.Registros.HeaderLote;
import cnab_bradesc.demo.Registros.RegistroTrailerLote;
import cnab_bradesc.demo.Utils.CnabGeraArquivoTxt;
import org.springframework.stereotype.Service;

@Service
public class GeraCnabPagamentoBusiness {

    private final HeaderArquivoBusiness geraHeaderArquivoBusiness;
    private final HeaderLoteBusiness gerarHeaderLoteBusiness;
    private final CnabFolhaPagamentoBusiness geraCnabFolhaPagamentoBusiness;
    private final RegistroTrailerLoteBusiness geraRegistroTrailerLoteBusiness;
    private final CnabGeraArquivoTxt gerarCnabGeraArquivoTxt;

    public GeraCnabPagamentoBusiness(
            HeaderArquivoBusiness geraHeaderArquivoBusiness,
            HeaderLoteBusiness gerarHeaderLoteBusiness,
            CnabFolhaPagamentoBusiness geraCnabFolhaPagamentoBusiness,
            RegistroTrailerLoteBusiness geraRegistroTrailerLoteBusiness,
            CnabGeraArquivoTxt gerarCnabGeraArquivoTxt)
    {
        this.geraHeaderArquivoBusiness = geraHeaderArquivoBusiness;
        this.gerarHeaderLoteBusiness = gerarHeaderLoteBusiness;
        this.geraCnabFolhaPagamentoBusiness = geraCnabFolhaPagamentoBusiness;
        this.geraRegistroTrailerLoteBusiness = geraRegistroTrailerLoteBusiness;
        this.gerarCnabGeraArquivoTxt = gerarCnabGeraArquivoTxt;
    }

    public void GerarCnabPagamento() {
        HeaderArquivo headerArquivo = geraHeaderArquivoBusiness.gerarHearArquivo();
        HeaderLote headerLote = gerarHeaderLoteBusiness.gerarHeaderLote();
        //List<RegistroSegmentoABDTO> segmentos = geraRegistroDetalheSegmentosBusiness.geraRegistroDeSegmentoAb(file);
        RegistroTrailerLote registroTrailerLote = geraRegistroTrailerLoteBusiness.geraTraillerLote();

        //gerarCnabGeraArquivoTxt.gerarArquivoTxt(headerArquivo, headerLote, segmentos, registroTrailerLote);
    }
}
