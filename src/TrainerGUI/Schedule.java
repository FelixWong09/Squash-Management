package TrainerGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Schedule extends JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
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
	public Schedule() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		getContentPane().setLayout(null);
		setUndecorated(true);
        setVisible(true);
        GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
        setBounds(maximumWindowBounds);
		
		table = new JTable();
		table.setForeground(Color.WHITE);
		table.setOpaque(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBounds(773, 593, -512, -358);
		
		getContentPane().add(table);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  dispose();
				Page2 pg2= new Page2();
				pg2.setVisible(true);
		
			}
		});

		Image bck = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		button.setIcon(new ImageIcon(bck));
		button.setBounds(1079, 762, 97, 81);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image scr = new ImageIcon(this.getClass().getResource("/Screenshot (2).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(scr));
		lblNewLabel.setBounds(217, 229, 775, 206);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTrainingSchedule = new JLabel("TRAINING SCHEDULE");
		lblTrainingSchedule.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		lblTrainingSchedule.setBounds(217, 68, 481, 93);
		getContentPane().add(lblTrainingSchedule);
		
		JButton btnCreateNewSchedule = new JButton("<html> CREATE NEW <br />SCHEDULE </html>");
		btnCreateNewSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
					Create crt= new Create();
					crt.setVisible(true);
			}
		});
		btnCreateNewSchedule.setBounds(329, 603, 141, 104);
		getContentPane().add(btnCreateNewSchedule);
		
		JButton btnModifyTrainingSchedule = new JButton("<html>MODIFY TRAINING<br/> SCHEDULE</html>");
		btnModifyTrainingSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "TRAINING SCHEDULE UPDATED", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnModifyTrainingSchedule.setBounds(642, 603, 137, 104);
		getContentPane().add(btnModifyTrainingSchedule);
		
		
		
	}
}
