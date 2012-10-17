package zombies;

public class Human extends Person {
	//Fields
	private String race;
	protected String height;
	protected boolean isMale;
	protected int strength;
	protected int age;
	protected int speed;
	protected Weapon item;
	protected Supplies supps;
	
	public Human()
	{
		race="Caucasian";
		height="6\"3'";
		isMale=true;
		strength=100;
		age=27;
		speed=100;
		item = new Weapon();
	}
	
	public Human(String race, String height, boolean isMale, int strength, int age, int speed)
	{
		this.race=race;
		this.height=height;
		this.isMale=isMale;
		this.strength=strength;
		this.age=age;
		this.speed=speed;
		this.item = new Weapon();
	
	}
	
	public String GetRace()
	{
		return race;
	}
	
}
