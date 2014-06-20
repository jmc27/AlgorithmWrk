import java.util.ArrayList;


public class Test2 {
	public static void main(String[] args) {
		ArrayList<BasicAnthill> anthills = new ArrayList<BasicAnthill>();
		for(int i = 0; i < 2; i++) {
			anthills.add(new BasicAnthill("" + i, 100));
		}
		PriorityScheduler scheduler = new PriorityScheduler(anthills);
		ArrayList<Aardvark> aardvarks = new ArrayList<Aardvark>();
		for(int i = 0; i < 150; i++) {
			aardvarks.add(new Aardvark(i + "-Aardvark", scheduler));
			aardvarks.get(i).setPriority(i % 5);
		}
		ArrayList<Anteater> anteaters = new ArrayList<Anteater>();
		for(int i = 150; i < 201; i ++) {
			Anteater a = new Anteater(i + "-Anteater", scheduler);
			a.setPriority(i % 5);
			anteaters.add(a);
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
