import java.util.Scanner;

public class Practice7 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1) Add a Student ID");
		System.out.println("2) Delete Student ID");
		System.out.println("3) Insert Student ID at a given position or index");
		System.out.println("4) Search Student ID");
		System.out.println("5) Update Student ID");
		System.out.println("6) Display Student IDs");
		System.out.println("7) Exit");
		
		int[] stdIDs = new int[100];
		int index = 0;
		
		while(true) {
			System.out.print("Enter your choice: ");
			int cmd = sc.nextInt();

//------------------------------------------------------------------		

			if(cmd == 1) {
				while(true) {
					System.out.print("Enter new stdudent ID: ");
					stdIDs[index] = sc.nextInt();
					
					System.out.print("If you want to continue add ID enter 1 or want to stop add Id enter 0: ");
					int choice = sc.nextInt();
					if(choice == 0) break;
					index++;
				}
			}

//------------------------------------------------------------------		
			
			else if(cmd == 2) {
				
				System.out.print("Enter a ID which you want to delete: ");
				int deleteID = sc.nextInt();
				int i2 = 0;
				
				while(true) {
					if(stdIDs[i2] == deleteID) {
						for(int j = i2; j < stdIDs.length-i2; j++) {
							if(j < stdIDs.length-i2-1) {
								stdIDs[j] = stdIDs[j+1];
							}
						}
						break;
					}
					
					i2++;
					
					if(i2 == stdIDs.length-1) {
						System.out.println("There is no such ID " + deleteID);
						break;
					}
				}
				
			}
			
//------------------------------------------------------------------		
			
			else if(cmd == 3) {
				System.out.print("Enter a new ID: ");
				int newID = sc.nextInt();
				System.out.print("Enter a index which you want to input ID: ");
				int newIndex = sc.nextInt();
				
				int[] backupList = new int[stdIDs.length-newIndex];
				for(int j = 0; j < backupList.length; j++) {
					backupList[j] = stdIDs[newIndex+j];
				}
				
				for(int j = 0; j < backupList.length-1; j++) {
					stdIDs[newIndex+j+1] = backupList[j];
				}
				
				stdIDs[newIndex] = newID;
			}

//------------------------------------------------------------------			
			
			else if(cmd == 4) {
				System.out.print("Enter student ID which want to find: ");
				int search = sc.nextInt();
				int i = 0;
				
				while(true) {
					if(stdIDs[i] == search) {
						System.out.println("Index of ID " + search + " is " + i);
						break;
					}
					if(i == stdIDs.length-1) {
						System.out.println("There is no ID of " + search);
						break;
					}
					i++;
				}
				
			}
			
//------------------------------------------------------------------			
			
			else if(cmd == 5) {
				
				System.out.print("Enter ID which you want to update: ");
				int prevID = sc.nextInt();
				
				System.out.print("Enter new ID: ");
				int updatedID = sc.nextInt();
				
				for(int i = 0; i < stdIDs.length; i++) {
					if(stdIDs[i] == prevID) {
						stdIDs[i] = updatedID;
					}
				}
				
			}
			
//------------------------------------------------------------------			
			
			else if(cmd == 6) {
				
				System.out.print("Student IDs: ");
				
				for(int j = 0; j < stdIDs.length; j++) {
					if(stdIDs[j] != 0) {
						System.out.print(stdIDs[j] + " ");
					}
				}
				
				System.out.println();
				
			}
			
//------------------------------------------------------------------			
			
			else if(cmd == 7) {
				break;
			}
		}

		sc.close();
	}

}
