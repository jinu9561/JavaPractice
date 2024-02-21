import java.util.Scanner;

public class Practice4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double pi = Math.PI;
		
		System.out.println("Q 4.1");
		System.out.print("Enter the length from the center to a vertex: ");
		double vertex = sc.nextDouble();
		double s1 = 2 * vertex * (Math.sin(pi/5));
		double area = (5*Math.pow(s1, 2)) / (4*Math.tan(pi/5));
		System.out.println("The area of the pentagon is " + area);
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.2");
		System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
		double x1 = Math.toRadians(sc.nextDouble());
		double y1 = Math.toRadians(sc.nextDouble());
		System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
		double x2 = Math.toRadians(sc.nextDouble());
		double y2 = Math.toRadians(sc.nextDouble());
		double distance = 6371.01 * Math.acos((Math.sin(x1) * Math.sin(x2))
				+ (Math.cos(x1) * Math.cos(x2) * Math.cos(y1-y2)));
		
		System.out.println("The distance between the two points is " + distance);
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.8");
		System.out.print("Enter an ASCII code: ");
		int num = sc.nextInt();
		char ascii = (char) num;
		System.out.println("The character for ASCII code 69 is " + ascii);
		
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.13");
		System.out.print("Enter a letter grade: ");
		String letter = sc.next();
		char ch = letter.charAt(0);
		if (ch >= 'A' && ch <= 'Z') {
			switch (letter) {
				case "A": System.out.println(letter + " is a vowel"); break;
				case "E": System.out.println(letter + " is a vowel"); break;
				case "I": System.out.println(letter + " is a vowel"); break;
				case "O": System.out.println(letter + " is a vowel"); break;
				case "U": System.out.println(letter + " is a vowel"); break;
				
				default : System.out.println(letter + " is a consonant");
				}
			}
		else if (ch >= 'a' && ch <= 'z') {
			switch (letter) {
				case "a": System.out.println(letter + " is a vowel"); break;
				case "e": System.out.println(letter + " is a vowel"); break;
				case "i": System.out.println(letter + " is a vowel"); break;
				case "o": System.out.println(letter + " is a vowel"); break;
				case "u": System.out.println(letter + " is a vowel"); break;
				
				default : System.out.println(letter + " is a consonant");
				}
			}
		else {
			System.out.println(letter + " is an invalid input");
		}

		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.14");
		System.out.print("Enter a letter grade: ");
		String letter2 = sc.next();
		
		switch (letter2) {
		case "A" :case "a" : System.out.println("The numeric value for grade " + letter2 + " is " + 4); break;
		case "B" :case "b" : System.out.println("The numeric value for grade " + letter2 + " is " + 3); break;
		case "C" :case "c" : System.out.println("The numeric value for grade " + letter2 + " is " + 2); break;
		case "D" :case "d" : System.out.println("The numeric value for grade " + letter2 + " is " + 1); break;
		case "F" :case "f" : System.out.println("The numeric value for grade " + letter2 + " is " + 0); break;
		
		default: System.out.println(letter2 + " is an invalid grade");
			
			}
		
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.16");
		int randomNum = (int)(Math.random()*(90-65+1)) + 65;
		char ch2 = (char)randomNum;
		System.out.println("Random letter : " + ch2);
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.17");
		System.out.print("Enter a year: ");
		int year = sc.nextInt();
		System.out.print("Enter a month: ");
		String month = sc.next();
		
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {

			switch (month) {
			case "Jan": case "Mar": case "May": case "July":
				case "Aug": case "Oct": case "Dec":
				System.out.println(month + year + " has 31 days"); break;
			case "Feb": System.out.println(month + year + " has 29 days"); break;
			default : System.out.println(month + year + " has 30 days"); break;
			}
		} 
		
		else {
			switch (month) {
			case "Jan": case "Mar": case "May": case "July":
				case "Aug": case "Oct": case "Dec":
				System.out.println(month + year + " has 31 days"); break;
			case "Feb": System.out.println(month + year + " has 28 days"); break;
			default : System.out.println(month + year + " has 30 days"); break;
			}
		}
		
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.20");
		System.out.print("Enter a String: ");
		
		
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.22");
		System.out.println();

//===============================================================================
		
		System.out.println("Q 4.23");
		System.out.println();

//===============================================================================
		
		
		
		
		sc.close();
	}

}