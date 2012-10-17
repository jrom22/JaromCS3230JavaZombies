package zombies;

public class Zombie extends Person {
	//Fields
	public String race;
	public String height;
	public boolean isMale;
	public int strength;
	public int age;
	public int speed;
	
	public Zombie(String race, String height, boolean isMale, int strength, int age, int speed)
	{
		super(race, height, isMale, strength, age, speed);
	}
	
}
