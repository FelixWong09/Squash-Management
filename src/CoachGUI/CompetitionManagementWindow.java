package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class CompetitionManagementWindow extends JFrame{

	/**
	 * @param args
	 */
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton backButton;
	private CompetitionManagementWindow frame;
	
	public CompetitionManagementWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("Competition Managerment");
		this.getContentPane().setLayout(null);
		
		this.add(this.getButtonCreate(), null);
		this.add(this.getButtonView(), null);
		this.add(this.getButtonHealthStatus(), null);
		this.add(this.getButtonPlayerStat(), null);
		this.add(this.getButtonRoster(), null);
		this.add(this.getButtonBack(), null);
	}
	
	private JButton getButtonCreate() {
		if(button1 == null){
			button1 = new JButton();
			button1.setBounds(153,59,175,30);
			button1.setText("Create Competition");
			button1.addActionListener(new CreateButton());
		}
		return button1;
	}
	
	private class CreateButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			CreateCompetitionWindow frame1 = new CreateCompetitionWindow();
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}
	
	private JButton getButtonView() {
		if(button2 == null){
			button2 = new JButton();
			button2.setBounds(153,119,175,30);
			button2.setText("View Competition");
			button2.addActionListener(new ViewButton());
		}
		return button2;
	}
	
	private class ViewButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			ViewCompetitionWindow frame2 = new ViewCompetitionWindow();
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame2.setVisible(true);
		}
	}
	
	private JButton getButtonHealthStatus() {
		if(button3 == null){
			button3 = new JButton();
			button3.setBounds(153,179,175,30);
			button3.setText("View Health Status");
			button3.addActionListener(new HealthStatusButton());
		}
		return button3;
	}
	
	private class HealthStatusButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			ViewHealthStatusWindow frame3 = new ViewHealthStatusWindow();
			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame3.setVisible(true);
		}
	}
	
	private JButton getButtonPlayerStat() {
		if(button4 == null){
			button4 = new JButton();
			button4.setBounds(153,239,175,30);
			button4.setText("View Player Statistics");
			button4.addActionListener(new PlayerStatButton());
		}
		return button4;
	}
	
	private class PlayerStatButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			ViewStatisticsWindow frame4 = new ViewStatisticsWindow();
			frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame4.setVisible(true);
		}
	}

	private JButton getButtonRoster() {
		if(button5 == null){
			button5 = new JButton();
			button5.setBounds(153,299,175,30);
			button5.setText("Roster");
			button5.addActionListener(new RosterButton());
		}
		return button5;
	}
	
	private class RosterButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			Roster frame5 = new Roster();
			frame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame5.setVisible(true);
		}
	}
	
	private JButton getButtonBack() {
		if(backButton == null){
			backButton = new JButton();
			backButton.setBounds(357,379,75,30);
			backButton.setText("Back");
			backButton.addActionListener(new BackButton());
		}
		return backButton;
	}
	
	private class BackButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			OperateWindow frame6 = new OperateWindow();
			frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame6.setVisible(true);
		}
	}
	
}
