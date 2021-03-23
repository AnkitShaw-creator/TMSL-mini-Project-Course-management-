package App_Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class new_user_frame extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_phNo;
	private JTextField tf_uid;
	private JPasswordField tf_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new_user_frame frame = new new_user_frame();
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
	public new_user_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_name_add = new JLabel("Name");
		lbl_name_add.setForeground(Color.RED);
		lbl_name_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_name_add.setBounds(10, 28, 150, 14);
		contentPane.add(lbl_name_add);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_name.setBounds(229, 25, 320, 20);
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel lbl_phNo_add = new JLabel("Phone number");
		lbl_phNo_add.setForeground(Color.RED);
		lbl_phNo_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_phNo_add.setBounds(10, 77, 150, 14);
		contentPane.add(lbl_phNo_add);
		
		tf_phNo = new JTextField();
		tf_phNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_phNo.setBounds(229, 76, 320, 20);
		contentPane.add(tf_phNo);
		tf_phNo.setColumns(10);
		
		JLabel lbl_uid_add = new JLabel("user-id");
		lbl_uid_add.setForeground(Color.RED);
		lbl_uid_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_uid_add.setBounds(10, 128, 150, 14);
		contentPane.add(lbl_uid_add);
		
		tf_uid = new JTextField();
		tf_uid.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_uid.setBounds(229, 127, 320, 20);
		contentPane.add(tf_uid);
		tf_uid.setColumns(10);
		
		JLabel lbl_password_add = new JLabel("Password");
		lbl_password_add.setForeground(Color.RED);
		lbl_password_add.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		lbl_password_add.setBounds(10, 179, 150, 14);
		contentPane.add(lbl_password_add);
		
		tf_pass = new JPasswordField();
		tf_pass.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tf_pass.setBounds(229, 178, 320, 20);
		contentPane.add(tf_pass);
		tf_pass.setColumns(10);
		
		JButton btn_create_user = new JButton("Create account");
		btn_create_user.setForeground(Color.RED);
		btn_create_user.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_create_user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tf_name.getText();
				String phNo = tf_phNo.getText();
				String uid = tf_uid.getText();
				String password = tf_pass.getText();
				if(name.equals("") || phNo.equals("") || uid.equals("") || password.equals("")) {
					System.out.println("Fields cannot be null");
				}
				else {
					try {
						String url = "jdbc:mysql://localhost:3306/newdb";
						String uname = "root";
						String pass ="ankit120599";
						String query = "insert into newdb.login values (?,?,?,?)";
						//Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, uname, pass);
						PreparedStatement st = con.prepareStatement(query);
						st.setString(1, name);
						st.setString(2, uid);
						st.setString(3, password);
						st.setString(4, phNo);
						int result = st.executeUpdate();
						if(result != 0) {
							JOptionPane.showMessageDialog(null," User added successfully");
							course_list_frame cl = new course_list_frame();
							cl.setVisible(true);
							}
						else {
							System.out.println("Insertion failed");
							}
						}
						
					catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					
				}
			}
		});
		btn_create_user.setBounds(362, 327, 187, 23);
		contentPane.add(btn_create_user);
		
		JButton btn_reset = new JButton("Reset");
		btn_reset.setForeground(Color.RED);
		btn_reset.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_reset.setBounds(10, 329, 89, 23);
		btn_reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tf_name.setText("");
				tf_phNo.setText("");
				tf_uid.setText("");
				tf_pass.setText("");
				
			}});
		contentPane.add(btn_reset);
	}

}
