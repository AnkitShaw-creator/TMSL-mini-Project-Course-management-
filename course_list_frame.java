package App_Windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class course_list_frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					course_list_frame frame = new course_list_frame();
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
	public course_list_frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ArrayList<String> course_array = new ArrayList<>();
		course_array.add("python");
		course_array.add("artificial intelligence");
		course_array.add("machine learning");
		course_array.add("deep learning");
		course_array.add("java");
		
		DefaultListModel al = new DefaultListModel();
		al.addAll(course_array);;
		
		JList<String> list = new JList<>(al);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
           
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String n = list.getSelectedValue();
				course_about_frame ca = new course_about_frame(n);
				ca.setVisible(true);
				
			}
        });
		getContentPane().add(list);
		list.setBounds(21, 60, 530, 290);
		contentPane.add(list);
		
		JLabel lbl_student_name = new JLabel("Student Name");
		lbl_student_name.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		lbl_student_name.setForeground(Color.RED);
		lbl_student_name.setBounds(21, 11, 186, 27);
		contentPane.add(lbl_student_name);
		
		JButton btn_add_course = new JButton("Add course");
		btn_add_course.setBounds(485, 14, 89, 23);
		contentPane.add(btn_add_course);
		this.setVisible(true);
	}
}
