package shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField mail;
	private JTextField phn;
	private JTextField id;
	private JTextField passs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(53, 49, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setBounds(53, 97, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setBounds(53, 152, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("UserID");
		lblNewLabel_3.setBounds(53, 203, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		name = new JTextField();
		name.setBounds(119, 46, 243, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(119, 94, 243, 20);
		contentPane.add(mail);
		mail.setColumns(10);
		
		phn = new JTextField();
		phn.setBounds(119, 149, 243, 20);
		contentPane.add(phn);
		phn.setColumns(10);
		
		id = new JTextField();
		id.setBounds(119, 200, 243, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(42, 257, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		passs = new JTextField();
		passs.setBounds(119, 254, 243, 20);
		contentPane.add(passs);
		passs.setColumns(10);
		
		Button button = new Button("SignUP");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=name.getText();
				String b=mail.getText();
				String c=phn.getText();
				String d=id.getText();
				String p=passs.getText();
				
				PreparedStatement ps=null;
			String sql="INSERT INTO register(Name, Email, Phone, UserID, Password) values(?,?,?,?,?)";
			
				try{
					ps=cn.prepareStatement(sql);
					ps.setString(1, a);
					ps.setString(2, b);
					ps.setString(3, c);
					ps.setString(4, d);
					ps.setString(5, p);
					ps.executeUpdate();
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(button, "insert error "+ e1);
				}
				Login log=new Login();
				log.setVisible(rootPaneCheckingEnabled);
				dispose();
			}
		});
		button.setBounds(292, 305, 70, 22);
		contentPane.add(button);
	}
}
