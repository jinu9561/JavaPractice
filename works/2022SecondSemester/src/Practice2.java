import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Practice2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Q 3.1");
		System.out.print("Enter a, b, c : ");
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		float r1 = (float) ((Math.sqrt(b*b - 4*a*c) - b) / 2*a);
		float r2 = (float) (((-1)*b - Math.sqrt(b*b - 4*a*c)) / 2*a);
		
		if(b*b - 4*a*c > 0) 
			System.out.println("The equation has two roots " + r1 + " and " + r2);
		else if(b*b - 4*a*c == 0)
			System.out.println("The equation has one root " + r1);
		else 
			System.out.println("The equation has no real root");
		
		System.out.println();
//-----------------------------------------------------------------------------		
		System.out.println("Q 3.3");
		System.out.print("Enter a, b, c, d, e, f : ");
		float a2 = sc.nextFloat();
		float b2 = sc.nextFloat();
		float c2 = sc.nextFloat();
		float d2 = sc.nextFloat();
		float e2 = sc.nextFloat();
		float f2 = sc.nextFloat();
		float x = (e2*d2 - b2*f2) / (a2*d2 - b2*c2);
		float y = (a2*f2 - e2*c2) / (a2*d2 - b2*c2);
		
		if(a2*d2 - b2*c2 == 0) 
			System.out.println("The equation has no solution");
		else 
			System.out.println("x is " + x + " and y is " + y);
		
		System.out.println();
//------------------------------------------------------------------------------		
		System.out.println("Q 3.4");
		int month = (int) (Math.random() * 12) + 1;
		System.out.print(month + " is ");
		switch (month) {
			case 1: System.out.println("January"); break;
			case 2: System.out.println("February"); break;
			case 3: System.out.println("March"); break;
			case 4: System.out.println("April"); break;
			case 5: System.out.println("May"); break;
			case 6: System.out.println("June"); break;
			case 7: System.out.println("July"); break;
			case 8: System.out.println("August"); break;
			case 9: System.out.println("September"); break;
			case 10: System.out.println("October"); break;
			case 11: System.out.println("November");  break;
			case 12: System.out.println("December"); break;
			default: System.out.println("Invalid month"); break;
		}
		System.out.println();
		
//------------------------------------------------------------------------------		
		System.out.println("Q 3.5");
		System.out.print("Enter today's day : ");
		int today = sc.nextInt();
		System.out.print("Enter the number of days elapsed since today : ");
		int future = sc.nextInt();
		int futureday = (future + today) % 7;
		String t = "";
		String f = "";
		
		switch (today) {
			case 0: t = "Sunday"; break;
			case 1: t = "Munday"; break;
			case 2: t = "Tuesday"; break;
			case 3: t = "Wednesday"; break;
			case 4: t = "Thursday"; break;
			case 5: t = "Friday"; break;
			case 6: t = "Saturday"; break;
		}
		switch (futureday) {
			case 0: f = "Sunday"; break;
			case 1: f = "Munday"; break;
			case 2: f = "Tuesday"; break;
			case 3: f = "Wednesday"; break;
			case 4: f = "Thursday"; break;
			case 5: f = "Friday"; break;
			case 6: f = "Saturday"; break;
		}
		System.out.println("Today is " + t + " and the future day is " + f);
		System.out.println();	
//------------------------------------------------------------------------------				

		System.out.println("Q 3.8");
		System.out.print("Enter three integers : ");
		int a3 = sc.nextInt();
		int b3 = sc.nextInt();
		int c3 = sc.nextInt();
		int first = 0; int second = 0; int third = 0;
		if(a3 > b3) {
			if(a3 > c3) third = a3;
			else second = a3;
		} 
		else {
			if(a3 <= c3) first = a3;
			else if(a3 > c3) second = a3;
		}
		
		if(b3 >= a3) {
			if(b3 > c3) third = b3;
			else second = b3;
		} 
		else {
			if(b3 <= c3) first = b3;
			else if(b3 > c3) second = b3;
		}
		
		if(c3 >= a3) {
			if(c3 >= b3) third = c3;
			else second = c3;
		} 
		else {
			if(c3 < b3) first = c3;
			else if(c3 >= b3) second = c3;
		}
		
		System.out.println(first + " " + second + " " + third);
		System.out.println();
		
