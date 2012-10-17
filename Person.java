package zombies;

public abstract class Person {

	//Fields
	public String race;
	public String height;
	public boolean isMale;
	public int strength;
	public int age;
	public int speed;
	
	//Constructor
	public Person(){
		race= "caucasian";
		height = "6\"1'";
		isMale=false;
		strength = 100;
		age = 27;
		speed = 100;
	}
	
	public Person(String race, String height, boolean isMale, int strength, int age, int speed)
	{
		this.race=race;
		this.height=height;
		this.isMale=isMale;
		this.strength=strength;
		this.age=age;
		this.speed=speed;
	}

}
