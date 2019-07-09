package view.after_login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.print.attribute.standard.JobSheets;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import database.dai.DAI_Celulares_Favoritos;
import database.dai.DAI_Contas_corrente;
import database.dai.DAI_Contas_poupanca;
import database.dai.DAI_Extratos;
import database.dao.DAO_Celulares_Favoritos;
import database.dao.DAO_Contas_corrente;
import database.dao.DAO_Extratos;
import database.update.UPDATE_TABLE_Contas_corrente;
import models.CelularFavorito;
import models.Database;
import models.Extrato;
import models.Usuario;
import view.before_login.Login;
import javax.swing.JSlider;

public class Recargas extends JInternalFrame {

	private static JLayeredPane UsefulSpace;
	private static JLabel imgBackground;
	
	private static Database database;
	private static Usuario usuario;
	private static JPanel panel_11;
	private static JPanel panel_14;
	private static JLabel label;
	private static JLabel lblNewLabel;
	private static JPanel novoNumero;
	private static JLabel label_1;
	private static JLabel lblR;
	private static JLabel lblSaldoDisponvel;
	private static JLabel lblMostrar;
	private static JPanel panel_1;
	private static JPanel panel_2;
	private static JLabel lblNewLabel_1;
	private static JLabel lblNewLabel_2;
	private static JTextField txtApelido;
	private static JTextField txtDDD;
	private static JTextField txtNumero;
	private static JTextField txtConfirmarDDD;
	private static JTextField txtConirmarNumero;
	private static JComboBox comboBoxOperadora;
	private static JPanel panel_3;
	private static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_4;
	private static JLabel lblNomeOuApelido;
	private static JLabel lblDdd;
	private static JLabel lblNmeroDeCelular;
	private static JLabel label_2;
	private static JLabel lblNmeroDeCelular_1;
	private static JLabel lblOperadora;
	private static JLabel lblConfirmarNmeroDe;
	private static JPanel panel_4;
	private static JPanel panel_5;
	private static JLabel lblNewLabel_5;
	private static JLabel lblX;
	private static JPanel panel_6;
	private static JPanel panel_7;
	private static JPanel menuSaldo;
	private static JPanel favoritos;
	private static JPanel panel_12;
	private static JLabel label_6;
	private static JList list;
	private static DefaultListModel demoList;
	
	private static boolean addFavoritos;
	private static boolean mostrarSaldo;
	private static boolean mostrarNovoNumero;
	private static boolean mostrarFavoritos;
	private static boolean mostrarEfetuarRecarga;
	private static boolean mostrarMenuSaldo;
	private static boolean mostrarMenu1;
	private static JPanel menu1;
	private static JScrollPane scrollPane;
	private static JPanel panel_9;
	private static JPanel panel_10;
	private static JPanel panel_13;
	private static JPanel panel_15;
	private static JSeparator separator_1;
	private static JSeparator separator_2;
	private static JLabel lblNewLabel_6;
	private static JPanel panel_16;
	private static JPanel efetuarRecarga;
	private static JLabel lblApelidoDoContato;
	private static JLabel lblDDD_Numero;
	private static JLabel lblOperadoraDoContato;
	private static JLabel lblSelecioneOValor;
	private static CelularFavorito celularSelecionado;
	private static JLabel lblFormaDePagamento;
	private static JPanel panel_17;
	private static JPanel panel_19;
	private static JLabel lblContaCorrente;
	private static JPanel panel_20;
	private static JLabel lblContaPoupana;
	private static JPanel panel_21;
	private static JLabel lblEfetuarRecarga;
	private static JPanel panel_22;
	private static JLabel lblVoltar;
	private static boolean contaCorrente;
	private static JLabel label_5;
	
	public Recargas(Database database, Usuario usuario) {
		this.database = database;
		this.usuario = usuario;
		this.addFavoritos = false;
		this.mostrarSaldo = false;
		this.mostrarNovoNumero = true;
		this.mostrarMenuSaldo = true;
		this.mostrarMenu1 = true;
		this.mostrarFavoritos = false;
		this.mostrarEfetuarRecarga = false;
		this.demoList = new DefaultListModel();
		this.celularSelecionado = new CelularFavorito();
		this.contaCorrente = true;
		
		pressets(this);
	}
	
