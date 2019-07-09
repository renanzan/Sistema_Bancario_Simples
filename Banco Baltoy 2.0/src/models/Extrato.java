package models;

public class Extrato {
	
	private int id;
	private String tipo;
	private String descricao;
	private float valor;
	private String formaDePagamento;
	private DateModel data;
	private String setFk_num_conta;
	
	public Extrato() {
		id = 0;
		tipo = null;
		descricao = null;
		formaDePagamento = null;
		data = new DateModel();
		setFk_num_conta = null;
	}
	
// HEADER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	public DateModel getData() {
		return data;
	}
	public void setData(Date dataDoSistema) {
		this.data = dataDoSistema.convertToDateModel();
	}
	
	public String getFk_num_conta() {
		return setFk_num_conta;
	}
	public void setFk_num_conta(String setFk_num_conta) {
		this.setFk_num_conta = setFk_num_conta;
	}
}
