package zombies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enviroment implements Runnable
{
	//Set Variables
	private int days;
	private int humans;
	private int zombies;
	
	//Take user's input from interface and parse as int
	public Enviroment(String days, String humans, String zombies)
	{
		this.days = Integer.parseInt(days);
		this.humans = Integer.parseInt(humans);
		this.zombies = Integer.parseInt(zombies);
	}

	//Create list of Humans and Zombies then start battles between Humans and Zombies
	public void run() 
	{
		List<Human> humanList = SetUpHumans();
		List<Zombie> zombieList = SetUpZombies();
		StartSimulation(zombieList, humanList);
	}
	
	//Creates a list of Zombies that is as big as user's input and returns it for use
	private List<Zombie> SetUpZombies()
	{
		List<Zombie> zombiesList = new ArrayList<Zombie>();
		
		for(int i = 0; i <= zombies; i++)
		{
			zombiesList.add(new Zombie("Asian","5:10",true,100,25,100));
		}
		return zombiesList;
	}
	
	//Creates a list of Humans that is as big as user's input and returns it for use
	private List<Human> SetUpHumans()
	{
		Random r = new Random();	
		List<Human> humanList = new ArrayList<Human>();
		for(int i = 0; i <= humans; i++)
		{
			//Randomly select whether Human is Military, Civilian, or Scientist
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
	
	//Zombie VS Human simulation
	private void StartSimulation(List<Zombie> zombieList, List<Human> humanList )
	{
		Random r = new Random();
		//Loop through each day and pitch battles each day between Humans and Zombies
		while (days != 0)
		{
			for(int i = r.nextInt(10); i > 0; i-- )
			{
				int indexForZombie = r.nextInt(zombieList.size()) + 1;
				int indexForHuman = r.nextInt(humanList.size()) + 1;
				//Make Zombie and Human fight, remove loser from appropriate list
				switch(Fight(zombieList.get(indexForZombie) , humanList.get(indexForHuman)))
				{
					case 0:
						zombieList.remove(indexForZombie);
						break;
					case 1:
						humanList.remove(indexForHuman);
						break;
				}
			}
			//Run End of day processing to account for bitten Humans, Days, Supplies, and Healing
			EndOfdayProcessing(zombieList, humanList);
			days--;
		}
		//Simulation is finished, display who won
		System.out.println("It is over.....");
	}
	
	//Zombie VS Human fight 1vs1
	private int Fight(Zombie zombie, Human human)
	{
		//Randomly select whether Human or Zombie attacks first
		Random r = new Random();
		//Determine whether Human has a Melee Weapon or Ranged Weapon for battle
		if(human.GetWeapon().GetIsMelee())
		{
			//If random number ==2 then Human attacks first
			if(r.nextInt(2) + 1 == 2)
			{
				//Zombie takes damage from Human equivalent to weapon damage plus modifiers
				zombie.setStrength(human.GetWeapon().GetDamage());
				//Checks to see if Zombie is alive before attacking Human
				if(zombie.getStrength() > 0)
				{
					//Zombie attack reduces life of Human by 20
					human.setStrength(human.getStrength() - 20);
				}
				//Checks to see if Human is alive before attacking Zombie
				if(human.getStrength() > 0)
				{
					//Zombie takes damage from Human equivalent to weapon damage plus modifiers
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
				//Checks to see if Zombie is alive before attacking Human
				if(zombie.getStrength() > 0)
				{
					//Zombie attack reduces life of Human by 20
					human.setStrength(human.getStrength() - 20);
				}
			}
			else
			{
				//If random number is not ==2 then Zombie attacks first
				//Zombie attack reduces life of Human by 20
				human.setStrength(human.getStrength() - 20);
				//Checks to see if Human is alive before attacking Zombie
				if(human.getStrength() > 0)
				{
					//Zombie takes damage from Human equivalent to weapon damage plus modifiers
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
				//Checks to see if Zombie is alive before attacking Human
				if(zombie.getStrength() > 0)
				{
					//Zombie attack reduces life of Human by 20
					human.setStrength(human.getStrength() - 20);
				}
				//Checks to see if Human is alive before attacking Zombie
				if(human.getStrength() > 0)
				{
					//Zombie takes damage from Human equivalent to weapon damage plus modifiers
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
			}
		}
		else // Is a Ranged attack
		{
			//If Random number is ==2 then Human attacks first
			if(r.nextInt(2) + 1 == 2)
			{
				//Since attack is ranged, repeat attack equivalent to range of weapon
				for(int i = 0; i < human.GetWeapon().GetRange(); i++)
				{
					//Zombie takes damage from Human equivalent to weapon damage plus modifiers
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
				//Checks to see if Zombie is alive before attacking Human
				if(zombie.getStrength() > 0)
				{
					//Zombie attack reduces life of Human by 20
					human.setStrength(human.getStrength() - 20);
				}
			}
			else//Zombie attacks first
			{
				//Zombie attack reduces life of Human by 20
				human.setStrength(human.getStrength() - 20);
				//Checks to see if Human is alive before attacking Zombie
				if(human.getStrength() > 0)
				{
					//Since attack is ranged, repeat attack equivalent to range of weapon
					for(int i = 0; i < human.GetWeapon().GetRange(); i++)
					{
						//Zombie takes damage from Human equivalent to weapon damage plus modifiers
						zombie.setStrength(human.GetWeapon().GetDamage());
					}
				}
			}
		}
		
		
		//Zombie gets a chance to bite Human and turn Human into a Zombie
		//Test to see if both Human and Zombie are still alive
		if(human.getStrength() > 0 && zombie.getStrength() > 0 )
		{
			//If Zombie's health is 25 or less Zombie will bite
			boolean okToBite = zombie.getStrength() <= 25;
			
			//Randomly select who attacks first, if random num == 2 Human attacks one last time
			if(r.nextInt(2) + 1 == 1)
			{
				//Zombie takes damage from Human equivalent to weapon damage plus modifiers
				zombie.setStrength(human.GetWeapon().GetDamage());
				
				//If the Zombie is still alive and can bite
				if(okToBite && zombie.getStrength() > 0)
				{
					//50 percent chance Zombie will bite.
					if(r.nextInt(2) + 1 == 2)
					{
						human.GotBitten();
					}
				}
			}
			else//Random number is == 1 and Zombie attacks first
			{
				//If the Zombie is still alive and can bite
				if(okToBite && zombie.getStrength() > 0)
				{
					//If the Zombie is still alive and can bite
					if(r.nextInt(2) + 1 == 2)
					{
						human.GotBitten();
					}
				}
				//Zombie takes damage from Human equivalent to weapon damage plus modifiers
				zombie.setStrength(human.GetWeapon().GetDamage());
			}
		}
		
		
		//Test to see if Zombie died and set flag
		if(zombie.getStrength() < 0)
		{
			return 1;
		}
		//Test to see if Human died and set flag
		else if(human.getStrength() < 0)
		{
			return 0;
		}
		//Test to see if Human was bitten by Zombie and set flag
		else
		{
			return 2;
		}
	}
	
	//Battle is over and the End of Day Processing begins
	private void EndOfdayProcessing(List<Zombie> zombieList, List<Human> humanList )
	{
		for(Human h : humanList)
		{
			//Check to see if Human was bitten
			if(h.hasBeenBitten())
			{
				//If Human was bitten, remove Human from Human list and add a Zombie to the Zombie list
				humanList.remove(h);
				zombieList.add(new Zombie(h.getRace(), h.getHeight(),h.isMale(),100,h.getAge(),h.getSpeed()));
			}
		}
	}
}
	
	

