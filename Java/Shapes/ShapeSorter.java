/*
	Author: Jonathan Chu
	Collection shape sorter object which will accept a collection
	of shapes and be able to sort them by area or circumference
*/

import java.util.*;

public class ShapeSorter {
	public ShapeSorter() {

	}

	/*
		Sort a given List. Chose lists as the type of collection
		because sets don't allow duplicates and Maps don't seem
		to fit the problem. 
	*/
	public void sortByArea(List<Shape> shapes) {
		ListIterator<Shape> litr = shapes.listIterator(1);
		boolean flag = true;
		boolean madeSwap = false;
		int prevI = 0;
		int nextI = 0;
		while(flag) {
			if(litr.hasNext()) {
				prevI = litr.previousIndex();
				nextI = litr.nextIndex();
				if(shapes.get(prevI).compareArea(shapes.get(nextI)) == 1) {
					swapElements(shapes, prevI, nextI);
					madeSwap = true;
				}
				litr.next();
			}
			else {
				if(madeSwap == false){
					flag = false;
				}
				else{
					madeSwap = false;
					litr = shapes.listIterator(1);
				}
			}
		}
	}
	public void sortByCircumference(List<Shape> shapes) {
		ListIterator<Shape> litr = shapes.listIterator(1);
		boolean flag = true;
		boolean madeSwap = false;
		int prevI = 0;
		int nextI = 0;
		while(flag) {
			if(litr.hasNext()) {
				prevI = litr.previousIndex();
				nextI = litr.nextIndex();
				if(shapes.get(prevI).compareCircumference(shapes.get(nextI)) == 1) {
					swapElements(shapes, prevI, nextI);
					madeSwap = true;
				}
				litr.next();
			}
			else {
				if(madeSwap == false){
					flag = false;
				}
				else{
					madeSwap = false;
					litr = shapes.listIterator(1);
				}
			}
		}
	}
	//swaps elements in a list
	public void swapElements(List<Shape> list, int index1, int index2) {
		Shape temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
}