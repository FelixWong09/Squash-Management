package TrainerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Create extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create frame = new Create();
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
	public Create() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		//Image scr = new ImageIcon(this.getClass().getResource("/Screenshot (4).png")).getImage();
		//lblNewLabel.setIcon(new ImageIcon(scr));
		lblNewLabel.setBounds(610, 333, 843, 317);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				  dispose();
				Schedule pg2= new Schedule();
				pg2.setVisible(true);
			}
		});
		//Image bck = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnNewButton.setIcon(new ImageIcon(bck));
		btnNewButton.setBounds(1539, 806, 97, 81);
		contentPane.add(btnNewButton);
		
		JLabel lblCreateNewTable = new JLabel("CREATE NEW TABLE");
		lblCreateNewTable.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblCreateNewTable.setBounds(616, 187, 449, 74);
		contentPane.add(lblCreateNewTable);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "TRAINING SCHEDULE CREATED", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCreate.setBounds(1097, 806, 137, 81);
		contentPane.add(btnCreate);

		
	}
}
