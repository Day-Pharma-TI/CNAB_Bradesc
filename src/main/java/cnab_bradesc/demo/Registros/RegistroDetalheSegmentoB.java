package cnab_bradesc.demo.Registros;

public class RegistroDetalheSegmentoB {

    // Controle
    private int codigoBanco;                       // 001-003
    private String lote;                              // 004-007
    private int tipoRegistro;                      // 008-008
    private String numeroSequencialRegistro;          // 009-013
    private String codigoSegmento;                 // 014-014
    private String cnab1;                          // 015-017 (brancos)

    // Dados Complementares - Favorecido
    private String tipoInscricaoFavorecido;           // 018-018
    private String numeroInscricaoFavorecido;      // 019-032
    private String logradouro;                     // 033-062
    private int numeroLocal;                       // 063-067
    private String complemento;                    // 068-082
    private String bairro;                         // 083-097
    private String cidade;                         // 098-117
    private int cep;                               // 118-122
    private String complementoCep;                 // 123-125
    private String estado;                         // 126-127

    // Pagamento
    private String dataVencimento;                 // 128-135 (ddMMyyyy)
    private String valorDocumento;                 // 136-150 (13.2, com zeros à esquerda)
    private String valorAbatimento;                // 151-165 (13.2)
    private String valorDesconto;                  // 166-180 (13.2)
    private String valorMora;                      // 181-195 (13.2)
    private String valorMulta;                     // 196-210 (13.2)
    private String codigoDocumentoFavorecido;      // 211-225
    private int avisoFavorecido;                   // 226-226
    private String codigoUgCentralizadora;         // 227-232
    private String codigoIspb;                     // 233-240


    public int getAvisoFavorecido() {
        return avisoFavorecido;
    }

    public void setAvisoFavorecido(int avisoFavorecido) {
        this.avisoFavorecido = avisoFavorecido;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

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

    public String getCodigoDocumentoFavorecido() {
        return codigoDocumentoFavorecido;
    }

    public void setCodigoDocumentoFavorecido(String codigoDocumentoFavorecido) {
        this.codigoDocumentoFavorecido = codigoDocumentoFavorecido;
    }

    public String getCodigoIspb() {
        return codigoIspb;
    }

    public void setCodigoIspb(String codigoIspb) {
        this.codigoIspb = codigoIspb;
    }

    public String getCodigoSegmento() {
        return codigoSegmento;
    }

    public void setCodigoSegmento(String codigoSegmento) {
        this.codigoSegmento = codigoSegmento;
    }

    public String getCodigoUgCentralizadora() {
        return codigoUgCentralizadora;
    }

    public void setCodigoUgCentralizadora(String codigoUgCentralizadora) {
        this.codigoUgCentralizadora = codigoUgCentralizadora;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplementoCep() {
        return complementoCep;
    }

    public void setComplementoCep(String complementoCep) {
        this.complementoCep = complementoCep;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNumeroInscricaoFavorecido() {
        return numeroInscricaoFavorecido;
    }

    public void setNumeroInscricaoFavorecido(String numeroInscricaoFavorecido) {
        this.numeroInscricaoFavorecido = numeroInscricaoFavorecido;
    }

    public int getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(int numeroLocal) {
        this.numeroLocal = numeroLocal;
    }

    public String getNumeroSequencialRegistro() {
        return numeroSequencialRegistro;
    }

    public void setNumeroSequencialRegistro(String numeroSequencialRegistro) {
        this.numeroSequencialRegistro = numeroSequencialRegistro;
    }

    public String getTipoInscricaoFavorecido() {
        return tipoInscricaoFavorecido;
    }

    public void setTipoInscricaoFavorecido(String tipoInscricaoFavorecido) {
        this.tipoInscricaoFavorecido = tipoInscricaoFavorecido;
    }

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(int tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(String valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public String getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(String valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getValorDocumento() {
        return valorDocumento;
    }

    public void setValorDocumento(String valorDocumento) {
        this.valorDocumento = valorDocumento;
    }

    public String getValorMora() {
        return valorMora;
    }

    public void setValorMora(String valorMora) {
        this.valorMora = valorMora;
    }

    public String getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(String valorMulta) {
        this.valorMulta = valorMulta;
    }

    public String _GET85BRANCO(){
        return " ".repeat(85);
    }

    public String _CEP(){
        return "0".repeat(5);
    }

    public String _COMPLECEP(){
        return " ".repeat(5);
    }

    public String _GET97ZEROCOMPLET(){
        return "0".repeat(97);
    }

    public String _GET8BRANCO(){
        return " ".repeat(8);
    }
}
