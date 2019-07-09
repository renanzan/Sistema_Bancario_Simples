package models;

public class CelularFavorito {
	private int id;
	private String apelido;
	private String ddd;
	private String numero;
	private String operadora;
	private String fk_cpf;
	
	public CelularFavorito() {
		id = 0;
		apelido = null;
		ddd = null;
		numero = null;
		operadora = null;
		fk_cpf = null;
	}
	
// ENCAPSULAMENTO
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
	public String getFk_cpf() {
		return fk_cpf;
	}
	public void setFk_cpf(String fk_cpf) {
		this.fk_cpf = fk_cpf;
	}
}
