package teste.models;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
public class Beneficiarios {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	private String Ano_Proposta;
	
	private Integer Elemento_Despesa;
	
	private Integer Codigo_UOR_Cadastradora;
	
	private Integer Unidade_Executada;
	
	private long Numero_Processo;
	
	private long Acao_Originaria;
	
	private String Tipo_Causa;
	
	private Integer Cod_Tua;
	
	private Integer Vara;
	
	private String Codigo_Beneficiario;
	
	private String Nome_Beneficiario;
	
	private String Data_Autuacao;
	
	private double Valor_Pago;
	
	@DateTimeFormat
	private Date Data_Pagamento;
	
	private Integer Codigo_Banco;
	
	private Integer Codigo_Agencia;
	
	private long Numero_Conta;
	
	private String UO_Lotacao;
	
	private String Condicao_Servidor;
	
	private double Valor_PSS_Retido;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAno_Proposta() {
		return Ano_Proposta;
	}

	public void setAno_Proposta(String ano_Proposta) {
		Ano_Proposta = ano_Proposta;
	}

	public Integer getElemento_Despesa() {
		return Elemento_Despesa;
	}

	public void setElemento_Despesa(Integer elemento_Despesa) {
		Elemento_Despesa = elemento_Despesa;
	}

	public Integer getCodigo_UOR_Cadastradora() {
		return Codigo_UOR_Cadastradora;
	}

	public void setCodigo_UOR_Cadastradora(Integer codigo_UOR_Cadastradora) {
		Codigo_UOR_Cadastradora = codigo_UOR_Cadastradora;
	}

	public Integer getUnidade_Executada() {
		return Unidade_Executada;
	}

	public void setUnidade_Executada(Integer unidade_Executada) {
		Unidade_Executada = unidade_Executada;
	}

	public long getNumero_Processo() {
		return Numero_Processo;
	}

	public void setNumero_Processo(long numero_Processo) {
		Numero_Processo = numero_Processo;
	}

	public long getAcao_Originaria() {
		return Acao_Originaria;
	}

	public void setAcao_Originaria(long acao_Originaria) {
		Acao_Originaria = acao_Originaria;
	}

	public String getTipo_Causa() {
		return Tipo_Causa;
	}

	public void setTipo_Causa(String tipo_Causa) {
		Tipo_Causa = tipo_Causa;
	}

	public Integer getCod_Tua() {
		return Cod_Tua;
	}

	public void setCod_Tua(Integer cod_Tua) {
		Cod_Tua = cod_Tua;
	}

	public Integer getVara() {
		return Vara;
	}

	public void setVara(Integer vara) {
		Vara = vara;
	}

	public String getCodigo_Beneficiario() {
		return Codigo_Beneficiario;
	}

	public void setCodigo_Beneficiario(String codigo_Beneficiario) {
		Codigo_Beneficiario = codigo_Beneficiario;
	}

	public String getNome_Beneficiario() {
		return Nome_Beneficiario;
	}

	public void setNome_Beneficiario(String nome_Beneficiario) {
		Nome_Beneficiario = nome_Beneficiario;
	}
	
	public String getData_Autuacao() {
		return Data_Autuacao;
	}

	public void setData_Autuacao(String data_Autuacao) {
		Data_Autuacao = data_Autuacao;
	}

	

	public Date getData_Pagamento() {
		return Data_Pagamento;
	}

	public void setData_Pagamento(Date data_Pagamento) {
		Data_Pagamento = data_Pagamento;
	}

	public double getValor_Pago() {
		return Valor_Pago;
	}

	public void setValor_Pago(double valor_Pago) {
		Valor_Pago = valor_Pago;
	}

	
	public Integer getCodigo_Banco() {
		return Codigo_Banco;
	}

	public void setCodigo_Banco(Integer codigo_Banco) {
		Codigo_Banco = codigo_Banco;
	}

	public Integer getCodigo_Agencia() {
		return Codigo_Agencia;
	}

	public void setCodigo_Agencia(Integer codigo_Agencia) {
		Codigo_Agencia = codigo_Agencia;
	}

	public long getNumero_Conta() {
		return Numero_Conta;
	}

	public void setNumero_Conta(long numero_Conta) {
		Numero_Conta = numero_Conta;
	}

	public String getUO_Lotacao() {
		return UO_Lotacao;
	}

	public void setUO_Lotacao(String uO_Lotacao) {
		UO_Lotacao = uO_Lotacao;
	}

	public String getCondicao_Servidor() {
		return Condicao_Servidor;
	}

	public void setCondicao_Servidor(String condicao_Servidor) {
		Condicao_Servidor = condicao_Servidor;
	}

	public double getValor_PSS_Retido() {
		return Valor_PSS_Retido;
	}

	public void setValor_PSS_Retido(double valor_PSS_Retido) {
		Valor_PSS_Retido = valor_PSS_Retido;
	}

	
	
	
	
}
