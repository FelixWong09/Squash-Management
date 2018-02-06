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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.UIManager;

public class CompSchedule extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompSchedule frame = new CompSchedule();
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
	public CompSchedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 393);
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
			  Catalog.main(null); 
		
		}
	});
		btnBack.setBounds(231, 320, 89, 23);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Balu\\Desktop\\se1.JPG"));
		label.setBounds(26, 48, 500, 257);
		contentPane.add(label);
		
		JLabel lblCompetetionSchedule = new JLabel("Competition Schedule");
		lblCompetetionSchedule.setFont(new Font("Perpetua Titling MT", Font.BOLD, 20));
		lblCompetetionSchedule.setBounds(135, 11, 299, 30);
		contentPane.add(lblCompetetionSchedule);
	}
}
