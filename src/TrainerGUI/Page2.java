package TrainerGUI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Page2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page2 frame = new Page2();
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
	public Page2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		//Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane.setLayout(null);
		setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);
		
		JButton btnNewButton = new JButton("<html>PLAYER'S  <br /> INFORMATION</html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				  dispose();
				 PlayerInfo plr=new PlayerInfo();
				 plr.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(616, 303, 172, 105);
		contentPane.add(btnNewButton);
		
		JButton btnModifyExistingTraining = new JButton("<html>TRAINING  <br /> SCHEDULE</html>");
		btnModifyExistingTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				  dispose();
				 Schedule sch=new Schedule();
				 sch.setVisible(true);
				
			}
		});
		btnModifyExistingTraining.setBounds(616, 107, 172, 105);
		contentPane.add(btnModifyExistingTraining);
		
		JButton btnRequestForSupplies = new JButton("REQUEST FOR SUPPLIES");
		btnRequestForSupplies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				  dispose();
				 Request req=new Request();
				 req.setVisible(true);
				
			}
		});
		btnRequestForSupplies.setBounds(616, 489, 175, 105);
		contentPane.add(btnRequestForSupplies);
		
		JButton btnLogout = new JButton("");
		Image out = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnLogout.setIcon(new ImageIcon(out));
		btnLogout.setBounds(853, 624, 97, 79);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.setVisible(false);
				  dispose();
				  MyGui.main(null); 
					
			}
		});
		contentPane.add(btnLogout);
		
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.setBounds(874, 705, 66, 16);
		contentPane.add(lblLogout);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nuthi\\Downloads\\P2.jpg"));
		lblNewLabel.setBounds(0, 0, 1000, 800);
		getContentPane().add(lblNewLabel);
		//frame.getContentPane().add(lblNewLabel);
	}
}
