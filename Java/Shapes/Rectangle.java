/*
	Author: Jonathan Chu
	A rectangle object which is a represenation of the shape.
*/

public class Rectangle extends Shape {
	private double width;
	private double height;

	//constructor
	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	//Accessors and Mutators
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}

	//implementation of abstract super methods
	public double area() {
		return width * height;
	}
	public double circumference() {
		return (2 * width) + (2 * height);
	}
	public String toString() {
		return "Rectangle (A: " + area() + ", C: " + circumference() + ")";
	}	
}