package PlayerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Training extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Training frame = new Training();
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
	public Training() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 420);
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
		btnBack.setBounds(219, 320, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblTrainingSchedule = new JLabel("Training Schedule");
		lblTrainingSchedule.setFont(new Font("Rockwell", Font.BOLD, 24));
		lblTrainingSchedule.setBounds(150, 6, 240, 38);
		contentPane.add(lblTrainingSchedule);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon("C:\\Users\\Balu\\Desktop\\se2.PNG"));
		label.setBounds(10, 55, 504, 254);
		contentPane.add(label);
	}

}
