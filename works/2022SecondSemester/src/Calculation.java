import java.util.Scanner;

public class Calculation {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Q 1.5");
		double res1 = ((9.5 * 4.5) - (2.5 *3.0)) / (45.5 - 3.5);
		System.out.println(res1);
		System.out.println();
		
		System.out.println("Q 1.7");
		double pi1 = 4.0 * (1.0 - 1.0/3.0 + 1.0/5.0 - 1.0/7.0 + 1.0/9.0 - 1.0/11.0);
		double pi2 = 4.0 * (1.0 - 1.0/3.0 + 1.0/5.0 - 1.0/7.0 + 1.0/9.0 - 1.0/11.0 + 1.0/13.0);
		System.out.println("(1)" + pi1);
		System.out.println("(2)" + pi2);
		System.out.println();
		
		System.out.println("Q 1.8");
		double radius1 = 5.5;
		double pi = 3.14159;
		double perimeter = 2.0 * radius1 * pi;
		double area = radius1 * radius1 * pi;
		System.out.println("perimeter : " + perimeter);
		System.out.println("area : " + area);
		System.out.println();
		
		System.out.println("Q 1.13");
		double a = 3.4; double b = 50.2; double c = 2.1; double d = 0.55; 
		double e = 44.5; double f = 5.9;
		double x = (e*d - b*f) / (a*d - b*c);
		double y = (a*f - e*c) / (a*d - b*c);
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		System.out.println();
		
		System.out.println("Q 2.2");
		System.out.print("Enter the radius and length of a cylinder : ");
		double radius3 = input.nextDouble();		
		double length = input.nextDouble();
		
		double area2 = radius3 * radius3 * pi;
		System.out.println("The area is : " + area2);
		
		double volume = area * length;
		System.out.println("The volume is : " + volume);
		System.out.println();
		
		System.out.println("Q 2.3");
		System.out.print("Enter a value for feet : ");
		double feet = input.nextDouble();
		double meter = feet * 0.305;
		System.out.println(feet + " feet is " + meter + " meters");
		System.out.println();
		
		System.out.println("Q 2.6");
		int num = 1000 - 0 -1;
		System.out.println("Enter a number between 0 and 1000 : " + num);
		int digit = num%10 + (num/10)%10 + (num/100)%10; 
		System.out.println("The sum of the digits is " + digit);
		System.out.println();
		
		System.out.println("Q 2.9");
		System.out.print("Enter v0, v1, and t : " );
		double v0 = input.nextDouble();
		double v1 = input.nextDouble();
		double t = input.nextDouble();
		double avg = (v1 - v0) / t;
		System.out.println("The average acceleration is " + avg);
		System.out.println();
		
		System.out.println("Q 2.14");
		System.out.print("Enter weight in pounds : ");
		double weight = input.nextDouble();
		double weightInKG = weight * 0.45359237;
		System.out.print("Enter height in inches : ");
		double height = input.nextDouble();
		double heightInMeter = height * 0.0254;
		double BMI = weightInKG / (heightInMeter * heightInMeter);
		System.out.println("BMI is " + BMI);
		System.out.println();
		
		System.out.println("Q 2.18");
		System.out.println("a    b    pow(a, b)");
		System.out.println("1    2    " + (int)Math.pow(1, 2));
		System.out.println("2    3    " + (int)Math.pow(2, 3));
		System.out.println("3    4    " + (int)Math.pow(3, 4));
		System.out.println("4    5    " + (int)Math.pow(4, 5));
		System.out.println("5    6    " + (int)Math.pow(5, 6));
		
		input.close();
		
	}

}
