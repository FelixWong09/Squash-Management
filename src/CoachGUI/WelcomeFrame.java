package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import CommonGUI.MainGUI;

//public class Welcome {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args)throws Exception{
//		// TODO Auto-generated method stub
//		WelcomeFrame frame1 = new WelcomeFrame();
//		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		
//		frame1.setVisible(true);
//	}
//
//}

public class WelcomeFrame extends JFrame{
	private JLabel label1;
	private JButton button1;
	
	private WelcomeFrame frame;

	public WelcomeFrame(){
		super();
		this.frame = this;
		this.setSize(500,500);
		this.getContentPane().setLayout(null);
		this.add(this.getLabelWelcome(), null);
		this.add(this.getButton(),null);
		this.setTitle("Coach Login");
	
	}
	private JLabel getLabelWelcome(){
		if(label1 == null){
			label1 = new JLabel();
//			label1.setHorizontalTextPosition(JLabel.CENTER);
			label1.setText("Coach, Welcome!");
//			label1.setSize(160,20);
			label1.setBounds(179, 79, 160, 20);
		}
		return label1;
	}
	
	private JButton getButton(){
		if(button1 == null){
			button1 = new JButton();
//			button1.setHorizontalTextPosition(JButton.CENTER);
			button1.setText("Log in");
//			button1.setSize(80,27);
			button1.setBounds(189, 319, 80, 27);
			button1.addActionListener(new LoginButton());
		}
		return button1;
	}
	
	private class LoginButton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			OperateWindow frame2 = new OperateWindow();
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			frame2.setVisible(true);
		}
	}
}
