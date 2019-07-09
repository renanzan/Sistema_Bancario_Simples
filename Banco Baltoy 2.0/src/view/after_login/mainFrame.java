package view.after_login;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import database.dao.DAO_Clientes;
import database.dao.DAO_Extratos;
import database.update.UpdatedData_Usuario;
import main.Main;
import models.Database;
import models.Date;
import models.Usuario;
import view.before_login.Login;
import view.before_login.Register;
import java.awt.Toolkit;

public class mainFrame {

	private static JFrame frame;
	private static JLayeredPane layeredMenuDesktop;
	private static JLayeredPane layeredMenus;
	
	private static JPanel showMenu;
	private static JPanel hideMenu;
	private static JPanel btnPaginaInicial;
		private static JLabel iconPaginaInicial;
		private static JPanel btnExtendedPaginaInicial;
			private static JLabel lblPginaInicial;
	private static JPanel btnRecarga;
		private static JLabel iconRecarga;
		private static JPanel btnExtendedRecarga;
			private static JLabel lblRecargas;
	private static JPanel btnContas;
		private static JLabel iconContas;
		private static JPanel btnExtendedContas;
			private static JLabel lblContas;
	private static JPanel btnTransacoes;
		private static JLabel iconTransacoes;
		private static JPanel btnExtendedTransacoes;
			private static JLabel lblTransacoes;
	private static JPanel btnContaCorrente;
		private static JLabel iconContaCorrente;
		private static JPanel btnExtendedContaCorrente;
			private static JLabel lblContaCorrente;
	private static JPanel btnSair;
		private static JLabel iconExit;
		private static JPanel btnExtendedSair;
			private static JLabel lblSair;	
	private static int elementMenuSelected;
	private static JLabel iconHideShow;
	
	private static JDesktopPane desktopPane;
	public static Date dataDoSistema;
	private static JLabel lblHora;
	private static JPanel panel_1;
	private static JLabel label;
	private static JLabel lblTitle;
	private static JLabel lblX;
	public static boolean showMenuIsVisible = true;
	
	private static Usuario usuario;
	private static Database database;
	private static JPanel panel_2;
	
