package view.after_login;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import models.Database;
import models.Usuario;
import view.before_login.Login;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import database.dao.DAO_Extratos;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Extrato extends JInternalFrame {

	private static JLayeredPane UsefulSpace;
	private static JLabel imgBackground;
	private static JPanel panel;
	
	private static Database database;
	private static Usuario usuario;
	public static JTable extratoContaCorrente;
	private static JTable extratoContaPoupanca;
	private static JLabel lblExtrato;
	private static JLabel label_1;
	
	public Extrato(Database database, Usuario usuario) {
		this.database = database;
		this.usuario = usuario;
		
		pressets(this);
	}

	private static void pressets(Extrato recargas) {
		recargas.setSize(1000, 633);
		recargas.getContentPane().setLayout(null);
		
		((BasicInternalFrameUI)recargas.getUI()).setNorthPane(null);   //retirar o painel superior
		recargas.setBorder(null);   //retirar bordas
		
		initializeLayered(recargas);
	}

	private static void initializeLayered(Extrato recargas) {
		UsefulSpace = new JLayeredPane();
		UsefulSpace.setSize(1000, 600);
		imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		imgBackground.setSize(1000, 600);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(201, 29, 630, 414);
		UsefulSpace.add(panel);
		panel.setLayout(null);
		
		if(mainFrame.showMenuIsVisible)
			Extrato.resizeUsefulSpace(230, 770);
		else
			Extrato.resizeUsefulSpace(30, 970);
		recargas.getContentPane().add(UsefulSpace);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(45, 80, 550, 300);
		panel.add(tabbedPane);
		
		extratoContaCorrente = new JTable();
		extratoContaCorrente.setBorder(new LineBorder(new Color(0, 0, 0)));
		extratoContaCorrente.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Hora", "Descri\u00E7\u00E3o", "Valor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		extratoContaCorrente.getColumnModel().getColumn(0).setPreferredWidth(45);
		extratoContaCorrente.getColumnModel().getColumn(0).setMinWidth(45);
		extratoContaCorrente.getColumnModel().getColumn(1).setPreferredWidth(45);
		extratoContaCorrente.getColumnModel().getColumn(1).setMinWidth(45);
		extratoContaCorrente.getColumnModel().getColumn(2).setResizable(false);
		extratoContaCorrente.getColumnModel().getColumn(2).setPreferredWidth(186);
		extratoContaCorrente.getColumnModel().getColumn(2).setMinWidth(45);
		extratoContaCorrente.getColumnModel().getColumn(3).setPreferredWidth(100);
		extratoContaCorrente.getColumnModel().getColumn(3).setMinWidth(45);
		
		extratoContaPoupanca = new JTable();
		extratoContaPoupanca.setBorder(new LineBorder(new Color(0, 0, 0)));
		extratoContaPoupanca.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Data", "Hora", "Descri\u00E7\u00E3o", "Valor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		extratoContaPoupanca.getColumnModel().getColumn(0).setPreferredWidth(45);
		extratoContaPoupanca.getColumnModel().getColumn(0).setMinWidth(45);
		extratoContaPoupanca.getColumnModel().getColumn(1).setPreferredWidth(45);
		extratoContaPoupanca.getColumnModel().getColumn(1).setMinWidth(45);
		extratoContaPoupanca.getColumnModel().getColumn(2).setResizable(false);
		extratoContaPoupanca.getColumnModel().getColumn(2).setPreferredWidth(186);
		extratoContaPoupanca.getColumnModel().getColumn(2).setMinWidth(45);
		extratoContaPoupanca.getColumnModel().getColumn(3).setPreferredWidth(100);
		extratoContaPoupanca.getColumnModel().getColumn(3).setMinWidth(45);
		
		DefaultTableModel modelTableContaCorrente = (DefaultTableModel) extratoContaCorrente.getModel();
		DefaultTableModel modelTableContaPoupanca = (DefaultTableModel) extratoContaPoupanca.getModel();
		
		for(models.Extrato temp : usuario.getExtratos()) {
			if(temp.getFormaDePagamento().equals("corrente")) {
				String tipo = temp.getTipo();
				String valorModificado;
				if(tipo.equals("debito"))
					valorModificado = "<HTML><b style='color:RED'>R$ " + temp.getValor() + "</b></HTML>";
				else
					valorModificado = "<HTML><b style='color:GREEN'>R$ " + temp.getValor() + "</b></HTML>";
				modelTableContaCorrente.addRow(new Object[]{temp.getData().getDataString(), temp.getData().getHoraString(), temp.getDescricao(), valorModificado});
			} else {
				String tipo = temp.getTipo();
				String valorModificado;
				if(tipo.equals("debito"))
					valorModificado = "<HTML><b style='color:RED'>R$ " + temp.getValor() + "</b></HTML>";
				else
					valorModificado = "<HTML><b style='color:GREEN'>R$ " + temp.getValor() + "</b></HTML>";
				modelTableContaPoupanca.addRow(new Object[]{temp.getData().getDataString(), temp.getData().getHoraString(), temp.getDescricao(), valorModificado});
			}
		}
		
		tabbedPane.addTab("Conta Corrente", null, extratoContaCorrente, null);
		tabbedPane.addTab("Conta Poupança", null, extratoContaPoupanca, null);
		
		lblExtrato = new JLabel("Extrato banc\u00E1rio");
		lblExtrato.setVerticalAlignment(SwingConstants.BOTTOM);
		lblExtrato.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lblExtrato.setBounds(100, 15, 515, 30);
		panel.add(lblExtrato);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Extrato.class.getResource("/view/images/separador.png")));
		label_1.setBounds(35, 50, 560, 3);
		panel.add(label_1);
		
		UsefulSpace.add(imgBackground);
	}
	
	public static void resizeUsefulSpace(int x, int width) {
		UsefulSpace.setBounds(x, UsefulSpace.getY(), width, UsefulSpace.getHeight());
		imgBackground.setBounds(-UsefulSpace.getX(), 0, 1000, 600);
		panel.setLocation(((UsefulSpace.getWidth()-panel.getWidth())/2), ((UsefulSpace.getHeight()-panel.getHeight())/2));
	}
}
