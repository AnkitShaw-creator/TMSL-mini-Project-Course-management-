package App_Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class course_about_frame extends JFrame {

	private JPanel contentPane;
	private JTextField tf_cDuration;
	private JTextField tf_instrName;
	private JTextField tf_cFee;
	private JTextField tf_cName;
	private JTextArea tA_instrAbout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					course_about_frame frame = new course_about_frame(null);
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
	public course_about_frame(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Course_Name = new JLabel("Course Name");
		lbl_Course_Name.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_Course_Name.setForeground(Color.RED);
		lbl_Course_Name.setBounds(10, 79, 140, 14);
		contentPane.add(lbl_Course_Name);
		
		tf_cName = new JTextField();
		tf_cName.setEditable(false);
		tf_cName.setBounds(194, 76, 200, 20);
		contentPane.add(tf_cName);
		tf_cName.setColumns(10);
		
		JLabel lbl_Course_duration = new JLabel("Duration");
		lbl_Course_duration.setForeground(Color.RED);
		lbl_Course_duration.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_Course_duration.setBounds(10, 121, 140, 14);
		contentPane.add(lbl_Course_duration);
		
		tf_cDuration = new JTextField();
		tf_cDuration.setEditable(false);
		tf_cDuration.setBounds(194, 118, 200, 20);
		contentPane.add(tf_cDuration);
		tf_cDuration.setColumns(10);
		
		JLabel lbl_instructor_name = new JLabel("Instructor's Name ");
		lbl_instructor_name.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_instructor_name.setForeground(Color.RED);
		lbl_instructor_name.setBounds(10, 204, 140, 14);
		contentPane.add(lbl_instructor_name);
		
		tf_instrName = new JTextField();
		tf_instrName.setEditable(false);
		tf_instrName.setBounds(194, 201, 200, 20);
		contentPane.add(tf_instrName);
		tf_instrName.setColumns(10);
		
		JLabel lbl_instructor_about = new JLabel("About the Instructor");
		lbl_instructor_about.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_instructor_about.setForeground(Color.RED);
		lbl_instructor_about.setBounds(10, 243, 140, 14);
		contentPane.add(lbl_instructor_about);
		
		tA_instrAbout = new JTextArea();
		tA_instrAbout.setWrapStyleWord(true);
		tA_instrAbout.setLineWrap(true);
		tA_instrAbout.setEditable(false);
		tA_instrAbout.setBounds(194, 238, 300, 100);
		contentPane.add(tA_instrAbout);
		
		JLabel lbl_Course_fee = new JLabel("Course Fee");
		lbl_Course_fee.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lbl_Course_fee.setForeground(Color.RED);
		lbl_Course_fee.setBounds(10, 161, 140, 14);
		contentPane.add(lbl_Course_fee);
		
		tf_cFee = new JTextField();
		tf_cFee.setEditable(false);
		tf_cFee.setBounds(194, 158, 200, 20);
		contentPane.add(tf_cFee);
		tf_cFee.setColumns(10);
		
		JLabel lbl_COURSE_DETAILS =new JLabel("Course Details");
		lbl_COURSE_DETAILS.setForeground(new Color(85, 107, 47));
		lbl_COURSE_DETAILS.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_COURSE_DETAILS.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lbl_COURSE_DETAILS.setBounds(121, 11, 267, 34);
		contentPane.add(lbl_COURSE_DETAILS);
		
		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				course_list_frame cf = new course_list_frame();
				cf.toFront();
				cf.setVisible(true);
				dispose();
			}
		});
		btn_back.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btn_back.setBounds(485, 11, 89, 23);
	
		contentPane.add(btn_back);
		
		
		
		display_data(name);
	}
	
	public void display_data(String a) {
		try {
			String url = "jdbc:mysql://localhost:3306/newdb";
			String uname = "root";
			String pass ="ankit120599";
			String query = "select * from newdb.coursedetails where course_name =?";
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, a);
			ResultSet result = st.executeQuery();
			if(result.next()) {
				tf_cName.setText(result.getString("course_name"));
				tf_cDuration.setText(result.getString("course_duration"));
				tf_cFee.setText(result.getString("fee"));
				tf_instrName.setText(result.getString("instructor"));
				tA_instrAbout.setText(result.getString("about"));
			}
			st.close();
			con.close();
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
