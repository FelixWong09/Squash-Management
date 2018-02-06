package ManageGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;

import DataAccess.DataAccess;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class ViewRequest extends JFrame{

	private JFrame frame;
	private JTextField txtCurrentRequest;
	private JTable table;
	private JTable table_1;
	private JButton btnOrderEuipment;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void request() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRequest window = new ViewRequest();
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
	public ViewRequest() {
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
		
		txtCurrentRequest = new JTextField();
		txtCurrentRequest.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCurrentRequest.setText("Current Request");
		txtCurrentRequest.setBounds(146, 56, 142, 20);
		frame.getContentPane().add(txtCurrentRequest);
		txtCurrentRequest.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 92, 342, 121);
		frame.getContentPane().add(scrollPane);
		
		
		DataAccess dataAccess = new DataAccess(); 
		String []columnNames = {
				"Equipment ", "Quantity", "Due date"
			};
		Object[][] data;
		
		try {
			data = dataAccess.readData2( 
			        "select * from request");
			table_1 = new JTable(data, columnNames);
			table_1.getColumnModel().getColumn(2).setPreferredWidth(89);
			scrollPane.setViewportView(table_1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}  
		
//		table = new JTable();
//		scrollPane.setColumnHeaderView(table);
//		
//		table_1 = new JTable();
//		table_1.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"John", "Racket", "10", "11/12/2016"},
//				{"Mark", "Ball","20", "12/01/2016"},
//				{"Steve", "Racket","10", "01/12/2017"},
//				{null, null, null, null},
//			},
//			new String[] {
//				"Coach Name", "Supply name ", "Supply Quantity", "Due date"
//			}
//		));
		
		
		btnOrderEuipment = new JButton("order Equipment");
		btnOrderEuipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				  OrderEquipment nw = new OrderEquipment();
				  nw.order();
			}
		});
		btnOrderEuipment.setBounds(81, 224, 117, 23);
		frame.getContentPane().add(btnOrderEuipment);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyFirst.main(null);
			}
		});
		btnBack.setBounds(235, 224, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
