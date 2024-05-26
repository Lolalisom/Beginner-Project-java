package shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

public class Burger extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Burger frame = new Burger();
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
	private JTable burger1;
	
	public void showdata() {
		try {
			PreparedStatement ps = cn.prepareStatement("Select * From burger");
			ResultSet rs=ps.executeQuery();
			burger1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(contentPane, "Table show error"+e1);
		}
	}
	
	public Burger() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 421);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                String sql="DELETE FROM burger ";
                PreparedStatement ps=null;
                try {
                    ps=cn.prepareStatement(sql);
                    ps.executeUpdate();
                }catch(Exception e1) {
                    JOptionPane.showMessageDialog(rootPane, "Table clear error "+e1);
                }
              e.getWindow().dispose();
            }
        });
		
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, 100, SpringLayout.NORTH, contentPane);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (15.jpg"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 231, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 100, SpringLayout.NORTH, contentPane);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (16.jpg"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 208, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 53, SpringLayout.WEST, contentPane);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (19.jpg"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 208, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 231, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 264, SpringLayout.NORTH, contentPane);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (20.jpg"));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Beyond Meat Burger");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 111, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 167, SpringLayout.WEST, contentPane);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hamburger");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 111, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 231, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 331, SpringLayout.WEST, contentPane);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Steak Burger");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 275, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_6, 153, SpringLayout.WEST, contentPane);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cream Chicken Burger");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 275, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 212, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_7, 353, SpringLayout.WEST, contentPane);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 136, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 153, SpringLayout.WEST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"Bread, tomatoes, olive, ketchup, meat, salad");
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 153, SpringLayout.WEST, contentPane);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton_1,"Bread, tomatoes, olive, ketchup, Steak, salad, Chilli");
				
				
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("350tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 334, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, 153, SpringLayout.WEST, contentPane);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="INSERT INTO burger(Name, Quantity, Price) values(?,?,?)";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.setString(1, "Steak Burger");
					ps.setInt(2, 1);
					ps.setInt(3, 350);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_2, "INSERT BURGER ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 136, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 231, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, 331, SpringLayout.WEST, contentPane);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(btnNewButton_3,"Bread, tomatoes, olive, ketchup, chicken");
				
				
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_4, 300, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 231, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, 331, SpringLayout.WEST, contentPane);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"Bread, tomatoes, olive, ketchup, Crispy Chicken, salad");
				
				
			}
		});
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("260tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_5, 174, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_5, 53, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_5, 153, SpringLayout.WEST, contentPane);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			PreparedStatement ps=null;
			String sql="INSERT INTO burger(Name, Quantity, Price) values(?,?,?)";
			
			try {
				ps=cn.prepareStatement(sql);
				ps.setString(1, "Beyond Meat Burger");
				ps.setInt(2, 1);
				ps.setInt(3, 260);
				ps.executeUpdate();
			}catch(Exception e1) {
				
				JOptionPane.showMessageDialog(btnNewButton_5, "INSERT BURGER ERROR"+e);
			}
			showdata();
			}
			
			
		});
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("180tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_6, 175, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_6, 231, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_6, 331, SpringLayout.WEST, contentPane);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="INSERT INTO burger(Name, Quantity, Price) values(?,?,?)";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.setString(1, "Hamburger");
					ps.setInt(2, 1);
					ps.setInt(3, 180);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_6, "INSERT BURGER ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("300tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_7, 334, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_7, 231, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_7, 331, SpringLayout.WEST, contentPane);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="INSERT INTO burger(Name, Quantity, Price) values(?,?,?)";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.setString(1, "Cream Chicken Burger");
					ps.setInt(2, 1);
					ps.setInt(3, 300);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_7, "INSERT BURGER ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_7);
		
		JLabel lblNewLabel_8 = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 27, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_8, 414, SpringLayout.WEST, contentPane);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Quantity");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 27, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_9, 505, SpringLayout.WEST, contentPane);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Price");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 27, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_10, 604, SpringLayout.WEST, contentPane);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton_8 = new JButton("Buy");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_8, 334, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_8, 604, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_8, 675, SpringLayout.WEST, contentPane);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton_8, "Thank You.");
				PreparedStatement ps=null;
				String sql="DELETE FROM burger";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_8, "BUY TABLE ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Clear");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_9, 0, SpringLayout.NORTH, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_9, 564, SpringLayout.WEST, contentPane);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="DELETE FROM burger";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_9, "CLEAR TABLE ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_9);
		
		burger1 = new JTable();
		sl_contentPane.putConstraint(SpringLayout.NORTH, burger1, 54, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, burger1, 386, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, burger1, 323, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, burger1, 675, SpringLayout.WEST, contentPane);
		showdata();
		contentPane.add(burger1);
		
		JButton btnNewButton_10 = new JButton("Back");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_9, 35, SpringLayout.EAST, btnNewButton_10);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_10, 334, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_10, 386, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_10, 458, SpringLayout.WEST, contentPane);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Option op=new Option();
				op.setVisible(rootPaneCheckingEnabled);
				dispose();
			}
		});
		contentPane.add(btnNewButton_10);
	}
}
