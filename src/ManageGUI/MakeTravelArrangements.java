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
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import DataAccess.DataAccess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class MakeTravelArrangements extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtEventDetailsschedule;
	private JButton btnNewButton;
	private JButton btnChangeTravel;

	/**
	 * Launch the application.
	 */
	public static void Travel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeTravelArrangements frame = new MakeTravelArrangements();
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
	public MakeTravelArrangements() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtEventDetailsschedule = new JTextField();
		txtEventDetailsschedule.setFont(new Font("Arial Black", Font.PLAIN, 14));
		txtEventDetailsschedule.setHorizontalAlignment(SwingConstants.CENTER);
		txtEventDetailsschedule.setText("Current Travel Schedule");
		txtEventDetailsschedule.setColumns(10);
		
		JButton btnBookmanageTravel = new JButton("Book Travel");
		btnBookmanageTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Booking Confirmed", "Message",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyFirst.main(null);
			}
		});
		
		btnChangeTravel = new JButton("Modify travel");
		btnChangeTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Changes Confirmed", "Message",JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(186)
							.addComponent(txtEventDetailsschedule, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addComponent(btnChangeTravel)
							.addGap(47)
							.addComponent(btnBookmanageTravel)
							.addGap(39)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(txtEventDetailsschedule, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBookmanageTravel)
						.addComponent(btnNewButton)
						.addComponent(btnChangeTravel))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		
		DataAccess dataAccess = new DataAccess(); 
		String []columnNames = {
				"Event Name", "Event Location", "Event Date", "No of Players", "Travel Mode"
			};
		Object[][] data;
		
		try {
			data = dataAccess.readData2( 
			        "select * from travel");
			table = new JTable(data, columnNames);
			table.getColumnModel().getColumn(0).setPreferredWidth(153);
			table.getColumnModel().getColumn(1).setPreferredWidth(97);
			table.getColumnModel().getColumn(2).setPreferredWidth(111);
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
//				{"Squash Tornment Divisional", "Florida", "Oct 18, 2016", "4", "Flight"},
//				{"Big Squash ", "North Carolina", "Nov 06, 2016", "2", "Car"},
//				{"Squash Cup", "Miami", "Nov 08, 2016", "2", "Train"},
//				{"Squash for the Best", "Newyork", "Dec 01, 2016", "4", "Flight"},
//				{null, null, null, null, null},
//				{null, null, null, null, null},
//			},
//			new String[] {
//				"Event Name", "Event Location", "Event Date", "No of Players", "Travel Mode"
//			}
//		));
		
	}

}
