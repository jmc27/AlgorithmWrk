/*
	Author: Jonathan Chu
	Test class to test ShapeSorter with the specified test
*/

import java.util.*;

public class ShapeTest {
	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(1.0));
		shapes.add(new Circle(2.5));
		shapes.add(new Rectangle(1.0, 2.0));
		shapes.add(new Triangle(3.0, 4.0, 4.0));
		System.out.print("Original: ");
		printList(shapes);

		ShapeSorter sorter = new ShapeSorter();
		List<Shape> orderedByArea = shapes;
		sorter.sortByArea(orderedByArea);
		
		List<Shape> orderedByCircumference = shapes;
		sorter.sortByCircumference(orderedByCircumference);

		System.out.print("Sorted by area: ");
		printList(orderedByArea);

		System.out.print("Sorted by circumference: ");
		printList(orderedByCircumference);
	}

	//method to print the elements of the List
	private static void printList(List<Shape> shapes) {
		System.out.print("[");
		ListIterator<Shape> litr = shapes.listIterator();
		while(litr.hasNext()) {
			System.out.print(litr.next().toString());
			if(litr.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}
}