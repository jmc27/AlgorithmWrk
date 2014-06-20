//Jonathan Chu
//Doubly linked list PA1

import java.util.Scanner;

/**
 * A basic implementation of a doubly linked list
 */
public class DoublyLinkedList {
	//Add the fields necessary for this class here
	int size = 0;
	Node front;
	Node end;
	boolean ifCircular = false;
	
	/**
	 * The node class used to store the nodes of the 
	 * doubly linked list.
	 */
	public class Node
	{
		//Implement a node containing a reference to a
		//previous node and a reference to a next node
		//as well as a value.
		public Node prev;
		public Node next;
		public Object value;
		
		//constructor
		public Node(Object value){
			this.value = value;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	
	
	/**
	 * The default constructor
	 */
	public DoublyLinkedList()
	{
		
	}
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else 
			return false;
	}
	
	
	/**
	 * Adds an item to the front of the doubly linked list
	 * @param item - the item to add
	 */
	public void addFront(Object item)
	{
		Node newFront = new Node(item);
		if(!isEmpty()){
			newFront.next = front;
			front.prev = newFront;
			front = newFront;
		}
		else {
			front = newFront;
			end = front;
		}
		size++;
	}
	
	public void setFront(Node newFront) {
		front = newFront;
	}
	
	/**
	 * Inserts an item into a specified position in the doubly linked list
	 * head is the in position 1
	 * if list is empty print error
	 * @param item - the item to add
	 * @param position - the position in the list where the item should be inserted
	 */
	public void addMid(Object item, int position)
	{
		if(!isEmpty()){
			Node newNode = new Node(item);
			Node curr = front;
			for(int i = 1; i < position; i ++){
				if(curr.next != null)
					curr = curr.next;
				else
					System.out.println("Wrong position");
			}
			curr.prev.next = newNode;
			curr.prev = newNode;
			newNode.prev = curr.prev;
			newNode.next = curr;
			size++;
		}
		else
			System.out.println("List is empty");
	}
	
	
	
	/**
	 * Adds an item to the end of the doubly linked list.
	 * @param item - the item to add
	 */
	public void addEnd(Object item)
	{
		Node newNode = new Node(item);
		if(!isEmpty()){
			Node curr = front;
			
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.prev = curr;
			end = newNode;
			size++;
		}
		else {
			front = newNode;
			end = front;
			size++;
		}
	}
	
	
	
	/**
	 * Deletes the first item of the list. Writes an error message if the list is empty.
	 * @return a reference to the new first node of the list.
	 */
	public Node deleteFront()
	{
		if(!isEmpty()){
			if(size > 1) {
				Node deleted = front;
				front.next.prev = null;
				front = front.next;
				size--;
				return deleted;
			}
			else {
				Node temp = front;
				front = null;
				end = null;
				size--;
				return temp;
			}
			
		}
		else{
			System.out.println("List is empty");
			return null;
		}
	}
	
	
	
