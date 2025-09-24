package cnab_bradesc.demo.Registros;

public class RegistroTrailerLote {

    private int codigoBanco;
    private String lote;
    private int tipoRegistro;
    private String cnab1;
    private int quantidadeLotes;
    private String somatoriaValores;
    private String somatoriaQtdMoedas;
    private String numeroAvisoDebito;
    private String cnab; // 036-240 (brancos)
    private String ocorrencias;


    public String getCnab1() {
        return cnab1;
    }

    public void setCnab1(String cnab1) {
        this.cnab1 = cnab1;
    }

    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getQuantidadeLotes() {
        return quantidadeLotes;
    }

    public void setQuantidadeLotes(int quantidadeLotes) {
        this.quantidadeLotes = quantidadeLotes;
    }


    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(int tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String _GET9BRANCOS(){
        return " ".repeat(9);
    }

    public String _GET176BRANCOS(){
        return " ".repeat(175);
    }

    public String getCnab() {
        return cnab;
    }

    public void setCnab(String cnab) {
        this.cnab = cnab;
    }

    public String getNumeroAvisoDebito() {
        return numeroAvisoDebito;
    }

    public void setNumeroAvisoDebito(String numeroAvisoDebito) {
        this.numeroAvisoDebito = numeroAvisoDebito;
    }

    public String getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(String ocorrencias) {
        this.ocorrencias = ocorrencias;
    }

    public String getSomatoriaQtdMoedas() {
        return somatoriaQtdMoedas;
    }

    public void setSomatoriaQtdMoedas(String somatoriaQtdMoedas) {
        this.somatoriaQtdMoedas = somatoriaQtdMoedas;
    }

    public String getSomatoriaValores() {
        return somatoriaValores;
    }

    public void setSomatoriaValores(String somatoriaValores) {
        this.somatoriaValores = somatoriaValores;
    }

    public String _GET24ZEROS(){
        return "0".repeat(24);
    }
}
