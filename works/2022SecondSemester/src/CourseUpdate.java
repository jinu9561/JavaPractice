import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CourseUpdate extends JFrame {

	private JPanel contentPane;
	private static JTextField t1;
	private static String stdID;
	private static int stdIdTemp;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseUpdate frame = new CourseUpdate();
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
	public CourseUpdate() {
		setTitle("update or delete course");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		lblStudentId.setFont(new Font("굴림", Font.BOLD, 12));
		lblStudentId.setBounds(28, 37, 85, 15);
		contentPane.add(lblStudentId);
		
		JLabel lblCId = new JLabel("Course id want to change or delete");
		lblCId.setBounds(28, 62, 215, 15);
		contentPane.add(lblCId);
		
		JLabel l_STD_ID = new JLabel("");
		l_STD_ID.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 12));
		l_STD_ID.setBounds(238, 37, 50, 15);
		contentPane.add(l_STD_ID);
		
		t1 = new JTextField();
		t1.setBounds(238, 59, 182, 21);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(226, 96, 91, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(329, 96, 91, 23);
		contentPane.add(btnDelete);
		
		StudentManagerMain std = new StudentManagerMain();
		stdID = Integer.toString(std.getSTDID());
		l_STD_ID.setText(stdID);
		
		JButton btnGoHome = new JButton("<- Go HOME");
		btnGoHome.setBounds(28, 96, 110, 23);
		contentPane.add(btnGoHome);
		
//=============================================================		
		btnGoHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentManagerMain main = new StudentManagerMain();
				main.setVisible(true);
				dispose();
			}
		});
		
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int courseID = Integer.parseInt(t1.getText()); // 없는 아이디면 false 리턴
					
					if(searchCourse(courseID)) {
						deleteCourse();
					} else {
						JOptionPane.showMessageDialog(null, "No such Course ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
						t1.setText(null);
					}
					
					t1.setText(null);
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					t1.setText(null);
					// 에러시 팝업창
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					t1.setText(null);
					// 에러시 팝업창
				}
			}
		});
		

		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int courseID = Integer.parseInt(t1.getText()); // 없는 아이디면 false 리턴
					
					if(searchCourse(courseID)) {
						deleteCourse();
						stdIdTemp = Integer.parseInt(t1.getText());
						AddCourse course = new AddCourse();
						course.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No such Course ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
						t1.setText(null);
					}
					
					t1.setText(null);
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					t1.setText(null);
					// 에러시 팝업창
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					t1.setText(null);
					// 에러시 팝업창
				}
			} 
		});
		
	}
	
	public static void deleteCourse() throws FileNotFoundException {
		java.io.File file = new java.io.File("student's_course_list.txt");
		java.io.File temp = new java.io.File("temp.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(temp);
		Scanner input = new Scanner(file);
		
		int idToDelete = Integer.parseInt(t1.getText());
		boolean flag = false;
		
		while (input.hasNext()) {
			int stdIdTemp = input.nextInt();
			int courseIdTemp = input.nextInt();
			String nameTemp = input.next();
			String majorTemp = input.next();
			String professorTemp = input.next();
			int scoreTemp = input.nextInt();
			
			if(idToDelete != courseIdTemp) {
				output.println(stdIdTemp);
				output.println(courseIdTemp);
				output.println(nameTemp);
				output.println(majorTemp);
				output.println(professorTemp);
				output.println(scoreTemp);
				
			} else {
				flag = true;
			}
		}
		
		input.close();
		output.close();
		
		if(flag == false) {
			temp.delete();		
		}
		if(flag == true) {
			file.delete();
			temp.renameTo(file);
		}
	}
	
	public static boolean searchCourse(int courseIdToSearch) throws FileNotFoundException {
		
		java.io.File file = new java.io.File("student's_course_list.txt");
		Scanner input = new Scanner(file);
		
		boolean flag = false;
		
		while (input.hasNext()) {

			int stdId = input.nextInt();
			int courseIDTemp = input.nextInt();
			String name = input.next();
			String major = input.next();
			String professor = input.next();
			int score = input.nextInt();
			
			if(Integer.parseInt(stdID) == stdId
					&& courseIdToSearch == courseIDTemp) {
				flag = true;
			}
		}

		input.close();
		
		return flag;
	}
}
