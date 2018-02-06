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

public class ViewStatisticsWindow extends JFrame {

	JTable StatTable;
	
	private JButton backButton;
	private JLabel viewLabel;
	private ViewStatisticsWindow frame;
	
	public ViewStatisticsWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("View Players Statistics");
		this.getContentPane().setLayout(null);
		
		this.add(this.getLabelView(), null);
		this.add(this.getButtonBack(), null);
		
		this.add(getTable());
	}
	
	private JLabel getLabelView() {
		if (viewLabel == null) {
			viewLabel = new JLabel();
			viewLabel.setBounds(180, 50, 150, 30);
			viewLabel.setText("Players Statistics");
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
//				{ "Name", "Average Score", "Game Won"},
//				{ "Alice", "20", "13" },
//				{ "Bob", "20", "13" },
//				{ "Clinton", "20", "13" },
//				{ "Hill", "20", "13"},
//				{ "Irving", "20", "13" },
//				{ "Alice", "20", "13" },
//				{ "Bob", "20", "13" },
//				{ "Clinton", "20", "13" },
//				{ "Hill", "20", "13" },
//				{ "Irving", "20", "13" },
//				{ "Clinton", "20", "13" },
//				{ "Hill", "20", "13" },
//				{ "Irving", "20", "13" }
//		};
		DataAccess dataAccess = new DataAccess(); 
		String[] columnNames = getColumnNames();
		Object[][] data;
		
		try {
			data = dataAccess.readData( 
			        "select * from statistics");
			System.out.println(columnNames[1]);
			StatTable = new JTable(data, columnNames);
			StatTable.setEnabled(false);
			StatTable.setBounds(80,90,300,250);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		return StatTable;
	}
	
	private String [] getColumnNames(){
    	String[] names = {"Name", "Average Score", "Game Won"};
    	return names;
    }

}
