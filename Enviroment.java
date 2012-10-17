package zombies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enviroment implements Runnable
{
	private int days;
	private int humans;
	private int zombies;
	
	public Enviroment(String days, String humans, String zombies)
	{
		this.days = Integer.parseInt(days);
		this.humans = Integer.parseInt(humans);
		this.zombies = Integer.parseInt(zombies);
	}
	

	public void run() 
	{
		List<Person> humanList = SetUpHumans();
		List<Person> zombieList = SetUpZombies();
		
		StartSimulation(zombieList, humanList);
		
	}
	
	private List<Person> SetUpZombies()
	{
		List<Person> zombiesList = new ArrayList<Person>();
		
		for(int i = 0; i <= zombies; i++)
		{
			zombiesList.add(new Zombie("Asian","5:10",true,100,25,100));
		}
		
		return zombiesList;
		
	}
	
	private List<Person> SetUpHumans()
	{
		Random r = new Random();
		
		List<Person> humanList = new ArrayList<Person>();
		
		for(int i = 0; i <= humans; i++)
		{
			int randomNum = r.nextInt(3) + 1;
			switch (randomNum)
			{
				case 1:
					humanList.add(new Military("White", "6:2", true, 100,25,100));
					break;
				case 2:
					humanList.add(new Civilian("Hispanic", "5:5", true, 100,25,100));
					break;
				case 3:
					humanList.add(new Scientist("Asian", "5:2", false, 100,25,100));
					break;
			}
			
		}
		return humanList;
	}
	
	private void StartSimulation(List<Person> zombieList, List<Person> humanList )
	{
		while (days != 0)
		{
			Random r = new Random();
			int indexForZombie = r.nextInt(zombieList.size()) + 1;
			int indexForHuman = r.nextInt(humanList.size()) + 1;
			Fight(zombieList.get(indexForZombie) , humanList.get(indexForHuman));
			
			EndOfdayProcessing();
		}
	}
	
	private void Fight(Person zombie, Person human)
	{
		//this is where we will have all of our predetermine conditions to determine who will win.
		//will return a value indicating who one
		//note if human was bitten the boolean indicator will be updated
		
	}
	
	private void EndOfdayProcessing()
	{
		//slowly humans that are bitten into Zombie
	}
}
	
	

