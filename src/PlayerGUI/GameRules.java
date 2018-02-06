package PlayerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameRules extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameRules frame = new GameRules();
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
	public GameRules() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);
		
		JLabel lblGameRulesAnd = new JLabel("Game Rules and Regulations :");
		lblGameRulesAnd.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblGameRulesAnd.setBounds(10, 11, 320, 25);
		contentPane.add(lblGameRulesAnd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				  dispose();
				  Catalog.main(null); 
			}
		});
		btnBack.setBounds(213, 319, 89, 23);
		contentPane.add(btnBack);
		
		JTextPane txtpnToStartPlaying = new JTextPane();
		txtpnToStartPlaying.setBackground(UIManager.getColor("Button.background"));
		txtpnToStartPlaying.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		txtpnToStartPlaying.setText("\tTo start playing, you have to decide who will serve first.  You can do this by lagging, coin toss, or any other method you choose.  To serve, the server must drop the ball in the service zone and hit it after it takes one bounce.  The server gets two chances to put the ball into play.  A good serve means that the ball hits the front wall first and did not hit more than one other wall before hitting the floor beyond the short line.  Bad serves are called either fault serves or out serves.  If a server commits two fault serves, they lose the serve, or if they commit one out serve, they lose the serve.\r\nA player wins the rally when their opponent does not make a good return by either: \r\n1) Two Bounce.  Opponent could not return the ball before the second bounce on the floor. \r\n2) Skip Ball.  Opponent\u2019s return hit the floor before touching the front wall. ");
		txtpnToStartPlaying.setBounds(10, 41, 507, 301);
		contentPane.add(txtpnToStartPlaying);
	}
}
