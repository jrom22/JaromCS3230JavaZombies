package zombies;

import java.util.Random;

public class Supplies {
	//Fields
	protected int strength;
	protected int ammo;
	protected boolean hasWeapon;
	protected boolean isMelee;
	
	public void obtainMedKit(int strength)
	{
		strength+=50;
	}
	
	public void obtainAmmo()
	{
		Random r = new Random();
		int randomInt = r.nextInt(100) + 1;
		ammo+=randomInt;
	}
	
	public void obtainWeapon()
	{
		Random r = new Random();
		int randomInt = r.nextInt(2) + 1;
		if(randomInt != 2)
		{
			isMelee=true;
		}
		else
		{
			isMelee=false;
		}
			
		hasWeapon=true;
	}
}
