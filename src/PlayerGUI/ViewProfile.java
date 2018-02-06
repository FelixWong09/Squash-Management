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
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class ViewProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProfile frame = new ViewProfile();
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
	public ViewProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			contentPane.setVisible(false);
			  dispose();
			  Catalog.main(null); 
		
		}
	});
		btnBack.setBounds(346, 312, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setFont(new Font("Rockwell", Font.BOLD, 22));
		lblPersonalInformation.setBounds(166, 0, 236, 43);
		contentPane.add(lblPersonalInformation);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			contentPane.setVisible(false);
			  dispose();
			  Profile.main(null); 
		}
	});
		btnChange.setBounds(130, 312, 89, 23);
		contentPane.add(btnChange);
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setBounds(10, 54, 53, 14);
		contentPane.add(lblFullName);
		
		JLabel lblBalaramRemala = new JLabel("Balaram Remala");
		lblBalaramRemala.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBalaramRemala.setBounds(73, 54, 110, 14);
		contentPane.add(lblBalaramRemala);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth :");
		lblDateOfBirth.setBounds(10, 94, 68, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel label = new JLabel("03/25/1995");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(92, 94, 91, 14);
		contentPane.add(label);
		
		JLabel lblSex = new JLabel("Sex :");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSex.setBounds(10, 139, 46, 14);
		contentPane.add(lblSex);
		
		JLabel lblMale = new JLabel("Male");
		lblMale.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMale.setBounds(50, 139, 46, 14);
		contentPane.add(lblMale);
		
		JLabel lblPhoneNumber = new JLabel("Phone number :");
		lblPhoneNumber.setBounds(10, 186, 86, 14);
		contentPane.add(lblPhoneNumber);
		
		JLabel label_1 = new JLabel("(269) 366 2399");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(94, 185, 110, 14);
		contentPane.add(label_1);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 236, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblXyzStreet = new JLabel("1923, XYZ Street, Greensboro, NC");
		lblXyzStreet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblXyzStreet.setBounds(66, 235, 227, 14);
		contentPane.add(lblXyzStreet);
	}

}
