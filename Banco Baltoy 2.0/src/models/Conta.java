package models;

public class Conta {
	private String num_conta_corrente;
	private String pin;
	private float saldo;
	private String fk_cpf;
	
	public Conta() {
		num_conta_corrente = null;
		pin = null;
		saldo = 0;
		fk_cpf = null;
	}
	
// HEADER
	public String getNum_conta() {
		return num_conta_corrente;
	}
	public void setNum_conta(String num_conta_corrente) {
		this.num_conta_corrente = num_conta_corrente;
	}
	
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public String getFk_cpf() {
		return fk_cpf;
	}
	public void setFk_cpf(String fk_cpf) {
		this.fk_cpf = fk_cpf;
	}
}
