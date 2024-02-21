import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice11_2 {
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
		
		while(true) {
			System.out.print("Enter registered courses: ");
			std.setCourseList(sc.next());
			
			System.out.print("Enter 0 is stop process & another number is continue: ");
			int choice = sc.nextInt();
			if(choice == 0) break;
		}
		
		std.setID(ID);
		std.setName(name);
		std.setAddress(address);
		std.setDepartment(department);
		
		st.add(std);
		
		output.print("ID: ");
		output.println(std.getID());
		output.print("Name: ");
		output.println(std.getName());
		output.print("Address: ");
		output.println(std.getAddress());
		output.print("Department: ");
		output.println(std.getDepartment());
		output.println();
		
		output.close();
}
	public static void update() {
		Student std = new Student();
		boolean flag = false;
		int idxToUpdate = 0;
		
		System.out.print("Enter ID which you want to update: ");
		int prevID = sc.nextInt();
		for(int i = 0; i < st.size(); i++) {
			if(st.get(i).getID() == prevID) {
				flag = true;
				idxToUpdate = i;
			}
		} // 다시 확인
		
		if(flag == true) {
			
			System.out.print("Enter new ID: ");
			int updatedID = sc.nextInt();
			System.out.print("Enter new name: ");
			String updatedName = sc.next();
			System.out.print("Enter new address: ");
			String updatedAddress = sc.next();
			System.out.print("Enter new department: ");
			String updatedDepartment = sc.next();
			
			while(true) {
				System.out.print("Enter registered courses: ");
				std.setCourseList(sc.next());
				
				System.out.print("Enter 0 is stop process & another number is continue: ");
				int choice = sc.nextInt();
				if(choice == 0) break;
			}
			
			std.setID(updatedID);
			std.setName(updatedName);
			std.setAddress(updatedAddress);
			std.setDepartment(updatedDepartment);
			
			st.set(idxToUpdate, std);
		}
		else System.out.println("---No such ID!---");
		
	}
	public static void search() {
		Student std = new Student();
		boolean flag = false;
		int idxToSearch = -1;
		
		System.out.print("Enter ID want to search: ");
		int IdToSearch = sc.nextInt();
		for(int i = 0; i < st.size(); i++) {
			if(st.get(i).getID() == IdToSearch) {
				flag = true;
				idxToSearch = i;
			}
		}
		
		if(flag == true) {
			std = st.get(idxToSearch);
			System.out.println("ID: " + std.getID());
			System.out.println("Index number: " + idxToSearch);
			System.out.println("Name: " + std.getName());
			System.out.println("Address: " + std.getAddress());
			System.out.println("Department: " + std.getDepartment());
			System.out.print("List of registered courses: ");
			for(int i = 0; i < std.courseList.size(); i++) {
				System.out.print(std.getCourseList(i) + " ");
			}
			System.out.println();
		} 
		else System.out.println("---No such ID!---");
		
	}
	public static void display() {
		Student std = new Student();
		
		for(int i = 0; i < st.size(); i++) {
			std = st.get(i);
			System.out.println("- Index " + i);
			System.out.println("ID: " + std.getID());
			System.out.println("Name: " + std.getName());
			System.out.println("Address: " + std.getAddress());
			System.out.println("Department: " + std.getDepartment());
			System.out.print("List of registered courses: ");
			for(int j = 0; j < std.courseList.size(); j++) {
				System.out.print(std.getCourseList(j) + " ");
			}
			System.out.println("\n");
		}
		
	}
	
}
