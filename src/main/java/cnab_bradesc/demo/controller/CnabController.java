package cnab_bradesc.demo.controller;

import cnab_bradesc.demo.Business.CnabFolhaPagamentoBusiness;
import cnab_bradesc.demo.Business.HeaderArquivoBusiness;
import cnab_bradesc.demo.Business.HeaderLoteBusiness;
import cnab_bradesc.demo.Business.RegistroTrailerLoteBusiness;
import cnab_bradesc.demo.DTO.RegistroSegmentoABDTO;
import cnab_bradesc.demo.Registros.HeaderArquivo;
import cnab_bradesc.demo.Registros.HeaderLote;
import cnab_bradesc.demo.Registros.RegistroTrailerLote;
import cnab_bradesc.demo.Utils.CnabGeraArquivoTxt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cnab")
public class CnabController {

    private final HeaderArquivoBusiness headerArquivoBusiness;
    private final HeaderLoteBusiness headerLoteBusiness;
    private final CnabFolhaPagamentoBusiness cnabFolhaPagamentoBusiness;
    private final RegistroTrailerLoteBusiness registroTrailerLoteBusiness;
    private final CnabGeraArquivoTxt cnabGeraArquivoTxt;

    public CnabController(
            CnabFolhaPagamentoBusiness cnabFolhaPagamentoBusiness,
            HeaderArquivoBusiness headerArquivoBusiness,
            HeaderLoteBusiness headerLoteBusiness,
            RegistroTrailerLoteBusiness trailerLoteBusiness,
            CnabGeraArquivoTxt cnabGeraArquivoTxt

    ) {
        this.cnabFolhaPagamentoBusiness = cnabFolhaPagamentoBusiness;
        this.headerArquivoBusiness = headerArquivoBusiness;
        this.headerLoteBusiness = headerLoteBusiness;
        this.registroTrailerLoteBusiness = trailerLoteBusiness;
        this.cnabGeraArquivoTxt = cnabGeraArquivoTxt;
    }

    @PostMapping("/folhapag/upload")
    public ResponseEntity<?> uploadCnab(@RequestParam("arquivo") MultipartFile file, @RequestParam boolean tipoPagamento) {

        try {

            HeaderArquivo headerArquivo = headerArquivoBusiness.gerarHearArquivo();
            HeaderLote headerLote = headerLoteBusiness.gerarHeaderLote();
            List<RegistroSegmentoABDTO> segmentos = cnabFolhaPagamentoBusiness.geraRegistroDeSegmento(file, tipoPagamento);
            RegistroTrailerLote registroTrailerLote = registroTrailerLoteBusiness.geraTraillerLote();

            byte[] conteudoTxt = cnabGeraArquivoTxt.gerarArquivoTxtBytes(headerArquivo, headerLote, segmentos, registroTrailerLote);

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=cnab.txt")
                    .header("Content-Type", "text/plain")
                    .body(conteudoTxt);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("Erro", "Não foi possivel gerar o arquivo"));
        }
    }
}
