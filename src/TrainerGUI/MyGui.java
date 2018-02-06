package TrainerGUI;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyGui {

	public JFrame frame;
	private JTextField txtTypeYourName;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGui window = new MyGui();
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
	public MyGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLACK);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		
		txtTypeYourName = new JTextField();
		txtTypeYourName.setText("");
		txtTypeYourName.setBounds(710, 504, 214, 49);
		frame.getContentPane().add(txtTypeYourName);
		txtTypeYourName.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		//Image img3 = new ImageIcon(this.getClass().getResource("/login (1).png")).getImage();
		//btnNewButton.setIcon(new ImageIcon(img3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try{
					//if(txtTypeYourName.getText()=="Mukund")
					//{
						frame.dispose();
						Page2 pg2= new Page2();
						pg2.setVisible(true);
	
						
					//}
					
				}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,e);
			}
			}
		});
		btnNewButton.setBounds(795, 618, 129, 41);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(188, 143, 143));
		Image img1 = new ImageIcon(this.getClass().getResource("/ball.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img1));
		lblNewLabel.setBounds(713, 103, 187, 187);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/trainer.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(600, 457, 80, 69);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblUncgRacquetBall = new JLabel("THE SQUASH CLUB");
		lblUncgRacquetBall.setFont(new Font("Tempus Sans ITC", Font.BOLD, 35));
		lblUncgRacquetBall.setBounds(499, 346, 405, 69);
		frame.getContentPane().add(lblUncgRacquetBall);
		
		JLabel lblTrainersLogin = new JLabel("TRAINER'S LOGIN");
		lblTrainersLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblTrainersLogin.setBounds(697, 457, 214, 34);
		frame.getContentPane().add(lblTrainersLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lblUsername.setBounds(570, 526, 115, 49);
		frame.getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\nuthi\\Downloads\\main1.jpg"));
		label.setBounds(0, 0, 1000, 800);
		frame.getContentPane().add(label);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
