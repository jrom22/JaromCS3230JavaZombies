package zombies;

public class Civilian extends Human {
	//Fields
	public String race;
	public String height;
	public boolean isMale;
	public int strength;
	public int age;
	public int speed;
	protected boolean hasWeapon;
	
	public Civilian(String race, String height, boolean isMale, int strength, int age, int speed)
	{
		super(race, height, isMale, strength, age, speed);
	}

}
