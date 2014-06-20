/*
 * Jonathan Chu
 * PA 3
 * This is the Process object class
 * Can be constructed and return all its values
 */
public class Process {
	int id = 0;
	int priority = 0;
	String name;
	public Process(int id, int priority, String name) {
		this.id = id;
		this.priority = priority;
		this.name = name;
	}
	public int getID() {
		return id;
	}
	public int getpriority() {
		return priority;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String toString() {
		return("ID: " + id + " | Priority: " + priority + " | Name: " + name);
	}
}
