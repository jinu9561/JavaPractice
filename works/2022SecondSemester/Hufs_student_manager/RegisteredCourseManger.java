import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

public class RegisteredCourseManger extends JFrame {

	private JPanel contentPane;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JTextField t5;
	private static String stdID;
	private static String courseID;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisteredCourseManger frame = new RegisteredCourseManger();
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
	public RegisteredCourseManger() {
		setTitle("registered course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblCourseMajor = new JLabel("COURSE NAME");
		lblCourseMajor.setBounds(25, 74, 137, 15);
		contentPane.add(lblCourseMajor);
		
		JLabel lblCourseMajor_1 = new JLabel("COURSE MAJOR");
		lblCourseMajor_1.setBounds(25, 104, 137, 15);
		contentPane.add(lblCourseMajor_1);
		
		JLabel lblCourse = new JLabel("COURSE PROFESSOR");
		lblCourse.setBounds(25, 134, 137, 15);
		contentPane.add(lblCourse);
		
		JLabel lblCourseScore = new JLabel("COURSE SCORE");
		lblCourseScore.setBounds(25, 164, 137, 15);
		contentPane.add(lblCourseScore);
		
		JButton btnGoMain = new JButton("GO HOME");
		btnGoMain.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnGoMain.setBounds(25, 199, 185, 23);
		contentPane.add(btnGoMain);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(167, 71, 242, 21);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(167, 101, 242, 21);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(167, 131, 242, 21);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setColumns(10);
		t5.setBounds(167, 161, 242, 21);
		contentPane.add(t5);
		
		JButton btnAddCourse = new JButton("ADD");
		btnAddCourse.setFont(new Font("±¼¸²", Font.BOLD, 12));
		btnAddCourse.setBounds(222, 199, 187, 23);
		contentPane.add(btnAddCourse);
		
		JLabel l0 = new JLabel("COURSE ID");
		l0.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 12));
		l0.setBounds(25, 46, 137, 15);
		contentPane.add(l0);
				
		JLabel l_COURSE_ID = new JLabel("");
		l_COURSE_ID.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 13));
		l_COURSE_ID.setBounds(167, 46, 211, 15);
		contentPane.add(l_COURSE_ID);
		
		AddCourse crs = new AddCourse();
		courseID = Integer.toString(crs.getCourseID());
		l_COURSE_ID.setText(courseID);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		lblStudentId.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 12));
		lblStudentId.setBounds(25, 21, 137, 15);
		contentPane.add(lblStudentId);
		
		JLabel l_STD_ID = new JLabel("0");
		l_STD_ID.setFont(new Font("±¼¸²", Font.BOLD | Font.ITALIC, 13));
		l_STD_ID.setBounds(167, 21, 211, 15);
		contentPane.add(l_STD_ID);
		
		StudentManagerMain std = new StudentManagerMain();
		stdID = Integer.toString(std.getSTDID());
		l_STD_ID.setText(stdID);
//========================================================================		
		btnGoMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentManagerMain main = new StudentManagerMain();
				main.setVisible(true);
				dispose();
			}
		});
		
		btnAddCourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addCourse();
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Invalid course ID or score", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// ¿¡·¯½Ã ÆË¾÷Ã¢
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid course ID or score", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// ¿¡·¯½Ã ÆË¾÷Ã¢
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
					t5.setText(null);
				}
			}
		});
		
	}
	
	public static void addCourse() throws IOException {
		
		java.io.FileWriter input = new java.io.FileWriter("student's_course_list.txt",true);
		java.io.PrintWriter output = new java.io.PrintWriter(input);
		
		boolean flag = true;
		
		String name = t2.getText();
		String major = t3.getText();
		String professor = t4.getText();
		int score = Integer.parseInt(t5.getText());
		
		output.println(stdID);
		output.println(courseID);
		output.println(name);
		output.println(major);
		output.println(professor);
		output.println(score);
		
		input.close();
		output.close();
	}
}
