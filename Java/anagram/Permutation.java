/* 
Jonathan Chu
This class does permutations of strings
*/
import java.util.*;

public class Permutation{
	private String input;
	ArrayList<String> permutations;
	public Permutation() {
		permutations = new ArrayList<String>();
	}
	public Permutation(String str) {
		permutations = new ArrayList<String>();
		input = str;
		permutation(input);
	}

	public void permutation(String str) {
		permutation("", str);
	}
	//displays all the permutations
	public void display() {
		Iterator<String> it = permutations.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	private void permutation(String prefix, String str) {
		int n = str.length();
		if(n == 0)
			permutations.add(prefix);
		else {
			for(int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}
}