//Jonathan Chu
//Postfix calculator

import java.util.Scanner;

/**
 * An implementation of a postfix calculator
 */
public class PostfixCalculator {
	
	/**
	 * The implementation of a postfix calculator
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String line;
		
		//Initialize a stack used for calculation
		Stack stack = new Stack();
		//Push postfix input onto a stack
		while (!(line = scan.nextLine()).equalsIgnoreCase("quit"))
		{
			//Check for various inputs: +,-,*,/,double,clear (Use Double.parseDouble())
			//When the user enters an operator the current value of the equation
			//should be displayed.
			if (line.equals("+"))
			{
				double one = Double.parseDouble((String) stack.Pop());
				double two = Double.parseDouble((String) stack.Pop());
				one = one + two;
				stack.Push(one);
				System.out.println(one);
			}
			else if(line.equals("-")) {
				double one = Double.parseDouble((String) stack.Pop());
				double two = Double.parseDouble((String) stack.Pop());
				one = one - two;
				stack.Push(one);
				System.out.println(one);
			}
			else if(line.equals("*")) {
				double one = Double.parseDouble((String) stack.Pop());
				double two = Double.parseDouble((String) stack.Pop());
				one = one * two;
				stack.Push(one);
				System.out.println(one);
			}
			else if(line.equals("/")) {
				double one = Double.parseDouble((String) stack.Pop());
				double two = Double.parseDouble((String) stack.Pop());
				one = one / two;
				stack.Push(one);
				System.out.println(one);
			}
			else{
				stack.Push(line);
			}
		}
	}
	
}
