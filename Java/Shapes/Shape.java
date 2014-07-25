
/* 
Author: Jonathan Chu
The abstract class for shapes such as circle, rectangle, and triangle. 
All shapes have an area and circumference and need to be able to
compare their area and circumference to that of another shape.
*/
public abstract class Shape{
	//Abstract shapes must calculate area and circumference
	public abstract double area();
	public abstract double circumference();
	public abstract String toString();

	//Compare this shape's area to another's
	public final int compareArea(Shape shape) {
		if (area() > shape.area())
			return 1;
		else if (area() == shape.area())
			return 0;
		else
			return -1;
	}
	//Compare this shape's circumference to another's
	public final int compareCircumference(Shape shape) {
		if (circumference() > shape.circumference())
			return 1;
		else if (circumference() == shape.circumference())
			return 0;
		else 
			return -1;
	}
}