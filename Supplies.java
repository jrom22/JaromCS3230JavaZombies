package zombies;


public class Supplies 
{
	private Weapon item;
	private Food dinner;
	boolean hasWater;
	
	public Supplies()
	{
		
	}
	
	
	public void obtainMedKit(int strength)
	{
		strength+=50;
	}


	public Weapon getItem()
	{
		return item;
	}


	public void setItem(Weapon item)
	{
		this.item = item;
	}


	public Food getDinner()
	{
		return dinner;
	}


	public void setDinner(Food dinner)
	{
		this.dinner = dinner;
	}


	public boolean isHasWater()
	{
		return hasWater;
	}


	public void setHasWater(boolean hasWater)
	{
		this.hasWater = hasWater;
	}
	
	
	
}
