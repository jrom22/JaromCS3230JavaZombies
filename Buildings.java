package zombies;

public class Buildings {
	//Variables
	public boolean isResidential;
	public boolean isIndustrial;
	public boolean isCommercial;
	public int capacity;
	public boolean isVacant;
	
	//Create a building object
	public Buildings()
	{
		isResidential=false;
		isIndustrial=false;
		isCommercial=true;
		capacity=100;
		isVacant=true;
	}
}
