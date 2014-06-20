import java.util.ArrayList;


public class BasicAnthill implements Anthill{
	String name;
	int numAnts;
	ArrayList<Animal> eating;
	public BasicAnthill(String name, int numAnts) {
		setName(name);
		this.numAnts = numAnts;
		eating = new ArrayList<Animal>();
	}
	@Override
	public boolean tryToEatAtWithAnimal(Animal animal) {
		if(eating.isEmpty()) {
			eating.add(animal);
			System.out.println(animal.getName() + " has started eating at " + this.name + " with priority " + animal.getPriority());
			return true;
		}
		else if (animal.getName().contains("Anteater") && !eating.isEmpty())
			return false;
		else if (eating.size() == 1 && eating.get(0).getName().contains("Anteater"))
			return false;
		else if (animal.getName().contains("Aardvark") && eating.size() < 3) {
			eating.add(animal);
			System.out.println(animal.getName() + " has started eating at " + this.name + " with priority " + animal.getPriority());
			return true;
		}
		else
			return false;
	}

	@Override
	public void exitAnthillWithAnimal(Animal animal) {
		System.out.println(animal.getName() + " has eaten at " + this.name + " with priority " + animal.getPriority());
		eating.remove(animal);
	}

	@Override
	public int antsLeft() {
		// TODO Auto-generated method stub
		return numAnts;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}
