package ManageGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import DataAccess.DataAccess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ManageBudget extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtExpensesSummary;
	private JButton btnNewButton_1;
	private JButton btnModify;
	private String [] columnNames = {
			"month", "opening_balance ", "spent_amount", "available_balance"
		};

	/**
	 * Launch the application.
	 */
	public static void Budget() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageBudget frame = new ManageBudget();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageBudget() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtExpensesSummary = new JTextField();
		txtExpensesSummary.setFont(new Font("Arial Black", Font.PLAIN, 14));
		txtExpensesSummary.setHorizontalAlignment(SwingConstants.CENTER);
		txtExpensesSummary.setText("Expenses Summary");
		txtExpensesSummary.setColumns(10);
		
//		JButton btnNewButton = new JButton("Save");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null,"SAVED", "Message",JOptionPane.INFORMATION_MESSAGE);
//			}
//		});
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyFirst.main(null);
			}
		});
		
		btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int column = table.getSelectedColumn();
				String dataString = table.getValueAt(row, column).toString();
				System.out.println(dataString);
				String idString = table.getValueAt(row, 0).toString();
				
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
					String queryString =" update budget set " + columnNames[column]+ "= ? where month = ?";
					PreparedStatement preparedStmt = connection.prepareStatement(queryString);
				      preparedStmt.setString(1, dataString);
				      preparedStmt.setString(2, idString);
				      
				      preparedStmt.execute();
				} catch (Exception e2) {
					System.out.println("insert data error!");
					e2.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"Modified", "Message",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(185)
							.addComponent(txtExpensesSummary, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 491, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addComponent(btnModify)
							.addPreferredGap(ComponentPlacement.UNRELATED)
						//	.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtExpensesSummary, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					//	.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnModify))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		
		DataAccess dataAccess = new DataAccess(); 
		
		Object[][] data;
		
		try {
			data = dataAccess.readData2( 
			        "select * from budget");
			table = new JTable(data, columnNames);
			table.getColumnModel().getColumn(1).setPreferredWidth(93);
			table.getColumnModel().getColumn(2).setPreferredWidth(83);
			table.getColumnModel().getColumn(3).setPreferredWidth(93);
			scrollPane.setViewportView(table);
			contentPane.setLayout(gl_contentPane);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Jan", "5000", "1000", "4000"},
//				{"Feb", "4000", "2000", "2000"},
//				{"March", "7000", "1000", "6000"},
//				{"April", "8000", "3000", "5000"},
//				{"May", "5000", "0", "5000"},
//				{"June", "6000", "0", "6000"},
//				{"July", "7000", "1000", "6000"},
//				{"August", "6000", "0", "6000"},
//				{"September", "6000", "4000", "2000"},
//				{"October", "2000", "0", "2000"},
//				{"November", "2000", "1000", "1000"},
//				{"December", "6000", "5000", "1000"},
//				{"Total", "5000", "18,000", "1000"},
//				{null, null, null, null},
//				{null, null, null, null},
//			},
//			new String[] {
//				"Month", "Opening Balance ", "Spent Amount", "Available Balance"
//			}
//		));
		
	}

}
