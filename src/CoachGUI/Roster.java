package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DataAccess.DataAccess;


public class Roster extends JFrame{
	
	JTable rosterTable;
	
	private JButton editButton;
	private JButton backButton;
	private JButton doneButton;
	
	private Roster frame;
	
	public Roster() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("Roster");
		this.getContentPane().setLayout(null);
		
		this.add(this.getButtonEdit(), null);
		this.add(this.getButtonBack(), null);
		this.add(this.getButtonDone(), null);
		
		this.add(getTable());
	}
	
	private JButton getButtonEdit(){
		if(editButton == null) {
			editButton = new JButton();
			editButton.setBounds(380,60,66,27);
			editButton.setText("Edit");
			editButton.addActionListener(new EditButton());
    	}
		return editButton;
	};
	
	private class EditButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			/**
			 * enable table to edit
			 */
			rosterTable.setEnabled(true);
		}
	}
	
	private JButton getButtonBack(){
		if(backButton == null) {
			backButton = new JButton();
			backButton.setBounds(380,180,66,27);
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
	
	private JButton getButtonDone(){
		if(doneButton == null) {
			doneButton = new JButton();
			doneButton.setBounds(380,120,66,27);
			doneButton.setText("Done");
			doneButton.addActionListener(new DoneButton());
    	}
		return doneButton;
	}
	
	private class DoneButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			/**
			 * save data
			 */
			int row = rosterTable.getSelectedRow();
			int column = rosterTable.getSelectedColumn();
			String dataString = rosterTable.getValueAt(row, column).toString();
			String nameString = rosterTable.getValueAt(row, 0).toString();
			
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
				String queryString =" update roster set " + getColumnNames()[column]+ "= ? where name = ?";
				PreparedStatement preparedStmt = connection.prepareStatement(queryString);
			      preparedStmt.setString(1, dataString);
			      preparedStmt.setString(2, nameString);
			      
			      preparedStmt.execute();
			} catch (Exception e2) {
				System.out.println("insert data error!");
				e2.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null,"Modified", "Message",JOptionPane.INFORMATION_MESSAGE);
//			frame.setVisible(false);
//        	CompetitionManagementWindow frame2 = new CompetitionManagementWindow();
//            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//
//            frame2.setVisible(true);
		}
	}
	
	private JTable getTable() {
//		Object[][] data = {
//				{ "Name", "Gender", "Age" },
//				{ "Alice", "Female", "19" },
//				{ "Bob", "Male", "23" },
//				{ "Clinton", "Male", "27" },
//				{ "David", "Male", "43" },
//				{ "Emily", "Female", "32" },
//				{ "Frank", "Male", "27" },
//				{ "Grace", "Female", "24" },
//				{ "Hill", "Male", "29" },
//				{ "Irving", "Male", "33" },
//				{ "Justin", "Male", "21" },
//				{ "Kevin", "Male", "45" },
//				{ "Lauren", "Female", "32" }
//		};
		DataAccess dataAccess = new DataAccess(); 
		String[] columnNames = getColumnNames();
		Object[][] data;
		
		try {
			data = dataAccess.readData( 
			        "select * from roster");
			rosterTable = new JTable();
			rosterTable.setModel(new DefaultTableModel(data, columnNames));
			rosterTable.setEnabled(false);
			rosterTable.setBounds(60,60,300,250);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		return rosterTable;
	}
	
	private String [] getColumnNames(){
    	String[] names = {"Name","Gender","Age"};
    	return names;
    }
}
