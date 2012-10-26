package zombies;

import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JLabel;

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
		Random r = new Random();
		List<EndOfDayResults> results = new ArrayList<EndOfDayResults>();
		while (days != 0)
		{
			int numberOfHumansKilled = 0;
			int numberOfZombiesKilled = 0;
			for(int i = r.nextInt(10); i > 0; i-- )
			{
				if(zombieList.size() > 0 && humanList.size() > 0)
				{
					int indexForZombie = r.nextInt(zombieList.size());
					int indexForHuman = r.nextInt(humanList.size());
					switch(Fight(zombieList.get(indexForZombie) , humanList.get(indexForHuman)))
					{
						case 0:
							zombieList.remove(indexForZombie);
							numberOfZombiesKilled++;
							break;
						case 1:
							humanList.remove(indexForHuman);
							numberOfHumansKilled++;
							break;
					}
				}
				else
				{
					break;
				}
			}
			
			results.add(EndOfdayProcessing(zombieList, humanList, numberOfZombiesKilled, numberOfHumansKilled));
			days--;
		}
		System.out.println("It is over.....");
		
		JFrame endOfSimulation = new JFrame();
		endOfSimulation.setTitle("Zombie Attack is Over!");
		endOfSimulation.setSize(700, 500 );
		endOfSimulation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = endOfSimulation.getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        int numberOfDays = 1;
		for(EndOfDayResults item : results)
		{
			contentPane.add(new JLabel("Day " + numberOfDays + ":" + " The number of humans killed: " + item.getNumberOfHumansKilled() + " The number of humans turned to zombies: " + item.getNumberOfHumansTurned() +  " The number of zombies killed: " + item.getNumberOfZombiesKilled()));		
			numberOfDays++;
		}
		
		contentPane.add(new JLabel("----------------------------------------------------------------------------------------------------------------------------------------"));
		
		contentPane.add(new JLabel("The number of humans that remain is: " + humanList.size()));
		
		contentPane.add(new JLabel("----------------------------------------------------------------------------------------------------------------------------------------"));
		contentPane.add(new JLabel("The number of zombies that remain is: " + zombieList.size()));
		
		endOfSimulation.setVisible(true);
	}
	
	private int Fight(Zombie zombie, Human human)
	{
		Random r = new Random();
		if(human.GetWeapon().GetIsMelee())
		{
			if(r.nextInt(2) + 1 == 2)
			{
				zombie.setStrength(human.GetWeapon().GetDamage());
				if(zombie.getStrength() > 0)
				{
					human.setStrength(human.getStrength() - 20);
				}
				if(human.getStrength() > 0)
				{
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
				if(zombie.getStrength() > 0)
				{
					human.setStrength(human.getStrength() - 20);
				}
			}
			else
			{
				
				human.setStrength(human.getStrength() - 20);
				if(human.getStrength() > 0)
				{
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
				if(zombie.getStrength() > 0)
				{
					human.setStrength(human.getStrength() - 20);
				}
				if(human.getStrength() > 0)
				{
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
			}
		}
		else // is ranged 
		{
			if(r.nextInt(2) + 1 == 2)
			{
				for(int i = 0; i < human.GetWeapon().GetRange(); i++)
				{
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
				
				human.setStrength(zombie.getStrength() - 20);
			}
			else
			{
				human.setStrength(human.getStrength() - 20);
				
				for(int i = 0; i < human.GetWeapon().GetRange(); i++)
				{
					zombie.setStrength(human.GetWeapon().GetDamage());
				}
			}
		}
		
		if(human.getStrength() > 0 && zombie.getStrength() > 0 )
		{
			boolean okToBite = zombie.getStrength() <= 25;
			
			if(r.nextInt(2) + 1 == 2)
			{
				zombie.setStrength(human.GetWeapon().GetDamage());
				
				if(okToBite && zombie.getStrength() > 0)
				{
					if(r.nextInt(2) + 1 == 2)
					{
						human.GotBitten();
					}
				}
			}
			else
			{
				if(okToBite && zombie.getStrength() > 0)
				{
					if(r.nextInt(2) + 1 == 2)
					{
						human.GotBitten();
					}
				}
				
				zombie.setStrength(human.GetWeapon().GetDamage());
			}
		}
		
		if(zombie.getStrength() < 0)
		{
			return 1;
		}
		else if(human.getStrength() < 0)
		{
			return 0;
		}
		else
		{
			return 2;
		}
	}
	
	private EndOfDayResults EndOfdayProcessing(List<Zombie> zombieList, List<Human> humanList, int numberOfZombiesKilled, int numberOfHumansKilled)
	{
		int numberOfHumansConverted = 0;
		List<Integer> indexofHUmantoRemove = new ArrayList<Integer>();
		int index = 0;
		for(Human h : humanList)
		{
			if(h.hasBeenBitten())
			{
				indexofHUmantoRemove.add(index);
				zombieList.add(new Zombie(h.getRace(), h.getHeight(),h.isMale(),100,h.getAge(),h.getSpeed()));
				numberOfHumansConverted++;
			}
			index++;
		}
		
		for(int n : indexofHUmantoRemove)
		{
			humanList.remove(n);
		}
		
		return new EndOfDayResults(numberOfZombiesKilled, numberOfHumansKilled, numberOfHumansConverted);
		
	}
}
	
	

