package zombies;

import java.util.Random;

public class Supplies 
{
	private Weapon item;
	private Food dinner;
	boolean hasWater;
	
	public Supplies()
	{
		
	}
	
	//Human obtains a medkit and is healed for 50 strength
	public void obtainMedKit(int strength)
	{
		strength+=50;
	}

	//Getter for Item
	public Weapon getItem()
	{
		return item;
	}

	//Setter for Item
	public void setItem(Weapon item)
	{
		this.item = item;
	}

	//Getter for Dinner
	public Food getDinner()
	{
		return dinner;
	}

	//Setter for Dinner
	public void setDinner(Food dinner)
	{
		this.dinner = dinner;
	}

	//Getter for Water
	public boolean isHasWater()
	{
		return hasWater;
	}

	//Setter for Water
	public void setHasWater(boolean hasWater)
	{
		this.hasWater = hasWater;
	}
	
	
	
}
