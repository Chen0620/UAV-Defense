package functions;

public class Target 
{
	private int ID;
	private boolean isActive;
	private int shotCount;
	private double xCoord;
	
	Target(int id,double x,double y)//constructor
	{
		id=ID;
	}
	
	public boolean isShot()
	{
		return false;
	}
	
	public int getShotCount()
	{
		return 0;
	}
	
	public void deactivate()
	{
		
	}
}
