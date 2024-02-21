import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Color;

public class StudentManagerMain extends JFrame {

	private JPanel contentPane;
	private static JTextField t1;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static JTextArea textArea;
	private static int stdIdTemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagerMain frame = new StudentManagerMain();
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
	public StudentManagerMain() {
		setTitle("HUFS Student Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("ID");
		l1.setFont(new Font("굴림", Font.BOLD, 13));
		l1.setBounds(35, 29, 56, 28);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("NAME");
		l2.setFont(new Font("굴림", Font.BOLD, 13));
		l2.setBounds(35, 138, 56, 28);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("ADDRESS");
		l3.setFont(new Font("굴림", Font.BOLD, 13));
		l3.setBounds(35, 176, 105, 28);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("DEPARTMENT");
		l4.setFont(new Font("굴림", Font.BOLD, 13));
		l4.setBounds(35, 213, 105, 28);
		contentPane.add(l4);
		
		t1 = new JTextField();
		t1.setBounds(152, 29, 490, 28);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(152, 137, 490, 28);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(152, 175, 490, 28);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(152, 213, 490, 28);
		contentPane.add(t4);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("굴림", Font.BOLD, 10));
		btnAdd.setBounds(152, 251, 241, 28);
		contentPane.add(btnAdd);
		
		JButton btnDisplay = new JButton("DISPLAY LIST OF STUDENTS");
		btnDisplay.setFont(new Font("굴림", Font.BOLD, 10));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDisplay.setBounds(401, 251, 241, 28);
		contentPane.add(btnDisplay);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("굴림", Font.BOLD, 10));
		btnSearch.setBounds(276, 64, 117, 28);
		contentPane.add(btnSearch);
		
		JTextArea displayPanel = new JTextArea();
		displayPanel.setText("HUFS Student Manager Panel");
		displayPanel.setBackground(Color.LIGHT_GRAY);
		displayPanel.setBounds(35, 289, 607, 20);
		contentPane.add(displayPanel);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setFont(new Font("굴림", Font.BOLD, 10));
		btnUpdate.setBounds(525, 64, 117, 28);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("굴림", Font.BOLD, 10));
		btnDelete.setBounds(401, 64, 117, 28);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 306, 607, 231);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(new Color(227, 227, 227));
		
		JButton btnCourse = new JButton("Add courses");
		btnCourse.setFont(new Font("굴림", Font.BOLD, 10));
		btnCourse.setBounds(152, 64, 117, 28);
		contentPane.add(btnCourse);
		
		JButton btnClear = new JButton("clear");
		btnClear.setFont(new Font("굴림", Font.BOLD, 12));
		btnClear.setBounds(551, 547, 91, 23);
		contentPane.add(btnClear);
		
		JButton btnCourseDisplay = new JButton("Display registered courses");
		btnCourseDisplay.setFont(new Font("굴림", Font.BOLD, 10));
		btnCourseDisplay.setBounds(152, 99, 241, 28);
		contentPane.add(btnCourseDisplay);
		
		JButton btnCourseUpdate = new JButton("Update or delete registered courses");
		btnCourseUpdate.setFont(new Font("굴림", Font.BOLD, 10));
		btnCourseUpdate.setBounds(401, 99, 241, 28);
		contentPane.add(btnCourseUpdate);
		
