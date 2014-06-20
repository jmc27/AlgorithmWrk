import java.util.ArrayList;

public class PriorityScheduler implements Anthill{
	ArrayList<Animal> waiting0 = new ArrayList<Animal>();
	ArrayList<Animal> waiting1 = new ArrayList<Animal>();
	ArrayList<Animal> waiting2 = new ArrayList<Animal>();
	ArrayList<Animal> waiting3 = new ArrayList<Animal>();
	ArrayList<Animal> waiting4 = new ArrayList<Animal>();
	private int currpriority;
	ArrayList<BasicAnthill> anthills;
	boolean eatingspace = true;
	String name;
	public PriorityScheduler(ArrayList<BasicAnthill> anthills) {
		this.anthills = anthills;
	}
	@Override
	public boolean tryToEatAtWithAnimal(Animal animal) {
		add(animal);
		setpriority();
		
		if(animal.getPriority() < currpriority) {
			try {
				animal.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		boolean room = anthillsfull(animal);
		if(room) {
			try {
				animal.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		else {
			remove(animal);
			return true;
		}
	}
	public void remove(Animal animal) {
		if(animal.getPriority() == 4)
			waiting4.remove(animal);
		else if(animal.getPriority() == 3)
			waiting3.remove(animal);
		else if(animal.getPriority() == 2)
			waiting2.remove(animal);
		else if(animal.getPriority() == 1)
			waiting1.remove(animal);
		else
			waiting0.remove(animal);
	}
	public boolean anthillsfull(Animal animal) {
		int numfull = 0;
		boolean flag = false;
		int i = 0;
		while(numfull != anthills.size() && !flag) {
			flag = anthills.get(i).tryToEatAtWithAnimal(animal);
			if(!flag){
				numfull++;
				i++;
			}
			else
				flag = true;
		}
		if(numfull == anthills.size())
			return true;
		else
			return false;
	}
	public void setpriority() {
		if(!waiting4.isEmpty())
			currpriority = 4;
		else if(!waiting3.isEmpty())
			currpriority = 3;
		else if(!waiting2.isEmpty())
			currpriority = 2;
		else if(!waiting1.isEmpty())
			currpriority = 1;
		else
			currpriority = 0;
	}
	public void add(Animal animal) {
		if(animal.getPriority() == 4)
			waiting4.add(animal);
		else if(animal.getPriority() == 3)
			waiting3.add(animal);
		else if(animal.getPriority() == 2)
			waiting2.add(animal);
		else if(animal.getPriority() == 1)
			waiting1.add(animal);
		else
			waiting0.add(animal);
	}
	@Override
	public void exitAnthillWithAnimal(Animal animal) {
		
		for(int i = 0; i < anthills.size(); i++) {
			
				anthills.get(i).exitAnthillWithAnimal(animal);
				animal.notifyAll();
		}
	}

	@Override
	public int antsLeft() {
		int numants = 0;
		for(int i = 0; i < anthills.size(); i++) {
			numants += anthills.get(i).antsLeft();
		}
		return numants;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
