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

public class ViewHealthStatusWindow extends JFrame {

	JTable statusTable;
	
	private JButton backButton;
	private JLabel viewLabel;
	private ViewHealthStatusWindow frame;
	
	public ViewHealthStatusWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("View Health Status");
		this.getContentPane().setLayout(null);
		
		this.add(this.getLabelView(), null);
		this.add(this.getButtonBack(), null);
		
		this.add(getTable());
	}
	
	private JLabel getLabelView() {
		if (viewLabel == null) {
			viewLabel = new JLabel();
			viewLabel.setBounds(180, 50, 150, 30);
			viewLabel.setText("Players Health Status");
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
//		Object[][] data = {
//				{ "Name", "Health status"},
//				{ "Alice", "Great"},
//				{ "Bob", "Good"},
//				{ "Clinton", "Great"},
//				{ "Hill", "Great"},
//				{ "Irving", "Good" },
//				{ "Alice", "Good" },
//				{ "Bob", "Great" },
//				{ "Clinton", "Good" },
//				{ "Hill", "Good" },
//				{ "Irving", "Great" },
//				{ "Clinton", "Great" },
//				{ "Hill", "Good" },
//				{ "Irving", "Great" }
//		};
		DataAccess dataAccess = new DataAccess(); 
		String[] columnNames = getColumnNames();
		Object[][] data;
		
		try {
			data = dataAccess.readData( 
			        "select PLAYERNAME, AGE, GENDER,health_issues from player");
			statusTable = new JTable(data, columnNames);
			statusTable.setEnabled(false);
			statusTable.setBounds(50,90,400,250);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		
	
		return statusTable;
	}
	
	private String [] getColumnNames(){
    	String[] names = {"PLAYERNAME","AGE","GENDER","health_issues"};
    	return names;
    }

}
