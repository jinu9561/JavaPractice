
public class LinearEquation {
	
	private double a,b,c,d,e,f;
	
	public void setA(double x) {
		a = x;
	}
	public void setB(double x) {
		b = x;
	}
	public void setC(double x) {
		c = x;
	}
	public void setD(double x) {
		d = x;
	}
	public void setE(double x) {
		e = x;
	}
	public void setF(double x) {
		f = x;
	}
	
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	public double getD() {
		return d;
	}
	public double getE() {
		return e;
	}
	public double getF() {
		return f;
	}
	
	public boolean isSolvable() {
		if((a*d - b*c) == 0) return false;
		else return true;
	}
	
	public void getX() {
		if(isSolvable() == true) 
			System.out.println("The value of x is " + (e*d-b*f) / (a*d-b*c));
		else 
			System.out.println("The equation has no solution.");
	}
	
	public void getY() {
		if(isSolvable() == true) 
			System.out.println("The value of y is " + (a*f-e*c) / (a*d-b*c));
	}
}
