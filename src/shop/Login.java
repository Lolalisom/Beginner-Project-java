package shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField uid;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	Connection cn=SQLConnection.ConnecrDb();
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("UserID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(53, 84, 70, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Food Village");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblNewLabel_1.setBounds(152, 11, 155, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(53, 137, 103, 14);
		contentPane.add(lblNewLabel);
		
		Button log = new Button("Login");
		log.setForeground(Color.DARK_GRAY);
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=uid.getText();
				String pa=pass.getText();
				if(!user.equals("") && !pa.equals("")) {
					PreparedStatement ps=null;
					String sql="SELECT * FROM register WHERE UserID = ? and Password = ?";
					ResultSet rs=null;
					String ou=null;
					String op=null;
					try {
						
						 ps=cn.prepareStatement(sql);
						 ps.setString(1, user);
						 ps.setString(2, pa);
						 rs=ps.executeQuery();
						 
						 while(rs.next()) {
							 ou=rs.getString("UserID");
							 op=rs.getString("Password");
						 }
						 if(rs.equals("")) {
							 JOptionPane.showMessageDialog(log, "Create an account");
							 
						 }
						 else if(user.equals(ou) && pa.equals(op)) {
							 
							 Option option=new Option();
							 option.setVisible(rootPaneCheckingEnabled);
							 dispose();
						 }
						 else {
							 JOptionPane.showMessageDialog(log, "Enter correct userID and password");
						 }
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(log, "logging error");
					}
					
				}
				else {
					JOptionPane.showMessageDialog(log, "userid or pass empty");
				}
			}
		});
		log.setBounds(314, 191, 70, 22);
		contentPane.add(log);
		
		Button reg = new Button("Register");
		reg.setForeground(Color.DARK_GRAY);
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register register=new Register();
				register.setVisible(rootPaneCheckingEnabled);
				dispose();
			}
		});
		reg.setBounds(145, 191, 70, 22);
		contentPane.add(reg);
		
		uid = new JTextField();
		uid.setBounds(145, 84, 239, 20);
		contentPane.add(uid);
		uid.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(145, 136, 239, 20);
		contentPane.add(pass);
	}
}
