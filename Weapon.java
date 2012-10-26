package zombies;

import java.util.Random;

public class Weapon {
	//Variables
	private boolean isMelee;
	private int damage;
	private int range;
	private int rate;
	
	//Constructor
	public Weapon()
	{
		//Randomly select whether a Human has a melee weapon or a ranged weapon
		Random r = new Random();
		int randomNum = r.nextInt(2) + 1;
		//If random number is not two then Human gets a melee weapon, also randomly select damage and rate of fire
		if(randomNum != 2 )
		{
			isMelee = true;
			damage = r.nextInt(50);
			range = 0;
			rate = r.nextInt(25);
		}
		else//If random number is  two then Human gets a ranged weapon.
		{
			isMelee = false;
			damage = r.nextInt(10);
			range = r.nextInt(5);
			rate = r.nextInt(25);
			damage =  damage * (rate/100);
			
		}
	}
	
	//Set Weapon
	public Weapon(boolean isMelee, int damage, int range, int rate)
	{
		this.isMelee = isMelee;
		this.damage = damage;
		this.range = range;
		this.rate = rate;
	}
	
	//Human obtains new weapon
	public Weapon obtainNewWeapon()
	{
		//Randomly select a number 1 or 2
		Random r = new Random();
		boolean typeIsMelee = false;
		int randomInt = r.nextInt(2) + 1;
		//If random number is 1 then Human gets a melee weapon
		if(randomInt != 2)
		{
			typeIsMelee = true;
		}
		else//If random number is 2 then Human gets a ranged weapon
		{
			typeIsMelee = false;
		}
		//Send new Weapon info over to Weapon Method to be set.
		return new Weapon(typeIsMelee, r.nextInt(100) + 1, r.nextInt(50) + 1, r.nextInt(10) + 1);
	}
	
	//Getter for melee weapon
	public boolean GetIsMelee()
	{
		return isMelee;	
	}
	
	//Getter for damage of weapon
	public int GetDamage()
	{
		return damage;
	}
	
	//Getter for rate of ranged weapon
	public int GetRate()
	{
		return rate;
	}
	
	//Getter for range of weapon
	public int GetRange()
	{
		return range;
	}
	
}

