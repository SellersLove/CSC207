package test;

public class ThisCircle implements Circle{
	
	public double radius;
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return getArea(radius);
	}
	public double getArea(double r){
		return Math.PI*r*r;
	}


}
