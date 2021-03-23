package App_Windows;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame
{	
	public static void main(String[] args)
	{	
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

	public Login() {
		initialize();
	}
	private void initialize() {
		
		JFrame frame = new JFrame("Login");
		JButton button =new JButton("Login");
		JTextField text1 =new JTextField();
		JPasswordField text2 =new JPasswordField(20);
		JLabel label1 = new JLabel("Username");
		JLabel label2 = new JLabel("Password");
		JButton forget_passwd = new JButton("Forget Password");
		
		label1.setBounds(50,100,220,30);
		label2.setBounds(50,150,220,30);
		text1.setBounds(120,100,220,30);
		text2.setBounds(120,150,220,30);
		button.setBounds(175,200,100,40);
		forget_passwd.setBounds(50,300,200,30);
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String value1=text1.getText();
				String value2=text2.getText();
				if(value1.isEmpty() || value2.isEmpty())
				{
					int a=7;
					char bp=(char)a;
					System.out.println(bp);
					JOptionPane.showMessageDialog(frame,"Enter Username and Passward");
				}
				else
				{
					try
					{
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb","root","ankit120599");
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(String.format("select * from login where user_id = '%s'",value1));
						if(rs.next())
						{
							if(value1.equals(rs.getString("user_id")) && value2.equals(rs.getString("passwd")))
							{
								//System.out.println(rs.getString("user_id")+" ,"+rs.getString("password"));
								course_list_frame cl = new course_list_frame();
								cl.setVisible(true);
							}
							else
							{
								int a=7;
								char bp=(char)a;
								System.out.println(bp);
								JOptionPane.showMessageDialog(frame,"Check username and pasword","Check",JOptionPane.WARNING_MESSAGE);
							}
						}
						else
						{
							int a=7;
							char bp=(char)a;
							System.out.println(bp);
							JOptionPane.showMessageDialog(frame,"register now than login","Register Now",JOptionPane.WARNING_MESSAGE);
						}
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					
				}
			}
		});
		
		forget_passwd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				frame.setVisible(false);
				JFrame fp =new JFrame("Forget Pasword");
				JLabel fpl1= new JLabel("Username");
				JLabel fpl2= new JLabel("Phone_no");
				JLabel fpl3= new JLabel("Enter Pasword");
				JLabel fpl4= new JLabel("Confirm Pasword");
				JTextField fpt1= new JTextField();
				JTextField fpt2= new JTextField();
				JTextField fpt3= new JTextField();
				JTextField fpt4= new JTextField();
				JButton back_button= new JButton("Back");
				JButton ch_passwd = new JButton("Change Password");
				fpl1.setBounds(20,100,220,30);
				fpl2.setBounds(20,150,220,30);
				fpl3.setBounds(20,200,220,30);
				fpl4.setBounds(20,250,220,30);
				fpt1.setBounds(120,100,220,30);
				fpt2.setBounds(120,150,220,30);
				fpt3.setBounds(120,200,220,30);
				fpt4.setBounds(120,250,220,30);
				back_button.setBounds(20,330,150,40);
				ch_passwd.setBounds(195,330,150,40);
				fp.getContentPane().add(fpl1);
				fp.getContentPane().add(fpl2);
				fp.getContentPane().add(fpl3);
				fp.getContentPane().add(fpl4);
				fp.getContentPane().add(fpt1);
				fp.getContentPane().add(fpt2);
				fp.getContentPane().add(fpt3);
				fp.getContentPane().add(fpt4);
				fp.getContentPane().add(back_button);
				fp.getContentPane().add(ch_passwd);
				ch_passwd.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent acev)
					{
						String uid = fpt1.getText();
						String ph = fpt2.getText();
						String get_passwd = fpt3.getText();
						String cnf_passwd = fpt4.getText();
						if(get_passwd.equals(cnf_passwd))
						{
							try
							{
								Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","mysql pasword");
								Statement st = conn.createStatement();
								//ResultSet rs = st.executeQuery(String.format("update login set passwd = '%s' where user_id = '%s' and phone_no = '%s'",cnf_passwd,uid,ph));
								int change_in_data= st.executeUpdate(String.format("update login set passwd = '%s' where user_id = '%s' and phone_no = '%s'",cnf_passwd,uid,ph));
								if(change_in_data > 0)
								{
									JDialog fpqd1 = new JDialog(fp,"Password");
									JLabel fpqdl1 = new JLabel("Pasword Change",JLabel.CENTER);
									Font font4 = new Font("SansSerif", Font.BOLD,15);
									fpqdl1.setFont(font4);
									fpqd1.getContentPane().add(fpqdl1);
									fpqd1.setSize(300,100);
									fpqd1.setVisible(true);
									fpqd1.setLocationRelativeTo(null);
								}
								else
								{
									int a=7;
									char bp=(char)a;
									System.out.println(bp);
									JOptionPane.showMessageDialog(fp,"Pasword Not Change","Password",JOptionPane.WARNING_MESSAGE);
								}
								
							}
							catch(Exception exc)
							{
								System.out.println(exc);
							}
						}
						else
						{
							int a=7;
							char bp=(char)a;
							System.out.println(bp);
							JOptionPane.showMessageDialog(fp,"Enter Pasword and Confirm Pasword Not Match","Password",JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				back_button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent acteve)
					{
						frame.setVisible(true);
						fp.dispose();
					}
				});
				fp.setSize(400,500);
				fp.setLocationRelativeTo(null);
				fp.getContentPane().setLayout(null);
				fp.setVisible(true);
				fp.getContentPane().setBackground(new Color(51,204,255));
				fp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		frame.getContentPane().add(label1);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(text1);
		frame.getContentPane().add(text2);
		frame.getContentPane().add(button);
		frame.getContentPane().add(forget_passwd);
		
		frame.setSize(400,500);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(51,153,255));
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}
	
