package models;

public class DateModel {
	private int ano;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	
	public void setDateSQL(String dateSQL) {
		String[] date = dateSQL.split("-");
		
		ano = Integer.parseInt(date[0]);
		mes = Integer.parseInt(date[1]);
		dia = Integer.parseInt(date[2]);
	}
	
	public void setTimeSQL(String timeSQL) {
		String[] time = timeSQL.split(":");
		
		hora = Integer.parseInt(time[0]);
		minuto = Integer.parseInt(time[1]);
		segundo = Integer.parseInt(time[2]);
	}
	
	public String getDataString() {
		String data = this.dia + "/" + this.mes + "/" + this.ano;
		return data;
	}
	
	public String getHoraString() {
		String hora = this.hora + ":" + this.minuto + ":" + this.segundo;
		return hora;
	}
	
// HEADER
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) {
		this.hora = hora;
	}
	
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
	public int getSegundos() {
		return segundo;
	}
	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}
}
