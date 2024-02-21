import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AddCourse extends JFrame {

	private JPanel contentPane;
	private static JTextField t1;
	private static String stdID;
	private JButton btnBack;
	private static int courseIdTemp;
	private static int stdIdTemp;
	private static JTextField t2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
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
	public AddCourse() {
		setTitle("add course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("COURSE ID");
		l1.setBounds(29, 57, 79, 15);
		contentPane.add(l1);
		
		t1 = new JTextField();
		t1.setBounds(120, 54, 204, 21);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton btnAdd1 = new JButton("ADD");
		btnAdd1.setBounds(233, 114, 91, 23);
		contentPane.add(btnAdd1);
		
		JLabel lblNewLabel = new JLabel("STUDENT ID");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(29, 26, 91, 15);
		contentPane.add(lblNewLabel);
		
		JLabel l_STD_ID = new JLabel("");
		l_STD_ID.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 12));
		l_STD_ID.setBounds(120, 26, 129, 15);
		contentPane.add(l_STD_ID);
		
		btnBack = new JButton("<- BACK");
		btnBack.setBounds(29, 114, 91, 23);
		contentPane.add(btnBack);
		
		StudentManagerMain std = new StudentManagerMain();
		stdID = Integer.toString(std.getSTDID());
		l_STD_ID.setText(stdID);
		
		JLabel l2 = new JLabel("SCORE");
		l2.setBounds(29, 86, 79, 15);
		contentPane.add(l2);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(120, 83, 204, 21);
		contentPane.add(t2);

//=======================================================================		
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentManagerMain main = new StudentManagerMain();
				main.setVisible(true);
				dispose();
			}
		});
		
		btnAdd1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					stdIdTemp = Integer.parseInt(l_STD_ID.getText());
					courseIdTemp = Integer.parseInt(t1.getText());
					addCourseValue();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// 에러시 팝업창
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});


	}
	
	public static int getCourseID() {
		return courseIdTemp;
	}
	
	public static void addCourseValue() throws IOException {
		java.io.File file = new java.io.File("student's_course_list.txt");
		java.io.FileWriter std = new java.io.FileWriter("student's_course_list.txt",true); // true -> over write 되지 않음
		java.io.PrintWriter output = new java.io.PrintWriter(std);
		Scanner input = new Scanner(file);
		
		int idToSearch = Integer.parseInt(t1.getText());
		int score = Integer.parseInt(t2.getText());
		boolean flag = false;
		
		while (input.hasNext()) {

			int stdIdToCheck = input.nextInt();
			int courseIdToCheck = input.nextInt();
			String nameToCheck = input.next();
			String majorToCheck = input.next();
			String professorToCheck = input.next();
			int scoreToCheck = input.nextInt();
			
			if(idToSearch == courseIdToCheck) {
				flag = true;
				
				output.println(stdID);
				output.println(courseIdToCheck);
				output.println(nameToCheck);
				output.println(majorToCheck);
				output.println(professorToCheck);
				output.println(score);
				t1.setText(null);
				t2.setText(null);
			}
		} // 파일에 입력한 id가 있으면 id와 score -> true
		
		output.close();
		input.close();
		
		if(!flag) {
			RegisteredCourseManger addValue = new RegisteredCourseManger();
			addValue.setVisible(true);
		} // 입력한 id의 코스가 없다 -> 입력한 id의 value 입력하는 새창 
		
	}
}
