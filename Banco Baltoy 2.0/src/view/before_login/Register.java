package view.before_login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import database.dai.DAI_Celulares_Favoritos;
import database.dai.DAI_Clientes;
import database.dai.DAI_Contas_corrente;
import database.dao.DAO_Contas_corrente;
import models.CelularFavorito;
import models.Cliente;
import models.Conta;
import models.Database;
import java.awt.Toolkit;

public class Register {

	private static JFrame frame;
	private static JTextField txtCPF;
	private static JPasswordField txtSenha;
	private static JLabel switchSelect;
	private static boolean switchSelectStatus;
	private static JLabel lblNaoTemUmaConta;
	private static JLabel lblEntrarAqui;
	private static JLabel lblEntrar;
	private static JLabel lblConectar;
	private static JLabel btnClose;
	private static JTextField txtPIN;
	private static JLabel image;

	private static Cliente client;
	private static Conta contaCorrente;
	private static Database database;
	private static JTextField txtNome;
	private static JTextField txtEmail;
	
	public Register(Database database) {
		client = new Cliente();
		contaCorrente = new Conta();
		this.database = database;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/view/icons/entre_25_e_50/bank_50x50.png")));
		pressets();
	}
	
	private static void pressets() {
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 800, 600);
		frame.getContentPane().setLayout(null);
		
		initializeBtnClose();
		initializeConectar();
		initializeTextFields();
		initializeBtnEntrar();
		initializeLembreseDeMim();
		initializeEsqueceuASenha();
		initializeRegistrese();
		initializeBackgroundImage();
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void initializeBtnClose() {
		btnClose = new JLabel("X");
		btnClose.setFont(new Font("Open Sans", Font.BOLD, 15));
		btnClose.setForeground(Color.WHITE);
		btnClose.setHorizontalAlignment(SwingConstants.CENTER);
		btnClose.setBorder(new LineBorder(Color.WHITE));
		btnClose.setBounds(770, 5, 25, 25);
		
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				frame.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClose.setForeground(new Color(253, 131, 68));
				btnClose.setBorder(new LineBorder(new Color(253, 131, 68)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClose.setForeground(Color.WHITE);
				btnClose.setBorder(new LineBorder(Color.WHITE));
			}
		});
		
