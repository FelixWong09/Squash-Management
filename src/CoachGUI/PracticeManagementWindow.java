package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class PracticeManagementWindow extends JFrame{

	/**
	 * @param args
	 */
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton backButton;
	private PracticeManagementWindow frame;
	
	public PracticeManagementWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("Practice Managerment");
		this.getContentPane().setLayout(null);
		
		this.add(this.getButtonCreate(), null);
		this.add(this.getButtonView(), null);
		this.add(this.getButtonRoster(), null);
		this.add(this.getButtonBack(), null);
	}
	
	private JButton getButtonCreate() {
		if(button1 == null){
			button1 = new JButton();
			button1.setBounds(153,89,175,30);
			button1.setText("Create Practice");
			button1.addActionListener(new CreateButton());
		}
		return button1;
	}
	
	private class CreateButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			CreatePracticeWindow frame1 = new CreatePracticeWindow();
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}
	
	private JButton getButtonView() {
		if(button2 == null){
			button2 = new JButton();
			button2.setBounds(153,149,175,30);
			button2.setText("View Practice");
			button2.addActionListener(new ViewButton());
		}
		return button2;
	}
	
	private class ViewButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			ViewPracticeWindow frame2 = new ViewPracticeWindow();
			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame2.setVisible(true);
		}
	}
	
	private JButton getButtonRoster() {
		if(button3 == null){
			button3 = new JButton();
			button3.setBounds(153,209,175,30);
			button3.setText("Roster");
			button3.addActionListener(new RosterButton());
		}
		return button3;
	}
	
	private class RosterButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			Roster frame3 = new Roster();
			frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame3.setVisible(true);
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
			OperateWindow frame4 = new OperateWindow();
			frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame4.setVisible(true);
		}
	}
	
}
