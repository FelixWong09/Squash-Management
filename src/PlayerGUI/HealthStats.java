package PlayerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class HealthStats extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthStats frame = new HealthStats();
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
	public HealthStats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 432);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("RadioButton.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);

		
		JLabel lblWeight = new JLabel("Weight :");
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWeight.setBounds(10, 72, 46, 14);
		contentPane.add(lblWeight);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Updated Successfully!", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnUpdate.setBounds(154, 325, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			contentPane.setVisible(false);
			  dispose();
			  Catalog.main(null); 
		
		}
	});
		btnBack.setBounds(355, 325, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPersonalHealthInformation = new JLabel("Personal Health Information");
		lblPersonalHealthInformation.setFont(new Font("Sylfaen", Font.BOLD, 22));
		lblPersonalHealthInformation.setBounds(120, 11, 304, 33);
		contentPane.add(lblPersonalHealthInformation);
		
		textField = new JTextField();
		textField.setBounds(45, 97, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLbs = new JLabel("Lbs.");
		lblLbs.setBounds(132, 100, 46, 14);
		contentPane.add(lblLbs);
		
		JLabel lblOther = new JLabel("Health Issues:");
		lblOther.setBounds(20, 283, 64, 14);
		contentPane.add(lblOther);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 280, 136, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
