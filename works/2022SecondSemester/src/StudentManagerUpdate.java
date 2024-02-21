import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentManagerUpdate extends JFrame {

	private JPanel contentPane;
	private static JTextField t2;
	private static JTextField t3;
	private static JTextField t4;
	private static String stdID;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagerUpdate frame = new StudentManagerUpdate();
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
	public StudentManagerUpdate() {
		setTitle("update student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGoMain = new JButton("<- BACK");
		btnGoMain.setFont(new Font("����", Font.BOLD, 12));
		btnGoMain.setBounds(22, 129, 91, 23);
		contentPane.add(btnGoMain);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("����", Font.BOLD, 12));
		lblID.setBounds(22, 26, 90, 15);
		contentPane.add(lblID);
		
		JLabel lblName = new JLabel("updated name");
		lblName.setFont(new Font("����", Font.BOLD, 12));
		lblName.setBounds(22, 51, 113, 15);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("updated address");
		lblAddress.setFont(new Font("����", Font.BOLD, 12));
		lblAddress.setBounds(22, 76, 113, 15);
		contentPane.add(lblAddress);
		
		JLabel lblDepartment = new JLabel("updated department");
		lblDepartment.setFont(new Font("����", Font.BOLD, 12));
		lblDepartment.setBounds(22, 101, 128, 15);
		contentPane.add(lblDepartment);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(157, 48, 141, 21);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(157, 73, 141, 21);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(157, 98, 141, 21);
		contentPane.add(t4);
		
		JButton btnDone = new JButton("DONE");
		btnDone.setFont(new Font("����", Font.BOLD, 12));
		btnDone.setBounds(207, 129, 91, 23);
		contentPane.add(btnDone);
		
		JLabel l_ID_to_update = new JLabel("");
		l_ID_to_update.setFont(new Font("����", Font.BOLD | Font.ITALIC, 12));
		l_ID_to_update.setBounds(157, 26, 79, 15);
		contentPane.add(l_ID_to_update);

		StudentManagerMain std = new StudentManagerMain();
		stdID = Integer.toString(std.getSTDID());
		l_ID_to_update.setText(stdID);
		
//======================================================================		
		btnGoMain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentManagerMain main = new StudentManagerMain();
				main.setVisible(true);
				dispose();
			}
		});
		
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					update();
					t2.setText(null);
					t3.setText(null);
					t4.setText(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static void update() throws FileNotFoundException {
		java.io.File file = new java.io.File("HUFS_student.txt");
		java.io.File temp = new java.io.File("temp.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(temp);
		Scanner input = new Scanner(file);
		
		boolean flag = false;
		
		while (input.hasNext()) {
			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			
			if(Integer.parseInt(stdID) != id) {
				output.println(id);
				output.println(name);
				output.println(address);
				output.println(dept);
			} else {
				flag = true;
				output.println(id);
				output.println(t2.getText());
				output.println(t3.getText());
				output.println(t4.getText());
			}
		}
		
		input.close();
		output.close();
		
		if(flag == false) {
			// @@@@@@@@@@@@@���߿� �˸�â�� No such ID!! ����ϱ�
			temp.delete();		
		}
		if(flag == true) {
			file.delete();
			temp.renameTo(file);
		}
	}
}
