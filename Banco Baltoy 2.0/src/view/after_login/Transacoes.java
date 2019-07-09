package view.after_login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import database.dai.DAI_Contas_corrente;
import database.dai.DAI_Contas_poupanca;
import database.dai.DAI_Emprestimo;
import database.dai.DAI_Extratos;
import database.dao.DAO_Clientes;
import database.dao.DAO_Contas_poupanca;
import database.dao.DAO_Emprestimo;
import models.Conta;
import models.Database;
import models.Extrato;
import models.Usuario;
import view.before_login.Login;

public class Transacoes extends JInternalFrame {

	private static JLayeredPane UsefulSpace;
	private static JLabel imgBackground;
	
	private static JPanel panel;
	private static JPanel btnTransferencia;
	private static JPanel btnEmprestimo;
	private static JPanel panel_4;
	private static JLabel lblNmeroDaConta;
	private static JPanel panelContaCorrente;
	private static JPanel panelContaPoupanca;
	private static JLabel lblContaCorrente;
	private static JLabel lblContaPoupanca;
	private static JPanel panel_7;
	private static JPanel panel_8;
	private static JLabel lblNewLabel;
	private static JLabel lblDadosDaConta;
	private static JLabel lblNome;
	private static JLabel lblNmeroDaConta_1;
	private static JLabel lblTipoDeConta;
	private static JLabel lblValorATransferir;
	private static JLabel lblSeuSaldoAps;
	private static JPanel panel_10;
	private static JLabel lblEfetuarTransfernia;
	private static JPanel panel_11;
	private static JLabel lblNumeroContaDestino;
	private static JPanel panel_12;
	private static JLabel lblNomeClienteDestino;
	private static JPanel panel_13;
	private static JLabel lblTipoContaDestino;
	private static JPanel panel_14;
	private static JLabel lblValorDaTransacao;
	private static JPanel panel_15;
	private static JLabel lblSeuSaldoFinal;
	private static JLabel lblNewLabel_2;
	private static JPanel panel_16;
	private static JPanel Emprestimo;
	private static JPanel panel_18;
	private static JPanel panel_19;
	private static JLabel lblInformaesDoEmprstimo;
	private static JLabel lblValorDoEmprstimo;
	private static JLabel lblJurosFixo;
	private static JLabel lblJurosFixo_1;
	private static JLabel lblValorAPagar;
	private static JPanel panel_20;
	private static JLabel lblQuitar;
	private static JPanel panel_21;
	private static JLabel lblValorEmprestimo;
	private static JPanel panel_22;
	private static JLabel lblDataEmprestimo;
	private static JPanel panel_23;
	private static JLabel lblJuros;
	private static JPanel panel_24;
	private static JLabel lblEmprestimoValorAPagar;
	private static JPanel panel_17;
	private static JLabel lblSolicitar;
	private static JLabel label_4;
	private static JPanel panel_3;
	private static JLabel lblJurosMensalDe;
	private static JTextField txtValor;
	private static JTextField txtNumeroDaConta;
	private static JPanel Transferencia;
	private static JLabel lblTransferencia;
	private static JLabel lblEmprestimo;
	private static JLabel lblMesesAtraso;
	
	private static boolean contaCorrente;
	private static boolean mostrarTransferencia;
	private static Usuario usuario;
	public static Database database;
	private static JTextField txtValorEmprestimo;
	private static JLabel lblValorJuros;
	
	public Transacoes(Database database, Usuario usuario) {
		this.usuario = usuario;
		this.contaCorrente = true;
		this.mostrarTransferencia = true;
		this.database = database;
		
		pressets(this);
	}
	
	private static void pressets(Transacoes recargas) {
		recargas.setSize(1000, 633);
		recargas.getContentPane().setLayout(null);
		
		((BasicInternalFrameUI)recargas.getUI()).setNorthPane(null);   //retirar o painel superior
		recargas.setBorder(null);   //retirar bordas
		
		initializeLayered(recargas);
	}

