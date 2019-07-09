package view.after_login;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import view.before_login.Login;

public class ExempleInternalFrame extends JInternalFrame {

	private static JLayeredPane UsefulSpace;
	private static JLabel imgBackground;
	
	public ExempleInternalFrame() {
		pressets(this);
	}
	
	private static void pressets(ExempleInternalFrame recargas) {
		recargas.setSize(1000, 633);
		recargas.getContentPane().setLayout(null);
		
		((BasicInternalFrameUI)recargas.getUI()).setNorthPane(null);   //retirar o painel superior
		recargas.setBorder(null);   //retirar bordas
		
		initializeLayered(recargas);
	}

	private static void initializeLayered(ExempleInternalFrame recargas) {
		UsefulSpace = new JLayeredPane();
		UsefulSpace.setSize(1000, 600);
		imgBackground = new JLabel(new ImageIcon(Login.class.getResource("/view/images/AfterLogin_MainFrame_Background.png")));
		imgBackground.setSize(1000, 600);
		
		if(mainFrame.showMenuIsVisible)
			ExempleInternalFrame.resizeUsefulSpace(230, 770);
		else
			ExempleInternalFrame.resizeUsefulSpace(30, 970);
		recargas.getContentPane().add(UsefulSpace);
		
		UsefulSpace.add(imgBackground);
	}
	
	public static void resizeUsefulSpace(int x, int width) {
		UsefulSpace.setBounds(x, UsefulSpace.getY(), width, UsefulSpace.getHeight());
		imgBackground.setBounds(-UsefulSpace.getX(), 0, 1000, 600);
	}
}
