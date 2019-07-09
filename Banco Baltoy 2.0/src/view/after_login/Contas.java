package view.after_login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import database.dai.DAI_Contas_poupanca;
import database.dai.DAI_Extratos;
import database.dao.DAO_Contas_poupanca;
import database.update.UPDATE_TABLE_Contas_corrente;
import models.Conta;
import models.Database;
import models.Extrato;
import models.Usuario;
import view.before_login.Login;

public class Contas extends JInternalFrame {

	private static JLayeredPane UsefulSpace;
	private static JLabel imgBackground;
	private static JLayeredPane panel;
	private static Database database;
	private static Usuario usuario;
	private static int elementMenuSelected;
	private static boolean mostrarContaCorrente;
	private static boolean mostrarContaPoupanca;
	private static JLabel txt_numero_contaPoupanca;
	private static JLabel txt_numero_contaCorrente;
	private static JLabel saldoContaCorrente;
	private static JLabel saldoContaPoupanca;
	private static JPanel panel_1;
	private static JPanel panel_2;
	private static JLabel label;
	private static JLabel label_2;
	
	public static JLabel lblNomeCliente_contaPoupanca;
	public static JLabel lblNomeCliente_contaCorrente;
	public static JPanel contaPoupanca;
	
	public Contas(Database database, Usuario usuario) {
		this.database = database;
		this.usuario = usuario;
		this.elementMenuSelected = 1;
		this.mostrarContaCorrente = true;
		this.mostrarContaPoupanca = false;
		
		pressets(this);
		
		JPanel contaCorrente = new JPanel();
		contaCorrente.setBackground(Color.WHITE);
		contaCorrente.setBounds(0, 0, 500, 330);
		contaCorrente.setVisible(mostrarContaCorrente);
		panel.add(contaCorrente);
		contaCorrente.setLayout(null);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(12, 79, 473, 173);
		contaCorrente.add(panel_20);
		panel_20.setBackground(Color.WHITE);
		panel_20.setLayout(null);
		
		JLabel label_19 = new JLabel("Ol\u00E1,");
		label_19.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_19.setBounds(40, 15, 40, 16);
		panel_20.add(label_19);
		
		 lblNomeCliente_contaCorrente = new JLabel(usuario.getCliente().getNome());
		lblNomeCliente_contaCorrente.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblNomeCliente_contaCorrente.setBounds(70, 15, 403, 16);
		panel_20.add(lblNomeCliente_contaCorrente);
		
		JLabel label_21 = new JLabel("SALDO DISPON\u00CDVEL");
		label_21.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_21.setBounds(40, 95, 118, 16);
		panel_20.add(label_21);
		
		JLabel label_22 = new JLabel("R$");
		label_22.setFont(new Font("Open Sans Light", Font.PLAIN, 32));
		label_22.setBounds(105, 124, 40, 36);
		panel_20.add(label_22);
		
		saldoContaCorrente = new JLabel("" + usuario.getContaCorrente().getSaldo());
		saldoContaCorrente.setFont(new Font("Open Sans Light", Font.PLAIN, 32));
		saldoContaCorrente.setBounds(157, 124, 103, 36);
		panel_20.add(saldoContaCorrente);
		
		JLabel label_24 = new JLabel("mostrar");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setFont(new Font("Open Sans Light", Font.BOLD, 26));
		label_24.setBounds(256, 124, 134, 36);
		panel_20.add(label_24);
		
		JLabel lblNmeroDaConta = new JLabel("N\u00FAmero da conta:");
		lblNmeroDaConta.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblNmeroDaConta.setBounds(40, 44, 118, 16);
		panel_20.add(lblNmeroDaConta);
		
		 txt_numero_contaCorrente = new JLabel("" + usuario.getContaCorrente().getNum_conta());
		txt_numero_contaCorrente.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		txt_numero_contaCorrente.setBounds(157, 44, 316, 16);
		panel_20.add(txt_numero_contaCorrente);
		
		JLabel lblContaCorrente = new JLabel("Conta corrente");
		lblContaCorrente.setBounds(110, 20, 378, 30);
		contaCorrente.add(lblContaCorrente);
		lblContaCorrente.setVerticalAlignment(SwingConstants.BOTTOM);
		lblContaCorrente.setFont(new Font("Open Sans", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(15, 55, 470, 3);
		contaCorrente.add(label_3);
		label_3.setIcon(new ImageIcon(Contas.class.getResource("/view/images/separador.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(22, 265, 170, 50);
		contaCorrente.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerar cart\u00E3o virtual");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 170, 50);
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(300, 265, 170, 50);
		contaCorrente.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblBaixarEstatsticas = new JLabel("Baixar relat\u00F3rio do m\u00EAs");
		lblBaixarEstatsticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaixarEstatsticas.setBounds(0, 0, 170, 50);
		panel_4.add(lblBaixarEstatsticas);
		
		contaPoupanca = new JPanel();
		panel.setLayer(contaPoupanca, 0);
		contaPoupanca.setBounds(0, 0, 500, 331);
		contaPoupanca.setVisible(mostrarContaPoupanca);
		panel.add(contaPoupanca);
		UsefulSpace.setLayer(contaPoupanca, 1);
		contaPoupanca.setLayout(null);
		contaPoupanca.setBorder(null);
		contaPoupanca.setBackground(Color.WHITE);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(12, 79, 473, 173);
		contaPoupanca.add(panel_1_1);
		
		JLabel label_9 = new JLabel("Ol\u00E1,");
		label_9.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_9.setBounds(40, 15, 40, 16);
		panel_1_1.add(label_9);
		
		lblNomeCliente_contaPoupanca = new JLabel(usuario.getCliente().getNome());
		lblNomeCliente_contaPoupanca.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblNomeCliente_contaPoupanca.setBounds(70, 15, 403, 16);
		panel_1_1.add(lblNomeCliente_contaPoupanca);
		
		JLabel label_2_1 = new JLabel("SALDO DISPON\u00CDVEL");
		label_2_1.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_2_1.setBounds(40, 95, 118, 16);
		panel_1_1.add(label_2_1);
		
		JLabel label_3_1 = new JLabel("R$");
		label_3_1.setFont(new Font("Open Sans Light", Font.PLAIN, 32));
		label_3_1.setBounds(105, 124, 40, 36);
		panel_1_1.add(label_3_1);
		
		saldoContaPoupanca = new JLabel("" + usuario.getContaPoupanca().getSaldo());
		saldoContaPoupanca.setFont(new Font("Open Sans Light", Font.PLAIN, 32));
		saldoContaPoupanca.setBounds(157, 124, 103, 36);
		panel_1_1.add(saldoContaPoupanca);
		
		JLabel label_5 = new JLabel("mostrar");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Open Sans Light", Font.BOLD, 26));
		label_5.setBounds(256, 124, 134, 36);
		panel_1_1.add(label_5);
		
		JLabel label_6 = new JLabel("N\u00FAmero da conta:");
		label_6.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_6.setBounds(40, 44, 118, 16);
		panel_1_1.add(label_6);
		
		txt_numero_contaPoupanca = new JLabel(usuario.getContaPoupanca().getNum_conta());
		txt_numero_contaPoupanca.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		txt_numero_contaPoupanca.setBounds(157, 44, 316, 16);
		panel_1_1.add(txt_numero_contaPoupanca);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(Contas.class.getResource("/view/images/separador.png")));
		label_8.setBounds(15, 55, 470, 3);
		contaPoupanca.add(label_8);
		
		JLabel lblContaPoupana = new JLabel("Conta poupan\u00E7a");
		lblContaPoupana.setVerticalAlignment(SwingConstants.BOTTOM);
		lblContaPoupana.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lblContaPoupana.setBounds(110, 20, 378, 30);
		contaPoupanca.add(lblContaPoupana);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(22, 265, 170, 50);
		contaPoupanca.add(panel_2_1);
		
		JLabel label_10 = new JLabel("Gerar cart\u00E3o virtual");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setBounds(0, 0, 170, 50);
		panel_2_1.add(label_10);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(301, 265, 170, 50);
		contaPoupanca.add(panel_3_1);
		
		JLabel label_11 = new JLabel("Baixar relat\u00F3rio do m\u00EAs");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setBounds(0, 0, 170, 50);
		panel_3_1.add(label_11);
		
		JPanel internalMenu = new JPanel();
		internalMenu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		internalMenu.setBackground(Color.WHITE);
		UsefulSpace.setLayer(internalMenu, 2);
		internalMenu.setBounds(0, 0, 1000, 62);
		UsefulSpace.add(internalMenu);
		internalMenu.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 60, 60);
		internalMenu.add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 60, 60);
		panel_1.add(label);
		
		panel_2 = new JPanel();
		panel_2.setBounds(60, 0, 60, 60);
		internalMenu.add(panel_2);
		panel_2.setLayout(null);
		
		label_2 = new JLabel("");
		label_2.setBackground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 0, 60, 60);
		panel_2.add(label_2);
		
			updateMenu();
			simpleAnimationButton(panel_1, 1);
			simpleAnimationButton(panel_2, 2);
		
		// CASOS ESPECÍFICOS
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(!mostrarContaCorrente) {
						mostrarContaCorrente=!mostrarContaCorrente;
						mostrarContaPoupanca=!mostrarContaPoupanca;
						contaCorrente.setVisible(mostrarContaCorrente);
						contaPoupanca.setVisible(mostrarContaPoupanca);
						panel_1.setBackground(new Color(253, 131, 68));
						elementMenuSelected=1;
						updateMenu();
					}
				}
			});
			panel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(usuario.getContaPoupanca().getNum_conta()!=null) {
						if(!mostrarContaPoupanca) {
							mostrarContaCorrente=!mostrarContaCorrente;
							mostrarContaPoupanca=!mostrarContaPoupanca;
							contaCorrente.setVisible(mostrarContaCorrente);
							contaPoupanca.setVisible(mostrarContaPoupanca);
							panel_2.setBackground(new Color(253, 131, 68));
							elementMenuSelected=2;
							updateMenu();
						}
					} else {
						System.out.println("Você não tem uma conta poupança...");
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
					}		
				}
			});
	}
	
	static JSlider getSlider(final JOptionPane optionPane) {
		final Integer[] VALUES = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
	    JSlider slider = new JSlider();
	    final Hashtable<Integer, JLabel> LABELS = new Hashtable<>();
            for(int i = 0; i < VALUES.length; ++i) {
            	LABELS.put(i, new JLabel(VALUES[i].toString()));
            }
        slider = new JSlider(0, VALUES.length - 1, 0);
        slider.setLabelTable(LABELS);      
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(1);
	    ChangeListener changeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	        JSlider theSlider = (JSlider) changeEvent.getSource();
	        if (!theSlider.getValueIsAdjusting()) {
	          optionPane.setInputValue(new Integer(theSlider.getValue()));
	        }
	      }
	    };
	    slider.addChangeListener(changeListener);
	    return slider;
	  }
	
	private static void updateMenu() {
		if(elementMenuSelected==1) {
			panel_1.setBackground(new Color(253, 131, 68));
			label.setIcon(new ImageIcon(Contas.class.getResource("/view/icons/entre_25_e_50/carteira_25x25_white.png")));
		} else {
			panel_1.setBackground(Color.WHITE);
			label.setIcon(new ImageIcon(Contas.class.getResource("/view/icons/entre_25_e_50/carteira_25x25_orange.png")));
		}
			
		if(elementMenuSelected==2) {
			panel_2.setBackground(new Color(253, 131, 68));
			label_2.setIcon(new ImageIcon(Contas.class.getResource("/view/icons/entre_25_e_50/ass_25x25_white.png")));
		} else {
			panel_2.setBackground(Color.WHITE);
			label_2.setIcon(new ImageIcon(Contas.class.getResource("/view/icons/entre_25_e_50/ass_25x25_orange.png")));
		}
	}
	
	private static void pressets(Contas recargas) {
		recargas.setSize(1000, 633);
		recargas.getContentPane().setLayout(null);
		
		((BasicInternalFrameUI)recargas.getUI()).setNorthPane(null);   //retirar o painel superior
		recargas.setBorder(null);   //retirar bordas
		
		initializeLayered(recargas);
	}

	private static void initializeLayered(Contas recargas) {
		UsefulSpace = new JLayeredPane();
		UsefulSpace.setSize(1000, 600);
		imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		imgBackground.setSize(1000, 600);
		
		panel = new JLayeredPane();
		UsefulSpace.setLayer(panel, 1);
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(200, 140, 500, 330);
		UsefulSpace.add(panel);
		
		if(mainFrame.showMenuIsVisible)
			Contas.resizeUsefulSpace(230, 770);
		else
			Contas.resizeUsefulSpace(30, 970);
		recargas.getContentPane().add(UsefulSpace);
		
		UsefulSpace.add(imgBackground);
	}
	
	private static void simpleAnimationButton(JPanel panel, int indexMenu) {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(indexMenu==elementMenuSelected) {
					panel.setBackground(Color.GRAY);
				} else {
					panel.setBackground(new Color(226, 225, 221));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(indexMenu==elementMenuSelected) {
					panel.setBackground(new Color(253, 131, 68));
				} else {
					panel.setBackground(Color.WHITE);
				}
			}
		});
	}
	
	public static void updateContas(String nome, String num_conta_corrente, String saldo_conta_corrente, String num_conta_poupanca, String saldo_conta_poupanca) {
		lblNomeCliente_contaCorrente.setText(nome);
		lblNomeCliente_contaPoupanca.setText(nome);
		txt_numero_contaPoupanca.setText(num_conta_corrente);
		txt_numero_contaCorrente.setText(num_conta_poupanca);
		saldoContaPoupanca.setText(saldo_conta_corrente);
		saldoContaCorrente.setText(saldo_conta_poupanca);
	}
	
	public static void resizeUsefulSpace(int x, int width) {
		UsefulSpace.setBounds(x, UsefulSpace.getY(), width, UsefulSpace.getHeight());
		imgBackground.setBounds(-UsefulSpace.getX(), 0, 1000, 600);
		panel.setLocation(((UsefulSpace.getWidth()-panel.getWidth())/2), ((UsefulSpace.getHeight()-panel.getHeight())/2));
	}
}
