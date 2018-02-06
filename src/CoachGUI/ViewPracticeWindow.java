package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DataAccess.DataAccess;

public class ViewPracticeWindow extends JFrame {

	JTable practiceTable;
	
	private JButton backButton;
	private JLabel viewLabel;
	private ViewPracticeWindow frame;
	
	public ViewPracticeWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("View Practice");
		this.getContentPane().setLayout(null);
		
		this.add(this.getLabelView(), null);
		this.add(this.getButtonBack(), null);
		
		this.add(getTable());
	}
	
	private JLabel getLabelView() {
		if (viewLabel == null) {
			viewLabel = new JLabel();
			viewLabel.setBounds(180, 50, 150, 30);
			viewLabel.setText("Practice Schedule");
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
        	PracticeManagementWindow frame1 = new PracticeManagementWindow();
            frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//
            frame1.setVisible(true);
		}
	}
	
	private JTable getTable() {
//		Object[][] data = {
//				{ "Player", "Time", "Date" },
//				{ "Alice", "12:55 PM", "2016-11-01" },
//				{ "Bob", "09:15 PM", "2016-11-03" },
//				{ "Clinton", "06:00 PM", "2016-11-04" },
//				{ "Hill", "09:05 PM", "2016-11-06" },
//				{ "Irving", "10:00 AM", "2016-11-07" },
//				{ "Alice", "12:55 PM", "2016-11-01" },
//				{ "Bob", "09:15 PM", "2016-11-03" },
//				{ "Clinton", "06:00 PM", "2016-11-04" },
//				{ "Hill", "09:05 PM", "2016-11-06" },
//				{ "Irving", "10:00 AM", "2016-11-07" },
//				{ "Clinton", "06:00 PM", "2016-11-04" },
//				{ "Hill", "09:05 PM", "2016-11-06" },
//				{ "Irving", "10:00 AM", "2016-11-07" }
//		};
		DataAccess dataAccess = new DataAccess(); 
		String[] columnNames = getColumnNames();
		Object[][] data;
		
		try {
			data = dataAccess.readData( 
			        "select * from practice_schedule");
			practiceTable = new JTable(data, columnNames);
			practiceTable.setEnabled(false);
			practiceTable.setBounds(80,90,300,250);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		
		
		return practiceTable;
	}
	
	private String [] getColumnNames(){
    	String[] names = {"Player1","Time","Date"};
    	return names;
    }

}
