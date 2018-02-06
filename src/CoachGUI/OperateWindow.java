package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OperateWindow extends JFrame{
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton quitButton;
	private OperateWindow frame;
	
	public OperateWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("Coach Management GUI");
		this.getContentPane().setLayout(null);
		
		this.add(this.getButtonCompetition(), null);
		this.add(this.getButtonPractice(), null);
		this.add(this.getButtonRequest(), null);
		this.add(this.getButtonQuit(), null);
	}
	
	private JButton getButtonCompetition() {
		if(button1 == null){
			button1 = new JButton();
			button1.setBounds(153,89,175,30);
			button1.setText("Manage Competition");
			button1.addActionListener(new CompetitionButton());
		}
		return button1;
	}
	
	private class CompetitionButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			CompetitionManagementWindow frame1 = new CompetitionManagementWindow();
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}
	
	private JButton getButtonPractice() {
		if(button2 == null){
			button2 = new JButton();
			button2.setBounds(153,149,175,30);
			button2.setText("Manage Practice");
			button2.addActionListener(new PracticeButton());
		}
		return button2;
	}
	
	private class PracticeButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			PracticeManagementWindow frame2 = new PracticeManagementWindow();
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame2.setVisible(true);
		}
	}
	
	private JButton getButtonRequest() {
		if(button3 == null){
			button3 = new JButton();
			button3.setBounds(153,209,175,30);
			button3.setText("Request equipment");
			button3.addActionListener(new RequestionButton());
		}
		return button3;
	}
	
	private class RequestionButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			RequestEquipmentWindow frame3 = new RequestEquipmentWindow();
			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame3.setVisible(true);
		}
	}
	
	private JButton getButtonQuit() {
		if(quitButton == null){
			quitButton = new JButton();
			quitButton.setBounds(333,309,95,30);
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
