package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.JTextField;

public class FileTxt {
	private static String fileName;
	private static File file;
	
	public FileTxt(String fileName) {
		this.fileName = fileName;
		file = new File(this.fileName);
	}
	
	public void file_SAVE(String cpf, String senha) {
		try {
			if(!file.exists()) file.createNewFile();
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
			bufferedWriter.write(cpf);
			bufferedWriter.newLine();
			bufferedWriter.write(senha);
			bufferedWriter.close();
		} catch(Exception ex) {
			System.err.println("Não foi possível salvar o arquivo de texto.\n" + ex.getMessage());
		}
	}
	
	public void file_UPDATE(JTextField txtCPF, JTextField txtSenha) {
		try {
			if(file.exists()) {
				Scanner scan = new Scanner(file);
				
				txtCPF.setText(scan.nextLine());
				txtSenha.setText(scan.nextLine());
				scan.close();
			}
		} catch(Exception ex) {
			System.err.println("Não foi possível ler o arquivo de texto.]n" + ex.getMessage());
		}
	}
	
	public void file_DELETE() {
		file.delete();
	}
	
// HEADER
	public static String getFileName() {
		return fileName;
	}
	public static void setFileName(String fileName) {
		FileTxt.fileName = fileName;
	}
	
	public static File getFile() {
		return file;
	}
	public static void setFile(File file) {
		FileTxt.file = file;
	}
}