//============================================================================
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					addStd();
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// 에러시 팝업창
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// 에러시 팝업창
					t1.setText(null);
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
				}
			}
		});
		
		btnDisplay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					display();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(null);
				t1.setText(null);
				t2.setText(null);
				t3.setText(null);
				t4.setText(null);
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					search();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// 에러시 팝업창
					t1.setText(null);
				}
			}
		});
		
		
		btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int stdID = Integer.parseInt(t1.getText()); // 없는 아이디면 false 리턴
					
					if(search(stdID)) {
						update();
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "No such ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
						t1.setText(null);
					}
					
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					t1.setText(null);
					// 에러시 팝업창
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					t1.setText(null);
				}
			}  
		});
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int stdID = Integer.parseInt(t1.getText()); // 없는 아이디면 false 리턴
					
					if(search(stdID)) {
						deleteStd();
					} else {
						JOptionPane.showMessageDialog(null, "No such ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
						t1.setText(null);
					}
					
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
		
		
		btnCourse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					stdIdTemp = Integer.parseInt(t1.getText());
					AddCourse course = new AddCourse();
					course.setVisible(true);
					dispose();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// 에러시 팝업창
				}
			} 
		});
		
		btnCourseDisplay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					displayCourse();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// 에러시 팝업창
				}
			}
		});
		
		btnCourseUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					stdIdTemp = Integer.parseInt(t1.getText());
					CourseUpdate courseUpdate = new CourseUpdate();
					courseUpdate.setVisible(true);
					dispose();
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Invalid ID", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
					// 에러시 팝업창
				}
			}
		});
	}

	public static int getSTDID() {
		return stdIdTemp;
	}
	
	public static void addStd() throws IOException {
		
		java.io.File file = new java.io.File("HUFS_student.txt");
		java.io.FileWriter std = new java.io.FileWriter("HUFS_student.txt",true); // true -> over write 되지 않음
		java.io.PrintWriter stdOutput = new java.io.PrintWriter(std);
		Scanner input = new Scanner(file);
		
		boolean flag = true;
		
		int ID = Integer.parseInt(t1.getText());
		String name = t2.getText();
		String address = t3.getText();
		String department = t4.getText();
		
		while (input.hasNext()) {
			int IdToCheck = input.nextInt();
			String nameToCheck = input.next();
			String addressToCheck = input.next();
			String departmentToCheck = input.next();
			
			if(IdToCheck == ID) {
				JOptionPane.showMessageDialog(null, "ID " + ID + " already exists", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				// 같은 학생 id 내에서 course id가 중복되면 추가안되고 알림창
				flag = false;
			}
		}

		if(flag) {
			stdOutput.println(ID);
			stdOutput.println(name);
			stdOutput.println(address);
			stdOutput.println(department);
		}
		
		std.close();
		input.close();
		stdOutput.close();
	}
	
	public static void display() throws FileNotFoundException {
		
		java.io.File file = new java.io.File("HUFS_student.txt");
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {

			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			
			textArea.append("● ID: " + id + "\n");
			textArea.append("    NAME: " + name + "\n");
			textArea.append("    ADDRESS: " + address + "\n");
			textArea.append("    DEPARTMENT: " + dept + "\n");
		}
		input.close();
	}
	
	public static void search() throws FileNotFoundException {
		
		java.io.File file = new java.io.File("HUFS_student.txt");
		Scanner input = new Scanner(file);
		
		int idToSearch = Integer.parseInt(t1.getText());
		boolean flag = false;
		
		while (input.hasNext()) {

			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			if(id == idToSearch) {
				textArea.append("● ID: " + id + "\n");
				textArea.append("    NAME: " + name + "\n");
				textArea.append("    ADDRESS: " + address + "\n");
				textArea.append("    DEPARTMENT: " + dept + "\n");
				flag = true;
			}
		}
		if(!flag) {
			JOptionPane.showMessageDialog(null, "No such ID!!", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			// id 없을시 알림창
			t1.setText(null);
		}
		input.close();

	}
	
	public static boolean search(int idToSearch) throws FileNotFoundException {
		
		java.io.File file = new java.io.File("HUFS_student.txt");
		Scanner input = new Scanner(file);
		
		boolean flag = false;
		
		while (input.hasNext()) {

			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			
			if(id == idToSearch) {
				flag = true;
			}
		}

		input.close();
		
		return flag;
	}
	
	public static void deleteStd() throws FileNotFoundException {
		java.io.File file = new java.io.File("HUFS_student.txt");
		java.io.File temp = new java.io.File("temp.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(temp);
		Scanner input = new Scanner(file);
		
		int idToUpdate = Integer.parseInt(t1.getText());
		boolean flag = false;
		
		while (input.hasNext()) {
			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			
			if(idToUpdate != id) {
				output.println(id);
				output.println(name);
				output.println(address);
				output.println(dept);
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
	
	
	public static void displayCourse() throws FileNotFoundException {
		
		java.io.File file = new java.io.File("student's_course_list.txt");
		Scanner input = new Scanner(file);
		java.io.File fileStd = new java.io.File("HUFS_student.txt");
		Scanner inputStd = new Scanner(fileStd);
		
		int stdID = Integer.parseInt(t1.getText());
		boolean flag = false;
		boolean flag2 = false;
		
		while (inputStd.hasNext()) {

			int id = inputStd.nextInt();
			String name = inputStd.next();
			String address = inputStd.next();
			String dept = inputStd.next();
			if(id == stdID) {
				flag = true;
			}
		}
		
		if(!flag) {
			JOptionPane.showMessageDialog(null, "No such ID!!", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			// 입력한 학생 id가 리스트에 없을때
		}
//---------------------------입력한 학생 id가 리스트에 없는지 판별-----------------------------------------------		
		
		while (input.hasNext()) {

			int stdID_course = input.nextInt();
			int courseID = input.nextInt();
			String coursename = input.next();
			String major = input.next();
			String professor = input.next();
			int score = input.nextInt();
			
			if(stdID_course == stdID) {
				textArea.append("● Student ID : " + stdID + "\n\n");
				textArea.append("COURSE ID: " + courseID + "\n");
				textArea.append("NAME: " + coursename + "\n");
				textArea.append("MAJOR: " + major + "\n");
				textArea.append("PROFESSOR: " + professor + "\n");
				textArea.append("SCORE: " + score + "\n\n");
				flag2 = true;
			}
		}
		if(!flag2 && flag) {
				JOptionPane.showMessageDialog(null, "ID " + stdID + " doesn't have registered course!!", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				// 학생 id에 등록된 course가 없을때 알림창
		}
		input.close();
		inputStd.close();
	}
	
	public static void update() {
		stdIdTemp = Integer.parseInt(t1.getText());
		StudentManagerUpdate stdUpdate = new StudentManagerUpdate();
		stdUpdate.setVisible(true);
	}
	
	public static void courseUpdate() {
		stdIdTemp = Integer.parseInt(t1.getText());
		RegisteredCourseManger stdUpdate = new RegisteredCourseManger();
		stdUpdate.setVisible(true);
	}
}

