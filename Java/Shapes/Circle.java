/*
	Author: Jonathan Chu
	Circle object that is a representation of the shape.
*/

public class Circle extends Shape {
	private double radius;
	private static final double PIE = 3.14159;
	//Constructor
	public Circle(double radius) {
		this.radius = radius;
	}

	//Getters Setters
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}

	//implentation of abstract super methods
	public double area() {
		return PIE * radius * radius;
	}

	public double circumference() {
		return 2 * PIE * radius;
	}

	public String toString() {
		return "Circle (A: " + area() + ", C: " + circumference() + ")";
	}
}