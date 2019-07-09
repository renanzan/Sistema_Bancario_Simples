package models;

public class Emprestimo {
	
	private int id;
	private float valor_emprestimo;
	private DateModel data_do_emprestimo;
	private String fk_cpf_cliente;
	
	public Emprestimo() {
		id = 0;
		valor_emprestimo = -1;
		data_do_emprestimo = new DateModel();
		fk_cpf_cliente = null;
	}
	
// HEADER
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getValor_emprestimo() {
		return valor_emprestimo;
	}
	public void setValor_emprestimo(float valor_emprestimo) {
		this.valor_emprestimo = valor_emprestimo;
	}
	
	public DateModel getData() {
		return data_do_emprestimo;
	}
	public void setData(Date dataDoSistema) {
		this.data_do_emprestimo = dataDoSistema.convertToDateModel();
	}
	
	public String getFk_cpf_cliente() {
		return fk_cpf_cliente;
	}
	public void setFk_cpf_cliente(String fk_cpf_cliente) {
		this.fk_cpf_cliente = fk_cpf_cliente;
	}
}