//------------------------------------------------------------------------------						
		System.out.println("Q 3.9");
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		int digit = sc.nextInt();
		int d1 = (digit/100000000);
		int d2_2 = (digit/10000000) % 10;
		int d3 = (digit/1000000) % 10;
		int d4 = (digit/100000) % 10;
		int d5 = (digit/10000) % 10;
		int d6 = (digit/1000) % 10;
		int d7 = (digit/100) % 10;
		int d8 = (digit/10) % 10;
		int d9 = digit % 10;
		int d10 = (d1*1 + d2_2*2 + d3*3 + d4*4 + d5*5 + d6*6 + d7*7 + d8*8 + d9*9) % 11;		
		if(d10 == 10) {
			System.out.print(d1);
			System.out.print(d2_2);
			System.out.print(d3);
			System.out.print(d4);
			System.out.print(d5);
			System.out.print(d6);
			System.out.print(d7);
			System.out.print(d8);
			System.out.print(d9);
			System.out.println("X");
		} else {
			System.out.print(d1);
			System.out.print(d2_2);
			System.out.print(d3);
			System.out.print(d4);
			System.out.print(d5);
			System.out.print(d6);
			System.out.print(d7);
			System.out.print(d8);
			System.out.print(d9);
			System.out.println(d10);
		}
		
		System.out.println();
//------------------------------------------------------------------------------				
		System.out.println("Q 3.12");
		System.out.print("Enter a three-digit integer: ");
		int palindrome = sc.nextInt();
		int startnum = (palindrome/100);
		int finalnum = (palindrome%10);
		
		if(startnum == finalnum) 
			System.out.println(palindrome + " is a palindrome");
		else 
			System.out.println(palindrome + " is not a palindrome");
		
		System.out.println();
//------------------------------------------------------------------------------				
		System.out.println("Q 3.18");
		double cost = 0;
		System.out.print("Enter weight in pounds: ");
		double weight = sc.nextDouble();
		
		if(weight > 0 && weight <= 1) cost = 3.5;
		else if(weight > 1 && weight <= 3) cost = 5.5;
		else if(weight > 3 && weight <= 10) cost = 8.5;
		else if(weight > 10 && weight <= 20) cost = 10.5;
		else if(weight > 50 || weight == 0) System.out.println("the package cannot be shipped.");
			
		if(cost != 0) System.out.println("The cost in dollars: " + cost);
		System.out.println();
//------------------------------------------------------------------------------				
		System.out.println("Q 3.26");
		System.out.print("Enter an integer: ");
		int num2 = sc.nextInt();
		System.out.print("Is " + num2 + " divisible by 5 and 6?");
		if(num2%5 == 0 && num2%6 == 0) System.out.println(" true");
		else System.out.println(" false");
		
		System.out.print("Is " + num2 + " divisible by 5 or 6?");
		if(num2%5 == 0 || num2%6 == 0) System.out.println(" true");
		else System.out.println(" false");
		
		System.out.print("Is " + num2 + " divisible by 5 or 6?, but not both?");
		if(num2%5 == 0 ^ num2%6 == 0) System.out.println(" true");
		else System.out.println(" false");
		
		System.out.println();
//------------------------------------------------------------------------------				
		System.out.println("Q 3.31");
		System.out.print("Enter the exchange rate from dollars to RMB: ");
		double rate = sc.nextDouble();
		
		System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
		int convert = sc.nextInt();
		
		if(convert == 0) {
			System.out.print("Enter the dollar amount: ");
			double dollar = sc.nextDouble();
			System.out.println("$" + dollar + " is " + dollar*rate + " yuan");
		} else if(convert == 1) {
			System.out.print("Enter the RMB amount: ");
			double RMB = sc.nextDouble();
			System.out.println(RMB + " yuan is " + "$" + RMB/rate);
		} else {
			System.out.println("Incorrect input");
		}
	
		sc.close();
		
	}

}
