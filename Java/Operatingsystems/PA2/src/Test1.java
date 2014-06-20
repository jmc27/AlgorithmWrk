//Jonathan Chu
//Test1 class for part 1 of PA2
import java.util.ArrayList;


public class Test1 {
	public static void main(String[] args) {
		ArrayList<Anthill> anthills = new ArrayList<Anthill>();
		for(int i = 0; i < 4; i++) {
			anthills.add(new BasicAnthill("" + i, 50));
		}
		ArrayList<Aardvark> aardvarks = new ArrayList<Aardvark>();
		for(int i = 0; i < 150; i++) {
			aardvarks.add(new Aardvark(i + "-Aardvark", anthills));
		}
		ArrayList<Anteater> anteaters = new ArrayList<Anteater>();
		for(int i = 150; i < 201; i ++) {
			anteaters.add(new Anteater(i + "-Anteater", anthills));
		}
		for(int i = 0; i < 50; i++) {
			Thread t = new Thread(aardvarks.get(i));
			t.start();
		}
		for(int i = 0; i < 50; i++) {
			Thread t = new Thread(anteaters.get(i));
			t.start();
		}
		for(int i = 50; i < 150; i ++) {
			Thread t = new Thread(aardvarks.get(i));
			t.start();
		}
	}
}
