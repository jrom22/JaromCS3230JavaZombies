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
		List<Human> humanList = SetUpHumans();
		List<Zombie> zombieList = SetUpZombies();
		
		StartSimulation(zombieList, humanList);
		
	}
	
	private List<Zombie> SetUpZombies()
	{
		List<Zombie> zombiesList = new ArrayList<Zombie>();
		
		for(int i = 0; i <= zombies; i++)
		{
			zombiesList.add(new Zombie("Asian","5:10",true,100,25,100));
		}
		
		return zombiesList;
		
	}
	
	private List<Human> SetUpHumans()
	{
		Random r = new Random();
		
		List<Human> humanList = new ArrayList<Human>();
		
		for(int i = 0; i <= humans; i++)
		{
			int randomNum = r.nextInt(3) + 1;
			switch (randomNum)
			{
				case 1:
					humanList.add(new Military("White", "6:2", true, 150,25,150));
					break;
				case 2:
					humanList.add(new Civilian("Hispanic", "5:5", true, 100,25,100));
					break;
				case 3:
					humanList.add(new Scientist("Asian", "5:2", false, 80,25,80));
					break;
			}
			
		}
		return humanList;
	}
	
	private void StartSimulation(List<Zombie> zombieList, List<Human> humanList )
	{
		while (days != 0)
		{
			Random r = new Random();
			int indexForZombie = r.nextInt(zombieList.size()) + 1;
			int indexForHuman = r.nextInt(humanList.size()) + 1;
			Fight(zombieList.get(indexForZombie) , humanList.get(indexForHuman));
			
			EndOfdayProcessing(zombieList, humanList);
		}
	}
	
	private void Fight(Zombie zombie, Human human)
	{
		if(human.GetWeapon().GetIsMelee())
		{
			zombie.setStrength(human.GetWeapon().GetDamage());
			human.setStrength(human.getStrength() - 20);
			zombie.setStrength(human.GetWeapon().GetDamage());
			human.setStrength(human.getStrength() - 20);
		}
		else
		{
			for(int i = 0; i < human.GetWeapon().GetRange(); i += 5)
			{
				zombie.setStrength(human.GetWeapon().GetDamage());
			}
			
			human.setStrength(human.getStrength() - 20);
			
		}
		
		if(zombie.getSpeed() > human.getSpeed())
		{
			human.GotBitten();
		}
		else
		{
			zombie.setStrength(zombie.getStrength() - 10);
		}
		
		if(zombie.isMale() && !human.isMale() && human.getStrength() < zombie.getStrength())
		{
			human.GotBitten();
		}
		else
		{
			zombie.setStrength(zombie.getStrength() -15);
		}
		
	}
	
	private void EndOfdayProcessing(List<Zombie> zombieList, List<Human> humanList )
	{
		for(Zombie z : zombieList)
		{
			if(z.getStrength() < 1)
			{
				zombieList.remove(z);
			}
		}
		
		for(Human h : humanList)
		{
			if(h.getStrength() < 1)
			{
				humanList.remove(h);
			}
		}
	}
}
	
	

