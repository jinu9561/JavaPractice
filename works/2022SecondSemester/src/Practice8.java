import java.util.Scanner;

public class Practice8 {
	
	public static int[] std_id;
	public static int[] sorted_id;
	public static int cmd, tempID, i, next, idx = 0, del_idx=-1, newStudentID;
	public static boolean flag = true;
	
	public static void sortList(int[] sorted_id) {
	
		for(i = 0; i < idx-1; i++) {
			next = i;
			
			for(int j = i+1; j < idx; j++) {
				if(sorted_id[next] > sorted_id[j]) next = j;
			}
			
			int tmp = sorted_id[next];
			sorted_id[next] = sorted_id[i];
			sorted_id[i] = tmp;
		}
		
		
	}
	
	public static int binarySearch(int[] sorted_id, int key) {
		  int low = 0;
		  int high = idx - 1;
		  
		  while (high >= low) {
		    int mid = (low + high) / 2;
		    if (key < sorted_id[mid]) high = mid - 1;
		    else if (key == sorted_id[mid]) return mid;
		    else low = mid + 1;
		  }
		  
		  return -1;
		}
	
	public static int addID(int[] std_id, int id) {
		flag = true;
		
		for(i = 0; i < idx; i++) {
			if(std_id[i] == id) {
				System.out.println("Repeated ID!");
				flag = false;
			}
		}
		
		if(flag == true) {
			std_id[idx] = id;
			idx++;
		}
		
		return idx;
		
	}
	
	public static void deleteID(int[] std_id, int tempID) {
		if(binarySearch(std_id, tempID) == -1) {
			System.out.printf("\nID does not exist.\n");
		} else {
			del_idx = binarySearch(std_id, tempID);
			for (i = del_idx; i < idx; i++) {
				std_id[i] = std_id[i + 1];
			}
			idx--;
		}
		
	}
	
	public static void insertID(int[] std_id, int tempID, int del_idx) {
		for (i = idx; i >= del_idx; i--) {
			std_id[i] = std_id[i - 1];
		}
		std_id[del_idx] = tempID;
		idx++;
	}
	
	public static int searchID(int[] std_id, int tempID) {
		
		int res = 0;
		
		for(i = 0; i < idx; i++) {
			if(tempID == std_id[i]) {
				res = i;
			}
		}
		
		return res;
	}
	
	public static void updateID(int[] std_id, int tempID, int newID) {
		
		int newIdx = searchID(std_id, tempID);
		std_id[newIdx] = newID;
		
	}
	
	public static void printID(int[] std_id) {
		for (i = 0; i < idx; i++) {
			System.out.printf("%d\n", std_id[i]);
		}
	}
	
	public static void main(String[] args) {	
		

		int std_id[] = new int [100];
		int sorted_id[] = new int [100];
		int i = 0;

	    Scanner input = new Scanner(System.in);
	    
		do {
			System.out.printf("\n\n<< Student ID Management Program >>\n");
			System.out.printf("1. Add Student ID\n");
			System.out.printf("2. Delete Student ID\n");
			System.out.printf("3. Insert Student ID\n");
			System.out.printf("4. Search Student ID\n");
			System.out.printf("5. Update Student ID\n");
			System.out.printf("6. Display Student IDs\n");
			System.out.printf("7. Exit\n\n");

			System.out.printf("Enter your choice:");
			cmd = input.nextInt();
			System.out.printf("%d", cmd);
			

			switch (cmd) {
			case 1:
				System.out.println("\nEnter Student ID : ");
				newStudentID = input.nextInt();
				idx = addID(std_id, newStudentID);
				for(i = 0; i < std_id.length; i++) sorted_id[i] = std_id[i]; 
				sortList(sorted_id);	
				break;

			case 2:
				System.out.printf("\nEnter ID to be deleted: ");
				tempID = input.nextInt();
				deleteID(std_id, tempID);
				break;
				
			case 3:
				System.out.printf("\nEnter ID to be inserted: ");
				tempID = input.nextInt();
				
				if(binarySearch(sorted_id, tempID) != -1) {
					System.out.printf("\n ID already exists!\n");
					break;
				}

				System.out.printf("Enter the index where you want to insert the ID: ");
				del_idx = input.nextInt();
				insertID(std_id, tempID, del_idx);
				break;

			case 4:
				System.out.printf("\nEnter Student ID: ");
				tempID = input.nextInt();
				
				if(binarySearch(sorted_id, tempID) == -1) 
					System.out.printf("\n %d does not exist.\n", tempID);
				else
					System.out.printf("\n %d is at %d index.\n", tempID, searchID(std_id, tempID));
					
				break;
				
			case 5:
				System.out.printf("\nEnter Student ID you would like to update: ");
				tempID = input.nextInt();
				
				if(binarySearch(sorted_id, tempID) == -1) 
					System.out.printf("\n %d does not exist.\n", tempID);
				else {
					System.out.printf("\nEnter new Student ID: ");
					int newID = input.nextInt();
					updateID(std_id, tempID, newID);
				}
					
				break;
				
			case 6:
				System.out.printf("\nThe list of student IDs\n");
				printID(std_id);
				break;
				
			case 7:
				return;

			default:
				System.out.printf("Invalid choice \n");
				break;
			}
		} while (cmd != 7);
		
		input.close();
	}

}
