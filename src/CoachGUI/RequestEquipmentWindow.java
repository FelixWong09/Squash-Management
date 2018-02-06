package CoachGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RequestEquipmentWindow extends JFrame {

	/**
	 * @param args
	 */
	private JLabel label1;
	private JLabel label2;
	private JTextField equipmentTextField;
	private JTextField quantityTextField;
	private JButton backButton;
	private JButton submitButton;
	private RequestEquipmentWindow frame;
	
	public RequestEquipmentWindow() {
		super();
		this.frame = this;
		this.setSize(500,500);
		this.setTitle("Request Equipment");
		this.getContentPane().setLayout(null);
		
		this.add(this.getLableEquip(), null);
		this.add(this.getLableQuantity(), null);
		this.add(this.getTextFieldEquip(), null);
		this.add(this.getTextFieldQuantity(), null);
		this.add(this.getButtonBack(), null);
		this.add(this.getButtonSubmit(), null);
	}
	
	private JLabel getLableEquip(){
		if(label1 == null) {
			label1 = new JLabel();
			label1.setBounds(84,109,63,28);
            label1.setText("Equipment");
		}
		return label1;
	}
	
	private JLabel getLableQuantity(){
		if(label2 == null) {
			label2 = new JLabel();
			label2.setBounds(324,109,63,28);
            label2.setText("Quantity");
		}
		return label2;
	}
	
	private JTextField getTextFieldEquip(){
		if(equipmentTextField == null) {
			equipmentTextField = new JTextField();
			equipmentTextField.setBounds(44, 139, 200, 40);
		}
		return equipmentTextField;
	}
	
	private JTextField getTextFieldQuantity(){
		if(quantityTextField == null) {
			quantityTextField = new JTextField();
			quantityTextField.setBounds(246, 139, 200, 40);
		}
		return quantityTextField;
	}
	
	private JButton getButtonBack(){
		if(backButton == null) {
			backButton = new JButton();
			backButton.setText("Back");
			backButton.setBounds(101,230,79,38);
			backButton.addActionListener(new BackButton());
		}
		return backButton;
	}
	
	private class BackButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			OperateWindow frame1 = new OperateWindow();
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.setVisible(true);
		}
	}
	
	private JButton getButtonSubmit(){
		if(submitButton == null) {
			submitButton = new JButton();
			submitButton.setText("Submit");
			submitButton.setBounds(300,230,79,38);
			submitButton.addActionListener(new SubmitButton());
		}
		return submitButton;
	}
	
	private class SubmitButton implements ActionListener {
		public void actionPerformed(ActionEvent e){
			/**
			 * save data
			 */
			String equipment = equipmentTextField.getText();
			String quantity = quantityTextField.getText();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");//load MYSQL JDBC Çý¶¯³ÌÐò
				System.out.println("Success loading Mysql Driver!");
			} catch (Exception e1) {
				System.out.println("Error loading Mysql Driver!");
				e1.printStackTrace();
			}
			try {
				Connection connection = DriverManager.getConnection(
						 "jdbc:mysql://localhost:3306/squash","root","123456");
				System.out.println("Success connect Mysql server!");
				String queryString =" insert into request (From, equipment, quantity, due_date)"
				        + " values (?, ?, ?, ?)";
				PreparedStatement preparedStmt = connection.prepareStatement(queryString);
				  preparedStmt.setString(1, "coach");
				  preparedStmt.setString(2, equipment);
			      preparedStmt.setString(3, quantity);
			      preparedStmt.setString(4, "2016-12-01");
			      

			      
			      preparedStmt.execute();
			} catch (Exception e2) {
				System.out.println("insert data error!");
				e2.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null,"Request created", "Message",JOptionPane.INFORMATION_MESSAGE);
//			frame.setVisible(false);
//			OperateWindow frame2 = new OperateWindow();
//			frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			frame2.setVisible(true);
		}
	}
}
