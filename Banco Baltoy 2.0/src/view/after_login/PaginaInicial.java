package view.after_login;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import database.dai.DAI_Contas_poupanca;
import database.dai.DAI_Extratos;
import database.dao.DAO_Contas_corrente;
import database.dao.DAO_Contas_poupanca;
import database.update.UPDATE_TABLE_Contas_corrente;
import models.Conta;
import models.Database;
import models.Extrato;
import models.Usuario;
import view.before_login.Login;

public class PaginaInicial extends JInternalFrame {

	private static JLayeredPane UsefulSpace;
	private static JLabel imgBackground;
	private static JLabel label;
	private static JPanel panel;
	private static JPanel panel_2;
	
	private static Usuario usuario;
	private static Database database;
	private static JLabel label_1;
	
	public PaginaInicial(Usuario usuario, Database database) {
		this.usuario = usuario;
		this.database = database;
		
		pressets(this);
	}
	
	private static void pressets(PaginaInicial recargas) {
		recargas.setSize(1000, 633);
		recargas.getContentPane().setLayout(null);
		
		((BasicInternalFrameUI)recargas.getUI()).setNorthPane(null);   //retirar o painel superior
		recargas.setBorder(null);   //retirar bordas
		
		initializeLayered(recargas);
	}

	private static void initializeLayered(PaginaInicial recargas) {
		UsefulSpace = new JLayeredPane();
		UsefulSpace.setSize(1000, 600);
		imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		imgBackground.setBounds(0, 0, 1000, 600);
		recargas.getContentPane().add(UsefulSpace);
		UsefulSpace.add(imgBackground);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(PaginaInicial.class.getResource("/view/images/banner_01.png")));
		UsefulSpace.setLayer(label, 1);
		label.setBounds(recargas.getWidth()-1000, 0, 1000, 300);
		UsefulSpace.add(label);
		
		panel = new JPanel();
		UsefulSpace.setLayer(panel, 1);
		panel.setBounds(0, 300, 1000, 300);
		panel.setBackground(new Color(0, 0, 0, 0));
		UsefulSpace.add(panel);
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 0, 0, 0));
		panel_2.setBounds(253, 37, 518, 230);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PaginaInicial.class.getResource("/view/images/anuncio.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(0, 0, 518, 230);
		panel_2.add(label_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				new DAO_Contas_poupanca(database).selectLogin(usuario);
				
				if(usuario.getContaPoupanca().getNum_conta()==null) {
					int resposta = JOptionPane.showConfirmDialog(null, "Você não possui uma conta poupança, deseja abrir uma?", "Falha ao acessar a conta poupança", JOptionPane.YES_NO_OPTION, 2);
						if(resposta==JOptionPane.YES_OPTION)
							resposta = JOptionPane.showConfirmDialog(null, "Para abrir uma conta poupança você precisa fazer um depósito mínimo de R$ 100,00 (cem reais), o valor será debitado automaticamente da sua conta corrente.\nTem certeza de que deseja abrir uma conta poupança?", "Atenção", JOptionPane.YES_NO_OPTION, 2);
								if(resposta==JOptionPane.YES_OPTION) {
									Conta contaPoupanca = new Conta();
									models.Extrato extrato = new Extrato(); 
									contaPoupanca.setNum_conta(new DAO_Contas_poupanca(database).gerarNumeroRandomicoParaContaPoupanca());
									String pin = JOptionPane.showInputDialog(
									        null, 
									        "Digite um PIN de 6 dígitos:", 
									        "Digite um PIN", 
									        JOptionPane.INFORMATION_MESSAGE
									    );
									contaPoupanca.setPin(pin);
									contaPoupanca.setSaldo(100);
									contaPoupanca.setFk_cpf(usuario.getCliente().getCpf());
									usuario.setContaPoupanca(contaPoupanca);
									
									extrato.setTipo("debito");
									extrato.setDescricao("Depósito mínimo para abertura de conta poupança.");
									extrato.setValor(100);
									extrato.setFormaDePagamento("corrente");
									extrato.setData(mainFrame.dataDoSistema);
									extrato.setFk_num_conta(usuario.getContaCorrente().getNum_conta());
									new DAI_Extratos(database).insert(extrato);
									
									extrato.setTipo("credito");
									extrato.setDescricao("Depósito mínimo para abertura de conta poupança.");
									extrato.setValor(100);
									extrato.setFormaDePagamento("poupanca");
									extrato.setFk_num_conta(contaPoupanca.getNum_conta());
									new DAI_Extratos(database).insert(extrato);
									
									usuario.getContaCorrente().setSaldo(usuario.getContaCorrente().getSaldo() - 100);
									new UPDATE_TABLE_Contas_corrente(database, usuario);
									new DAI_Contas_poupanca(database).insert(usuario.getCliente().getCpf(), contaPoupanca);
								}
				} else
					JOptionPane.showMessageDialog(null, "Você já possui uma conta poupança!", "Erro inesperado", 2);
			}
		});
		panel_1.setBounds(237, 165, 269, 52);
		panel_2.add(panel_1);
		
		if(mainFrame.showMenuIsVisible)
			PaginaInicial.resizeUsefulSpace(230, 770);
		else
			PaginaInicial.resizeUsefulSpace(30, 970);
	}
	
	public static void resizeUsefulSpace(int x, int width) {
		UsefulSpace.setBounds(x, UsefulSpace.getY(), width, UsefulSpace.getHeight());
		panel.setBounds(0, panel.getY(), width, panel.getHeight());
		imgBackground.setBounds(-UsefulSpace.getX(), 0, 1000, 600);
		label.setBounds(UsefulSpace.getWidth()-1000, 0, 1000, 300);
		centerElementInUsefulSpace(panel_2, panel);
	}
	
	public static void centerElementInUsefulSpace(JPanel jPanel, JPanel UsefulSpace) {
		jPanel.setLocation(((UsefulSpace.getWidth()-jPanel.getWidth())/2), ((UsefulSpace.getHeight()-jPanel.getHeight())/2));
	}
}
