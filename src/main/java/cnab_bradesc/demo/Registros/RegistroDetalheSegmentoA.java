package cnab_bradesc.demo.Registros;

public class RegistroDetalheSegmentoA {

    // 001-003
    private int codigoBanco;

    // 004-007
    private String lote;

    // 008 (fixo: 3)
    private int tipoRegistro;

    // 009-013
    private String numeroSequencialRegistro;

    // 014 (fixo: 'A')
    private String codigoSegmento;

    // 015
    private int tipoMovimento;

    // 016-017
    private String codigoInstrucaoMovimento;

    // 018-020
    private String codigoCamaraCentralizadora;

    // 021-023
    private int codigoBancoFavorecido;

    // 024-028
    private String agencia;

    // 029
    private String digitoAgencia;

    // 030-041
    private String numeroContaCorrente;

    // 042
    private String digitoConta;

    // 043
    private String digitoAgenciaConta;

    // 044-073
    private String nomeFavorecido;

    // 074-093 (CPF)
    private String seuNumero;

    // 094-101 (Formato: ddMMyyyy)
    private String dataPagamento;

    // 102-104
    private String tipoMoeda;

    // 105-119 (10 inteiros + 5 decimais, como string sem ponto)
    private String quantidadeMoeda;

    // 120-134 (13 inteiros + 2 decimais, sem ponto)
    private String valorPagamento;

    // 135-154
    private String nossoNumero;

    // 155-162 (Formato: ddMMyyyy)
    private String dataEfetivacaoPagamento;

    // 163-177 (13 inteiros + 2 decimais)
    private String valorRealEfetivacaoPagamento;

    // 178-217
    private String informacao2;

    // 218-219
    private String codigoFinalidadeDoc;

    // 220-224
    private String codigoFinalidadeTED;

    // 225-226
    private String codigoFinalidadeComplementar;

    // 227-229 (Espaços)
    private String cnab;

    // 230
    private int avisoFavorecido;

    // 231-240
    private String ocorrencias;

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

    public int getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(int tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getNumeroSequencialRegistro() {
        return numeroSequencialRegistro;
    }

    public void setNumeroSequencialRegistro(String numeroSequencialRegistro) {
        this.numeroSequencialRegistro = numeroSequencialRegistro;
    }

    public String getCodigoSegmento() {
        return codigoSegmento;
    }

    public void setCodigoSegmento(String codigoSegmento) {
        this.codigoSegmento = codigoSegmento;
    }

    public int getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(int tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getCodigoInstrucaoMovimento() {
        return codigoInstrucaoMovimento;
    }

    public void setCodigoInstrucaoMovimento(String codigoInstrucaoMovimento) {
        this.codigoInstrucaoMovimento = codigoInstrucaoMovimento;
    }

    public String getCodigoCamaraCentralizadora() {
        return codigoCamaraCentralizadora;
    }

    public void setCodigoCamaraCentralizadora(String codigoCamaraCentralizadora) {
        this.codigoCamaraCentralizadora = codigoCamaraCentralizadora;
    }

    public int getCodigoBancoFavorecido() {
        return codigoBancoFavorecido;
    }

    public void setCodigoBancoFavorecido(int codigoBancoFavorecido) {
        this.codigoBancoFavorecido = codigoBancoFavorecido;
    }

    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroContaCorrente() {
        return numeroContaCorrente;
    }

    public void setNumeroContaCorrente(String numeroContaCorrente) {
        this.numeroContaCorrente = numeroContaCorrente;
    }

    public String getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(String digitoConta) {
        this.digitoConta = digitoConta;
    }

    public String getDigitoAgenciaConta() {
        return " ".repeat(1);
    }

    public void setDigitoAgenciaConta(String digitoAgenciaConta) {
        this.digitoAgenciaConta = digitoAgenciaConta;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public String getNomeFavorecido() {
        return nomeFavorecido;
    }

    public void setNomeFavorecido(String nomeFavorecido) {
        this.nomeFavorecido = nomeFavorecido;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public void setTipoMoeda(String tipoMoeda) {
        this.tipoMoeda = tipoMoeda;
    }

    public String getQuantidadeMoeda() {
        return quantidadeMoeda;
    }

    public void setQuantidadeMoeda(String quantidadeMoeda) {
        this.quantidadeMoeda = quantidadeMoeda;
    }

    public String getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(String valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getDataEfetivacaoPagamento() {
        return "0".repeat(8);
    }

    public void setDataEfetivacaoPagamento(String dataEfetivacaoPagamento) {
        this.dataEfetivacaoPagamento = dataEfetivacaoPagamento;
    }

    public String getInformacao2() {
        return informacao2;
    }

    public void setInformacao2(String informacao2) {
        this.informacao2 = informacao2;
    }

    public String getNossoNumero() {
        return " ".repeat(20);
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getValorRealEfetivacaoPagamento() {
        return "0".repeat(15);
    }

    public String _GET52SPACE(){
        return " ".repeat(52);
    }

    public String _GET10SPACE(){
        return " ".repeat(10);
    }

    public void setValorRealEfetivacaoPagamento(String valorRealEfetivacaoPagamento) {
        this.valorRealEfetivacaoPagamento = valorRealEfetivacaoPagamento;
    }

    public String getCodigoFinalidadeDoc() {
        return codigoFinalidadeDoc;
    }

    public void setCodigoFinalidadeDoc(String codigoFinalidadeDoc) {
        this.codigoFinalidadeDoc = codigoFinalidadeDoc;
    }

    public String getCodigoFinalidadeComplementar() {
        return codigoFinalidadeComplementar;
    }

    public void setCodigoFinalidadeComplementar(String codigoFinalidadeComplementar) {
        this.codigoFinalidadeComplementar = codigoFinalidadeComplementar;
    }

    public String getCodigoFinalidadeTED() {
        return codigoFinalidadeTED;
    }

    public void setCodigoFinalidadeTED(String codigoFinalidadeTED) {
        this.codigoFinalidadeTED = codigoFinalidadeTED;
    }

    public String getCnab() {
        return cnab;
    }

    public void setCnab(String cnab) {
        this.cnab = cnab;
    }

    public int getAvisoFavorecido() {
        return avisoFavorecido;
    }

    public void setAvisoFavorecido(int avisoFavorecido) {
        this.avisoFavorecido = avisoFavorecido;
    }

    public String getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(String ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
}
