package ManageGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import DataAccess.DataAccess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class OrderEquipment extends JFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void order() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderEquipment window = new OrderEquipment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OrderEquipment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 2);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(89, 73, 161, 76);
		frame.getContentPane().add(scrollPane_1);
		
		DataAccess dataAccess = new DataAccess(); 
		String []columnNames = {
				"Equipment ", "Quantity"
			};
		Object[][] data;
		
		try {
			data = dataAccess.readData2( 
			        "select * from orders");
			table = new JTable(data, columnNames);
			scrollPane_1.setViewportView(table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Racket", ""},
//				{"Balls", ""},
//				{"Gloves", ""},
//			},
//			new String[] {
//				"Equipment", "Quantity"
//			}
//		));
		
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Equipments Ordered", "Message",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnOrder.setBounds(90, 180, 89, 23);
		frame.getContentPane().add(btnOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
				MyFirst.main(null);
			}
		});
		btnBack.setBounds(216, 180, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