		frame.getContentPane().add(btnClose);
	}
	
	private static void initializeConectar() {
		lblConectar = new JLabel("Nova conta");
		lblConectar.setForeground(new Color(102, 102, 102));
		lblConectar.setFont(new Font("Open Sans", Font.PLAIN, 36));
		lblConectar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConectar.setBounds(207, 49, 426, 35);
		frame.getContentPane().add(lblConectar);
			/* Inicializa ícone: people_100x100_white.png */
			image = new JLabel(new ImageIcon(Register.class.getResource("/view/icons/maior_que_50/people_100x100_white.png")));
			image.setLocation(243, 325);
			image.setBounds(534, 102, 100, 100);
			frame.getContentPane().add(image);
	}
	
	private static void initializeBtnEntrar() {
		lblEntrar = new JLabel("Registrar");
		lblEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEntrar.setFont(new Font("Open Sans", Font.PLAIN, 32));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEntrar.setFont(new Font("Open Sans", Font.PLAIN, 30));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				client.setNome(txtNome.getText());
				client.setCpf(txtCPF.getText());
				client.setSenha(txtSenha.getText().toString());
				client.setEmail(txtEmail.getText());
				contaCorrente.setNum_conta(new DAO_Contas_corrente(database).gerarNumeroRandomicoParaContaCorrente());
				contaCorrente.setPin(txtPIN.getText());
				new DAI_Clientes(database, client);
				new DAI_Contas_corrente(database).insert(client.getCpf(), contaCorrente);
			}
		});
		
		JLabel label = new JLabel(new ImageIcon(Register.class.getResource("/view/icons/entre_25_e_50/user_50x50_gray.png")));
		label.setBounds(105, 175, 50, 50);
		frame.getContentPane().add(label);
		
		txtNome = new JTextField();
		txtNome.setText("Nome completo");
		txtNome.setForeground(new Color(102, 102, 102));
		txtNome.setFont(new Font("Open Sans Light", Font.PLAIN, 24));
		txtNome.setColumns(10);
		txtNome.setBorder(null);
		txtNome.setBounds(165, 178, 265, 43);
		frame.getContentPane().add(txtNome);
		lblEntrar.setForeground(Color.WHITE);
		lblEntrar.setFont(new Font("Open Sans", Font.PLAIN, 30));
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setBounds(230, 445, 347, 52);
		frame.getContentPane().add(lblEntrar);
	}
	
	private static void initializeLembreseDeMim() {
		switchSelectStatus = false;
		switchSelect = new JLabel();
		
		if(switchSelectStatus==true)
			switchSelect.setText("  X");
		else
			switchSelect.setText("");
		
		switchSelect.setBounds(244, 471, 25, 21);
		frame.getContentPane().add(switchSelect);
		switchSelect.setVerticalAlignment(SwingConstants.TOP);
		switchSelect.setFont(new Font("Open Sans", Font.BOLD, 16));
		switchSelect.setForeground(new Color(83, 129, 172));
		switchSelect.setHorizontalAlignment(SwingConstants.LEFT);
		
		switchSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switchSelectStatus=!switchSelectStatus;
				
				if(switchSelectStatus==true)
					switchSelect.setText("  X");
				else
					switchSelect.setText("");
			}
		});
	}
	
	private static void initializeRegistrese() {
		lblNaoTemUmaConta = new JLabel("J\u00E1 possui uma conta?");
		lblNaoTemUmaConta.setForeground(Color.WHITE);
		lblNaoTemUmaConta.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblNaoTemUmaConta.setBounds(309, 560, 120, 16);
		frame.getContentPane().add(lblNaoTemUmaConta);
		
		lblEntrarAqui = new JLabel("ENTRAR AQUI");
		SimpleAnimationButton(lblEntrarAqui);
		lblEntrarAqui.setForeground(Color.WHITE);
		lblEntrarAqui.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblEntrarAqui.setBounds(431, 560, 90, 16);
		frame.getContentPane().add(lblEntrarAqui);
	}
	
	private static void initializeEsqueceuASenha() {
	}

	private static void initializeBackgroundImage() {
		/* Inicializa imagem de plano de fundo */
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setForeground(new Color(102, 102, 102));
		txtEmail.setFont(new Font("Open Sans Light", Font.PLAIN, 24));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(165, 381, 265, 43);
		frame.getContentPane().add(txtEmail);
		
		JLabel label = new JLabel(new ImageIcon(Register.class.getResource("/view/icons/entre_25_e_50/mail_50x50_gray.png")));
		label.setBounds(105, 377, 50, 50);
		frame.getContentPane().add(label);
		
		JLabel btnBrowser = new JLabel("Carregar uma foto");
		btnBrowser.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int returnValue = fileChooser.showOpenDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					client.setDiretorioImagem(selectedFile.getAbsolutePath());
					System.out.println(client.getDiretorioImagem());
					image.setIcon(new ImageIcon(client.getDiretorioImagem()));
					image.revalidate();
				}
			}
		});
		
		btnBrowser.setHorizontalAlignment(SwingConstants.CENTER);
		btnBrowser.setFont(new Font("Open Sans Light", Font.PLAIN, 18));
		btnBrowser.setBounds(473, 218, 224, 35);
		frame.getContentPane().add(btnBrowser);
		JLabel imgBackground = new JLabel(new ImageIcon(Register.class.getResource("/view/images/BeforeLogin_Register_Background.png")));
		imgBackground.setBounds(0, 0, imgBackground.getIcon().getIconWidth(), imgBackground.getIcon().getIconHeight());
		frame.getContentPane().add(imgBackground);
	}
	
	private static void initializeTextFields() {
		/* Inicializa caixa de texto: USERNAME */
			txtCPF = new JTextField();
			txtCPF.setText("CPF");
			txtCPF.setFont(new Font("Open Sans Light", Font.PLAIN, 24));
			txtCPF.setBounds(165, 115, 265, 43);
			txtCPF.setForeground(new Color(102, 102, 102));
			txtCPF.setColumns(10);
			txtCPF.setBorder(null);
			/* Inicializa ícone: USERNAME */
				JLabel iconUser = new JLabel(new ImageIcon(Register.class.getResource("/view/icons/entre_25_e_50/user_50x50_gray.png")));
				iconUser.setBounds(105, 110, 50, 50);
				frame.getContentPane().add(iconUser);
		
		/* Inicializa caixa de texto: PASSWORD */
			txtSenha = new JPasswordField();
			txtSenha.setText("Password");
			txtSenha.setForeground(new Color(102, 102, 102));
			txtSenha.setFont(new Font("Open Sans Light", Font.PLAIN, 24));
			txtSenha.setColumns(10);
			txtSenha.setBorder(null);
			txtSenha.setBounds(165, 255, 265, 43);
			frame.getContentPane().add(txtSenha);
			/* Inicializa ícone: PASSWORD */
				JLabel iconPass = new JLabel(new ImageIcon(Register.class.getResource("/view/icons/entre_25_e_50/lock_50x50_gray.png")));
				iconPass.setBounds(105, 250, 50, 50);
				frame.getContentPane().add(iconPass);
			
		
		/* Inicializa caixa de texto: EMAIL */
			txtPIN = new JTextField();
			txtPIN.setText("PIN");
			txtPIN.setForeground(new Color(102, 102, 102));
			txtPIN.setFont(new Font("Open Sans Light", Font.PLAIN, 24));
			txtPIN.setColumns(10);
			txtPIN.setBorder(null);
			txtPIN.setBounds(165, 316, 265, 43);
			frame.getContentPane().add(txtPIN);
				/* Inicializa ícone: EMAIL */
				JLabel iconMail = new JLabel(new ImageIcon(Register.class.getResource("/view/icons/entre_25_e_50/lock_50x50_gray.png")));
				iconMail.setBounds(105, 313, 50, 50);
				frame.getContentPane().add(iconMail);
		
		pressetTextField(txtCPF, "Username");
		pressetTextField(txtSenha, "Password");
		pressetTextField(txtPIN, "Email");
		
		frame.getContentPane().add(txtCPF);
	}
	
	private static void pressetTextField(JTextField textField, String textInTextFields) {
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(textField.getText().equals(textInTextFields))
					textField.setText("");
			}
		});
		
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(textField.getText().equals(textInTextFields))
					textField.setText("");
			}
		});
	}
	
	private static void SimpleAnimationButton(JLabel jLabel) {
		jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jLabel.setForeground(new Color(253, 131, 68));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				Login login = new Login(database);
				login.initialize();
			}
		});
	}
}
