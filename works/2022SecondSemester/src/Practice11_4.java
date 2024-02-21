import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice11_4 {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> st = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("1) Add a Student information");
		System.out.println("2) Update Student information");
		System.out.println("3) Search Student information");
		System.out.println("4) Display Student informations");
		System.out.println("5) Exit");
		System.out.println("\n================================================================\n");
		
		int cmd = 0;
		
		while(cmd != 5) {
			System.out.print("● Enter your choice: ");
			cmd = sc.nextInt();
			System.out.println("\n================================================================\n");
			
			switch (cmd) {
			case 1: {
				try {
					add();
				} 
				catch (Exception e) {
					System.out.println("FileNotFoundException");
				}
				System.out.println("\n===============================================================\n");
				break;
			}
			case 2: {
				update();
				System.out.println("\n================================================================\n");
				break;
			}
			case 3: {
				search();
				System.out.println("\n================================================================\n");
				break;
			}
			case 4: {
				display();
				System.out.println("\n================================================================\n");
				break;
			}
			case 5: System.out.println("End process"); break;
			default: System.out.println("---Invalid value!---");
			}
		}
	}
	
	public static void add() throws IOException {
		
		java.io.FileWriter file = new java.io.FileWriter("student.txt", true); // true -> over write 되지 않음
		
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		Student std = new Student();
		
		System.out.print("Enter new stdudent ID: ");
		int ID = sc.nextInt();
		System.out.print("Enter new stdudent name: ");
		String name = sc.next();
		System.out.print("Enter new stdudent address: ");
		String address = sc.next();
		System.out.print("Enter new stdudent department: ");
		String department = sc.next();
		
		std.setID(ID);
		std.setName(name);
		std.setAddress(address);
		std.setDepartment(department);
		
		st.add(std);
		
		output.println(std.getID());
		output.println(std.getName());
		output.println(std.getAddress());
		output.println(std.getDepartment());
		
		while(true) {
			System.out.print("Enter registered courses: ");
			std.setCourseList(sc.next());

			System.out.print("Enter 0 is stop process & another number is continue: ");
			int choice = sc.nextInt();
			if(choice == 0) break;
		}
		for(int i = 0; i < std.courseList.size(); i++) {
			output.print(std.getCourseList(i) + ",");
		}
		
		output.println();
		
		output.close();
	}
	public static void update() throws FileNotFoundException {
		java.io.File file = new java.io.File("scores.txt");
		java.io.File temp = new java.io.File("temp.txt");
		java.io.PrintWriter output = new java.io.PrintWriter(temp);
		Scanner input = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter ID which you want to update: ");
		int idToUpdate = sc.nextInt();
		
		while (input.hasNext()) {
			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			String course = input.next();
			
			if(idToUpdate != id) {
				output.println(id);
				output.println(name);
				output.println(address);
				output.println(dept);
				output.println(course);
			} else {
				
			}
			
		}
		

		
	}
	public static void search() throws FileNotFoundException {
		
		java.io.File file = new java.io.File("student.txt");
		
		Scanner input = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter ID want to search: ");
		int idToSearch = sc.nextInt();
		
		while (input.hasNext()) {

			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			String course = input.next();
			if(id == idToSearch) {
				System.out.println("ID: " + id);
				System.out.println("NAME: " + name);
				System.out.println("ADDRESS: " + address);
				System.out.println("DEPARTMENT: " + dept);
				System.out.println("List of registered courses: " + course);	
			}
		}
		input.close();

	}
	public static void display() throws FileNotFoundException {
		
		java.io.File file = new java.io.File("student.txt");
		
		Scanner input = new Scanner(file);
		
		while (input.hasNext()) {

			int id = input.nextInt();
			String name = input.next();
			String address = input.next();
			String dept = input.next();
			String course = input.next();
			
			System.out.println("ID: " + id);
			System.out.println("NAME: " + name);
			System.out.println("ADDRESS: " + address);
			System.out.println("DEPARTMENT: " + dept);
			System.out.println("List of registered courses: " + course);
			System.out.println();
		}
		input.close();
	}
	
}
