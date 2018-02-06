package TrainerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Request extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Request frame = new Request();
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
	public Request() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);
		
		JLabel lblRequest = new JLabel("Ran Out of Equipment?  Ask Us..!");
		lblRequest.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblRequest.setBounds(246, 63, 510, 81);
		contentPane.add(lblRequest);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("hi");
		comboBox.setBounds(288, 219, 259, 36);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(288, 317, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblQuantity.setBounds(288, 282, 116, 22);
		contentPane.add(lblQuantity);
		
		JButton btnRequest = new JButton("REQUEST");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "EQUIPMENT REQUESTED", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnRequest.setBounds(288, 408, 97, 25);
		contentPane.add(btnRequest);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				  dispose();
				Page2 pg2= new Page2();
				pg2.setVisible(true);
			}
		});
		Image bck = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(bck));
		btnNewButton.setBounds(811, 612, 97, 81);
		contentPane.add(btnNewButton);
		
		JLabel lblSelectItem = new JLabel("Select Item");
		lblSelectItem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSelectItem.setBounds(288, 173, 130, 36);
		contentPane.add(lblSelectItem);
	}

}
