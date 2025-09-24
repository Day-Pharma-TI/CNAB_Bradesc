package cnab_bradesc.demo.Registros;

import java.time.LocalDateTime;

public class HeaderArquivo {

    // 01 a 03 – Código do Banco
    private int banco;

    // 04 a 07 – Lote
    private String lote;

    // 08 – Tipo de Registro
    private int registro;

    // 09 a 17 – 9 espaços em branco
    public String getNoveEspacos() {
        return " ".repeat(9);
    }

    // 18 – Tipo de Inscrição da Empresa (1 = CPF, 2 = CNPJ)
    private int tipoInscricaoEmpresa;

    // 19 a 32 – Número de Inscrição da Empresa (14 caracteres numéricos)
    private String numeroDeInscricaoEmpresa;

    // 33 a 52 – Código do Convênio no Banco (20 alfanumérico)
    private String codigoConvenioBanco;

    // 53 a 57 – Agência (5 dígitos numéricos)
    private String agenciaMantedoraDaConta;

    // 58 – Dígito da Agência (1 caractere alfanumérico)
    private String digitoVerificadorDaAgencia;

    // 59 a 70 – Número da Conta Corrente (12 dígitos numéricos)
    private String numeroDaContaCorrente;

    // 71 – Dígito da Conta Corrente (1 caractere alfanumérico)
    private String digitoVerificadorDaConta;

    // 72 – Dígito da Agência/Conta (1 caractere alfanumérico)
    private String digitoVerificadorDaAgOuConta;

    // 73 a 102 – Nome da Empresa (30 alfanumérico)
    private String nomeDaEmpresa;

    // 103 a 132 – Nome do Banco (30 alfanumérico)
    private String nomeDoBanco;

    // 133 a 142 – 10 espaços em branco
    public String getDezEspacos() {
        return " ".repeat(10);
    }

    // 143 – Código Remessa/Retorno (1 numérico)
    private int codigoRemessaRetorno;

    // 144 a 151 – Data de geração do arquivo (formato ddMMyyyy)
    private LocalDateTime dataGeracaoArquivo;

    // 152 a 157 – Hora de geração (formato HHmmss)
    private LocalDateTime horaDeGeracaoArquivo;

    // 158 a 163 – Número Sequencial do Arquivo (6 numérico)
    private String numeroSequencialArquvivo;

    // 164 a 166 – Versão do Layout do Arquivo (3 numérico)
    private String versaoLayoutArquivo;

    // 167 a 171 – Densidade de gravação (5 numérico)
    private String densidade;

    // 172 a 191 – Reservado Banco (20 alfanumérico)
    private String reservadoBanco;

    // 192 a 211 – Reservado Empresa (20 alfanumérico)
    private String reservadoEmpresa = " ".repeat(20);

    // 212 a 240 – CNAB (29 espaços em branco)
    public String getEspacoFinal() {
        return " ".repeat(29);
    }

    // Getters e Setters

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

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getTipoInscricaoEmpresa() {
        return tipoInscricaoEmpresa;
    }

    public void setTipoInscricaoEmpresa(int tipoInscricaoEmpresa) {
        this.tipoInscricaoEmpresa = tipoInscricaoEmpresa;
    }

    public String getNumeroDeInscricaoEmpresa() {
        return numeroDeInscricaoEmpresa;
    }

    public void setNumeroDeInscricaoEmpresa(String numeroDeInscricaoEmpresa) {
        this.numeroDeInscricaoEmpresa = numeroDeInscricaoEmpresa;
    }

    public String getCodigoConvenioBanco() {
        return codigoConvenioBanco;
    }

    public void setCodigoConvenioBanco(String codigoConvenioBanco) {
        this.codigoConvenioBanco = codigoConvenioBanco;
    }

    public String getAgenciaMantedoraDaConta() {
        return agenciaMantedoraDaConta;
    }

    public void setAgenciaMantedoraDaConta(String agenciaMantedoraDaConta) {
        this.agenciaMantedoraDaConta = agenciaMantedoraDaConta;
    }

    public String getDigitoVerificadorDaAgencia() {
        return digitoVerificadorDaAgencia;
    }

    public void setDigitoVerificadorDaAgencia(String digitoVerificadorDaAgencia) {
        this.digitoVerificadorDaAgencia = digitoVerificadorDaAgencia;
    }

    public String getNumeroDaContaCorrente() {
        return numeroDaContaCorrente;
    }

    public void setNumeroDaContaCorrente(String numeroDaContaCorrente) {
        this.numeroDaContaCorrente = numeroDaContaCorrente;
    }

    public String getDigitoVerificadorDaConta() {
        return digitoVerificadorDaConta;
    }

    public void setDigitoVerificadorDaConta(String digitoVerificadorDaConta) {
        this.digitoVerificadorDaConta = digitoVerificadorDaConta;
    }

    public String getDigitoVerificadorDaAgOuConta() {
        return digitoVerificadorDaAgOuConta;
    }

    public void setDigitoVerificadorDaAgOuConta(String digitoVerificadorDaAgOuConta) {
        this.digitoVerificadorDaAgOuConta = digitoVerificadorDaAgOuConta;
    }

    public String getNomeDaEmpresa() {
        return nomeDaEmpresa;
    }

    public void setNomeDaEmpresa(String nomeDaEmpresa) {
        this.nomeDaEmpresa = nomeDaEmpresa;
    }

    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    public int getCodigoRemessaRetorno() {
        return codigoRemessaRetorno;
    }

    public void setCodigoRemessaRetorno(int codigoRemessaRetorno) {
        this.codigoRemessaRetorno = codigoRemessaRetorno;
    }

    public LocalDateTime getDataGeracaoArquivo() {
        return dataGeracaoArquivo;
    }

    public void setDataGeracaoArquivo(LocalDateTime dataGeracaoArquivo) {
        this.dataGeracaoArquivo = dataGeracaoArquivo;
    }

    public LocalDateTime getHoraDeGeracaoArquivo() {
        return horaDeGeracaoArquivo;
    }

    public void setHoraDeGeracaoArquivo(LocalDateTime horaDeGeracaoArquivo) {
        this.horaDeGeracaoArquivo = horaDeGeracaoArquivo;
    }

    public String getNumeroSequencialArquvivo() {
        return numeroSequencialArquvivo;
    }

    public void setNumeroSequencialArquvivo(String numeroSequencialArquvivo) {
        this.numeroSequencialArquvivo = numeroSequencialArquvivo;
    }

    public String getVersaoLayoutArquivo() {
        return versaoLayoutArquivo;
    }

    public void setVersaoLayoutArquivo(String versaoLayoutArquivo) {
        this.versaoLayoutArquivo = versaoLayoutArquivo;
    }

    public String getDensidade() {
        return densidade;
    }

    public void setDensidade(String densidade) {
        this.densidade = densidade;
    }

    public String getReservadoBanco() {
        return reservadoBanco;
    }

    public void setReservadoBanco(String reservadoBanco) {
        this.reservadoBanco = reservadoBanco;
    }

    public String getReservadoEmpresa() {
        return reservadoEmpresa;
    }

    public void setReservadoEmpresa(String reservadoEmpresa) {
        this.reservadoEmpresa = reservadoEmpresa;
    }
}
