package zombies;

import java.util.Random;

public class Weapon {
	//Fields
	private boolean isMelee;
	private int damage;
	private int range;
	private int rate;
	private int ammo;
	
	//Constructor
	public Weapon()
	{
		Random r = new Random();
		int randomNum = r.nextInt(2) + 1;
		if(randomNum != 2 )
		{
			isMelee = true;
			damage = 10;
			range = 30;
			rate = 6;
			ammo = 50;
		}
		else
		{
			isMelee = false;
			damage = 15;
			range = 15;
			rate = 6;
			ammo = 0;
		}
	}
	
	public boolean GetIsMelee()
	{
		return isMelee;	
	}
	
	public int GetDamage()
	{
		return damage;
	}
	
	public int GetRate()
	{
		return rate;
	}
	
	public int GetRange()
	{
		return range;
	}
	
	public int GetAmmo()
	{
		return ammo;
	}
}

