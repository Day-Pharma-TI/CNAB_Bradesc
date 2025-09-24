package cnab_bradesc.demo.Registros;

public class HeaderLote {

    // 01.1 - Código do Banco (1-3)
    private int banco;

    // 02.1 - Lote de Serviço (4-7)
    private String lote;

    // 03.1 - Tipo de Registro (8)
    private int tipoRegistro; // Valor fixo: 1

    // 04.1 - Tipo da Operação (9)
    private String tipoOperacao; // Valor fixo: 'C'

    // 05.1 - Tipo do Serviço (10-11)
    private int tipoServico;

    // 06.1 - Forma de Lançamento (12-13)
    private String formaLancamento;

    // 07.1 - Nº da Versão do Layout do Lote (14-16)
    private String versaoLayoutLote;

    // 08.1 - CNAB (17) - Branco
    public String getCnab1() {
        return " ";
    }

    // 09.1 - Tipo de Inscrição da Empresa (18)
    private int tipoInscricaoEmpresa;

    // 10.1 - Número de Inscrição da Empresa (19-32)
    private String numeroInscricaoEmpresa;

    // 11.1 - Código do Convênio no Banco (33-52)
    private String codigoConvenio;

    // 12.1 - Agência Mantenedora da Conta (53-57)
    private String agencia;

    // 13.1 - Dígito da Agência (58)
    private String digitoAgencia;

    // 14.1 - Número da Conta Corrente (59-70)
    private String contaCorrente;

    // 15.1 - Dígito da Conta Corrente (71)
    private String digitoConta;

    // 16.1 - Dígito Verificador da Ag/Conta (72)
    private String digitoAgenciaConta;

    // 17.1 - Nome da Empresa (73-102)
    private String nomeEmpresa;

    // 18.1 - Informação 1 / Mensagem (103-142)
    private String mensagem;

    // 19.1 - Logradouro (143-172)
    private String logradouro;

    // 20.1 - Número (173-177)
    private String numeroEndereco;

    // 21.1 - Complemento (178-192)
    private String complemento;

    // 22.1 - Cidade (193-212)
    private String cidade;

    // 23.1 - CEP (213-217)
    private String cep;

    // 24.1 - Complemento do CEP (218-220)
    private String complementoCep;

    // 25.1 - Estado (221-222)
    private String estado;

    // 26.1 - Indicativo de Forma de Pagamento (223-224)
    private String indicativoFormaPagamento;

    // 27.1 - CNAB (225-230) - 6 espaços
    public String getCnab2() {
        return " ".repeat(6);
    }

    // 28.1 - Ocorrências (231-240)
    private String ocorrencias;


    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
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

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public int getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(int tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getFormaLancamento() {
        return formaLancamento;
    }

    public void setFormaLancamento(String formaLancamento) {
        this.formaLancamento = formaLancamento;
    }

    public String getVersaoLayoutLote() {
        return versaoLayoutLote;
    }

    public void setVersaoLayoutLote(String versaoLayoutLote) {
        this.versaoLayoutLote = versaoLayoutLote;
    }

    public int getTipoInscricaoEmpresa() {
        return tipoInscricaoEmpresa;
    }

    public void setTipoInscricaoEmpresa(int tipoInscricaoEmpresa) {
        this.tipoInscricaoEmpresa = tipoInscricaoEmpresa;
    }

    public String getNumeroInscricaoEmpresa() {
        return numeroInscricaoEmpresa;
    }

    public void setNumeroInscricaoEmpresa(String numeroInscricaoEmpresa) {
        this.numeroInscricaoEmpresa = numeroInscricaoEmpresa;
    }

    public String getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(String codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getDigitoConta() {
        return digitoConta;
    }

    public void setDigitoConta(String digitoConta) {
        this.digitoConta = digitoConta;
    }

    public String getDigitoAgenciaConta() {
        return digitoAgenciaConta;
    }

    public void setDigitoAgenciaConta(String digitoAgenciaConta) {
        this.digitoAgenciaConta = digitoAgenciaConta;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplemento() {
        return " ".repeat(15);
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplementoCep() {
        return complementoCep;
    }

    public void setComplementoCep(String complementoCep) {
        this.complementoCep = complementoCep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIndicativoFormaPagamento() {
        return indicativoFormaPagamento;
    }

    public void setIndicativoFormaPagamento(String indicativoFormaPagamento) {
        this.indicativoFormaPagamento = indicativoFormaPagamento;
    }

    public String getOcorrencias() {
        return " ".repeat(10);
    }

    public void setOcorrencias(String ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
}
