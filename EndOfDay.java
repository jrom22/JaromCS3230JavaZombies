package zombies;

public class EndOfDay {
	protected int daysToSpoil;
	protected int strength;
	
	//End of day method that will do all work to be done such as days to spoil and gathering supplies
	public void endOfDay()
	{
		daysToSpoil-=1;
		strength-=10;
	}
}
