package TrainerGUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;

public class PlayerInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayerInfo frame = new PlayerInfo();
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
	public PlayerInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//pack();
		//setSize(screenSize.width,screenSize.height);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);
		
		JButton btnBack = new JButton("");
		//Image back = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		//btnBack.setIcon(new ImageIcon(back));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				  dispose();
				
				Page2 pg2= new Page2();
				pg2.setVisible(true);
				//((Window) getRootPane().getParent()).dispose();
			}
		});
		btnBack.setBounds(707, 392, 97, 73);
		contentPane.add(btnBack);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(335, 105, 272, 35);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Get Details");
		btnNewButton.setBounds(721, 105, 135, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblSelectAPlayer = new JLabel("Select a Player");
		lblSelectAPlayer.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSelectAPlayer.setBounds(325, 70, 111, 25);
		contentPane.add(lblSelectAPlayer);
		
		JLabel lblLastUpdated = new JLabel("Last Updated");
		lblLastUpdated.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastUpdated.setBounds(325, 153, 97, 35);
		contentPane.add(lblLastUpdated);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWeight.setBounds(325, 302, 70, 19);
		contentPane.add(lblWeight);
		
		JLabel lblHealthIssues = new JLabel("Health Issues");
		lblHealthIssues.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHealthIssues.setBounds(325, 372, 97, 25);
		contentPane.add(lblHealthIssues);
		
		JLabel lblWristPain = new JLabel("<html> Wrist pain <br/> Leg Sprain </html>");
		lblWristPain.setBackground(Color.WHITE);
		lblWristPain.setBackground(Color.white);
		lblWristPain.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblWristPain.setHorizontalAlignment(SwingConstants.CENTER);
		lblWristPain.setOpaque(true);
		lblWristPain.setBounds(335, 410, 170, 146);
		contentPane.add(lblWristPain);
		
		JLabel lblNewLabel = new JLabel("09/09/2016, Sunday");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(Color.white);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(335, 187, 159, 21);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("55");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBackground(Color.white);
		label_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setOpaque(true);
		label_1.setBounds(335, 334, 66, 25);
		contentPane.add(label_1);
		
		JLabel lblBack = new JLabel("BACK");
		lblBack.setBounds(735, 467, 56, 16);
		contentPane.add(lblBack);
		
		JLabel lblPlayersTrainingStatus = new JLabel("Player's Training Completed Status");
		lblPlayersTrainingStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlayersTrainingStatus.setBounds(325, 232, 231, 25);
		contentPane.add(lblPlayersTrainingStatus);
		
		JLabel lblYes = new JLabel("YES");
		lblYes.setBackground(Color.white);
		lblYes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblYes.setHorizontalAlignment(SwingConstants.CENTER);
		lblYes.setOpaque(true);
		lblYes.setBounds(335, 260, 66, 29);
		contentPane.add(lblYes);
		
		JLabel lblPlayerInformation = new JLabel("PLAYER INFORMATION");
		lblPlayerInformation.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblPlayerInformation.setBounds(281, 13, 243, 35);
		contentPane.add(lblPlayerInformation);
	}
}
