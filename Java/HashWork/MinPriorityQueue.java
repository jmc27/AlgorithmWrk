//Jonathan Chu
//Min priority queue PA3
public class MinPriorityQueue {
	HashTable table;
	Process[] queue;
	int end;
	public final int size;
	public MinPriorityQueue(int size){
		this.size = size;
		queue = new Process[size];
		table = new HashTable(size);
		end = -1;
	}
	//extracts the process with smallest priority and deletes it
	//must heapify down
	//dequeue
	public Process extractMin() {
		if(isEmpty()){
			System.err.println("Queue is empty");
			return null;
		}
		Process min = queue[0];
		queue[0] = queue[end];
		queue[end] = null;
		end--;
		if(!isEmpty())
			heapifyD(0);
		table.delete(min);
		return min;
	}
	//insert process and heapify up to maintain
	//the min priority queue
	//enqueue
	public void insert(Process p) {
		if(table.search(p) == null){
			end++;
			queue[end] = p;
			heapifyU(end);
			table.add(p);
		}
	}
	//checks if queue is empty
	public boolean isEmpty(){
		if(end == -1)
			return true;
		else
			return false;
	}
	//heapify down
	public void heapifyD(int index) {
		int left = (index + 1) * 2 - 1;
		int right = (index + 1) * 2;
		int min;
		if(left <= end && queue[left].getpriority() < queue[index].getpriority())
			min = left;
		else
			min = index;
		if(right <= end && queue[right].getpriority() < queue[min].getpriority())
			min = right;
		if(min != index){
			Process temp = queue[index];
			queue[index] = queue[min];
			queue[min] = temp;
			heapifyD(min);
		}
	}
	//heapify up
	public void heapifyU(int index) {
		while(index > 0 && queue[index].getpriority() < queue[parent(index)].getpriority()) {
			Process temp = queue[parent(index)];
			queue[parent(index)] = queue[index];
			queue[index] = temp;
			index = parent(index);
		}
	}
	//get index of parent
	public int parent(int index){
		if(index == 0)
			return -1;
		else
			return (index + 1) / 2 - 1;
		
	}
	
}
