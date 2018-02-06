package PlayerGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Window.Type;
//import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Login {

	public JFrame frmLogin;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.getContentPane().setBackground(Color.WHITE);
		frmLogin.setBounds(100, 100, 561, 375);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setExtendedState(frmLogin.getExtendedState()| JFrame.MAXIMIZED_BOTH);
		frmLogin.setUndecorated(true);
		textField = new JTextField();
		textField.setBounds(343, 131, 167, 27);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLogin.dispose();
				Catalog cat=new Catalog();
				cat.setVisible(true);
			}
		});
		btnSubmit.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		btnSubmit.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		btnSubmit.setBounds(429, 169, 81, 27);
		frmLogin.getContentPane().add(btnSubmit);
		
		JLabel lblWelcomeToRaquetball = new JLabel("University RacquetBall club");
		lblWelcomeToRaquetball.setFont(new Font("Tw Cen MT", Font.PLAIN, 28));
		lblWelcomeToRaquetball.setBounds(10, 37, 300, 65);
		frmLogin.getContentPane().add(lblWelcomeToRaquetball);
		
		
		JLabel lblEnterYourUser = new JLabel("Enter your User ID");
		lblEnterYourUser.setForeground(Color.WHITE);
		lblEnterYourUser.setFont(new Font("Yu Gothic UI", Font.BOLD, 12));
		lblEnterYourUser.setBounds(375, 106, 97, 14);
		frmLogin.getContentPane().add(lblEnterYourUser);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		btnReset.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        textField.setText("");
		    }
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(383, 240, 89, 23);
		frmLogin.getContentPane().add(btnExit);
		btnReset.setBackground(SystemColor.inactiveCaptionBorder);
		btnReset.setBounds(343, 169, 76, 27);
		frmLogin.getContentPane().add(btnReset);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/balaram_remala/Documents/workspace/Balaram Remala/RaquetBall/Pictures/Login.png"));
		lblNewLabel.setBounds(0, 0, 561, 375);
		frmLogin.getContentPane().add(lblNewLabel);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalGlue.setBounds(343, 131, 1, 1);
		frmLogin.getContentPane().add(verticalGlue);
	//	frmLogin.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmLogin.getContentPane(), textField, btnSubmit, lblWelcomeToRaquetball, lblEnterYourUser, btnReset, lblNewLabel, verticalGlue}));
	}
}