	private static void pressets(Recargas recargas) {
		recargas.setSize(1000, 633);
		recargas.getContentPane().setLayout(null);
		
		((BasicInternalFrameUI)recargas.getUI()).setNorthPane(null);   //retirar o painel superior
		recargas.setBorder(null);   //retirar bordas
		
		initializeLayered(recargas);
	}

	private static void initializeLayered(Recargas recargas) {
		UsefulSpace = new JLayeredPane();
		UsefulSpace.setSize(1000, 600);
		imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		UsefulSpace.setLayer(imgBackground, 2);
		imgBackground.setBounds(0, 0, 1000, 600);
		
		panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 0, 0, 0));
		UsefulSpace.setLayer(panel_11, 3);
		panel_11.setBounds(171, 80, 700, 490);
		UsefulSpace.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Recargas.class.getResource("/view/images/smartphone_vector.png")));
		label_4.setBounds(495, 55, 205, 435);
		panel_11.add(label_4);
		
		panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(0, 0, 645, 435);
		panel_11.add(panel_14);
		panel_14.setLayout(null);
		
		lblNewLabel = new JLabel("Recarga de celular");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Open Sans", Font.PLAIN, 18));
		lblNewLabel.setBounds(115, 10, 515, 30);
		panel_14.add(lblNewLabel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Recargas.class.getResource("/view/images/separador.png")));
		label.setBounds(15, 40, 615, 3);
		panel_14.add(label);
		
		menuSaldo = new JPanel();
		menuSaldo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mostrarSaldo=!mostrarSaldo;
				if(mostrarSaldo) {
					lblSaldoDisponvel.setText("" + usuario.getContaCorrente().getSaldo());
					lblMostrar.setText("Ocultar");
				} else {
					lblSaldoDisponvel.setText("Saldo disponível");
					lblMostrar.setText("Mostrar");
				}
			}
		});
		menuSaldo.setBackground(new Color(0, 0, 0, 0));
		menuSaldo.setBounds(113, 70, 278, 19);
		panel_14.add(menuSaldo);
		menuSaldo.setLayout(null);
		
		lblR = new JLabel("R$");
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setBounds(5, 0, 20, 19);
		menuSaldo.add(lblR);
		lblR.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblR.setForeground(Color.WHITE);
		
		lblSaldoDisponvel = new JLabel("Saldo dispon\u00EDvel");
		lblSaldoDisponvel.setBounds(35, 0, 170, 19);
		menuSaldo.add(lblSaldoDisponvel);
		lblSaldoDisponvel.setForeground(Color.WHITE);
		lblSaldoDisponvel.setFont(new Font("Open Sans", Font.PLAIN, 13));
		
		lblMostrar = new JLabel("Mostrar");
		lblMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrar.setBounds(215, 0, 55, 19);
		menuSaldo.add(lblMostrar);
		lblMostrar.setForeground(Color.WHITE);
		lblMostrar.setFont(new Font("Open Sans", Font.PLAIN, 13));
		
		label_1 = new JLabel("");
		label_1.setBounds(0, 0, 278, 19);
		menuSaldo.add(label_1);
		label_1.setIcon(new ImageIcon(Recargas.class.getResource("/view/images/saldo.png")));
		
		menu1 = new JPanel();
		menu1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mostrarFavoritos=!mostrarFavoritos;
				
				novoNumero.setVisible(!mostrarFavoritos);
				favoritos.setVisible(mostrarFavoritos);
				
				if(!mostrarFavoritos) {
					lblNewLabel_1.setForeground(Color.WHITE);
					lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 13));
					panel_1.setBackground(new Color(253, 131, 68));
					
					lblNewLabel_2.setForeground(new Color(253, 131, 68));
					lblNewLabel_2.setFont(new Font("Open Sans", Font.PLAIN, 13));
					panel_2.setBackground(Color.WHITE);
				} else {
					usuario.getCelularesFavoritos().clear();
					demoList.clear();
					new DAO_Celulares_Favoritos(database).getAllCelularesFavoritos(usuario);
					for(CelularFavorito temp : usuario.getCelularesFavoritos())
						demoList.addElement("<HTML><b>" + temp.getOperadora() + "</b><br>" + temp.getApelido() + "</HTML>");
					list.setModel(demoList);
					
					lblNewLabel_1.setForeground(new Color(253, 131, 68));
					lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 13));
					panel_1.setBackground(Color.WHITE);
					
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setFont(new Font("Open Sans", Font.BOLD, 13));
					panel_2.setBackground(new Color(253, 131, 68));
				}
			}
		});
		
		efetuarRecarga = new JPanel();
		efetuarRecarga.setBorder(new LineBorder(new Color(191, 191, 191)));
		efetuarRecarga.setBackground(Color.WHITE);
		efetuarRecarga.setBounds(132, 74, 240, 336);
		efetuarRecarga.setVisible(mostrarEfetuarRecarga);
		panel_14.add(efetuarRecarga);
		efetuarRecarga.setLayout(null);
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(1, 1, 238, 81);
		efetuarRecarga.add(panel_9);
		panel_9.setLayout(null);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Recargas.class.getResource("/view/icons/maior_que_50/userInCircle_60x60_gray.png")));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(10, 10, 60, 60);
		panel_9.add(lblNewLabel_6);
		
		panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(80, 0, 158, 81);
		panel_9.add(panel_16);
		panel_16.setLayout(null);
		
		lblApelidoDoContato = new JLabel();
		lblApelidoDoContato.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblApelidoDoContato.setVerticalAlignment(SwingConstants.BOTTOM);
		lblApelidoDoContato.setBounds(0, 0, 158, 27);
		panel_16.add(lblApelidoDoContato);
		
		lblDDD_Numero = new JLabel();
		lblDDD_Numero.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblDDD_Numero.setBounds(0, 27, 158, 27);
		panel_16.add(lblDDD_Numero);
		
		lblOperadoraDoContato = new JLabel();
		lblOperadoraDoContato.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblOperadoraDoContato.setVerticalAlignment(SwingConstants.TOP);
		lblOperadoraDoContato.setBounds(0, 54, 158, 27);
		panel_16.add(lblOperadoraDoContato);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(191, 191, 191));
		separator.setBounds(20, 82, 200, 3);
		efetuarRecarga.add(separator);
		
		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(1, 84, 238, 81);
		efetuarRecarga.add(panel_10);
		
		lblSelecioneOValor = new JLabel("Selecione o valor (R$)");
		lblSelecioneOValor.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblSelecioneOValor.setBounds(10, 0, 218, 20);
		panel_10.add(lblSelecioneOValor);
		
		JSlider sliderValor = new JSlider();
		sliderValor.setBackground(Color.WHITE);
		sliderValor.setValue(0);
		sliderValor.setMaximum(3);
		sliderValor.setBounds(20, 42, 200, 26);
		panel_10.add(sliderValor);
		
		JLabel label_3 = new JLabel("15");
		label_3.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(15, 20, 20, 20);
		panel_10.add(label_3);
		
		JLabel label_7 = new JLabel("30");
		label_7.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(141, 20, 20, 20);
		panel_10.add(label_7);
		
		JLabel label_8 = new JLabel("50");
		label_8.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(204, 20, 20, 20);
		panel_10.add(label_8);
		
		label_5 = new JLabel("20");
		label_5.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(77, 20, 20, 20);
		panel_10.add(label_5);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(191, 191, 191));
		separator_1.setBounds(20, 165, 200, 3);
		efetuarRecarga.add(separator_1);
		
		panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(1, 168, 238, 81);
		efetuarRecarga.add(panel_13);
		
		lblFormaDePagamento = new JLabel("Forma de pagamento");
		lblFormaDePagamento.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblFormaDePagamento.setBounds(10, 0, 218, 20);
		panel_13.add(lblFormaDePagamento);
		
		panel_17 = new JPanel();
		panel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				contaCorrente=!contaCorrente;
				if(contaCorrente==true) {
					panel_19.setBackground(new Color(253, 131, 68));
					panel_20.setBackground(Color.WHITE);
					lblContaCorrente.setForeground(Color.WHITE);
					lblContaCorrente.setFont(new Font("Open Sans", Font.BOLD, 13));
					lblContaPoupana.setForeground(new Color(253, 131, 68));
					lblContaPoupana.setFont(new Font("Open Sans", Font.PLAIN, 13));
				} else {
					panel_19.setBackground(Color.WHITE);
					panel_20.setBackground(new Color(253, 131, 68));
					lblContaPoupana.setForeground(Color.WHITE);
					lblContaPoupana.setFont(new Font("Open Sans", Font.BOLD, 12));
					lblContaCorrente.setForeground(new Color(253, 131, 68));
					lblContaCorrente.setFont(new Font("Open Sans", Font.PLAIN, 13));
				}
			}
		});
		panel_17.setBounds(14, 35, 210, 25);
		panel_13.add(panel_17);
		panel_17.setLayout(null);
		panel_17.setBackground(Color.WHITE);
		
		panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_19.setBackground(new Color(253, 131, 68));
		panel_19.setBounds(0, 0, 105, 25);
		panel_17.add(panel_19);
		
		lblContaCorrente = new JLabel("conta corrente");
		lblContaCorrente.setHorizontalAlignment(SwingConstants.CENTER);
		lblContaCorrente.setForeground(Color.WHITE);
		lblContaCorrente.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblContaCorrente.setBounds(0, 0, 105, 25);
		panel_19.add(lblContaCorrente);
		
		panel_20 = new JPanel();
		panel_20.setLayout(null);
		panel_20.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_20.setBackground(Color.WHITE);
		panel_20.setBounds(105, 0, 105, 25);
		panel_17.add(panel_20);
		
		lblContaPoupana = new JLabel("conta poupan\u00E7a");
		lblContaPoupana.setHorizontalAlignment(SwingConstants.CENTER);
		lblContaPoupana.setForeground(new Color(253, 131, 68));
		lblContaPoupana.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblContaPoupana.setBounds(0, 0, 105, 25);
		panel_20.add(lblContaPoupana);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(191, 191, 191));
		separator_2.setBounds(20, 249, 200, 3);
		efetuarRecarga.add(separator_2);
		
		panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(1, 251, 238, 84);
		efetuarRecarga.add(panel_15);
		
		panel_22 = new JPanel();
		panel_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mostrarNovoNumero=!mostrarNovoNumero;
				mostrarFavoritos=!mostrarFavoritos;
				mostrarEfetuarRecarga=!mostrarEfetuarRecarga;
				mostrarMenu1=!mostrarMenu1;
				mostrarMenuSaldo=!mostrarMenuSaldo;
				
				novoNumero.setVisible(mostrarNovoNumero);
				favoritos.setVisible(mostrarFavoritos);
				menu1.setVisible(mostrarMenu1);
				menuSaldo.setVisible(mostrarMenuSaldo);
				efetuarRecarga.setVisible(mostrarEfetuarRecarga);
			}
		});
		panel_22.setLayout(null);
		panel_22.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_22.setBackground(Color.WHITE);
		panel_22.setBounds(15, 15, 210, 25);
		panel_15.add(panel_22);
		
		lblVoltar = new JLabel("voltar");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setForeground(new Color(253, 131, 68));
		lblVoltar.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblVoltar.setBounds(0, 0, 210, 25);
		panel_22.add(lblVoltar);
		
		panel_21 = new JPanel();
		panel_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Extrato extrato = new Extrato();
				extrato.setDescricao("<HTML><b>Recarga de celular</b><br>Apelido: " + celularSelecionado.getApelido() + "<br>Número: " + celularSelecionado.getNumero() + " (" + celularSelecionado.getOperadora() + ")</HTML>");
				System.out.println(sliderValor.getValue());
				if(sliderValor.getValue()==0)
					extrato.setValor(15);
				else if(sliderValor.getValue()==1)
					extrato.setValor(20);
				else if(sliderValor.getValue()==2)
					extrato.setValor(30);
				else if(sliderValor.getValue()==3)
					extrato.setValor(50);
				extrato.setTipo("debito");
				if(contaCorrente)
					extrato.setFormaDePagamento("corrente");
				else
					extrato.setFormaDePagamento("poupanca");
				extrato.setData(mainFrame.dataDoSistema);
				extrato.setFk_num_conta(usuario.getContaCorrente().getNum_conta());
				if(contaCorrente)
					new DAI_Contas_corrente(database).updateSaldo(usuario.getContaCorrente().getNum_conta(), -extrato.getValor());
				else
					new DAI_Contas_poupanca(database).updateSaldo(usuario.getContaCorrente().getNum_conta(), -extrato.getValor());
				usuario.getContaCorrente().setSaldo(usuario.getContaCorrente().getSaldo()-extrato.getValor());
				new DAI_Extratos(database).insert(extrato);
				new UPDATE_TABLE_Contas_corrente(database, usuario);
				usuario.getExtratos().add(extrato);
				JOptionPane.showMessageDialog(null, "Recarga efetuada com sucesso!", "Sucesso", 1);
			}
		});
		panel_21.setLayout(null);
		panel_21.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_21.setBackground(new Color(253, 131, 68));
		panel_21.setBounds(15, 50, 210, 25);
		panel_15.add(panel_21);
		
		lblEfetuarRecarga = new JLabel("efetuar recarga");
		lblEfetuarRecarga.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfetuarRecarga.setForeground(Color.WHITE);
		lblEfetuarRecarga.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblEfetuarRecarga.setBounds(0, 0, 210, 25);
		panel_21.add(lblEfetuarRecarga);
		menu1.setBounds(147, 100, 210, 25);
		panel_14.add(menu1);
		menu1.setBackground(Color.WHITE);
		menu1.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 105, 25);
		menu1.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_1.setBackground(new Color(253, 131, 68));
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("novo n\u00FAmero");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 105, 25);
		panel_1.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(105, 0, 105, 25);
		menu1.add(panel_2);
		panel_2.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);
		
		lblNewLabel_2 = new JLabel("favoritos");
		lblNewLabel_2.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(new Color(253, 131, 68));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 105, 25);
		panel_2.add(lblNewLabel_2);
		
		novoNumero = new JPanel();
		novoNumero.setBorder(new LineBorder(new Color(195, 195, 195)));
		novoNumero.setBackground(Color.WHITE);
		novoNumero.setVisible(!mostrarFavoritos);
		novoNumero.setBounds(132, 74, 240, 336);
		panel_14.add(novoNumero);
		novoNumero.setLayout(null);
		
		txtApelido = new JTextField();
		txtApelido.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtApelido.setBounds(15, 86, 210, 25);
		txtApelido.setBorder(new LineBorder(new Color(253, 131, 68)));
		novoNumero.add(txtApelido);
		txtApelido.setColumns(10);
		
		txtDDD = new JTextField();
		txtDDD.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtDDD.setColumns(10);
		txtDDD.setBorder(new LineBorder(new Color(253, 131, 68)));
		txtDDD.setBounds(15, 126, 40, 25);
		novoNumero.add(txtDDD);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Open Sans", Font.PLAIN, 12));
		txtNumero.setColumns(10);
		txtNumero.setBorder(new LineBorder(new Color(253, 131, 68)));
		txtNumero.setBounds(60, 126, 165, 25);
		novoNumero.add(txtNumero);
		
		txtConfirmarDDD = new JTextField();
		txtConfirmarDDD.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtConfirmarDDD.setColumns(10);
		txtConfirmarDDD.setBorder(new LineBorder(new Color(253, 131, 68)));
		txtConfirmarDDD.setBounds(15, 200, 40, 25);
		novoNumero.add(txtConfirmarDDD);
		
		txtConirmarNumero = new JTextField();
		txtConirmarNumero.setFont(new Font("Open Sans", Font.PLAIN, 13));
		txtConirmarNumero.setColumns(10);
		txtConirmarNumero.setBorder(new LineBorder(new Color(253, 131, 68)));
		txtConirmarNumero.setBounds(60, 200, 165, 25);
		novoNumero.add(txtConirmarNumero);
		
		comboBoxOperadora = new JComboBox();
		comboBoxOperadora.setModel(new DefaultComboBoxModel(new String[] {"Oi", "Tim", "Vivo", "Claro"}));
		comboBoxOperadora.setFont(new Font("Open Sans", Font.PLAIN, 13));
		comboBoxOperadora.setBounds(15, 240, 210, 25);
		novoNumero.add(comboBoxOperadora);
		
		lblNomeOuApelido = new JLabel("Nome ou apelido");
		lblNomeOuApelido.setForeground(new Color(191, 191, 191));
		lblNomeOuApelido.setFont(new Font("Open Sans", Font.PLAIN, 10));
		lblNomeOuApelido.setBounds(15, 70, 210, 16);
		novoNumero.add(lblNomeOuApelido);
		
		lblDdd = new JLabel("DDD");
		lblDdd.setForeground(new Color(191, 191, 191));
		lblDdd.setFont(new Font("Open Sans", Font.PLAIN, 10));
		lblDdd.setBounds(15, 110, 40, 16);
		novoNumero.add(lblDdd);
		
		lblNmeroDeCelular = new JLabel("N\u00FAmero de celular");
		lblNmeroDeCelular.setForeground(new Color(191, 191, 191));
		lblNmeroDeCelular.setFont(new Font("Open Sans", Font.PLAIN, 10));
		lblNmeroDeCelular.setBounds(60, 110, 165, 16);
		novoNumero.add(lblNmeroDeCelular);
		
		label_2 = new JLabel("DDD");
		label_2.setForeground(new Color(191, 191, 191));
		label_2.setFont(new Font("Open Sans", Font.PLAIN, 10));
		label_2.setBounds(15, 184, 40, 16);
		novoNumero.add(label_2);
		
		lblNmeroDeCelular_1 = new JLabel("N\u00FAmero de celular");
		lblNmeroDeCelular_1.setForeground(new Color(191, 191, 191));
		lblNmeroDeCelular_1.setFont(new Font("Open Sans", Font.PLAIN, 10));
		lblNmeroDeCelular_1.setBounds(60, 184, 165, 16);
		novoNumero.add(lblNmeroDeCelular_1);
		
		lblOperadora = new JLabel("Operadora");
		lblOperadora.setForeground(new Color(191, 191, 191));
		lblOperadora.setFont(new Font("Open Sans", Font.PLAIN, 10));
		lblOperadora.setBounds(15, 224, 210, 16);
		novoNumero.add(lblOperadora);
		
		lblConfirmarNmeroDe = new JLabel("Confirmar n\u00FAmero de celular");
		lblConfirmarNmeroDe.setForeground(new Color(191, 191, 191));
		lblConfirmarNmeroDe.setFont(new Font("Open Sans", Font.BOLD, 10));
		lblConfirmarNmeroDe.setBounds(15, 164, 213, 16);
		novoNumero.add(lblConfirmarNmeroDe);
		
		panel_7 = new JPanel();
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addFavoritos=!addFavoritos;
				if(addFavoritos) {
					lblNewLabel_5.setText("X");
					panel_4.setBackground(Color.WHITE);
					lblX.setText("");
					panel_5.setBackground(new Color(191, 191, 191));
				} else {
					lblNewLabel_5.setText("");
					panel_4.setBackground(new Color(191, 191, 191));
					lblX.setText("X");
					panel_5.setBackground(Color.WHITE);
				}
			}
		});
		panel_7.setBackground(new Color(0, 0, 0, 0));
		panel_7.setBounds(15, 270, 210, 15);
		novoNumero.add(panel_7);
		panel_7.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Adicionar o contato aos favoritos");
		lblNewLabel_4.setBounds(0, 0, 165, 15);
		panel_7.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(191, 191, 191));
		lblNewLabel_4.setFont(new Font("Open Sans", Font.PLAIN, 10));
		
		panel_6 = new JPanel();
		panel_6.setBounds(180, 0, 30, 15);
		panel_7.add(panel_6);
		panel_6.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(191, 191, 191));
		panel_4.setBounds(0, 0, 15, 15);
		panel_6.add(panel_4);
		panel_4.setBorder(new LineBorder(new Color(191, 191, 191)));
		panel_4.setLayout(null);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setForeground(new Color(253, 131, 68));
		lblNewLabel_5.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 15, 15);
		panel_4.add(lblNewLabel_5);
		
		panel_5 = new JPanel();
		panel_5.setBounds(15, 0, 15, 15);
		panel_6.add(panel_5);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new LineBorder(new Color(191, 191, 191)));
		panel_5.setLayout(null);
		
		lblX = new JLabel("X");
		lblX.setForeground(new Color(191, 191, 191));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblX.setBounds(0, 0, 15, 15);
		panel_5.add(lblX);
		
		panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				celularSelecionado = new CelularFavorito();
				
				celularSelecionado.setApelido(txtApelido.getText());
				celularSelecionado.setDdd(txtDDD.getText());
				celularSelecionado.setNumero(txtNumero.getText());
				celularSelecionado.setOperadora(comboBoxOperadora.getSelectedItem().toString());
				celularSelecionado.setFk_cpf(usuario.getCliente().getCpf());
				
				if(addFavoritos)
					new DAI_Celulares_Favoritos(database, celularSelecionado);
				
				mostrarNovoNumero=!mostrarNovoNumero;
				mostrarEfetuarRecarga=!mostrarEfetuarRecarga;
				mostrarMenu1=!mostrarMenu1;
				mostrarMenuSaldo=!mostrarMenuSaldo;
				
				novoNumero.setVisible(mostrarNovoNumero);
				menu1.setVisible(mostrarMenu1);
				menuSaldo.setVisible(mostrarMenuSaldo);
				efetuarRecarga.setVisible(mostrarEfetuarRecarga);
				
				lblApelidoDoContato.setText(celularSelecionado.getApelido());
				lblDDD_Numero.setText("(" + celularSelecionado.getDdd() + ") " + celularSelecionado.getNumero());
				lblOperadoraDoContato.setText("Operadora: " + celularSelecionado.getOperadora());
			}
		});
		panel_3.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_3.setBackground(new Color(253, 131, 68));
		panel_3.setBounds(15, 300, 210, 25);
		novoNumero.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_3 = new JLabel("continuar");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(0, 0, 210, 25);
		panel_3.add(lblNewLabel_3);
		
		favoritos = new JPanel();
		favoritos.setBounds(132, 74, 240, 336);
		panel_14.add(favoritos);
		favoritos.setVisible(mostrarFavoritos);
		favoritos.setLayout(null);
		favoritos.setBorder(new LineBorder(new Color(195, 195, 195)));
		favoritos.setBackground(Color.WHITE);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 50, 210, 235);
		favoritos.add(scrollPane);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		list.setFont(new Font("Open Sans Light", Font.PLAIN, 12));
		list.setBorder(new LineBorder(new Color(253, 131, 68)));
		
		panel_12 = new JPanel();
		panel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				celularSelecionado = usuario.getCelularesFavoritos().get(list.getSelectedIndex());
				
				mostrarFavoritos=!mostrarFavoritos;
				mostrarEfetuarRecarga=!mostrarEfetuarRecarga;
				mostrarMenu1=!mostrarMenu1;
				mostrarMenuSaldo=!mostrarMenuSaldo;
				
				favoritos.setVisible(mostrarFavoritos);
				menu1.setVisible(mostrarMenu1);
				menuSaldo.setVisible(mostrarMenuSaldo);
				efetuarRecarga.setVisible(mostrarEfetuarRecarga);
				
				lblApelidoDoContato.setText(celularSelecionado.getApelido());
				lblDDD_Numero.setText("(" + celularSelecionado.getDdd() + ") " + celularSelecionado.getNumero());
				lblOperadoraDoContato.setText("Operadora: " + celularSelecionado.getOperadora());
			}
		});
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_12.setBackground(new Color(253, 131, 68));
		panel_12.setBounds(15, 300, 210, 25);
		favoritos.add(panel_12);
		
		label_6 = new JLabel("continuar");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_6.setBounds(0, 0, 210, 25);
		panel_12.add(label_6);
		
		if(mainFrame.showMenuIsVisible)
			Recargas.resizeUsefulSpace(230, 770);
		else
			Recargas.resizeUsefulSpace(30, 970);
		recargas.getContentPane().add(UsefulSpace);
		
		UsefulSpace.add(imgBackground);
	}
	
	public static void resizeUsefulSpace(int x, int width) {
		UsefulSpace.setBounds(x, UsefulSpace.getY(), width, UsefulSpace.getHeight());
		imgBackground.setBounds(-UsefulSpace.getX(), 0, 1000, 600);
		panel_11.setLocation(((UsefulSpace.getWidth()-panel_11.getWidth())/2), ((UsefulSpace.getHeight()-panel_11.getHeight())/2));
	}
}
