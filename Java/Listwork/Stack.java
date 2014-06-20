//Jonathan Chu
//Stack PA1

/**
 * A basic implementation of a Stack
 */
public class Stack {
	//this array will store the data in the stack
	Object array[];
	int head = -1;
	int tail = -1;
	
	
	/**
	 * The default empty constructor. This initializes the max capacity
	 * of the stack to be 10.
	 */
	public Stack()
	{
		array = new Object[10];
	}
	
	
	
	/**
	 * This constructor initializes the max capacity of the stack to
	 * be the specified value.
	 * @param capacity - The capacity of the stack.
	 */
	public Stack(int capacity)
	{
		array = new Object[capacity];
	}
	
	
	
	/**
	 * Pushes a new item onto the top of the stack
	 * @param item - the item to push
	 */
	public void Push(Object item)
	{
		if(IsEmpty()){
			head++;
			tail++;
			array[head] = item;
		}
		else if(!IsFull()){
			head++;
			array[head] = item;
		}
	}
	
	
	
	/**
	 * Pops an item from the stack.
	 * @return the item that was previously on top of the stack
	 */
	public Object Pop()
	{
		if(!IsEmpty()){
			Object popped = array[head];
			array[head] = null;
			head--;
			return popped;
		}
		else
			return null;
	}

	
	
	/**
	 * Peeks at the top item on the stack without popping it.
	 * @return the top item of the stack
	 */
	public Object Peek()
	{
		if(!IsEmpty())
			return array[head];
		else
			return null;
	}
	
	
	
	/**
	 * Tests whether the stack is empty.
	 * @return true if empty, false if not
	 */
	public boolean IsEmpty()
	{
		//replace the following line with desired output
		if(this.head == -1 || this.array[head] == null) {
			return true;
		}
		else{
			return false;
		}
	}
	public boolean IsFull() 
	{
		if(tail == array.length - 1)
			return true;
		else
			return false;
	}
}
