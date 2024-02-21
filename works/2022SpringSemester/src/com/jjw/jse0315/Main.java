package com.jjw.jse0315;

import java.io.*;
import java.util.*;

abstract class Shape {
	protected double x;
	protected double y;

	protected Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public abstract void draw();

	public abstract double getArea();
}

//여기에 Circle과 Rectangle 클래스를 작성하시오.

//--------Rectangle Class------------------------------------------------------
class Rectangle extends Shape {	
	
	protected double width;
	protected double height;
	protected double size;
	
	public Rectangle(double x, double y, double width, double height) {
		
		super(x, y);

		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public void draw() {		
	}

	@Override
	public double getArea() {
		return size = width * height;
	}


}

//---------Circle Class-------------------------------------------------

class Circle extends Shape {	

	public static final double PI = 3.14;
	protected double radius;
	protected double size;
	
	public Circle(double x, double y, double radius) {
		
		super(x, y);

		this.radius = radius;
	}
	
	
	@Override
	public void draw() {		
	}

	@Override
	public double getArea() {
		return size = radius * radius * PI;
	}


}

//------------------------------------------------------------------

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noShape = scan.nextInt();
		Shape[] shapes = new Shape[noShape];

		for (int i = 0; i < noShape; i++) {
			String s = scan.next();
			if (s.equals("Rectangle")) {
				double x = scan.nextDouble();
				double y = scan.nextDouble();
				double width = scan.nextDouble();
				double height = scan.nextDouble();
				shapes[i] = new Rectangle(x, y, width, height);
			} else if (s.equals("Circle")) {
				double x = scan.nextDouble();
				double y = scan.nextDouble();
				double radius = scan.nextDouble();
				shapes[i] = new Circle(x, y, radius);
			}
		}

		// 그 다음엔 면적을 계산한다.
		double sumArea = 0;
		for (Shape shape : shapes) {
			sumArea += shape.getArea();
		}

		System.out.printf("%.2f", sumArea);
	}
}