	/**
	 * Deletes the last item of the list. Writes an error message if the list is empty.
	 */
	public void deleteEnd()
	{
		if(!isEmpty()){
			Node curr = front;
			while(curr.next != null){
				curr = curr.next;
			}
			curr = curr.prev;
			curr.next = null;
			end = curr;
			size--;
		}
		else
			System.out.println("Liste empty");
	}
	public void delete(Node curr) {
		try{
			Node temp = curr.prev;
			temp.next = curr.next;
			curr.prev = null;
			curr.next = null;
			size--;
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	/**
	 * Deletes the first occurrence of the specified item from the list. Writes an error
	 * message if the list doesn't contain the item.
	 * @param item - the item to delete
	 */
	public void delete(Object item)
	{
		if(!isEmpty()){
			if(front.value.equals(item))
				deleteFront();
			Node curr = front.next;
			boolean flag = true;
			while(flag && curr.next != null) {
				if(curr.value.equals(item)) {
					delete(curr);
					flag = false;
				}
				else
					curr = curr.next;
			}
			if(curr.value.equals(item)) {
				deleteEnd();
			}
			
			if(flag){
				System.out.println("Item not in list");
			}
		}
	}
	
	
	
	/**
	 * Deletes all occurrences of the specified item from the list. Writes an error
	 * message if the list doesn't contain the item.
	 * @param item - the item to delete
	 */
	public void deleteAll(Object item)
	{
		if(!isEmpty()) {
			for(int i = 1; i <= size; i ++) {
				delete(item);
			}
		}
	}
	
	
	
	/**
	 * Searches for the specified item in the list.
	 * @param item - the item to search for.
	 * @return true if the item is in the list, false otherwise.
	 */
	public boolean contains(Object item)
	{
		Node curr = front;
		while(curr.next != null) {
			if(curr.value.equals(item)) {
				return true;
			}
			else
				curr = curr.next;
		}
		if(curr.value.equals(item))
			return true;
		return false;
	}
	
	
	
	/**
	 * Makes this list a circular one by having the last node refer
	 * back to the first.
	 */
	public void makeCircular()
	{
		end.next = front;
		front.prev = end;
	}
	
	
	
	/**
	 * Returns the first node of the list.
	 * @return the first node.
	 */
	public Node getFront()
	{
		//replace the following line with desired output
		return front;
	}
	
	
	
	/**
	 * Joins two circular lists by making the elements alternate.
	 * The first list will be in the odd positions and the second will
	 * be in the even positions. Do this without creating a new list or
	 * making new nodes.
	 * 
	 * For example:
	 *     listOdds = 1 2 3 4 (circular)
	 *     listEvens = a b c d (circular)
	 *     
	 *     returns 1 a 2 b 3 c 4 d (circular)
	 * @param listOdds - the list to merge into the odd positions.
	 * @param listEvens - the list to merge into the even positions. 
	 * @return the first node of the merged list.
	 */
	public static DoublyLinkedList joinLists(DoublyLinkedList listOdds, DoublyLinkedList listEvens)
	{
		int size = Math.min(listOdds.size, listEvens.size);
		int position = 2;
		Node nextNode;
		for(int i = 1; i <= size; i++) {
			listOdds.addMid(listEvens.front.value, position);
			listEvens.deleteFront();
			position += 2;
		}
		while(!listEvens.isEmpty()) {
			nextNode = listEvens.deleteFront();
			listOdds.addEnd(nextNode);
		}
		listOdds.makeCircular();
		return listOdds;
	}
	
	
	
	public String toString()
	{
		//This procedure should visualize the contents of the list 
		//as a string. Refer to a similar procedure in ArrayQueue.
		//replace the following line with desired output
		//Account for the fact that the list may be circular
		try{
			String s = "";
			Node curr = front;
			for (int i=0;i<size;i++)
			{
				s += "["+curr.value.toString()+"]";
				curr = curr.next;
			}
			s += "\n\t";
			s += "Size: " + size + "\n\t";
			s += "front: " + front.value.toString() + "\n\t";
			s += "End: " + end.value.toString() + "\n\t";
			return s;
		}catch(Exception e){
			return "List Empty";
		}
	}
	
	
	
	/**
	 * A main with which to test the implementation of the queue.
	 * @param args
	 */
	public static void main(String[] args)
	{
		//Initialize the list
		DoublyLinkedList dll = new DoublyLinkedList();
	    
	    //Create a scanner object and a string for storing the input
	    Scanner scan = new Scanner(System.in);
	    String cmd;
	    
	    //Print the program's commands to the user.
	    System.out.println("Commands:\n\taddFront OBJ\n\taddEnd OBJ" +
          "\n\taddMid OBJ POSITION\n\tdeleteFront\n\tdeleteEnd"+
          "\n\tdelete OBJ\n\tdeleteAll OBJ\n\tcontains OBJ\n\tquit");
	    
	    //Loop through accepting input and printing returned information until quit
	    while (!(cmd=scan.next()).equalsIgnoreCase("quit"))
	    {
	    	if (cmd.equalsIgnoreCase("addFront"))
	    	{
	    		dll.addFront(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("addEnd"))
	    	{
	    		dll.addEnd(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("addMid"))
	    	{
	    		dll.addMid(scan.next(), scan.nextInt());
	    	}
	    	else if (cmd.equalsIgnoreCase("deleteFront"))
	    	{
	    		dll.deleteFront();
	    	}
	    	else if (cmd.equalsIgnoreCase("deleteEnd"))
	    	{
	    		dll.deleteEnd();
	    	}
	    	else if (cmd.equalsIgnoreCase("delete"))
	    	{
	    		dll.delete(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("deleteAll"))
	    	{
	    		dll.deleteAll(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("contains"))
	    	{
	    		System.out.println("Contains: "+dll.contains(scan.next()));
	    	}
	    	
	    	//Show what the list looks like
	    	System.out.println("Contents:\n\t"+dll.toString());
	    }
	}
}
