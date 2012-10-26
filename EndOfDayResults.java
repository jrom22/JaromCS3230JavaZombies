package zombies;

public class EndOfDayResults
{
	private int NumberOfZombiesKilled;
	private int NumberOfHumansKilled;
	private int NumberOfHumansTurned;
	
	public int getNumberOfHumansTurned()
	{
		return NumberOfHumansTurned;
	}

	public int getNumberOfZombiesKilled()
	{
		return NumberOfZombiesKilled;
	}

	public int getNumberOfHumansKilled()
	{
		return NumberOfHumansKilled;
	}

	
	public EndOfDayResults(int numberOfZombiesKilled, int numberOfHumansKilled, int numberOfHumansTurned)
	{
		NumberOfHumansKilled = numberOfHumansKilled;
		NumberOfHumansTurned = numberOfHumansTurned;
		NumberOfZombiesKilled = numberOfZombiesKilled;
		
	}
	

}
