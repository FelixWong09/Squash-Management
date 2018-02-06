package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class CreatePracticeWindow extends JFrame{

	/**
	 * @param args
	 */
	private JLabel playerLabel;
	private JLabel dateLabel;
	private JLabel timeLabel;
	private JTextField dateTextField;
	private JTextField playerTextField;
	private JComboBox hourComboBox;
	private JComboBox minuteComboBox;
//	private JComboBox apmComboBox;
	private JButton backButton;
	private JButton doneButton;
	
	private DateChooser date;
    
    DateChooser dateChooser;
	
	private CreatePracticeWindow frame;

	public CreatePracticeWindow() {
		super();
		this.setSize(500,500);
		this.getContentPane().setLayout(null);
		
		this.frame = this;
		this.setTitle("Create Practice");
		
		this.add(this.getLabelPlayer(), null);
		this.add(this.getLabelDate(), null);
		this.add(this.getLabelTime(), null);
		this.add(this.getTextFieldPlayer(), null);
		this.add(this.getBoxHour(), null);
		this.add(this.getBoxMinute(), null);
//		this.add(this.getBoxAPM(), null);
		this.add(this.getDate(), null);
		this.add(this.getButtonBack(), null);
		this.add(this.getButtonDone(), null);
	}
	
	private JLabel getLabelPlayer() {
		if (playerLabel == null) {
			playerLabel = new JLabel();
			playerLabel.setBounds(50, 50, 80, 35);
			playerLabel.setText("Player:");
		}
		return playerLabel;
	} 
	
	private JLabel getLabelDate(){
		if (dateLabel == null) {
			dateLabel = new JLabel();
			dateLabel.setBounds(50, 105, 80, 35);
			dateLabel.setText("Date:");
		}
		return dateLabel;
	}
	
	private JLabel getLabelTime(){
		if (timeLabel == null) {
			timeLabel = new JLabel();
			timeLabel.setBounds(50, 160, 80, 35);
			timeLabel.setText("Time:");
		}
		return timeLabel;
	}
	
	private JTextField getTextFieldPlayer(){
		if (playerTextField == null) {
			playerTextField = new JTextField();
			playerTextField.setBounds(150, 50, 140, 30);
		}
		return playerTextField;
	}
	

	
	private JComboBox getBoxHour(){
		if (hourComboBox == null) {
			hourComboBox = new JComboBox();
			hourComboBox.setBounds(150, 160, 50, 30);
			hourComboBox.addItem("00");
			hourComboBox.addItem("01");
			hourComboBox.addItem("02");
			hourComboBox.addItem("03");
			hourComboBox.addItem("04");
			hourComboBox.addItem("05");
			hourComboBox.addItem("06");
			hourComboBox.addItem("07");
			hourComboBox.addItem("08");
			hourComboBox.addItem("09");
			hourComboBox.addItem("10");
			hourComboBox.addItem("11");
			hourComboBox.addItem("12");
			hourComboBox.addItem("13");
			hourComboBox.addItem("14");
			hourComboBox.addItem("15");
			hourComboBox.addItem("16");
			hourComboBox.addItem("17");
			hourComboBox.addItem("18");
			hourComboBox.addItem("19");
			hourComboBox.addItem("20");
			hourComboBox.addItem("21");
			hourComboBox.addItem("22");
			hourComboBox.addItem("23");
		}
		return hourComboBox;
	}
	
	private JComboBox getBoxMinute(){
		if (minuteComboBox == null) {
			minuteComboBox = new JComboBox();
			minuteComboBox.setBounds(220, 160, 50, 30);
			minuteComboBox.addItem("00");
			minuteComboBox.addItem("05");
			minuteComboBox.addItem("10");
			minuteComboBox.addItem("15");
			minuteComboBox.addItem("20");
			minuteComboBox.addItem("25");
			minuteComboBox.addItem("30");
			minuteComboBox.addItem("35");
			minuteComboBox.addItem("40");
			minuteComboBox.addItem("45");
			minuteComboBox.addItem("50");
			minuteComboBox.addItem("55");
		}		
		return minuteComboBox;
	}
	
//	private JComboBox getBoxAPM(){
//		if (apmComboBox == null) {
//			apmComboBox = new JComboBox();
//			apmComboBox.setBounds(290, 160, 50, 30);
//			apmComboBox.addItem("AM");
//			apmComboBox.addItem("PM");
//		}
//		return apmComboBox;
//	}
	
	private JTextField getDate() {
    	if(dateTextField == null) {
    	    this.dateChooser = DateChooser.getInstance("yyyy-MM-dd");
    		dateTextField = new JTextField("click to choose date");
            dateTextField.setBounds(150, 105, 135, 30);
        	this.dateChooser.register(dateTextField);
    	}
    	return dateTextField;
    }
	
	private JButton getButtonBack(){
		if (backButton == null) {
			backButton = new JButton();
			backButton.setBounds(100, 300, 80, 30);
			backButton.setText("Back");
			backButton.addActionListener(new BackButton());
		}
		return backButton;
	}
	
	private class BackButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			PracticeManagementWindow frame1 = new PracticeManagementWindow();
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}
	private JButton getButtonDone(){
		if (doneButton == null) {
			doneButton = new JButton();
			doneButton.setBounds(300, 300, 80, 30);
			doneButton.setText("Done");
			doneButton.addActionListener(new DoneButton());
		}
		return doneButton;
	}
	
	private class DoneButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/**
			 * save data && quit
			 */
			String player = playerTextField.getText();
			String dateString = dateTextField.getText();
			String timeString = hourComboBox.getSelectedItem().toString() + ":"+ minuteComboBox.getSelectedItem().toString();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");//load MYSQL JDBC Çý¶¯³ÌÐò
				System.out.println("Success loading Mysql Driver!");
			} catch (Exception e1) {
				System.out.println("Error loading Mysql Driver!");
				e1.printStackTrace();
			}
			try {
				Connection connection = DriverManager.getConnection(
						 "jdbc:mysql://localhost:3306/squash","root","123456");
				System.out.println("Success connect Mysql server!");
				String queryString =" insert into practice_schedule (player, practice_time, practice_date)"
				        + " values (?, ?, ?)";
				PreparedStatement preparedStmt = connection.prepareStatement(queryString);
			      preparedStmt.setString(1, player);
			      preparedStmt.setString(2, timeString);
			      preparedStmt.setString(3, dateString);
			      
			      preparedStmt.execute();
			} catch (Exception e2) {
				System.out.println("insert data error!");
				e2.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null,"Schedule created", "Message",JOptionPane.INFORMATION_MESSAGE);
//			frame.setVisible(false);
//			PracticeManagementWindow frame2 = new PracticeManagementWindow();
//			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			frame2.setVisible(true);
		}
	}
}
