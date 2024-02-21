import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Practice10 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//=========================================================		
		System.out.println("#### Q 9.1 #### ");
		
		Rectangle rectangle1 = new Rectangle();
		rectangle1.setArea(4, 40);
		
		Rectangle rectangle2 = new Rectangle();
		rectangle2.setArea(3.5, 35.9);
		
		System.out.println("--rectangle1--");
		System.out.println("width: " + rectangle1.getWidth());
		System.out.println("height: " + rectangle1.getHeight());
		System.out.println("area: " + rectangle1.getArea());
		System.out.println("perimeter: " + rectangle1.getPerimeter());
		System.out.println();
		
		System.out.println("--rectangle2--");
		System.out.println("width: " + rectangle2.getWidth());
		System.out.println("height: " + rectangle2.getHeight());
		System.out.println("area: " + rectangle2.getArea());
		System.out.println("perimeter: " + rectangle2.getPerimeter());
		System.out.println();
//=========================================================	
		
		System.out.println("#### Q 9.6 #### ");
		
		StopWatch sw = new StopWatch();
		System.out.println("Stop watch");
		System.out.println("Enter 1 is start & 0 is stop");
		
		while(true) {
			int cmd = sc.nextInt();	
			
			if(cmd == 1) {
				System.out.println("start!");
				sw.start();
			} 
			
			else if(cmd == 0) {
				System.out.println("stop!");
				sw.stop();
				break;
			} 
			
			else {
				System.out.println("Invalid number!");
			}
		}
		
		System.out.println("Elapsed Time is " + sw.getElapsedTime());

		System.out.println();
//=========================================================	
		
		System.out.println("#### Q 9.10 #### ");
		
		System.out.println("ax^2 + bx + c = 0");
		
		QuadraticEquation q = new QuadraticEquation();
		System.out.print("a: ");
		q.setA(sc.nextDouble());
		System.out.print("b: ");
		q.setB(sc.nextDouble());
		System.out.print("c: ");
		q.setC(sc.nextDouble());
		
		q.getRoot();
		System.out.println();
		
//=========================================================	
				
		System.out.println("#### Q 9.11 #### ");
				
		System.out.println("ax + by = e");
		System.out.println("cx + dy = f");
		
		LinearEquation le = new LinearEquation();
		System.out.print("a: ");
		le.setA(sc.nextDouble());
		System.out.print("b: ");
		le.setB(sc.nextDouble());
		System.out.print("c: ");
		le.setC(sc.nextDouble());
		System.out.print("d: ");
		le.setD(sc.nextDouble());
		System.out.print("e: ");
		le.setE(sc.nextDouble());
		System.out.print("f: ");
		le.setF(sc.nextDouble());
		
		le.getX();
		le.getY();
		
		sc.close();
		
	}
	
}

