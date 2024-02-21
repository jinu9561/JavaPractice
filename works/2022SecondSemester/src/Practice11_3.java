import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Practice11_3 {
	static Scanner sc = new Scanner(System.in);
	static HashMap<Integer, Student> st = new HashMap<>();
	
	public static void main(String[] args) {
		
		System.out.println("1) Add a Student information");
		System.out.println("2) Update Student information");
		System.out.println("3) Search Student information");
		System.out.println("4) Display Student informations");
		System.out.println("5) Exit");
		System.out.println("\n================================================================\n");
		
		int cmd = 0;
		
		while(cmd != 5) {
			System.out.print("¡Ü Enter your choice: ");
			cmd = sc.nextInt();
			System.out.println("\n================================================================\n");
			
			switch (cmd) {
			case 1: {
				add();
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
	
	public static void add() {
		
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
		
		st.put(ID, std);
	}
	public static void update() {
		Student std = new Student();
		
		System.out.print("Enter ID which you want to update: ");
		int updatedID = sc.nextInt();
		
		boolean flag = st.containsKey(updatedID);
		
		if(flag == true) {
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
			
			st.replace(updatedID, std);
		}
		else System.out.println("---No such ID!---");
	}
	public static void search() {
		Student std = new Student();
		
		System.out.print("Enter ID want to search: ");
		int IdToSearch = sc.nextInt();
		
		boolean flag = st.containsKey(IdToSearch);
		
		if(flag == true) {
			std = st.get(IdToSearch);
			System.out.println("ID: " + std.getID());
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
		
		Iterator<Integer> it = st.keySet().iterator();
		
		while(it.hasNext()) {
			int key = it.next();
			std = st.get(key);
			System.out.println("- ID: " + std.getID());
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
