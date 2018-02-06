package CommonGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import CoachGUI.CompetitionManagementWindow;
import CoachGUI.OperateWindow;
import CoachGUI.PracticeManagementWindow;
import CoachGUI.RequestEquipmentWindow;
import CoachGUI.WelcomeFrame;
import ManageGUI.MyFirst;
import PlayerGUI.Login;
import TrainerGUI.Create;
import TrainerGUI.MyGui;

public class MainGUI{

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		MainFrame frame1 = new MainFrame();
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame1.setVisible(true);
	}

}

class MainFrame extends JFrame{

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton quitButton;
	private MainFrame frame;
	
	public MainFrame() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("Squash Club");
		this.getContentPane().setLayout(null);
		
		this.add(this.getButtonCoach(), null);
		this.add(this.getButtonManager(), null);
		this.add(this.getButtonPlayer(), null);
		this.add(this.getButtonAdmin(), null);
		this.add(this.getButtonQuit(), null);
		
	}
	

	private JButton getButtonCoach() {
		if(button1 == null){
			button1 = new JButton();
			button1.setBounds(153,89,175,30);
			button1.setText("Coach");
			button1.addActionListener(new CoachButton());
		}
		return button1;
	}
	
	private class CoachButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			WelcomeFrame frame1 = new WelcomeFrame();
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}
	
	private JButton getButtonManager() {
		if(button2 == null){
			button2 = new JButton();
			button2.setBounds(153,149,175,30);
			button2.setText("Manager");
			button2.addActionListener(new ManagerButton());
		}
		return button2;
	}
	
	private class ManagerButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			MyFirst frame2 = new MyFirst();
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame2.setVisible(true);
		}
	}
	
	private JButton getButtonPlayer() {
		if(button3 == null){
			button3 = new JButton();
			button3.setBounds(153,209,175,30);
			button3.setText("Player");
			button3.addActionListener(new PlayerButton());
		}
		return button3;
	}
	
	private class PlayerButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			Login frame3 = new Login();
			frame3.frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame3.frmLogin.setVisible(true);
		}
	}
	
	private JButton getButtonAdmin() {
		if(button4 == null){
			button4 = new JButton();
			button4.setBounds(153,269,175,30);
			button4.setText("Trainer");
			button4.addActionListener(new AdminButton());
		}
		return button4;
	}
	
	private class AdminButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			MyGui frame4 = new MyGui();
			frame4.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame4.frame.setVisible(true);
		}
	}
	
	
	private JButton getButtonQuit() {
		if(quitButton == null){
			quitButton = new JButton();
			quitButton.setBounds(333,359,95,30);
			quitButton.setText("Log out");
			quitButton.addActionListener(new QuitButton());
		}
		return quitButton;
	}
	
	private class QuitButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
		}
	}

}
