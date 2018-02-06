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
import java.sql.SQLException;


public class ViewEquipment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtAvailableInventory;

	/**
	 * Launch the application.
	 */
	public static  void View() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEquipment frame = new ViewEquipment();
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
	public ViewEquipment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtAvailableInventory = new JTextField();
		txtAvailableInventory.setFont(new Font("Arial Black", Font.BOLD, 14));
		txtAvailableInventory.setHorizontalAlignment(SwingConstants.CENTER);
		txtAvailableInventory.setText("Available Inventory");
		txtAvailableInventory.setColumns(10);
		
		JButton btnNewButton = new JButton("Order Equipment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				  dispose();
				  OrderEquipment nw = new OrderEquipment();
				  nw.order();
				  MyFirst.main(null);
				//  Profile.main(null);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			
				
			}
		});
		
		JButton btnViewRequest = new JButton("view Request");
		btnViewRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				 ViewRequest nw = new ViewRequest();
				  nw.request();
				 
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(btnViewRequest)
							.addGap(27)
							.addComponent(btnNewButton)
							.addGap(18)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtAvailableInventory, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(42, Short.MAX_VALUE)
					.addComponent(txtAvailableInventory, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton)
						.addComponent(btnViewRequest))
					.addGap(12))
		);
		DataAccess dataAccess = new DataAccess(); 
		String []columnNames = {
				"Equipment ", "Quantity"
			};
		Object[][] data;
		
		try {
			data = dataAccess.readData2( 
			        "select * from inventory");
			table = new JTable(data, columnNames);
			table.getColumnModel().getColumn(0).setPreferredWidth(102);
			table.getColumnModel().getColumn(1).setPreferredWidth(80);
			scrollPane.setViewportView(table);
			contentPane.setLayout(gl_contentPane);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
	}
}
