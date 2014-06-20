//Jonathan Chu
//Array Queue PA 1

import java.util.Scanner;

/**
 * A basic implementation of a queue using an array.
 */
public class ArrayQueue {
	//this array will store the data in the queue.
	Object array[];
	//What other fields are required for this implementation?
	int front;
	int rear;
	int size = 0;
	/**
	 * The default empty constructor. This initializes the max capacity
	 * of the queue to be 10.
	 */
	public ArrayQueue()
	{
		array = new Object[10];
	}
	
	
	
	/**
	 * The default empty constructor. This initializes the max capacity
	 * of the queue to be the specified capacity.
	 * @param capacity - The capacity of the queue.
	 */
	public ArrayQueue(int capacity)
	{
		array = new Object[capacity];
	}
	
	
	
	/**
	 * Adds an item to the queue. Writes an error message if the queue is
	 * full.
	 * @param item - The item to add.
	 */
	public void enqueue(Object item)
	{
		if(isEmpty()){
			size++;
			front = 0;
			rear = 0;
			array[rear] = item;
		}
		else if(!isFull()){
			rear++;
			size++;
			array[rear % array.length] = item;
		}
		else
			System.out.println("Queue is full");
	}
	
	
	
	/**
	 * Dequeues the first item in the queue and returns it. Writes an error
	 * message if the queue is empty.
	 * @return The dequeued item.
	 */
	public Object dequeue()
	{
		if(!isEmpty()) {
			Object dequeued = array[front % array.length];
			front++;
			size--;
			return dequeued;
		}
		else {
			System.out.println("Queue is empty");
			return null;
		}
	}
	
	
	
	/**
	 * Gets the current size of the queue.
	 * @return The size of the queue.
	 */
	public int size()
	{
		//replace the following line with desired output
		return size;
	}
	
	
	
	/**
	 * Tests whether the queue is empty.
	 * @return true if empty, false if not
	 */
	public boolean isEmpty()
	{
		//replace the following line with desired output
		if(size == 0)
			return true;
		else
			return false;
	}
	
	
	
	/**
	 * Tests whether the queue is full.
	 * @return true if empty, false if not
	 */
	public boolean isFull()
	{
		//replace the following line with desired output
		if(size == array.length)
			return true;
		else 
			return false;
	}
	
	
	
	public String toString()
	{
		String s = "";
		for (int i=0;i<array.length;i++)
		{
			s += "["+array[i].toString()+"]";
		}
		s += "\n\t"; //new line and indent
		s += "Size: " + size + "\n\t";
		s += "Front: " + array[front].toString() + "\n\t";
		s += "Rear: " + array[rear].toString() + "\n\t";
		//DO: Add the values of the other fields to the string
		
		return s;
	}
	
	/**
	 * A main with which to test the implementation of the queue.
	 * @param args - the capacity of the queue
	 */
	public static void main(String[] args)
	{
		//Declare the ArrayQueue
		ArrayQueue q;
		
		//Initialize the capacity from the args
	    if (args.length > 0)
	    	q = new ArrayQueue(Integer.parseInt(args[0]));
	    else
	    	q = new ArrayQueue();
	    
	    //Create a scanner object and a string for storing the input
	    Scanner scan = new Scanner(System.in);
	    String cmd;
	    
	    //Print the program's commands to the user.
	    System.out.println("Commands:\n\tenqueue OBJ\n\tdequeue\n\tsize\n\t" +
          "isEmpty\n\tisFull\n\tquit");
	    
	    //Loop through, accepting input and printing returned information until quit
	    while (!(cmd=scan.next()).equalsIgnoreCase("quit"))
	    {
	    	if (cmd.equalsIgnoreCase("enqueue"))
	    	{
	    		q.enqueue(scan.next());
	    	}
	    	else if (cmd.equalsIgnoreCase("dequeue"))
	    	{
	    		System.out.println("Dequeued: "+q.dequeue());
	    	}
	    	else if (cmd.equalsIgnoreCase("size"))
	    	{
	    		System.out.println("Size: "+q.size());
	    	}
	    	else if (cmd.equalsIgnoreCase("isEmpty"))
	    	{
	    		System.out.println("IsEmpty: "+q.isEmpty());
	    	}
	    	else if (cmd.equalsIgnoreCase("isFull"))
	    	{
	    		System.out.println("IsFull: "+q.isFull());
	    	}
	    	
	    	//Show what the queue looks like
	    	System.out.println("Contents:\n\t"+q.toString());
	    }
	}
}
