package view.after_login;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import view.before_login.Login;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ContaCorrente extends JInternalFrame {

	private static JLayeredPane UsefulSpace;
	private static JLabel imgBackground;
	private static JPanel panel;
	
	public ContaCorrente() {
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(208, 13, 695, 574);
		
		pressets(this);
		
		UsefulSpace.setLayer(panel, 1);
		UsefulSpace.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(52, 245, 600, 300);
		panel.add(tabbedPane);
		
		JPanel panel_15 = new JPanel();
		tabbedPane.addTab("Conta Poupança", null, panel_15, null);
		panel_15.setLayout(null);
		
		JLabel label_12 = new JLabel("Saldo:");
		label_12.setBounds(12, 13, 56, 16);
		panel_15.add(label_12);
		
		JLabel label_13 = new JLabel("Juros:");
		label_13.setBounds(12, 46, 56, 16);
		panel_15.add(label_13);
		
		JLabel label_14 = new JLabel("Rendimento anual:");
		label_14.setBounds(12, 87, 115, 16);
		panel_15.add(label_14);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Investimentos", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 20, 575, 50);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblFundosDeInvestimentos = new JLabel("Fundos de investimentos");
		lblFundosDeInvestimentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblFundosDeInvestimentos.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblFundosDeInvestimentos.setBounds(0, 0, 250, 25);
		panel_3.add(lblFundosDeInvestimentos);
		
		JLabel lblSemInvestimentos = new JLabel("Sem movimenta\u00E7\u00E3o");
		lblSemInvestimentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemInvestimentos.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblSemInvestimentos.setBounds(0, 25, 250, 25);
		panel_3.add(lblSemInvestimentos);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(475, 0, 100, 50);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblResgatar = new JLabel("Resgatar");
		lblResgatar.setHorizontalAlignment(SwingConstants.CENTER);
		lblResgatar.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblResgatar.setBounds(0, 0, 100, 50);
		panel_4.add(lblResgatar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(375, 0, 100, 50);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblAplicar = new JLabel("Aplicar");
		lblAplicar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicar.setFont(new Font("Open Sans", Font.BOLD, 13));
		lblAplicar.setBounds(0, 0, 100, 50);
		panel_5.add(lblAplicar);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(250, 0, 125, 50);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor l\u00EDquido");
		lblValor.setBounds(0, 0, 125, 25);
		panel_6.add(lblValor);
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor.setFont(new Font("Open Sans", Font.BOLD, 13));
		
		JLabel lblRXx = new JLabel("R$ XX,XX");
		lblRXx.setHorizontalAlignment(SwingConstants.CENTER);
		lblRXx.setFont(new Font("Open Sans", Font.PLAIN, 13));
		lblRXx.setBounds(0, 25, 125, 25);
		panel_6.add(lblRXx);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(10, 100, 575, 50);
		panel_2.add(panel_7);
		
		JLabel label = new JLabel("Fundos de investimentos");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Open Sans", Font.BOLD, 13));
		label.setBounds(0, 0, 250, 25);
		panel_7.add(label);
		
		JLabel label_1 = new JLabel("Sem movimenta\u00E7\u00E3o");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Open Sans", Font.PLAIN, 13));
		label_1.setBounds(0, 25, 250, 25);
		panel_7.add(label_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(475, 0, 100, 50);
		panel_7.add(panel_8);
		
		JLabel label_2 = new JLabel("Resgatar");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_2.setBounds(0, 0, 100, 50);
		panel_8.add(label_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(375, 0, 100, 50);
		panel_7.add(panel_9);
		
		JLabel label_3 = new JLabel("Aplicar");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_3.setBounds(0, 0, 100, 50);
		panel_9.add(label_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(250, 0, 125, 50);
		panel_7.add(panel_10);
		
		JLabel label_4 = new JLabel("Valor l\u00EDquido");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_4.setBounds(0, 0, 125, 25);
		panel_10.add(label_4);
		
		JLabel label_5 = new JLabel("R$ XX,XX");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Open Sans", Font.PLAIN, 13));
		label_5.setBounds(0, 25, 125, 25);
		panel_10.add(label_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBounds(10, 180, 575, 50);
		panel_2.add(panel_11);
		
		JLabel label_6 = new JLabel("Fundos de investimentos");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_6.setBounds(0, 0, 250, 25);
		panel_11.add(label_6);
		
		JLabel label_7 = new JLabel("Sem movimenta\u00E7\u00E3o");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Open Sans", Font.PLAIN, 13));
		label_7.setBounds(0, 25, 250, 25);
		panel_11.add(label_7);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBounds(475, 0, 100, 50);
		panel_11.add(panel_12);
		
		JLabel label_8 = new JLabel("Resgatar");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_8.setBounds(0, 0, 100, 50);
		panel_12.add(label_8);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBounds(375, 0, 100, 50);
		panel_11.add(panel_13);
		
		JLabel label_9 = new JLabel("Aplicar");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_9.setBounds(0, 0, 100, 50);
		panel_13.add(label_9);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBounds(250, 0, 125, 50);
		panel_11.add(panel_14);
		
		JLabel label_10 = new JLabel("Valor l\u00EDquido");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Open Sans", Font.BOLD, 13));
		label_10.setBounds(0, 0, 125, 25);
		panel_14.add(label_10);
		
		JLabel label_11 = new JLabel("R$ XX,XX");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Open Sans", Font.PLAIN, 13));
		label_11.setBounds(0, 25, 125, 25);
		panel_14.add(label_11);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 13, 695, 173);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblOla = new JLabel("Ol\u00E1,");
		lblOla.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblOla.setBounds(40, 15, 40, 16);
		panel_1.add(lblOla);
		
		JLabel label_15 = new JLabel("<NOME DO USU\u00C1RIO>");
		label_15.setFont(new Font("Open Sans Light", Font.BOLD, 13));
		label_15.setBounds(70, 15, 529, 16);
		panel_1.add(label_15);
		
		JLabel lblSaldoDisponvel = new JLabel("SALDO DISPON\u00CDVEL");
		lblSaldoDisponvel.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblSaldoDisponvel.setBounds(40, 65, 118, 16);
		panel_1.add(lblSaldoDisponvel);
		
		JLabel lblNewLabel = new JLabel("R$");
		lblNewLabel.setFont(new Font("Open Sans Light", Font.PLAIN, 32));
		lblNewLabel.setBounds(105, 94, 40, 36);
		panel_1.add(lblNewLabel);
		
		JLabel lblXxxx = new JLabel("XX,XX");
		lblXxxx.setFont(new Font("Open Sans Light", Font.PLAIN, 32));
		lblXxxx.setBounds(157, 94, 103, 36);
		panel_1.add(lblXxxx);
		
		JLabel lblMostrar = new JLabel("mostrar");
		lblMostrar.setFont(new Font("Open Sans Light", Font.PLAIN, 13));
		lblMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrar.setBounds(262, 65, 56, 16);
		panel_1.add(lblMostrar);
	}
	
	private static void pressets(ContaCorrente recargas) {
		recargas.setSize(1000, 633);
		recargas.getContentPane().setLayout(null);
		
		((BasicInternalFrameUI)recargas.getUI()).setNorthPane(null);   //retirar o painel superior
		recargas.setBorder(null);   //retirar bordas
		
		initializeLayered(recargas);
	}

	private static void initializeLayered(ContaCorrente recargas) {
		UsefulSpace = new JLayeredPane();
		UsefulSpace.setSize(1000, 600);
		imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		imgBackground.setSize(1000, 600);
		
		if(mainFrame.showMenuIsVisible)
			ContaCorrente.resizeUsefulSpace(230, 770);
		else
			ContaCorrente.resizeUsefulSpace(30, 970);
		recargas.getContentPane().add(UsefulSpace);
		
		UsefulSpace.add(imgBackground);
	}
	
	public static void resizeUsefulSpace(int x, int width) {
		UsefulSpace.setBounds(x, UsefulSpace.getY(), width, UsefulSpace.getHeight());
		imgBackground.setBounds(-UsefulSpace.getX(), 0, 1000, 600);
		panel.setLocation(((UsefulSpace.getWidth()-panel.getWidth())/2), ((UsefulSpace.getHeight()-panel.getHeight())/2));
	}
}
