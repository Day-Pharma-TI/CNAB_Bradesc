package cnab_bradesc.demo.DTO;

import cnab_bradesc.demo.Registros.RegistroDetalheSegmentoA;
import cnab_bradesc.demo.Registros.RegistroDetalheSegmentoB;

public class RegistroSegmentoABDTO {

    private RegistroDetalheSegmentoA segmentoA;

    private RegistroDetalheSegmentoB segmentoB;

    public RegistroDetalheSegmentoA getSegmentoA() {
        return segmentoA;
    }

    public void setSegmentoA(RegistroDetalheSegmentoA segmentoA) {
        this.segmentoA = segmentoA;
    }

    public RegistroDetalheSegmentoB getSegmentoB() {
        return segmentoB;
    }

    public void setSegmentoB(RegistroDetalheSegmentoB segmentoB) {
        this.segmentoB = segmentoB;
    }
}

