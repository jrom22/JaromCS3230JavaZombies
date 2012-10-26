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
	
	//Setter for Person object
	public Person(String race, String height, boolean isMale, int strength, int age, int speed)
	{
		this.race = race;
		this.height = height;
		this.isMale = isMale;
		this.strength = strength;
		this.age = age;
		this.speed = speed;
	}

	//Getter for Race
	public String getRace()
	{
		return race;
	}

	//Setter for Race
	public void setRace(String race) 
	{
		this.race = race;
	}

	//Getter for Height
	public String getHeight() 
	{	
		return height;
	}

	//Setter for Height
	public void setHeight(String height) 
	{
		this.height = height;
	}

	//Getter for if Human is Male
	public boolean isMale() 
	{
		return isMale;
	}

	//Setter for if Human is Male
	public void setMale(boolean isMale) 
	{
		this.isMale = isMale;
	}

	//Getter for Human Strength
	public int getStrength() 
	{
		return strength;
	}

	//Setter for Human Strength
	public void setStrength(int strength) 
	{
		this.strength = strength;
	}

	//Getter for Human Age
	public int getAge() 
	{
		return age;
	}

	//Setter for Human Age
	public void setAge(int age) 
	{
		this.age = age;
	}

	//Getter for Human Speed
	public int getSpeed() 
	{
		return speed;
	}

	//Setter for Human Speed
	public void setSpeed(int speed) 
	{
		this.speed = speed;
	}

}
