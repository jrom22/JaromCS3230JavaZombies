package zombies;

public class Buildings {
	//Fields
	public boolean isResidential;
	public boolean isIndustrial;
	public boolean isCommercial;
	public int capacity;
	public boolean isVacant;
	
	public Buildings()
	{
		isResidential=false;
		isIndustrial=false;
		isCommercial=true;
		capacity=100;
		isVacant=true;
	}
}
