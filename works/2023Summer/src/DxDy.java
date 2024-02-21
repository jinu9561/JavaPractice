import java.util.Scanner;

public class DxDy {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int n = sc.nextInt();
        
        int DxDy[] = {0, 0};
        
        for(int i = 0; i < n; i++) {
        	String dir = sc.next();
        	int dirNum = sc.nextInt();
        	
        	switch (dir) {
			case "N" : DxDy[1] += dirNum; break; 
			case "S" : DxDy[1] -= dirNum; break;
			case "E" : DxDy[0] += dirNum; break;
			case "W" : DxDy[0] -= dirNum; break;
			default :
				throw new IllegalArgumentException("Unexpected value: " + dir);
			}
        }
        
        System.out.println(DxDy[0] + " " + DxDy[1]);
       
        
    }
}