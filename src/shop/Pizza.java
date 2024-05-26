package shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SpringLayout;

public class Pizza extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pizza frame = new Pizza();
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
	private JTable pizza1;
	
	public void showdata() {
		try {
			PreparedStatement ps = cn.prepareStatement("Select * From pizza");
			ResultSet rs=ps.executeQuery();
			pizza1.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(contentPane, "Table show error"+e1);
		}
	}
	public Pizza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                String sql="DELETE FROM pizza ";
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 48, SpringLayout.WEST, contentPane);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (13.jpg"));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BBQ Chicken Pizza");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 105, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 36, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_1, 162, SpringLayout.WEST, contentPane);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_2, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 94, SpringLayout.NORTH, contentPane);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (12.jpg"));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Veggie Pizza");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 105, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_3, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_3, 341, SpringLayout.WEST, contentPane);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_9 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 212, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_9, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, 268, SpringLayout.NORTH, contentPane);
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (18.jpg"));
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 212, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_8, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_8, 268, SpringLayout.NORTH, contentPane);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\shakh\\Downloads\\wallpaperflare.com_wallpaper (11.jpg"));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_4 = new JLabel("Special Pizza");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 279, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_4, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_4, 148, SpringLayout.WEST, contentPane);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Pepperoni Pizza");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 279, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_5, 214, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_5, 377, SpringLayout.WEST, contentPane);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 130, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 148, SpringLayout.WEST, contentPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"Crust, cheese, tomatoes, olive, Pizza Sauce, chicken, chilli flakes, mushroom");
				
			}
			
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("650tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 164, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, 148, SpringLayout.WEST, contentPane);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="INSERT INTO pizza(Name, Quantity, Price) values(?,?,?)";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.setString(1, "BBQ Chicken Pizza");
					ps.setInt(2, 1);
					ps.setInt(3, 650);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_1, "INSERT PIZZA ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 303, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, 148, SpringLayout.WEST, contentPane);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"Crust, tomatoes, olive, Pizza Sauce, chicken, chilli flakes, mushroom, Cheese");
				
				
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_3, 304, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_3, 341, SpringLayout.WEST, contentPane);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"Crust, tomatoes, olive, Pizza Sauce, chicken, pepperoni, chilli flakes, mushroom, Cheese");
					
				
			}
		});
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Details");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_4, 130, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_4, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_4, 341, SpringLayout.WEST, contentPane);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton,"Crust, tomatoes, olive, Pizza Sauce, Sliced Almonds, chilli flakes, mushroom");
			
			}
		});
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_1_1 = new JButton("450tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1_1, 164, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1_1, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1_1, 341, SpringLayout.WEST, contentPane);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="INSERT INTO pizza(Name, Quantity, Price) values(?,?,?)";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.setString(1, "Veggie Pizza");
					ps.setInt(2, 1);
					ps.setInt(3, 450);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_1_1, "INSERT PIZZA ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("800tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1_2, 338, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1_2, 241, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1_2, 341, SpringLayout.WEST, contentPane);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="INSERT INTO pizza(Name, Quantity, Price) values(?,?,?)";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.setString(1, "Pepperoni Pizza");
					ps.setInt(2, 1);
					ps.setInt(3, 800);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_1_2, "INSERT PIZZA ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("550tk");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1_3, 338, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1_3, 48, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1_3, 148, SpringLayout.WEST, contentPane);
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="INSERT INTO pizza(Name, Quantity, Price) values(?,?,?)";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.setString(1, "Special Pizza");
					ps.setInt(2, 1);
					ps.setInt(3, 550);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_1_3, "INSERT PIZZA ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_6 = new JLabel("Name");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_6, 455, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 52, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_6, 501, SpringLayout.WEST, contentPane);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Quantity");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_7, 558, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, 52, SpringLayout.NORTH, contentPane);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("Price");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 38, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_10, 675, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel_10, 52, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel_10, 721, SpringLayout.WEST, contentPane);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton_5 = new JButton("Clear");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_5, 338, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_5, 542, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_5, 627, SpringLayout.WEST, contentPane);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				String sql="DELETE FROM pizza";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_5, "CLEAR TABLE ERROR"+e);
				}
				showdata();
			}
		});
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Buy");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_6, 338, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_6, 675, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_6, 735, SpringLayout.WEST, contentPane);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnNewButton_6, "Thank You.");
				PreparedStatement ps=null;
				String sql="DELETE FROM pizza";
				
				try {
					ps=cn.prepareStatement(sql);
					ps.executeUpdate();
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(btnNewButton_6, "BUY TABLE ERROR"+e);
				}
				showdata();
				}
		});
		contentPane.add(btnNewButton_6);
		
		pizza1 = new JTable();
		sl_contentPane.putConstraint(SpringLayout.NORTH, pizza1, 69, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, pizza1, 416, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, pizza1, 326, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, pizza1, 734, SpringLayout.WEST, contentPane);
		contentPane.add(pizza1);
		
		JButton btnNewButton_7 = new JButton("Back");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Option op=new Option();
				op.setVisible(rootPaneCheckingEnabled);
				dispose();
			}
			
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_7, 338, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_7, 416, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_7, 505, SpringLayout.WEST, contentPane);
		contentPane.add(btnNewButton_7);
	}
}
