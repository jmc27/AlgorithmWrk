//Jonathan Chu
//Hash table PA3
public class HashTable {
	public int size;
	Record[] hashtable;
	int n;
	//inner class of record to be stored in hashtable
	public class Record {
		int key;
		Process value;
		boolean flag;
		public Record(Process p, int key) {
			this.value = p;
			this.key = key;
			flag = true;
		}
		public String toString() {
			if(value == null)
				return "null";
			else
				return "Key: " + key + " of Process " + value.toString();
		}
	}
	//constructs hash table of size 2029 as specified
	public HashTable(int size) {
		this.size = size;
		hashtable = new Record[size];
		n = 0;
	}
	//calculate load factor of the hashtable
	public double loadfactor(){
		return n / size;
	}
	//hash function
	//I chose this hash function because it was recomended in the slides
	//I tried a few other but this one allows for everything to be hashed 
	//successfully with a loadfactor less than .7
	//I chose 1201 because its a prime number about half the size of 2029
	public int hashf(Process p, int i) {
		return (p.getID() % size) + i * (1201 - (p.getID() % 1201)) % size;
	}
	//Using double hashing this function creates a key for a process
	public int createKey(Process p) {
		int i = 0;
		int key;
		do{
			key = hashf(p, i);
			//System.out.println(key);
			if(hashtable[key] == null || hashtable[key].value == null) {
				return key;
			}
			else
				i = i + 1;
		}while(i != size);
		return -1;
	}
	//add process to hashtable
	public void add(Process p) {
		if(loadfactor() < .5) {
			int key = createKey(p);
			if(key != -1)
				hashtable[key] = new Record(p, key);
			n++;
		}
		else {
			rehash();
			add(p);
		}
	}
	//rehashes who loadfactor is too large
	public void rehash() {
		HashTable rehash = new HashTable(size * 2);
		for(int i = 0; i < hashtable.length; i++) {
			if(hashtable[i].value != null)
				rehash.add(hashtable[i].value);
		}
		hashtable = rehash.hashtable;
		this.size = size * 2;
		this.n = rehash.n;
	}
	//Searches for a process and returns the record of it
	//in the hashtable or null if it is not found
	public Record search(Process p) {
		int i = 0;
		int key;
		if(loadfactor() > .7)
			rehash();
		do{
			key = hashf(p, i);
			if(hashtable[key] != null && hashtable[key].value != null && hashtable[key].value.equals(p))
				return hashtable[key];
			else
				i = i + 1;
		}while(i != size && hashtable[key] != null);
		return null;
	}
	//deletes a process from the hashtable
	public void delete(Process p) {
		Record delete = search(p);
		if(delete != null){
			hashtable[delete.key].value = null;
		}
	}
}
