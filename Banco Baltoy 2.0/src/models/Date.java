package models;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

public class Date {
	private int ano;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	
	public Date() {
		updateDate();
	}
	
	public void updateDate() {
		LocalDateTime now = LocalDateTime.now();
		
		ano = now.getYear();
		mes = now.getMonthValue();
		dia = now.getDayOfMonth();
		hora = now.getHour();
		minuto = now.getMinute();
		segundo = now.getSecond();
	}
	
	public void updateTime(JLabel lblHora) {
		LocalDateTime now = LocalDateTime.now();
		
		hora = now.getHour();
		minuto = now.getMinute();
		segundo = now.getSecond();
		
		if(segundo%2==0) {
			lblHora.setText(hora + ":" + minuto);
		} else
			lblHora.setText(hora + " " + minuto);
	}
	
	public void updateSegundos(JLabel lblHora) {
		while(true) {
			if(segundo!=LocalDateTime.now().getSecond()) {
				updateTime(lblHora);
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class Clock extends Thread {
		JLabel lblHora;
		
		public Clock(JLabel lblHora) {
			this.lblHora = lblHora;
		}

		@Override
		public void run() {
			updateSegundos(lblHora);
		}
	}
	
	public void initializeClock(JLabel lblHora) {
		new Clock(lblHora).start();
	}
	
	public DateModel convertToDateModel() {
		DateModel dateModel = new DateModel();
		
		dateModel.setAno(ano);
		dateModel.setMes(mes);
		dateModel.setDia(dia);
		dateModel.setHora(hora);
		dateModel.setMinuto(minuto);
		dateModel.setSegundo(segundo);
		
		return dateModel;
	}
	
	// ENCAPSULAMENTO
		public int getAno() {
			return ano;
		}
		
		public int getMes() {
			return mes;
		}
		
		public int getDia() {
			return dia;
		}
		
		public int getHora() {
			return hora;
		}
		
		public int getMinuto() {
			return minuto;
		}
		
		public int getSegundos() {
			return segundo;
		}
}
