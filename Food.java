package zombies;

public class Food
{
	//Variables
	private boolean spoils;
	private int daysToSpoil;
	
	//Constructor
	public Food(boolean spoils, int daysToSpoil)
	{
		this.spoils = spoils;
		this.daysToSpoil = daysToSpoil;
	}
	
	//Getter for spoils of food
	public boolean GetSpoils()
	{
		return spoils;
	}
	
	//Gets days to spoil for food
	public int GetDaysToSpoil()
	{
		return daysToSpoil;
	}
	
	//Reduces the days till spoil for food by one if the food is perishable
	public void ReduceDays()
	{ 
		if(spoils)
		{
			daysToSpoil--;
		}
	}
}
