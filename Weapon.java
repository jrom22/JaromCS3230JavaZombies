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
	
	public Weapon(boolean isMelee, int damage, int range, int rate, int ammo)
	{
		this.isMelee = isMelee;
		this.damage = damage;
		this.range = range;
		this.rate = rate;
		this.ammo = ammo;
		
	}
	
	public void obtainAmmo()
	{
		Random r = new Random();
		int randomInt = r.nextInt(100) + 1;
		this.ammo += randomInt;
	}
	
	public Weapon obtainNewWeapon()
	{
		Random r = new Random();
		boolean typeIsMelee = false;
		int randomInt = r.nextInt(2) + 1;
		if(randomInt != 2)
		{
			typeIsMelee = true;
		}
		else
		{
			typeIsMelee = false;
		}
			
		return new Weapon(typeIsMelee, r.nextInt(100) + 1, r.nextInt(50) + 1, r.nextInt(10) + 1, r.nextInt(100) + 1);
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

