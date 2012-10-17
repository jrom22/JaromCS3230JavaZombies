package zombies;

public class Food
{
	//Fields
	private boolean spoils;
	private int daysToSpoil;
	
	//Constructor
	public Food(boolean spoils, int daysToSpoil)
	{
		this.spoils = spoils;
		this.daysToSpoil = daysToSpoil;
	}
	
	public boolean GetSpoils()
	{
		return spoils;
	}
	
	public int GetDaysToSpoil()
	{
		return daysToSpoil;
	}
	
	public void ReduceDays()
	{ 
		if(spoils)
		{
			daysToSpoil--;
		}
	}
}
