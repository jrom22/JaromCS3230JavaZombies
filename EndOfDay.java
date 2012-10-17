package zombies;

public class EndOfDay {
	protected int daysToSpoil;
	protected int strength;
	
	public void endOfDay()
	{
		daysToSpoil-=1;
		strength-=10;
	}
}
