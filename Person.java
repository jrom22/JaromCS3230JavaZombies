package zombies;

public abstract class Person {

	//Fields
	private String race;
	private String height;
	private boolean isMale;
	private int strength;
	private int age;
	private int speed;
	
	//Constructor
	public Person()
	{
		setRace("caucasian");
		setHeight("6\"1'");
		setMale(false);
		setStrength(100);
		setAge(27);
		setSpeed(100);
	}
	
	public Person(String race, String height, boolean isMale, int strength, int age, int speed)
	{
		this.race = race;
		this.height = height;
		this.isMale = isMale;
		this.strength = strength;
		this.age = age;
		this.speed = speed;
	}

	public String getRace()
	{
		return race;
	}

	public void setRace(String race) 
	{
		this.race = race;
	}

	public String getHeight() 
	{	
		return height;
	}

	public void setHeight(String height) 
	{
		this.height = height;
	}

	public boolean isMale() 
	{
		return isMale;
	}

	public void setMale(boolean isMale) 
	{
		this.isMale = isMale;
	}

	public int getStrength() 
	{
		return strength;
	}

	public void setStrength(int strength) 
	{
		this.strength = strength;
	}

	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public int getSpeed() 
	{
		return speed;
	}

	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}

}
