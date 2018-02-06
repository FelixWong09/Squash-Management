package PlayerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.SystemColor;

public class Catalog extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catalog frame = new Catalog();
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
	public Catalog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);		
		JButton btnViewSchedule = new JButton("View training schedule");
		btnViewSchedule.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnViewSchedule.setBounds(373, 100, 182, 39);
		contentPane.add(btnViewSchedule);
		btnViewSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				  dispose();
				  Training.main(null);
			}
		});
		
		JButton btnNewButton_1 = new JButton("My Health Stats");
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				  dispose();
				  HealthStats.main(null); 
			}
		});
		btnNewButton_1.setBounds(31, 104, 133, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Competetion Schedule");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				  dispose();
				  CompSchedule.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnNewButton_2.setBounds(31, 322, 146, 31);
		contentPane.add(btnNewButton_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				  dispose();
				  Login.main(null); 
			
			}
		});
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				  dispose();
				  ViewProfile.main(null); 
			
			}
		});
		
		btnMyProfile.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnMyProfile.setBounds(242, 161, 105, 31);
		contentPane.add(btnMyProfile);
		btnLogout.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnLogout.setBounds(424, 326, 105, 23);
		contentPane.add(btnLogout);
		
		JLabel lblWelcomeToRacquetball = new JLabel("Welcome to Racquetball Club");
		lblWelcomeToRacquetball.setForeground(new Color(0, 0, 102));
		lblWelcomeToRacquetball.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblWelcomeToRacquetball.setBounds(65, 11, 464, 59);
		contentPane.add(lblWelcomeToRacquetball);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/balaram_remala/Documents/workspace/Balaram Remala/RaquetBall/Pictures/player.png"));
		lblNewLabel_1.setBounds(217, 203, 164, 218);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/balaram_remala/Documents/workspace/Balaram Remala/RaquetBall/Pictures/Background.jpg"));
		lblNewLabel.setBounds(0, 0, 582, 428);
		contentPane.add(lblNewLabel);
	}

}
