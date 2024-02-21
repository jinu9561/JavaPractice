import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Q 5.1");
		System.out.print("Enter an integer, the input ends if it is 0: ");
		int numOfPositive = 0;
		int numOfNegative = 0;
		double total = 0;
		int cnt = 0;
		double avg = 0;
		
		while(true) {
			int num = sc.nextInt();
			
			total += num;
			if(num > 0) numOfPositive++;
			else if(num < 0) numOfNegative++;
			
			if(num == 0) break;
			cnt++;
		}
		
		avg = total/cnt;
		
		System.out.println("The number of positives is " + numOfPositive);
		System.out.println("The number of negatives is " + numOfNegative);
		System.out.println("The total is " + total);
		System.out.println("The average is " + avg);
		
		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.3");
		
		System.out.println("Kilograms       Pounds");
		for(int i = 1; i < 200; i++) {
			System.out.printf(i + "               " + "%.1f",(double)i * 2.2);
			System.out.println();
		}
		
		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.5");
		
		System.out.println("Kilograms       Pounds");
		for(int i = 1; i < 200; i++) {
			System.out.printf(i + "               " + "%.1f",(double)i * 2.2);
			System.out.println();
		}
		System.out.println("Pounds          Kilograms");
		for(int i = 20; i < 515; i++) {
			System.out.printf(i + "               " + "%.1f",(double)i / 2.2);
			System.out.println();
		}
		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.8");
		
		System.out.print("Enter the number of student: ");
		int studentNum = sc.nextInt();
		String highestName = "";
		int highestScore = 0;
		
		for(int i = 0; i < studentNum; i++) {
			String name = sc.next(); 
			int score = sc.nextInt();
			
			if (score > highestScore) {
				highestName = name;
				highestScore = score;
			}
		}
		System.out.println("the name of the student with the highest score: " + highestName);
		
		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.9");
		
		System.out.print("Enter the number of student: ");
		int studentNum2 = sc.nextInt();
		
		String highestName2 = "";
		String secondName = "";
		int highestScore2 = 0;
		int secondScore = 0;
		
		for(int i = 0; i < studentNum2; i++) {
			String name = sc.next(); 
			int score = sc.nextInt();
			
			if (score > highestScore2) {
				if(secondScore < highestScore2) {
					secondName = highestName2;
				} else if (secondScore == highestScore2) {
					secondName += name;
				}
				highestName2 = name;
				highestScore2 = score;
			} else if (score == highestScore2) {
				highestName2 += " and ";
				highestName2 += name;
			} 

		}
		System.out.println("the name of the student with the highest score: " + highestName2);
		System.out.println("the name of the student with the second-highest score: " + secondName);

		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.10");
		
		int cnt2 = 0;
		
		for(int i = 100; i <= 1000; i++) {
			if(i%5 == 0 && i%6 == 0) {
				System.out.print(i + " ");
				cnt2++;
			}
			if(cnt2 == 10) {
				System.out.println();
				cnt2 = 0;
			}
		}
		
		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.12");
		
		int i = 1;
		
		while(true) {
			if(Math.pow(i, 2) > 12000) {
				System.out.println(i);
				break;
			}
			i++;
		}
		
		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.14");
		
		int gcd = 1;
		
		System.out.print("Enter two integers: ");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		for(int j = 1; j < n1; j++) {
			if(n1%j == 0 && n2%j == 0) {
				gcd = j;
			}
		}
		System.out.println("gcd is " + gcd);
		
		
		System.out.println();
		
//=======================================================		
		System.out.println("Q 5.16");
		
		System.out.print("Enter a integer: ");
		int num16 = sc.nextInt();
		int next = num16;
		int i16 = 2;
		
		while(true) {
			if(i16 <= next && next % i16 == 0) {
				next = next/i16;
				System.out.print(i16);
				i16 = 2;
			} else {
				i16++;
			}
			
			if(i16 > next) {
				break;
			} 
			
			if(i16 <= next && next % i16 == 0) {
				System.out.print(", ");
			}
		}

		System.out.println();
		
//=====================================================		
		System.out.println("Q 5.39");
		int i39 = 25000;
		double comm = 0;
		while(true) {
			comm = 5000*0.08 + 5000*0.1 + (i39 - 10000)*0.12;
			
			if(comm >= 30000) {
				break;
			}
			
			i39++;
		}
		
		System.out.println("the minimum sales to make $30,000 is " + i39);
		
		System.out.println();
		
//=====================================================	
		System.out.println("Q 5.41");
		
		int cnt41 = 0;
		int largestNum = 0;
		
		System.out.print("Enter numbers: ");
		while(true) {
			int number = sc.nextInt();
			if(number == 0) {
				break;
			}
			if(number > largestNum) {
				largestNum = number;
				cnt41++;
			}
		}
		
		System.out.println("The largest number is " + largestNum);
		System.out.println("The occurrence count of the largest number is " + cnt41);
		
		System.out.println();
		
//=====================================================		
		
		sc.close();
	}
	
}
