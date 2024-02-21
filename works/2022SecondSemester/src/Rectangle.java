
public class Rectangle {
	private double width = 1;
	private double height = 1;
	
	public void setArea(double w, double h) {
		width = w;
		height = h;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		return Math.round(height * width);
	}
	
	public double getPerimeter() {
		return Math.round(2 * (width + height));
	}
}
