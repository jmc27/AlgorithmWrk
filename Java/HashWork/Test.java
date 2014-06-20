//Jonathan Chu
//Print process PA3
/*
 * Note: My MinPriorityQueue class has a hashtable as a field and its
 * size is set to the same size as the Process[] field So in order to show
 * that my hashtable can rehash I create a seperate hashtable of size 2029
 * as the hw instructs. Every process is added to the min priority queue
 * and this hash table.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		HashTable table = new HashTable(2029);
		MinPriorityQueue queue = new MinPriorityQueue(630000 * 2);
		int id;
		int priority;
		String name;
		File processes = new File("/Users/jchu/Desktop/fall2013/datastruct/PA3/src/Process.txt");
		try {
			Scanner reader = new Scanner(processes);
			while(reader.hasNextLine()) {
				id = reader.nextInt();
				priority = reader.nextInt();
				name = reader.nextLine();
				//store each process in a process object
				Process p = new Process(id, priority, name);
				System.out.println(p.toString());
				//check if its a duplicate
				if(table.search(p) == null) {
					table.add(p);
					queue.insert(p);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dequeue each process and print the name a priority
		while(!queue.isEmpty()){
			Process min = queue.extractMin();
			table.delete(min);
			System.out.println(toString(min));
		}
	}
	
	public static String toString(Process p){
		return "Name: " + p.getName() + " | Priority: " + p.getpriority();
	}
}
