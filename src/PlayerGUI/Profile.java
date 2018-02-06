package PlayerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			contentPane.setVisible(false);
			  dispose();
			  ViewProfile.main(null); 
		
		}
	});
		btnBack.setBounds(330, 329, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFullName.setBounds(20, 68, 64, 14);
		contentPane.add(lblFullName);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Updated Successfully!", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBounds(150, 329, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblPersonalInformation = new JLabel("Update Personal Information");
		lblPersonalInformation.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblPersonalInformation.setBounds(117, 11, 444, 39);
		contentPane.add(lblPersonalInformation);
		
		textField = new JTextField();
		textField.setBounds(94, 65, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setBounds(20, 110, 95, 14);
		contentPane.add(lblDateOfBirth);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 107, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex :");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(20, 146, 46, 14);
		contentPane.add(lblSex);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(68, 142, 73, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(143, 142, 81, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(227, 142, 109, 23);
		contentPane.add(rdbtnOther);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 179, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(20, 212, 64, 14);
		contentPane.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 210, 179, 88);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNumber.setBounds(20, 182, 95, 14);
		contentPane.add(lblPhoneNumber);
	}

}
