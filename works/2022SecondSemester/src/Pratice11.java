import java.util.Scanner;

public class Pratice11 {
	
	static int idx = 0;
	static Scanner sc = new Scanner(System.in);
	static Student[] st = new Student[10];

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
				idx++;
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
		
		int idxCourse = 0;
		while(true) {
			System.out.print("Enter registered courses: ");
			String course = sc.next();
			std.setCourse(course, idxCourse);
			
			System.out.print("Enter 0 is stop process & another number is continue: ");
			int choice = sc.nextInt();
			if(choice == 0) break;
			
			idxCourse++;
			if(idxCourse >= 9) break;
			
		}
		
		std.setID(ID);
		std.setName(name);
		std.setAddress(address);
		std.setDepartment(department);
		
		st[idx] = std;
		
	}
	public static void update() {
		
		Student std = new Student();
		boolean flag = true;
		
		System.out.print("Enter ID which you want to update: ");
		int prevID = sc.nextInt();
		int idxToUpdate = 0;
		
		while(true) {
			if(idxToUpdate >= idx) {
				System.out.println("---No such ID!---"); 
				flag = false;
				break;
			}
			
			if(st[idxToUpdate].getID() == prevID) {
				break;
			}
			idxToUpdate++;
		}
		
		if(flag == true) {
			System.out.print("Enter new ID: ");
			int updatedID = sc.nextInt();

			System.out.print("Enter new name: ");
			String updatedName = sc.next();
			
			System.out.print("Enter new address: ");
			String updatedAddress = sc.next();
			
			System.out.print("Enter new department: ");
			String updatedDepartment = sc.next();
			
			int idxCourse = 0;
			while(true) {
				System.out.print("Enter course which you want to update: ");
				String course = sc.next();
				std.setCourse(course, idxCourse);
				
				System.out.print("Enter 0 is stop process & another number is continue: ");
				int choice = sc.nextInt();
				if(choice == 0) break;
				
				idxCourse++;
				if(idxCourse >= 9) break;
				
			}
			
			std.setID(updatedID);
			std.setName(updatedName);
			std.setAddress(updatedAddress);
			std.setDepartment(updatedDepartment);
			
			st[idxToUpdate] = std;
		}
		
	}
	public static void search() {
		Student std = new Student();
		boolean flag = true;
		int idxToSearch = 0;
		
		System.out.print("Enter a ID want to search: ");
		int IdToSearch = sc.nextInt();
		System.out.println();
		
		while(true) {
			if(idxToSearch >= idx) {
				System.out.println("---No such ID!---"); 
				flag = false;
				break;
			}
			
			if(st[idxToSearch].getID() == IdToSearch) {
				break;
			}
			idxToSearch++;
		}
		
		if(flag == true) {
			std = st[idxToSearch];
			System.out.println("ID: " + std.getID());
			System.out.println("Index number: " + idxToSearch);
			System.out.println("Name: " + std.getName());
			System.out.println("Address: " + std.getAddress());
			System.out.println("Department: " + std.getDepartment());
			System.out.print("List of registered courses: ");
			for(int i = 0; i < 10; i++) {
				if(std.getCourse(i) != null) {
					System.out.print(std.getCourse(i) + " ");
				}
			}
			System.out.println();
		}
		
		
	}
	public static void display() {
		Student std = new Student();
		
		for(int i = 0; i < idx; i++) {
			std = st[i];
			System.out.println("- Index " + i);
			System.out.println("ID: " + std.getID());
			System.out.println("Name: " + std.getName());
			System.out.println("Address: " + std.getAddress());
			System.out.println("Department: " + std.getDepartment());
			System.out.print("List of registered courses: ");
			for(int j = 0; j < 10; j++) {
				if(std.getCourse(j) != null) {
					System.out.print(std.getCourse(j) + " ");
				}
			}
			System.out.println("\n");
		}
		
	}
	
}
