package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.DTO.RegistroSegmentoABDTO;
import cnab_bradesc.demo.Registros.HeaderArquivo;
import cnab_bradesc.demo.Registros.HeaderLote;
import cnab_bradesc.demo.Registros.RegistroTrailerLote;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class GeraCnabPagamentoBusiness {

    private final HeaderArquivoBusiness geraHeaderArquivoBusiness;
    private final HeaderLoteBusiness gerarHeaderLoteBusiness;
    private final RegistroDetalheSegmentosBusiness geraRegistroDetalheSegmentosBusiness;
    private final RegistroTrailerLoteBusiness geraRegistroTrailerLoteBusiness;
    private final ArquivoCnabTxtBusiness gerarArquivoCnabTxtBusiness;

    public GeraCnabPagamentoBusiness(
            HeaderArquivoBusiness geraHeaderArquivoBusiness,
            HeaderLoteBusiness gerarHeaderLoteBusiness,
            RegistroDetalheSegmentosBusiness geraRegistroDetalheSegmentosBusiness,
            RegistroTrailerLoteBusiness geraRegistroTrailerLoteBusiness,
            ArquivoCnabTxtBusiness gerarArquivoCnabTxtBusiness)
    {
        this.geraHeaderArquivoBusiness = geraHeaderArquivoBusiness;
        this.gerarHeaderLoteBusiness = gerarHeaderLoteBusiness;
        this.geraRegistroDetalheSegmentosBusiness = geraRegistroDetalheSegmentosBusiness;
        this.geraRegistroTrailerLoteBusiness = geraRegistroTrailerLoteBusiness;
        this.gerarArquivoCnabTxtBusiness = gerarArquivoCnabTxtBusiness;
    }

    public void GerarCnabPagamento() throws IOException {
        HeaderArquivo headerArquivo = geraHeaderArquivoBusiness.gerarHearArquivo();
        HeaderLote headerLote = gerarHeaderLoteBusiness.gerarHeaderLote();
        List<RegistroSegmentoABDTO> segmentos = geraRegistroDetalheSegmentosBusiness.geraRegistroDeSegmentoAb();
        RegistroTrailerLote registroTrailerLote = geraRegistroTrailerLoteBusiness.geraTraillerLote();

        gerarArquivoCnabTxtBusiness.gerarArquivoTxt(headerArquivo, headerLote, segmentos, registroTrailerLote);
    }
}
