package ManageGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class MyFirst extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFirst frame = new MyFirst();
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
	public MyFirst() {
		setTitle("Manager View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 616, 416);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		 
		 JButton btnNewButton = new JButton("View Equipments/Training Supplies");
		 btnNewButton.setBounds(23, 241, 207, 23);
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		dispose();
		 		ViewEquipment nw = new ViewEquipment();
		 		nw.View();
		 		
		 	}
		 });
		 
		 JButton btnNewButton_1 = new JButton("Make Travel Arrangements");
		 btnNewButton_1.setBounds(23, 275, 191, 23);
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		dispose();
		 		MakeTravelArrangements nz = new MakeTravelArrangements();
		 		nz.Travel();
		 		
		 	}
		 });
		 
		 JButton btnNewButton_2 = new JButton("Manage Budget");
		 btnNewButton_2.setBounds(23, 305, 131, 23);
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		ManageBudget ns = new ManageBudget();
		 		ns.Budget();
		 	}
		 });
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_2);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\CodeRepository\\Done\\IMG\\s.jpg"));
		lblNewLabel.setBounds(-12, 0, 617, 383);
		contentPane.add(lblNewLabel);
	}
}
