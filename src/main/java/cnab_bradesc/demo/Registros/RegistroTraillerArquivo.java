package cnab_bradesc.demo.Registros;

public class RegistroTraillerArquivo {

    // 01.9 - Código do Banco na Compensação (1-3)
    private String codigoBanco; // 3 N

    // 02.9 - Lote de Serviço (4-7) -> sempre "9999"
    private String loteServico; // 4 N

    // 03.9 - Tipo de Registro (8-8) -> sempre "9"
    private String tipoRegistro; // 1 N

    // 04.9 - Uso Exclusivo FEBRABAN/CNAB (9-17) -> brancos
    private String cnab1; // 9 A

    // 05.9 - Quantidade de Lotes do Arquivo (18-23)
    private int quantidadeLotes; // 6 N

    // 06.9 - Quantidade de Registros do Arquivo (24-29)
    private int quantidadeRegistros; // 6 N

    // 07.9 - Quantidade de Contas Conciliação (30-35)
    private int quantidadeContasConciliacao; // 6 N

    // 08.9 - Uso Exclusivo FEBRABAN/CNAB (36-240) -> brancos
    private String cnab2; // 205 A


    // Getters e Setters
    public String getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(String codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getLoteServico() {
        return loteServico;
    }

    public void setLoteServico(String loteServico) {
        this.loteServico = loteServico;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getCnab1() {
        return cnab1;
    }

    public void setCnab1(String cnab1) {
        this.cnab1 = cnab1;
    }

    public int getQuantidadeLotes() {
        return quantidadeLotes;
    }

    public void setQuantidadeLotes(int quantidadeLotes) {
        this.quantidadeLotes = quantidadeLotes;
    }

    public int getQuantidadeRegistros() {
        return quantidadeRegistros;
    }

    public void setQuantidadeRegistros(int quantidadeRegistros) {
        this.quantidadeRegistros = quantidadeRegistros;
    }

    public int getQuantidadeContasConciliacao() {
        return quantidadeContasConciliacao;
    }

    public void setQuantidadeContasConciliacao(int quantidadeContasConciliacao) {
        this.quantidadeContasConciliacao = quantidadeContasConciliacao;
    }

    public String getCnab2() {
        return cnab2;
    }

    public void setCnab2(String cnab2) {
        this.cnab2 = cnab2;
    }
}
