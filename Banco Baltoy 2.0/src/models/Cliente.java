package models;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private String diretorioImagem;
	private Emprestimo emprestimo;
	
	public Cliente() {
		nome = null;
		cpf = null;
		senha = null;
		email = null;
		diretorioImagem = null;
		emprestimo = new Emprestimo();
	}
	
// HEADER
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDiretorioImagem() {
		return diretorioImagem;
	}
	public void setDiretorioImagem(String diretorioImagem) {
		this.diretorioImagem = diretorioImagem;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
}
