package App_Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class user_checking_form {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_checking_form window = new user_checking_form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public user_checking_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JButton btn_newUser = new JButton("New User");
		btn_newUser.setForeground(Color.BLACK);
		btn_newUser.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_newUser.setBackground(Color.RED);
		btn_newUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new_user_frame nu = new new_user_frame();
				nu.setVisible(true);
			}});
		btn_newUser.setBounds(93, 75, 218, 23);
		frame.getContentPane().add(btn_newUser);
		
		JButton btn_existingUser = new JButton("Already a user");
		btn_existingUser.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		btn_existingUser.setForeground(Color.BLACK);
		btn_existingUser.setBackground(Color.RED);
		btn_existingUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lf = new Login();
			}});
		btn_existingUser.setBounds(93, 132, 218, 23);
		frame.getContentPane().add(btn_existingUser);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