	public mainFrame(Database database, Usuario usuario) {
		this.usuario = usuario;
		this.database = database;
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void initialize() {
		dataDoSistema = new Date();
		
		pressets();
		
		dataDoSistema.initializeClock(lblHora);
		
		panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int coordenadaX = arg0.getXOnScreen();
				int coordenadaY = arg0.getYOnScreen();
				
				frame.setLocation(coordenadaX, coordenadaY);
			}
		});
		panel_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(227, 227, 227)));
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(0, 0, 1000, 25);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/bank_25x25.png")));
		label.setBounds(15, 0, 25, 25);
		panel_1.add(label);
		
		lblTitle = new JLabel("Banco Baltoy");
		lblTitle.setBounds(50, 0, 250, 25);
		panel_1.add(lblTitle);
		
		lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(965, 0, 25, 25);
		panel_1.add(lblX);
	}
	
	private static void pressets() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(mainFrame.class.getResource("/view/icons/entre_25_e_50/bank_50x50.png")));
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1000, 625);
		frame.getContentPane().setLayout(null);
		
		elementMenuSelected=1;
		
		initializeLayers();
		initializeMenu();
		updateMenu();
		initializeJDesktopPane();
		initializeBackgroundImage();
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void initializeLayers() {
		layeredMenuDesktop = new JLayeredPane();
		layeredMenuDesktop.setBounds(0, 25, 1000, 600);
		frame.getContentPane().add(layeredMenuDesktop);
		
		layeredMenus = new JLayeredPane();
		layeredMenus.setBounds(0, 0, 236, 600);
		layeredMenuDesktop.add(layeredMenus);
		layeredMenuDesktop.setLayer(layeredMenus, 1);

	}
	
	private static void initializeMenu() {
		showMenu = new JPanel();
		showMenu.setBounds(33, 0, 203, 600);
		showMenu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		showMenu.setBackground(Color.WHITE);
		showMenu.setVisible(true);
		showMenuIsVisible=true;
		showMenu.setLayout(null);
		layeredMenus.add(showMenu);
		layeredMenuDesktop.setLayer(showMenu, 1);
		
		btnExtendedPaginaInicial = new JPanel();
		btnExtendedPaginaInicial.setBounds(0, 60, 200, 60);
		btnExtendedPaginaInicial.setLayout(null);
		showMenu.add(btnExtendedPaginaInicial);
		
			lblPginaInicial = new JLabel("P\u00E1gina Inicial");
			lblPginaInicial.setHorizontalAlignment(SwingConstants.CENTER);
			lblPginaInicial.setFont(new Font("Open Sans", Font.PLAIN, 24));
			lblPginaInicial.setBounds(0, 0, 200, 60);
			btnExtendedPaginaInicial.add(lblPginaInicial);
			
			btnExtendedRecarga = new JPanel();
			btnExtendedRecarga.setBounds(0, 120, 200, 60);
			btnExtendedRecarga.setLayout(null);
			showMenu.add(btnExtendedRecarga);
			
				lblRecargas = new JLabel("Recargas");
				lblRecargas.setFont(new Font("Open Sans", Font.PLAIN, 24));
				lblRecargas.setHorizontalAlignment(SwingConstants.CENTER);
				lblRecargas.setBounds(0, 0, 200, 60);
				btnExtendedRecarga.add(lblRecargas);
				
					btnExtendedContas = new JPanel();
					btnExtendedContas.setBounds(0, 180, 200, 60);
					showMenu.add(btnExtendedContas);
					btnExtendedContas.setLayout(null);
					
						lblContas = new JLabel("Contas");
						lblContas.setHorizontalAlignment(SwingConstants.CENTER);
						lblContas.setFont(new Font("Open Sans", Font.PLAIN, 24));
						lblContas.setBounds(0, 0, 200, 60);
						btnExtendedContas.add(lblContas);
									
									btnExtendedContaCorrente = new JPanel();
									btnExtendedContaCorrente.setBounds(0, 300, 200, 60);
									showMenu.add(btnExtendedContaCorrente);
									btnExtendedContaCorrente.setLayout(null);
									
									lblContaCorrente = new JLabel("Extrato");
									lblContaCorrente.setHorizontalAlignment(SwingConstants.CENTER);
									lblContaCorrente.setFont(new Font("Open Sans", Font.PLAIN, 24));
									lblContaCorrente.setBounds(0, 0, 200, 60);
									btnExtendedContaCorrente.add(lblContaCorrente);
								
								btnExtendedTransacoes = new JPanel();
								btnExtendedTransacoes.setBounds(0, 240, 200, 60);
								showMenu.add(btnExtendedTransacoes);
								btnExtendedTransacoes.setLayout(null);
								
									lblTransacoes = new JLabel("Transa\u00E7\u00F5es");
									lblTransacoes.setHorizontalAlignment(SwingConstants.CENTER);
									lblTransacoes.setFont(new Font("Open Sans", Font.PLAIN, 24));
									lblTransacoes.setBounds(0, 0, 200, 60);
									btnExtendedTransacoes.add(lblTransacoes);
									
									btnExtendedSair = new JPanel();
									btnExtendedSair.addMouseListener(new MouseAdapter() {
										@Override
										public void mousePressed(MouseEvent e) {
											Main.exit();
										}
									});
									btnExtendedSair.setBounds(0, 420, 200, 60);
									showMenu.add(btnExtendedSair);
									btnExtendedSair.setLayout(null);
									
										lblSair = new JLabel("Sair");
										lblSair.setHorizontalAlignment(SwingConstants.CENTER);
										lblSair.setFont(new Font("Open Sans", Font.PLAIN, 24));
										lblSair.setBounds(0, 0, 200, 60);
										btnExtendedSair.add(lblSair);
										JPanel btnExtendedShowHide = new JPanel();
										btnExtendedShowHide.setBounds(0, 0, 200, 60);
										btnExtendedShowHide.setBackground(new Color(226, 225, 221));
										btnExtendedShowHide.setLayout(null);
										showMenu.add(btnExtendedShowHide);
										
										panel_2 = new JPanel();
										panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
										panel_2.setBackground(Color.WHITE);
										panel_2.setBounds(140, 0, 60, 60);
										btnExtendedShowHide.add(panel_2);
										panel_2.setLayout(null);
										
										Blob imageBlob = DAO_Clientes.selectImageUser(usuario.getCliente().getCpf());
										byte[] imageBytes = null;
										BufferedImage bufferedImage = null;
										
										if(imageBlob!=null) {
											try {
												imageBytes = imageBlob.getBytes(1, (int) imageBlob.length());
												imageBlob.free();
											} catch (SQLException ex) {
												ex.printStackTrace();
											}
											
											try {
												bufferedImage = ImageIO.read(new ByteArrayInputStream(imageBytes));
											} catch (IOException ex) {
												ex.printStackTrace();
											}
										}
										
										JLabel imageUser = new JLabel("");
										imageUser.setBounds(5, 5, 50, 50);
										if(bufferedImage!=null) {
											int type = bufferedImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : bufferedImage.getType();
											BufferedImage resizedImage = new BufferedImage(50, 50, type);
											imageUser.setIcon(new ImageIcon(bufferedImage));
										} else
											imageUser.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/user_50x50_gray.png")));
										imageUser.setHorizontalAlignment(SwingConstants.CENTER);
										panel_2.add(imageUser);
										
										JLabel nomeDoUsuario = new JLabel("" + usuario.getCliente().getNome());
										nomeDoUsuario.setFont(new Font("Open Sans", Font.BOLD, 10));
										nomeDoUsuario.setForeground(Color.WHITE);
										nomeDoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
										nomeDoUsuario.setBounds(0, 0, 140, 30);
										btnExtendedShowHide.add(nomeDoUsuario);
										
										JLabel cpfDoUsuario = new JLabel(usuario.getCliente().getCpf());
										cpfDoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
										cpfDoUsuario.setForeground(Color.WHITE);
										cpfDoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
										cpfDoUsuario.setBounds(0, 30, 140, 30);
										btnExtendedShowHide.add(cpfDoUsuario);
										
										JPanel extendedDataEHora = new JPanel();
										extendedDataEHora.setBackground(Color.WHITE);
										extendedDataEHora.setBounds(0, 480, 200, 120);
										showMenu.add(extendedDataEHora);
										extendedDataEHora.setLayout(null);
										
										JLabel lblDia = new JLabel("" + dataDoSistema.getDia());
										lblDia.setForeground(new Color(191, 191, 191));
										lblDia.setBounds(-20, 10, 110, 35);
										extendedDataEHora.add(lblDia);
										lblDia.setFont(new Font("Open Sans", Font.PLAIN, 30));
										lblDia.setHorizontalAlignment(SwingConstants.CENTER);
										
										JLabel lblMes = new JLabel();
										lblMes.setForeground(new Color(191, 191, 191));
										lblMes.setBounds(-20, 40, 110, 35);
										extendedDataEHora.add(lblMes);
										lblMes.setHorizontalAlignment(SwingConstants.CENTER);
										lblMes.setFont(new Font("Open Sans", Font.PLAIN, 30));
										
										JLabel lblAno = new JLabel("" + dataDoSistema.getAno());
										lblAno.setForeground(new Color(191, 191, 191));
										lblAno.setBounds(-20, 70, 110, 35);
										extendedDataEHora.add(lblAno);
										lblAno.setHorizontalAlignment(SwingConstants.CENTER);
										lblAno.setFont(new Font("Open Sans", Font.PLAIN, 30));
										
										lblHora = new JLabel();
										lblHora.setForeground(new Color(191, 191, 191));
										lblHora.setBounds(90, 40, 110, 40);
										lblHora.setText(dataDoSistema.getHora() + ":" + dataDoSistema.getMinuto());
										extendedDataEHora.add(lblHora);
										lblHora.setHorizontalAlignment(SwingConstants.CENTER);
										lblHora.setFont(new Font("Open Sans", Font.PLAIN, 30));
				
				JPanel menu = new JPanel();
				menu.setBorder(new MatteBorder(0, 3, 3, 0, (Color) SystemColor.control));
				menu.setBounds(0, 0, 36, 600);
				layeredMenus.add(menu);
				menu.setLayout(null);
				
				hideMenu = new JPanel();
				hideMenu.setBounds(3, 0, 33, 600);
				menu.add(hideMenu);
				hideMenu.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				hideMenu.setBackground(Color.WHITE);
				hideMenu.setVisible(true);
				hideMenu.setLayout(null);
				layeredMenuDesktop.setLayer(hideMenu, 0);
				
				btnPaginaInicial = new JPanel();
				btnPaginaInicial.setBounds(0, 60, 30, 60);
				btnPaginaInicial.setLayout(null);
				hideMenu.add(btnPaginaInicial);
				
					iconPaginaInicial = new JLabel("");
					iconPaginaInicial.setBounds(2, 17, 25, 25);
					btnPaginaInicial.add(iconPaginaInicial);
					
		btnRecarga = new JPanel();
		btnRecarga.setBounds(0, 120, 30, 60);
		hideMenu.add(btnRecarga);
		btnRecarga.setLayout(null);
		
			iconRecarga = new JLabel("");
			iconRecarga.setBounds(2, 17, 25, 25);
			btnRecarga.add(iconRecarga);
			btnContas = new JPanel();
			btnContas.setBounds(0, 180, 30, 60);
			btnContas.setLayout(null);
			hideMenu.add(btnContas);
			
				iconContas = new JLabel("");
				iconContas.setBounds(2, 17, 25, 25);
				btnContas.add(iconContas);
				btnTransacoes = new JPanel();
				btnTransacoes.setBounds(0, 240, 30, 60);
				hideMenu.add(btnTransacoes);
				btnTransacoes.setLayout(null);
				
					iconTransacoes = new JLabel("");
					iconTransacoes.setBounds(2, 17, 25, 25);
					btnTransacoes.add(iconTransacoes);
						btnContaCorrente = new JPanel();
						btnContaCorrente.setBounds(0, 300, 30, 60);
						hideMenu.add(btnContaCorrente);
						btnContaCorrente.setLayout(null);
						
							iconContaCorrente = new JLabel("");
							iconContaCorrente.setBounds(2, 17, 25, 25);
							btnContaCorrente.add(iconContaCorrente);
							btnSair = new JPanel();
							btnSair.setBounds(0, 420, 30, 60);
							hideMenu.add(btnSair);
							btnSair.setLayout(null);
							
								iconExit = new JLabel("");
								iconExit.setBounds(3, 17, 25, 25);
								btnSair.add(iconExit);
								
								JPanel dataEHora = new JPanel();
								dataEHora.setBackground(Color.WHITE);
								dataEHora.setBounds(0, 480, 30, 120);
								hideMenu.add(dataEHora);
								dataEHora.setLayout(null);
								switch(dataDoSistema.getMes()) {
									case 1:
										lblMes.setText("JAN");
										break;
									case 2:
										lblMes.setText("FEV");
										break;
									case 3:
										lblMes.setText("MAR");
										break;
									case 4:
										lblMes.setText("ABR");
										break;
									case 5:
										lblMes.setText("MAI");
										break;
									case 6:
										lblMes.setText("JUN");
										break;
									case 7:
										lblMes.setText("JUL");
										break;
									case 8:
										lblMes.setText("AGO");
										break;
									case 9:
										lblMes.setText("SET");
										break;
									case 10:
										lblMes.setText("OUT");
										break;
									case 11:
										lblMes.setText("NOV");
										break;
									case 12:
										lblMes.setText("DEZ");
										break;
								}
								
								JPanel btnShowHide = new JPanel();
								btnShowHide.addMouseListener(new MouseAdapter() {
									@Override
									public void mousePressed(MouseEvent arg0) {
										showMenu.setVisible(!showMenu.isVisible());
										
										if(showMenu.isVisible()) {
											iconHideShow.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/show_25x25_white.png")));
											showMenuIsVisible = true;
											PaginaInicial.resizeUsefulSpace(230, 770);
											Recargas.resizeUsefulSpace(230, 770);
											Contas.resizeUsefulSpace(230, 770);
											PaginaInicial.resizeUsefulSpace(230, 770);
											Extrato.resizeUsefulSpace(230, 770);
											Transacoes.resizeUsefulSpace(230, 770);
											
											lblDia.setBounds(-20, 10, 110, 35);
											lblMes.setBounds(-20, 40, 110, 35);
											lblAno.setBounds(-20, 70, 110, 35);
											lblHora.setBounds(90, 40, 110, 40);
											
											lblDia.setFont(new Font("Open Sans", Font.PLAIN, 30));
											lblMes.setFont(new Font("Open Sans", Font.PLAIN, 30));
											lblAno.setFont(new Font("Open Sans", Font.PLAIN, 30));
											lblHora.setFont(new Font("Open Sans", Font.PLAIN, 30));
											
											dataEHora.remove(lblDia);
											extendedDataEHora.add(lblDia);
											
											dataEHora.remove(lblMes);
											extendedDataEHora.add(lblMes);
											
											dataEHora.remove(lblAno);
											extendedDataEHora.add(lblAno);
											
											dataEHora.remove(lblHora);
											extendedDataEHora.add(lblHora);
											
											dataEHora.repaint();
										} else {
											iconHideShow.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/hide_25x25_white.png")));
											showMenuIsVisible = false;
											PaginaInicial.resizeUsefulSpace(30, 970);
											Recargas.resizeUsefulSpace(30, 970);
											Contas.resizeUsefulSpace(30, 970);
											PaginaInicial.resizeUsefulSpace(30, 970);
											Extrato.resizeUsefulSpace(30, 970);
											Transacoes.resizeUsefulSpace(30, 970);
											
											lblDia.setBounds(0, 40, 30, 16);
											lblMes.setBounds(0, 55, 30, 16);
											lblAno.setBounds(0, 70, 30, 16);
											lblHora.setBounds(0, 90, 30, 16);
											
											lblDia.setFont(new Font("Open Sans", Font.PLAIN, 10));
											lblMes.setFont(new Font("Open Sans", Font.PLAIN, 10));
											lblAno.setFont(new Font("Open Sans", Font.PLAIN, 10));
											lblHora.setFont(new Font("Open Sans", Font.PLAIN, 10));
											
											extendedDataEHora.remove(lblDia);
											dataEHora.add(lblDia);
											
											extendedDataEHora.remove(lblMes);
											dataEHora.add(lblMes);
											
											extendedDataEHora.remove(lblAno);
											dataEHora.add(lblAno);
											
											extendedDataEHora.remove(lblHora);
											dataEHora.add(lblHora);
											
											dataEHora.repaint();
										}
									}
								});
								btnShowHide.setBackground(new Color(191, 191, 191));
								btnShowHide.setBounds(0, 0, 30, 60);
								hideMenu.add(btnShowHide);
								btnShowHide.setLayout(null);
								iconHideShow = new JLabel(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/show_25x25_white.png")));
								iconHideShow.setBounds(2, 17, 25, 25);
								btnShowHide.add(iconHideShow);
	}
	
	private static void updateMenu() {
		/** 1 BOTÃO PAGINA INICIAL **/
			
			if(elementMenuSelected==1) btnPaginaInicial.setBackground(new Color(253, 131, 68));
			else btnPaginaInicial.setBackground(Color.WHITE);
			
				if(elementMenuSelected==1) iconPaginaInicial.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/home_25x25_white.png")));
				else iconPaginaInicial.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/home_25x25_orange.png")));

				if(elementMenuSelected==1) btnExtendedPaginaInicial.setBackground(new Color(253, 131, 68));
				else btnExtendedPaginaInicial.setBackground(Color.WHITE);
			
					if(elementMenuSelected==1) lblPginaInicial.setForeground(Color.WHITE);
					else lblPginaInicial.setForeground(new Color(253, 131, 68));
			
		/** 2 BOTÃO RECARGA **/
			
			if(elementMenuSelected==2) btnRecarga.setBackground(new Color(253, 131, 68));
			else btnRecarga.setBackground(Color.WHITE);
			
				if(elementMenuSelected==2) iconRecarga.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/smartphone_25x25_white.png")));
				else iconRecarga.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/smartphone_25x25_orange.png")));
			
				if(elementMenuSelected==2) btnExtendedRecarga.setBackground(new Color(253, 131, 68));
				else btnExtendedRecarga.setBackground(Color.WHITE);
					
					if(elementMenuSelected==2) lblRecargas.setForeground(Color.WHITE);
					else lblRecargas.setForeground(new Color(253, 131, 68));
					
		/** 3 BOTÃO CONTAS **/
			if(elementMenuSelected==3) btnContas.setBackground(new Color(253, 131, 68));
			else btnContas.setBackground(Color.WHITE);
				if(elementMenuSelected==3) iconContas.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/accounts_25x25_white.png")));
				else iconContas.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/accounts_25x25_orange.png")));
				if(elementMenuSelected==3) btnExtendedContas.setBackground(new Color(253, 131, 68));
				else btnExtendedContas.setBackground(Color.WHITE);
					if(elementMenuSelected==3) lblContas.setForeground(Color.WHITE);
					else lblContas.setForeground(new Color(253, 131, 68));
			
		/** 4 BOTÃO TRANSAÇÕES **/
			if(elementMenuSelected==4) btnTransacoes.setBackground(new Color(253, 131, 68));
			else btnTransacoes.setBackground(Color.WHITE);
				if(elementMenuSelected==4) iconTransacoes.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/transactions_25x25_white.png")));
				else iconTransacoes.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/transactions_25x25_orange.png")));
				if(elementMenuSelected==4) btnExtendedTransacoes.setBackground(new Color(253, 131, 68));
				else btnExtendedTransacoes.setBackground(Color.WHITE);
					if(elementMenuSelected==4) lblTransacoes.setForeground(Color.WHITE);
					else lblTransacoes.setForeground(new Color(253, 131, 68));
				
	/** 6 BOTÃO CONFIGURAÇÕES **/
		if(elementMenuSelected==6) btnContaCorrente.setBackground(new Color(253, 131, 68));
		else btnContaCorrente.setBackground(Color.WHITE);
			if(elementMenuSelected==6) iconContaCorrente.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/extrato_25x25_white.png")));
			else iconContaCorrente.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/extrato_25x25_orange.png")));
			if(elementMenuSelected==6) btnExtendedContaCorrente.setBackground(new Color(253, 131, 68));
			else btnExtendedContaCorrente.setBackground(Color.WHITE);
			if(elementMenuSelected==6) lblContaCorrente.setForeground(Color.WHITE);
			else lblContaCorrente.setForeground(new Color(253, 131, 68));
	/** 7 BOTÃO SAIR **/
		if(elementMenuSelected==7) btnSair.setBackground(new Color(253, 131, 68));
		else btnSair.setBackground(Color.WHITE);
			if(elementMenuSelected==7) iconExit.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/exit_25x25_white.png")));
			else iconExit.setIcon(new ImageIcon(mainFrame.class.getResource("/view/icons/entre_25_e_50/exit_25x25_orange.png")));
			if(elementMenuSelected==7) btnExtendedSair.setBackground(new Color(253, 131, 68));
			else btnExtendedSair.setBackground(Color.WHITE);
				if(elementMenuSelected==7) lblSair.setForeground(Color.WHITE);
				else lblSair.setForeground(new Color(253, 131, 68));
	}
	
	private static void initializeJDesktopPane() {
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1000, 650);
		layeredMenuDesktop.add(desktopPane);
		
		PaginaInicial paginaInicial = new PaginaInicial(usuario, database);
		mouseClickChangeScreen(paginaInicial, 1);
		
		// ANIMATIONS
			simpleAnimationButton(btnPaginaInicial, btnExtendedPaginaInicial, paginaInicial, 1);
			simpleAnimationButton(btnRecarga, btnExtendedRecarga, new Recargas(database, usuario), 2);
			simpleAnimationButton(btnContas, btnExtendedContas, new Contas(database, usuario), 3);
			simpleAnimationButton(btnTransacoes, btnExtendedTransacoes, new Transacoes(database, usuario), 4);
			simpleAnimationButton(btnContaCorrente, btnExtendedContaCorrente, new Extrato(database, usuario), 6);
			simpleAnimationButton(btnSair, btnExtendedSair, null, 7);
		
		desktopPane.setBackground(new Color(0, 0, 0, 0));
	}
	
	private static void initializeBackgroundImage() {
		/* Inicializa imagem de plano de fundo */
		JLabel imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		imgBackground.setBounds(0, 25, imgBackground.getIcon().getIconWidth(), imgBackground.getIcon().getIconHeight());
		frame.getContentPane().add(imgBackground);
	}
	
	private static void simpleAnimationButton(JPanel panel, JPanel panelExtended, JInternalFrame internalFrame, int indexMenu) {
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(indexMenu==elementMenuSelected) {
					panel.setBackground(Color.BLACK);
					panelExtended.setBackground(Color.BLACK);
				} else {
					panel.setBackground(new Color(226, 225, 221));
					panelExtended.setBackground(new Color(226, 225, 221));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(indexMenu==elementMenuSelected) {
					panel.setBackground(new Color(253, 131, 68));
					panelExtended.setBackground(new Color(253, 131, 68));
				} else {
					panel.setBackground(Color.WHITE);
					panelExtended.setBackground(Color.WHITE);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(indexMenu==elementMenuSelected)
					desktopPane.removeAll();
				else
					mouseClickChangeScreen(internalFrame, indexMenu);
			}
		});
		
		panelExtended.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				if(indexMenu==elementMenuSelected) {
					panel.setBackground(Color.GRAY);
					panelExtended.setBackground(Color.GRAY);
				} else {
					panel.setBackground(new Color(226, 225, 221));
					panelExtended.setBackground(new Color(226, 225, 221));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(indexMenu==elementMenuSelected) {
					panel.setBackground(new Color(253, 131, 68));
					panelExtended.setBackground(new Color(253, 131, 68));
				} else {
					panel.setBackground(Color.WHITE);
					panelExtended.setBackground(Color.WHITE);
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				mouseClickChangeScreen(internalFrame, indexMenu);
				Contas.updateContas(usuario.getCliente().getNome(), usuario.getContaPoupanca().getNum_conta(), "" + usuario.getContaPoupanca().getSaldo(), usuario.getContaCorrente().getNum_conta(), "" + usuario.getContaCorrente().getSaldo());
			}
		});
	}

	private static void mouseClickChangeScreen(JInternalFrame internalFrame, int indexMenu) {
		desktopPane.removeAll();
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		elementMenuSelected = indexMenu;
		updateMenu();
	}
}
