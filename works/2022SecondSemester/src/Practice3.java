import java.util.Scanner;

public class Practice3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		int sum = 0;		
		
		while(i != 0) {
			int j = sc.nextInt();
			sum += j;
			i = j;
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
