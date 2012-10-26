package zombies;

public class Human extends Person 
{
	private Supplies items;
	private boolean isBitten;
	
	//Create new human object
	public Human()
	{
		items = new Supplies();
		setRace("Caucasian");
		setHeight("6\"3'");
		setMale(true);
		setStrength(100);
		setAge(27);
		setSpeed(100);
		items.setItem(new Weapon());
		isBitten = false;
	}
	
	public Human(String race, String height, boolean isMale, int strength, int age, int speed)
	{
		super(race,height,isMale,strength, age,speed);
	
		items = new Supplies();
		items.setItem(new Weapon());
		isBitten = false;
	}
	
	//Getter for if Human has been bitten
	public boolean hasBeenBitten()
	{
		return isBitten;
	}
	
	//Setter for if Human has been bitten
	public void GotBitten()
	{
		isBitten = true;
	}
	
	public Weapon GetWeapon()
	{
		return items.getItem();
	}
	
}
