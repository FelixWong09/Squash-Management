package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DataAccess.DataAccess;

public class ViewCompetitionWindow extends JFrame {

	JTable competitionTable;
	
	private JButton backButton;
	private JLabel viewLabel;
	private ViewCompetitionWindow frame;
	
	public ViewCompetitionWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("View Competition");
		this.getContentPane().setLayout(null);
		
		this.add(this.getLabelView(), null);
		this.add(this.getButtonBack(), null);
		
		this.add(getTable());
	}
	
	private JLabel getLabelView() {
		if (viewLabel == null) {
			viewLabel = new JLabel();
			viewLabel.setBounds(180, 50, 150, 30);
			viewLabel.setText("Competition Schedule");
		}
		return viewLabel;
	}
	
	private JButton getButtonBack() {
		if (backButton == null) {
			backButton = new JButton();
			backButton.setBounds(350, 400, 80, 30);
			backButton.setText("Back");
			backButton.addActionListener(new BackButton());
		}
		return backButton;
	}
	
	private class BackButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
        	CompetitionManagementWindow frame1 = new CompetitionManagementWindow();
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//
            frame1.setVisible(true);
		}
	}
	
	
	private JTable getTable() {
		DataAccess dataAccess = new DataAccess(); 
		String[] columnNames = getColumnNames();
		Object[][] data;
		
		try {
			data = dataAccess.readData( 
			        "select * from competition_schedule");
			competitionTable = new JTable(data, columnNames);
			competitionTable.setEnabled(false);
			competitionTable.setBounds(40,90,400,250);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		return competitionTable;
		
		
		      

//		Object[][] data = {
//				{ "Player1", "Player2", "Time", "Date" },
//				{ "Alice", "Emily", "12:55 PM", "2016-11-01" },
//				{ "Bob", "David", "09:15 PM", "2016-11-03" },
//				{ "Clinton", "Frank", "06:00 PM", "2016-11-04" },
//				{ "Hill", "Justin", "09:05 PM", "2016-11-06" },
//				{ "Irving", "Kevin", "10:00 AM", "2016-11-07" },
//				{ "Alice", "Emily", "12:55 PM", "2016-11-01" },
//				{ "Bob", "David", "09:15 PM", "2016-11-03" },
//				{ "Clinton", "Frank", "06:00 PM", "2016-11-04" },
//				{ "Hill", "Justin", "09:05 PM", "2016-11-06" },
//				{ "Irving", "Kevin", "10:00 AM", "2016-11-07" },
//				{ "Clinton", "Frank", "06:00 PM", "2016-11-04" },
//				{ "Hill", "Justin", "09:05 PM", "2016-11-06" },
//				{ "Irving", "Kevin", "10:00 AM", "2016-11-07" }
//		};
		
		
		
	}
	
	private String [] getColumnNames(){
    	String[] names = {"Player1","Player2","Time","Date"};
    	return names;
    }

}
