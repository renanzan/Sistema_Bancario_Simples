package view.before_login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import database.update.UpdatedData_Usuario;
import models.Database;
import models.FileTxt;
import models.Usuario;
import view.after_login.mainFrame;
import java.awt.Toolkit;

public class Login {

	private static JFrame frame;
	private static JTextField txtCPF;
	private static JPasswordField txtSenha;
	private static JLabel switchSelect;
	private static boolean switchSelectStatus;
	private static JLabel lblLembrese;
	private static JLabel lblNaoTemUmaConta;
	private static JLabel lblRegistreseAqui;
	private static JLabel lblEntrar;
	private static JLabel lblConectar;
	private static JLabel btnClose;

	private static Database database;
	private static FileTxt file;
	
	public Login() {}
	
	public Login(Database database) {
		file = new FileTxt("lembrar.txt");
		this.database = database;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void initialize() {
		pressets();
	}
	
	private static void pressets() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/view/icons/entre_25_e_50/bank_50x50.png")));
		frame.setUndecorated(true);
		frame.setSize(800, 600);
		frame.getContentPane().setLayout(null);
		
		initializeBtnClose();
		initializeConectar();
		initializeTextFields();
		initializeBtnEntrar();
		initializeLembreseDeMim();
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
		lblConectar = new JLabel("Conectar");
		lblConectar.setForeground(new Color(102, 102, 102));
		lblConectar.setFont(new Font("Open Sans Light", Font.PLAIN, 36));
		lblConectar.setHorizontalAlignment(SwingConstants.CENTER);
		lblConectar.setBounds(205, 170, 426, 35);
		frame.getContentPane().add(lblConectar);
			/* Inicializa ícone: people_100x100_white.png */
			JLabel iconPeople = new JLabel(new ImageIcon(Login.class.getResource("/view/icons/maior_que_50/people_100x100_white.png")));
			iconPeople.setLocation(243, 325);
			iconPeople.setBounds(361, 60, 100, 100);
			frame.getContentPane().add(iconPeople);
	}
	
	private static void initializeBtnEntrar() {
		lblEntrar = new JLabel("Entrar");
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
				Usuario usuario = new Usuario();
				usuario.getCliente().setCpf(txtCPF.getText());
				usuario.getCliente().setSenha(txtSenha.getText().toString());
				new UpdatedData_Usuario(database, usuario);
				
				if(switchSelectStatus) {
					file.file_SAVE(txtCPF.getText(), txtSenha.getText().toString());
				} else {
					file.file_DELETE();
				}
				
				if(usuario.getCliente().getNome()==null) {
					JOptionPane.showMessageDialog(frame, "Username ou senha inválidos, tente novamente.", "Falha no login", 0);
					txtSenha.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "Login efetuado com sucesso, bem vindo " + usuario.getCliente().getNome() + "!", "Sucesso", 1);
					frame.dispose();
					new mainFrame(database, usuario).initialize();
				}
			}
		});
		lblEntrar.setForeground(Color.WHITE);
		lblEntrar.setFont(new Font("Open Sans Light", Font.PLAIN, 30));
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setBounds(245, 417, 347, 52);
		frame.getContentPane().add(lblEntrar);
	}
	
	private static void initializeLembreseDeMim() {
		if(file.getFile().exists()) switchSelectStatus = true;
		else switchSelectStatus = false;
		
		file.file_UPDATE(txtCPF, txtSenha);
		
		switchSelect = new JLabel();
		
		if(switchSelectStatus==true)
			switchSelect.setText("  X");
		else
			switchSelect.setText("");
		
		switchSelect.setBounds(246, 485, 25, 21);
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
		
		lblLembrese = new JLabel("Lembre-se de mim");
		SimpleAnimationButton(lblLembrese);
		
		lblLembrese.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				switchSelectStatus=!switchSelectStatus;
				
				if(switchSelectStatus==true)
					switchSelect.setText("  X");
				else
					switchSelect.setText("");
			}
		});
		
		lblLembrese.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblLembrese.setForeground(Color.WHITE);
		lblLembrese.setBounds(272, 488, 115, 16);
		frame.getContentPane().add(lblLembrese);
	}
	
	private static void initializeRegistrese() {
		lblNaoTemUmaConta = new JLabel("Ainda n\u00E3o \u00E9 nosso cliente?");
		lblNaoTemUmaConta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNaoTemUmaConta.setForeground(Color.WHITE);
		lblNaoTemUmaConta.setFont(new Font("Open Sans", Font.PLAIN, 12));
		lblNaoTemUmaConta.setBounds(193, 560, 236, 16);
		frame.getContentPane().add(lblNaoTemUmaConta);
		
		lblRegistreseAqui = new JLabel("ABRA SUA CONTA");
		SimpleAnimationButton(lblRegistreseAqui);
		lblRegistreseAqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				frame.dispose();
				Register newAccount = new Register(database);
				newAccount.initialize();
			}
		});
		lblRegistreseAqui.setForeground(Color.WHITE);
		lblRegistreseAqui.setFont(new Font("Open Sans", Font.BOLD, 12));
		lblRegistreseAqui.setBounds(431, 560, 200, 16);
		frame.getContentPane().add(lblRegistreseAqui);
	}

	private static void initializeBackgroundImage() {
		/* Inicializa imagem de plano de fundo */
		JLabel imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/BeforeLogin_Login_Background.png")));
		imgBackground.setBounds(0, 0, imgBackground.getIcon().getIconWidth(), imgBackground.getIcon().getIconHeight());
		frame.getContentPane().add(imgBackground);
	}
	
	private static void initializeTextFields() {
		/* Inicializa caixa de texto: USERNAME */
			txtCPF = new JTextField();
			txtCPF.setText("CPF");
			txtCPF.setFont(new Font("Open Sans Light", Font.PLAIN, 24));
			txtCPF.setBounds(300, 261, 265, 43);
			txtCPF.setForeground(new Color(102, 102, 102));
			txtCPF.setColumns(10);
			txtCPF.setBorder(null);
			/* Inicializa ícone: USERNAME */
				JLabel iconUser = new JLabel(new ImageIcon(Login.class.getResource("/view/icons/entre_25_e_50/user_50x50_gray.png")));
				iconUser.setBounds(250, 258, 50, 50);
				frame.getContentPane().add(iconUser);
		
		/* Inicializa caixa de texto: PASSWORD */
			txtSenha = new JPasswordField();
			txtSenha.setText("Password");
			txtSenha.setForeground(new Color(102, 102, 102));
			txtSenha.setFont(new Font("Open Sans Light", Font.PLAIN, 24));
			txtSenha.setColumns(10);
			txtSenha.setBorder(null);
			txtSenha.setBounds(300, 331, 265, 43);
			frame.getContentPane().add(txtSenha);
			/* Inicializa ícone: PASSWORD */
			JLabel iconPass = new JLabel(new ImageIcon(Login.class.getResource("/view/icons/entre_25_e_50/lock_50x50_gray.png")));
			iconPass.setBounds(250, 326, 50, 50);
			frame.getContentPane().add(iconPass);
		
		pressetTextField(txtCPF, "Username");
		pressetTextField(txtSenha, "Password");
		
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
		});
	}
}
