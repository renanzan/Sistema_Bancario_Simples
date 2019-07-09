package models;

import java.util.ArrayList;

public class Usuario {
	private Cliente cliente;
	private Conta contaCorrente;
	private Conta contaPoupanca;
	private ArrayList<Extrato> extratos;
	private ArrayList<CelularFavorito> celularesFavoritos;
	
	public Usuario() {
		cliente = new Cliente();
		contaCorrente = new Conta();
		contaPoupanca = new Conta();
		extratos = new ArrayList<Extrato>();
		celularesFavoritos = new ArrayList<CelularFavorito>();
	}
	
// HEADER
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Conta getContaCorrente() {
		return contaCorrente;
	}
	public void setContaCorrente(Conta contaCorrente) {
		this.contaCorrente = contaCorrente;
	}
	
	public Conta getContaPoupanca() {
		return contaPoupanca;
	}
	public void setContaPoupanca(Conta contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}
	
	public ArrayList<Extrato> getExtratos() {
		return extratos;
	}
	public void setExtratos(ArrayList<Extrato> extratos) {
		this.extratos = extratos;
	}
	
	public ArrayList<CelularFavorito> getCelularesFavoritos() {
		return celularesFavoritos;
	}
	public void setCelularesFavoritos(ArrayList<CelularFavorito> celularesFavoritos) {
		this.celularesFavoritos = celularesFavoritos;
	}
}