	private static void initializeLayered(Transacoes recargas) {
		UsefulSpace = new JLayeredPane();
		UsefulSpace.setSize(1000, 600);
		imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		imgBackground.setSize(1000, 600);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(225, 25, 550, 550);
		UsefulSpace.add(panel);
		panel.setLayout(null);
		
		btnTransferencia = new JPanel();
		btnTransferencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(mostrarTransferencia==false) {
					btnTransferencia.setBackground(new Color(253, 131, 68));
					lblTransferencia.setForeground(Color.WHITE);
					lblTransferencia.setFont(new Font("Open Sans Light", Font.BOLD, 13));
					
					btnEmprestimo.setBackground(Color.WHITE);
					lblEmprestimo.setForeground(new Color(253, 131, 68));
					lblEmprestimo.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
					
					mostrarTransferencia=!mostrarTransferencia;
					Transferencia.setVisible(mostrarTransferencia);
					Emprestimo.setVisible(!mostrarTransferencia);
				}
			}
		});
		btnTransferencia.setBorder(new LineBorder(new Color(253, 131, 68)));
		btnTransferencia.setBackground(new Color(253, 131, 68));
		btnTransferencia.setBounds(125, 10, 150, 50);
		panel.add(btnTransferencia);
		btnTransferencia.setLayout(null);
		
		lblTransferencia = new JLabel("Transfer\u00EAncia");
		lblTransferencia.setForeground(Color.WHITE);
		lblTransferencia.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblTransferencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferencia.setBounds(0, 0, 150, 50);
		btnTransferencia.add(lblTransferencia);
		
		btnEmprestimo = new JPanel();
		btnEmprestimo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(mostrarTransferencia==true) {
					btnEmprestimo.setBackground(new Color(253, 131, 68));
					lblEmprestimo.setForeground(Color.WHITE);
					lblEmprestimo.setFont(new Font("Open Sans Light", Font.BOLD, 13));
					
					btnTransferencia.setBackground(Color.WHITE);
					lblTransferencia.setForeground(new Color(253, 131, 68));
					lblTransferencia.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
					
					new DAO_Emprestimo(database).select_fk_Cpf_cliente(usuario.getCliente());
					if(usuario.getCliente().getEmprestimo().getValor_emprestimo()==-1)
						txtValorEmprestimo.setEnabled(true);
					else {
						txtValorEmprestimo.setEnabled(false);
						lblValorEmprestimo.setText("" + usuario.getCliente().getEmprestimo().getValor_emprestimo());
						lblDataEmprestimo.setText(usuario.getCliente().getEmprestimo().getData().getDataString());
						lblJuros.setText(lblValorJuros.getText().substring(0, lblValorJuros.getText().length()-1));
						
						int anos = mainFrame.dataDoSistema.getAno() - usuario.getCliente().getEmprestimo().getData().getAno();
						int meses = (anos*12) + mainFrame.dataDoSistema.getMes() - usuario.getCliente().getEmprestimo().getData().getMes();
						float valorAPagar = (float) usuario.getCliente().getEmprestimo().getValor_emprestimo() + (meses * (usuario.getCliente().getEmprestimo().getValor_emprestimo()*((Float.parseFloat(lblJuros.getText())/100))));
						
						lblMesesAtraso.setText("" + meses);
						lblEmprestimoValorAPagar.setText("" + valorAPagar);
					}
					mostrarTransferencia=!mostrarTransferencia;
					Transferencia.setVisible(mostrarTransferencia);
					Emprestimo.setVisible(!mostrarTransferencia);
				}
			}
		});
		btnEmprestimo.setBorder(new LineBorder(new Color(253, 131, 68)));
		btnEmprestimo.setBackground(Color.WHITE);
		btnEmprestimo.setBounds(275, 10, 150, 50);
		panel.add(btnEmprestimo);
		btnEmprestimo.setLayout(null);
		
		lblEmprestimo = new JLabel("Empr\u00E9stimo");
		lblEmprestimo.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblEmprestimo.setForeground(new Color(253, 131, 68));
		lblEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprestimo.setBounds(0, 0, 150, 50);
		btnEmprestimo.add(lblEmprestimo);
		
		Transferencia = new JPanel();
		Transferencia.setBackground(Color.WHITE);
		Transferencia.setBorder(null);
		Transferencia.setBounds(0, 70, 550, 450);
		Transferencia.setVisible(mostrarTransferencia);
		
		Emprestimo = new JPanel();
		Emprestimo.setBackground(Color.WHITE);
		Emprestimo.setBounds(0, 70, 550, 450);
		Emprestimo.setVisible(!mostrarTransferencia);
		panel.add(Emprestimo);
		Emprestimo.setLayout(null);
		
		panel_18 = new JPanel();
		panel_18.setBorder(new MatteBorder(1, 0, 1, 0, new Color(253, 131, 68)));
		panel_18.setBackground(Color.WHITE);
		panel_18.setBounds(0, 0, 550, 200);
		Emprestimo.add(panel_18);
		panel_18.setLayout(null);
		
		panel_17 = new JPanel();
		panel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				models.Emprestimo emprestimo = new models.Emprestimo();
				emprestimo.setValor_emprestimo(Float.parseFloat(txtValorEmprestimo.getText()));
				emprestimo.setData(mainFrame.dataDoSistema);
				emprestimo.setFk_cpf_cliente(usuario.getCliente().getCpf());
				
				lblValorEmprestimo.setText("" + emprestimo.getValor_emprestimo());
				lblDataEmprestimo.setText(emprestimo.getData().getDataString());
				lblJuros.setText(lblValorJuros.getText().substring(0, lblValorJuros.getText().length()-1));
				
				int anos = mainFrame.dataDoSistema.getAno() - emprestimo.getData().getAno();
				int meses = (anos*12) + mainFrame.dataDoSistema.getMes() - emprestimo.getData().getMes();
				float valorAPagar = (float) emprestimo.getValor_emprestimo() + (meses * (emprestimo.getValor_emprestimo()*((Float.parseFloat(lblJuros.getText())/100))));
				
				lblMesesAtraso.setText("" + meses);
				lblEmprestimoValorAPagar.setText("" + valorAPagar);
				
				JOptionPane.showMessageDialog(null, "Empréstimo efetuado", "Sucesso", 1);
				txtValorEmprestimo.setEnabled(false);
				new DAI_Emprestimo(database).insert(emprestimo);
				new DAI_Contas_corrente(database).updateSaldo(usuario.getContaCorrente().getNum_conta(), Float.parseFloat(lblValorEmprestimo.getText()));
				
				Extrato extrato = new Extrato();
				extrato.setData(mainFrame.dataDoSistema);
				extrato.setDescricao("Empréstimo");
				extrato.setFormaDePagamento("corrente");
				extrato.setValor(Float.parseFloat(lblValorEmprestimo.getText()));
				extrato.setFk_num_conta(usuario.getContaCorrente().getNum_conta());
				extrato.setTipo("credito");
				new DAI_Extratos(database).insert(extrato);
			}
		});
		panel_17.setLayout(null);
		panel_17.setBackground(new Color(253, 131, 68));
		panel_17.setBounds(175, 150, 200, 35);
		panel_18.add(panel_17);
		
		lblSolicitar = new JLabel("Solicitar");
		lblSolicitar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicitar.setForeground(Color.WHITE);
		lblSolicitar.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
		lblSolicitar.setBounds(0, 0, 200, 35);
		panel_17.add(lblSolicitar);
		
		label_4 = new JLabel("Valor (R$)");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		label_4.setBounds(10, 60, 530, 16);
		panel_18.add(label_4);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(10, 80, 530, 25);
		panel_18.add(panel_3);
		
		txtValorEmprestimo = new JTextField();
		txtValorEmprestimo.setColumns(10);
		txtValorEmprestimo.setBorder(null);
		txtValorEmprestimo.setBackground(new Color(245, 245, 245));
		txtValorEmprestimo.setBounds(5, 1, 520, 20);
		panel_3.add(txtValorEmprestimo);
		
		lblJurosMensalDe = new JLabel("Juros mensal de ");
		lblJurosMensalDe.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJurosMensalDe.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblJurosMensalDe.setBounds(10, 25, 470, 16);
		panel_18.add(lblJurosMensalDe);
		
		lblValorJuros = new JLabel("4.79%");
		lblValorJuros.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorJuros.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblValorJuros.setBounds(480, 25, 60, 16);
		panel_18.add(lblValorJuros);
		
		panel_19 = new JPanel();
		panel_19.setLayout(null);
		panel_19.setBorder(null);
		panel_19.setBackground(new Color(253, 131, 68));
		panel_19.setBounds(0, 200, 550, 250);
		Emprestimo.add(panel_19);
		
		lblInformaesDoEmprstimo = new JLabel("Empr\u00E9stimo pendente");
		lblInformaesDoEmprstimo.setForeground(Color.WHITE);
		lblInformaesDoEmprstimo.setFont(new Font("Open Sans Light", Font.BOLD, 15));
		lblInformaesDoEmprstimo.setBounds(12, 13, 526, 16);
		panel_19.add(lblInformaesDoEmprstimo);
		
		lblValorDoEmprstimo = new JLabel("Valor do empr\u00E9stimo");
		lblValorDoEmprstimo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDoEmprstimo.setForeground(Color.WHITE);
		lblValorDoEmprstimo.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblValorDoEmprstimo.setBounds(10, 50, 180, 20);
		panel_19.add(lblValorDoEmprstimo);
		
		lblJurosFixo = new JLabel("Data do empr\u00E9stimo");
		lblJurosFixo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJurosFixo.setForeground(Color.WHITE);
		lblJurosFixo.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblJurosFixo.setBounds(10, 80, 180, 20);
		panel_19.add(lblJurosFixo);
		
		lblJurosFixo_1 = new JLabel("Juros fixo");
		lblJurosFixo_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJurosFixo_1.setForeground(Color.WHITE);
		lblJurosFixo_1.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblJurosFixo_1.setBounds(10, 110, 180, 20);
		panel_19.add(lblJurosFixo_1);
		
		lblValorAPagar = new JLabel("Valor a pagar");
		lblValorAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorAPagar.setForeground(Color.WHITE);
		lblValorAPagar.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblValorAPagar.setBounds(10, 140, 180, 20);
		panel_19.add(lblValorAPagar);
		
		panel_20 = new JPanel();
		panel_20.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				new DAI_Contas_corrente(database).updateSaldo(usuario.getContaCorrente().getNum_conta(), -Float.parseFloat(lblEmprestimoValorAPagar.getText()));
				new DAO_Emprestimo(database).delete_Emprestimo(usuario.getCliente().getCpf());
				Extrato extrato = new Extrato();
				extrato.setData(mainFrame.dataDoSistema);
				extrato.setDescricao("Pagamento de empréstimo.");
				extrato.setFk_num_conta(usuario.getContaCorrente().getNum_conta());
				extrato.setFormaDePagamento("corrente");
				extrato.setValor(Float.parseFloat(lblEmprestimoValorAPagar.getText()));
				extrato.setTipo("debito");
				new DAI_Extratos(database).insert(extrato);
				JOptionPane.showMessageDialog(null, "O empréstimo foi quitado.", "Sucesso", 1);
			}
		});
		panel_20.setLayout(null);
		panel_20.setBackground(Color.WHITE);
		panel_20.setBounds(178, 201, 200, 35);
		panel_19.add(panel_20);
		
		lblQuitar = new JLabel("Quitar empr\u00E9stimo");
		lblQuitar.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuitar.setForeground(new Color(253, 131, 68));
		lblQuitar.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
		lblQuitar.setBounds(0, 0, 200, 35);
		panel_20.add(lblQuitar);
		
		panel_21 = new JPanel();
		panel_21.setLayout(null);
		panel_21.setBorder(new LineBorder(Color.WHITE));
		panel_21.setBackground(new Color(253, 131, 68));
		panel_21.setBounds(200, 50, 320, 20);
		panel_19.add(panel_21);
		
		lblValorEmprestimo = new JLabel("<VALOR DO EMPR\u00C9STIMO>");
		lblValorEmprestimo.setForeground(Color.WHITE);
		lblValorEmprestimo.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblValorEmprestimo.setBounds(10, 0, 300, 20);
		panel_21.add(lblValorEmprestimo);
		
		panel_22 = new JPanel();
		panel_22.setLayout(null);
		panel_22.setBorder(new LineBorder(Color.WHITE));
		panel_22.setBackground(new Color(253, 131, 68));
		panel_22.setBounds(200, 80, 320, 20);
		panel_19.add(panel_22);
		
		lblDataEmprestimo = new JLabel("<DATA DO EMPR\u00C9STIMO>");
		lblDataEmprestimo.setForeground(Color.WHITE);
		lblDataEmprestimo.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblDataEmprestimo.setBounds(10, 0, 300, 20);
		panel_22.add(lblDataEmprestimo);
		
		panel_23 = new JPanel();
		panel_23.setLayout(null);
		panel_23.setBorder(new LineBorder(Color.WHITE));
		panel_23.setBackground(new Color(253, 131, 68));
		panel_23.setBounds(200, 110, 320, 20);
		panel_19.add(panel_23);
		
		lblJuros = new JLabel("<JUROS>");
		lblJuros.setForeground(Color.WHITE);
		lblJuros.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblJuros.setBounds(10, 0, 300, 20);
		panel_23.add(lblJuros);
		
		panel_24 = new JPanel();
		panel_24.setLayout(null);
		panel_24.setBorder(new LineBorder(Color.WHITE));
		panel_24.setBackground(new Color(253, 131, 68));
		panel_24.setBounds(200, 140, 320, 20);
		panel_19.add(panel_24);
		
		lblEmprestimoValorAPagar = new JLabel("<VALOR A PAGAR>");
		lblEmprestimoValorAPagar.setForeground(Color.WHITE);
		lblEmprestimoValorAPagar.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblEmprestimoValorAPagar.setBounds(10, 0, 300, 20);
		panel_24.add(lblEmprestimoValorAPagar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(Color.WHITE));
		panel_1.setBackground(new Color(253, 131, 68));
		panel_1.setBounds(200, 173, 320, 20);
		panel_19.add(panel_1);
		
		lblMesesAtraso = new JLabel("<MESES>");
		lblMesesAtraso.setForeground(Color.WHITE);
		lblMesesAtraso.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblMesesAtraso.setBounds(10, 0, 300, 20);
		panel_1.add(lblMesesAtraso);
		
		JLabel lblMeses = new JLabel("Meses");
		lblMeses.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMeses.setForeground(Color.WHITE);
		lblMeses.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblMeses.setBounds(10, 173, 180, 20);
		panel_19.add(lblMeses);
		panel.add(Transferencia);
		Transferencia.setLayout(null);
		
		panel_8 = new JPanel();
		panel_8.setBorder(null);
		panel_8.setBackground(new Color(253, 131, 68));
		panel_8.setBounds(0, 200, 550, 250);
		Transferencia.add(panel_8);
		panel_8.setLayout(null);
		
		lblDadosDaConta = new JLabel("Informa\u00E7\u00F5es da transfer\u00EAncia");
		lblDadosDaConta.setFont(new Font("Open Sans Light", Font.BOLD, 15));
		lblDadosDaConta.setForeground(Color.WHITE);
		lblDadosDaConta.setBounds(12, 13, 526, 16);
		panel_8.add(lblDadosDaConta);
		
		lblNmeroDaConta_1 = new JLabel("N\u00FAmero da conta destino");
		lblNmeroDaConta_1.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblNmeroDaConta_1.setForeground(Color.WHITE);
		lblNmeroDaConta_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNmeroDaConta_1.setBounds(10, 50, 180, 20);
		panel_8.add(lblNmeroDaConta_1);
		
		lblNome = new JLabel("Nome do cliente destino");
		lblNome.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(10, 80, 180, 20);
		panel_8.add(lblNome);
		
		lblTipoDeConta = new JLabel("Tipo da conta destino");
		lblTipoDeConta.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblTipoDeConta.setForeground(Color.WHITE);
		lblTipoDeConta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeConta.setBounds(10, 110, 180, 20);
		panel_8.add(lblTipoDeConta);
		
		lblValorATransferir = new JLabel("Valor a transferir");
		lblValorATransferir.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblValorATransferir.setForeground(Color.WHITE);
		lblValorATransferir.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorATransferir.setBounds(10, 140, 180, 20);
		panel_8.add(lblValorATransferir);
		
		lblSeuSaldoAps = new JLabel("Seu saldo final");
		lblSeuSaldoAps.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		lblSeuSaldoAps.setForeground(Color.WHITE);
		lblSeuSaldoAps.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeuSaldoAps.setBounds(10, 170, 180, 20);
		panel_8.add(lblSeuSaldoAps);
		
		panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Extrato extrato = new Extrato();
				
				extrato.setTipo("debito");
				extrato.setDescricao("Transferência para conta " + lblNumeroContaDestino.getText() + ".");
				extrato.setValor(Float.parseFloat(lblValorDaTransacao.getText()));
				extrato.setData(mainFrame.dataDoSistema);
				
				if(contaCorrente) {
					extrato.setFormaDePagamento("corrente");
					extrato.setFk_num_conta(usuario.getContaCorrente().getNum_conta());
					new DAI_Contas_corrente(database).updateSaldo(usuario.getContaCorrente().getNum_conta(), -extrato.getValor());
				} else {
					extrato.setFormaDePagamento("poupanca");
					extrato.setFk_num_conta(usuario.getContaPoupanca().getNum_conta());
					new DAI_Contas_poupanca(database).updateSaldo(usuario.getContaPoupanca().getNum_conta(), -extrato.getValor());
				}
				
				new DAI_Extratos(database).insert(extrato);
				
				/////////////////////////////////
				
				extrato.setTipo("credito");
				extrato.setFk_num_conta(lblNumeroContaDestino.getText());
				
				if(lblTipoContaDestino.getText().equals("Conta poupança")) {
					extrato.setDescricao("Transferência de " + usuario.getContaCorrente().getNum_conta() + ".");
					usuario.getContaCorrente().setSaldo(usuario.getContaCorrente().getSaldo() - Float.parseFloat(lblValorDaTransacao.getText()));
					extrato.setFormaDePagamento("poupanca");
					new DAI_Contas_poupanca(database).updateSaldo(extrato.getFk_num_conta(), extrato.getValor());
				} else if (lblTipoContaDestino.getText().equals("Conta corrente")) {
					extrato.setDescricao("Transferência de " + usuario.getContaPoupanca().getNum_conta() + ".");
					usuario.getContaPoupanca().setSaldo(usuario.getContaPoupanca().getSaldo() - Float.parseFloat(lblValorDaTransacao.getText()));
					extrato.setFormaDePagamento("corrente");
					new DAI_Contas_corrente(database).updateSaldo(extrato.getFk_num_conta(), extrato.getValor());
				}
				
				new DAI_Extratos(database).insert(extrato);
				JOptionPane.showMessageDialog(null, "A transferência foi completada com êxito.", "Sucesso", 2);
			}
		});
		panel_10.setLayout(null);
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(178, 201, 200, 35);
		panel_8.add(panel_10);
		
		lblEfetuarTransfernia = new JLabel("Efetuar transfer\u00EAnia");
		lblEfetuarTransfernia.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfetuarTransfernia.setForeground(new Color(253, 131, 68));
		lblEfetuarTransfernia.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
		lblEfetuarTransfernia.setBounds(0, 0, 200, 35);
		panel_10.add(lblEfetuarTransfernia);
		
		panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(Color.WHITE));
		panel_11.setBackground(new Color(253, 131, 68));
		panel_11.setBounds(200, 50, 320, 20);
		panel_8.add(panel_11);
		panel_11.setLayout(null);
		
		lblNumeroContaDestino = new JLabel("<N\u00DAMERO DA CONTA DESTINO>");
		lblNumeroContaDestino.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblNumeroContaDestino.setForeground(Color.WHITE);
		lblNumeroContaDestino.setBounds(10, 0, 300, 20);
		panel_11.add(lblNumeroContaDestino);
		
		panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new LineBorder(Color.WHITE));
		panel_12.setBackground(new Color(253, 131, 68));
		panel_12.setBounds(200, 80, 320, 20);
		panel_8.add(panel_12);
		
		lblNomeClienteDestino = new JLabel("<NOME DO CLIENTE DA CONTA DESTINO>");
		lblNomeClienteDestino.setForeground(Color.WHITE);
		lblNomeClienteDestino.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblNomeClienteDestino.setBounds(10, 0, 300, 20);
		panel_12.add(lblNomeClienteDestino);
		
		panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBorder(new LineBorder(Color.WHITE));
		panel_13.setBackground(new Color(253, 131, 68));
		panel_13.setBounds(200, 110, 320, 20);
		panel_8.add(panel_13);
		
		lblTipoContaDestino = new JLabel("<TIPO DA CONTA DESTINO>");
		lblTipoContaDestino.setForeground(Color.WHITE);
		lblTipoContaDestino.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblTipoContaDestino.setBounds(10, 0, 300, 20);
		panel_13.add(lblTipoContaDestino);
		
		panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBorder(new LineBorder(Color.WHITE));
		panel_14.setBackground(new Color(253, 131, 68));
		panel_14.setBounds(200, 140, 320, 20);
		panel_8.add(panel_14);
		
		lblValorDaTransacao = new JLabel("<VALOR DA TRANSFERENCIA>");
		lblValorDaTransacao.setForeground(Color.WHITE);
		lblValorDaTransacao.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblValorDaTransacao.setBounds(10, 0, 300, 20);
		panel_14.add(lblValorDaTransacao);
		
		panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBorder(new LineBorder(Color.WHITE));
		panel_15.setBackground(new Color(253, 131, 68));
		panel_15.setBounds(200, 170, 320, 20);
		panel_8.add(panel_15);
		
		lblSeuSaldoFinal = new JLabel("<SEU SALDO AP\u00D3S A TRANSFER\u00CANCIA>");
		lblSeuSaldoFinal.setForeground(Color.WHITE);
		lblSeuSaldoFinal.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblSeuSaldoFinal.setBounds(10, 0, 300, 20);
		panel_15.add(lblSeuSaldoFinal);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(255, 200, 0)));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 0, 550, 200);
		Transferencia.add(panel_7);
		panel_7.setLayout(null);
		
		panelContaCorrente = new JPanel();
		panelContaCorrente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(contaCorrente==false) {
					contaCorrente=true;
					updateMenuTipoConta(panelContaCorrente, lblContaCorrente, panelContaPoupanca, lblContaPoupanca);
				}
			}
		});
		panelContaCorrente.setBounds(10, 15, 255, 25);
		panel_7.add(panelContaCorrente);
		panelContaCorrente.setBorder(new LineBorder(new Color(253, 131, 68)));
		panelContaCorrente.setBackground(new Color(253, 131, 68));
		panelContaCorrente.setLayout(null);
		
		lblContaCorrente = new JLabel("Conta corrente");
		lblContaCorrente.setForeground(Color.WHITE);
		lblContaCorrente.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblContaCorrente.setHorizontalAlignment(SwingConstants.CENTER);
		lblContaCorrente.setBounds(0, 0, 255, 25);
		panelContaCorrente.add(lblContaCorrente);
		
		panelContaPoupanca = new JPanel();
		panelContaPoupanca.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(contaCorrente==true) {
					contaCorrente=false;
					updateMenuTipoConta(panelContaCorrente, lblContaCorrente, panelContaPoupanca, lblContaPoupanca);
				}
			}
		});
		panelContaPoupanca.setBounds(10, 50, 255, 25);
		panel_7.add(panelContaPoupanca);
		panelContaPoupanca.setBorder(new LineBorder(new Color(253, 131, 68)));
		panelContaPoupanca.setBackground(Color.WHITE);
		panelContaPoupanca.setLayout(null);
		
		lblContaPoupanca = new JLabel("Conta poupan\u00E7a");
		lblContaPoupanca.setForeground(new Color(253, 131, 68));
		lblContaPoupanca.setHorizontalAlignment(SwingConstants.CENTER);
		lblContaPoupanca.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblContaPoupanca.setBounds(0, 0, 255, 25);
		panelContaPoupanca.add(lblContaPoupanca);
		
		lblNmeroDaConta = new JLabel("N\u00FAmero da conta de destino");
		lblNmeroDaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNmeroDaConta.setBounds(10, 90, 530, 16);
		panel_7.add(lblNmeroDaConta);
		lblNmeroDaConta.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 110, 530, 25);
		panel_7.add(panel_4);
		panel_4.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_4.setBackground(new Color(245, 245, 245));
		panel_4.setLayout(null);
		
		txtNumeroDaConta = new JTextField();
		txtNumeroDaConta.setColumns(10);
		txtNumeroDaConta.setBorder(null);
		txtNumeroDaConta.setBackground(new Color(245, 245, 245));
		txtNumeroDaConta.setBounds(5, 1, 520, 20);
		panel_4.add(txtNumeroDaConta);
		
		JPanel panel_9 = new JPanel();
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Conta conta = new Conta();
				conta.setNum_conta(txtNumeroDaConta.getText());
				String tipo = conta.getNum_conta().substring(conta.getNum_conta().length()-2, conta.getNum_conta().length());
				
				String numeroDaContaDestino = txtNumeroDaConta.getText();
				String nomeClienteDestino = null;
				String tipoDaContaDestino = null;
				float valorTransferido = Float.parseFloat(txtValor.getText());
				float saldoFinal;
				
				if(conta.getNum_conta().substring(conta.getNum_conta().length()-2, conta.getNum_conta().length()).equals("01")) {
					tipoDaContaDestino = "Conta poupança";
				} else {
					tipoDaContaDestino = "Conta corrente";
				}
								
				if(tipoDaContaDestino.equals("Conta corrente")) {
					nomeClienteDestino = DAO_Clientes.selectContaCorrente(txtNumeroDaConta.getText());
				} else if(tipoDaContaDestino.equals("Conta poupança")) {
					nomeClienteDestino = DAO_Clientes.selectContaPoupanca(txtNumeroDaConta.getText());
				}
					
				if(nomeClienteDestino!=null) {
					if(contaCorrente) {
						if(!(txtNumeroDaConta.getText().equals(usuario.getContaCorrente().getNum_conta()))) {
							saldoFinal = usuario.getContaCorrente().getSaldo() - valorTransferido;
							if(saldoFinal>=0) {
								lblNumeroContaDestino.setText(numeroDaContaDestino);
								lblNomeClienteDestino.setText(nomeClienteDestino);
								lblTipoContaDestino.setText(tipoDaContaDestino);
								lblValorDaTransacao.setText("" + valorTransferido);
								lblSeuSaldoFinal.setText("" + saldoFinal);
								
								JOptionPane.showMessageDialog(null, "Verifique as informações da transferência.", "Atenção", 1);
							} else
								JOptionPane.showMessageDialog(null, "Saldo insuficiente para efetuar a transação.", "Falha", 0);
						} else
							JOptionPane.showMessageDialog(null, "Você não pode efetuar uma transferencia para a sua própria conta.", "Falha", 0);
					} else {
						if(!(txtNumeroDaConta.getText().equals(usuario.getContaPoupanca().getNum_conta()))) {
							saldoFinal = usuario.getContaPoupanca().getSaldo() - valorTransferido;
							if(saldoFinal>=0) {
								lblNumeroContaDestino.setText(numeroDaContaDestino);
								lblNomeClienteDestino.setText(nomeClienteDestino);
								lblTipoContaDestino.setText(tipoDaContaDestino);
								lblValorDaTransacao.setText("" + valorTransferido);
								lblSeuSaldoFinal.setText("" + saldoFinal);
								
								JOptionPane.showMessageDialog(null, "Verifique as informações da transferência.", "Atenção", 1);
							} else
								JOptionPane.showMessageDialog(null, "Saldo insuficiente para efetuar a transação.", "Falha", 0);
						} else
							JOptionPane.showMessageDialog(null, "Você não pode efetuar uma transferencia para a sua própria conta.", "Falha", 0);
					}
				}
			}
		});
		panel_9.setBackground(new Color(253, 131, 68));
		panel_9.setBounds(175, 150, 200, 35);
		panel_7.add(panel_9);
		panel_9.setLayout(null);
		
		lblNewLabel = new JLabel("Seguir");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Open Sans Light", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 200, 35);
		panel_9.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Valor (R$)");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(285, 30, 255, 16);
		panel_7.add(lblNewLabel_2);
		
		panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(new Color(253, 131, 68)));
		panel_16.setBackground(new Color(245, 245, 245));
		panel_16.setBounds(285, 50, 255, 25);
		panel_7.add(panel_16);
		panel_16.setLayout(null);
		
		txtValor = new JTextField();
		txtValor.setBackground(new Color(245, 245, 245));
		txtValor.setBounds(5, 1, 245, 20);
		txtValor.setBorder(null);
		panel_16.add(txtValor);
		txtValor.setColumns(10);
		
		if(mainFrame.showMenuIsVisible)
			Transacoes.resizeUsefulSpace(230, 770);
		else
			Transacoes.resizeUsefulSpace(30, 970);
		recargas.getContentPane().add(UsefulSpace);
		
		UsefulSpace.add(imgBackground);
	}
	
	public static void updateMenuTipoConta(JPanel panelContaCorrente, JLabel lblContaCorrente, JPanel panelContaPoupanca, JLabel lblContaPoupanca) {
		 if(contaCorrente) {
			 panelContaCorrente.setBackground(new Color(253, 131, 68));
			 lblContaCorrente.setForeground(Color.WHITE);
			 panelContaPoupanca.setBackground(Color.WHITE);
			 lblContaPoupanca.setForeground(new Color(253, 131, 68));
		 } else {
			 panelContaPoupanca.setBackground(new Color(253, 131, 68));
			 lblContaPoupanca.setForeground(Color.WHITE);
			 panelContaCorrente.setBackground(Color.WHITE);
			 lblContaCorrente.setForeground(new Color(253, 131, 68));
		 }
	}
	
	public static void resizeUsefulSpace(int x, int width) {
		UsefulSpace.setBounds(x, UsefulSpace.getY(), width, UsefulSpace.getHeight());
		imgBackground.setBounds(-UsefulSpace.getX(), 0, 1000, 600);
		panel.setLocation(((UsefulSpace.getWidth()-panel.getWidth())/2), ((UsefulSpace.getHeight()-panel.getHeight())/2));
	}
}
