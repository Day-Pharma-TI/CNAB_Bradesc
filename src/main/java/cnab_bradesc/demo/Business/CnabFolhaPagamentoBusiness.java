package cnab_bradesc.demo.Business;

import cnab_bradesc.demo.DTO.RegistroSegmentoABDTO;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface CnabFolhaPagamentoBusiness {

    List<RegistroSegmentoABDTO> geraRegistroDeSegmento(MultipartFile file, boolean tipoPagamento);
}