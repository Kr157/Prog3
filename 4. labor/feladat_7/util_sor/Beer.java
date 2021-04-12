package util_sor;



public class Beer{
	String name;
	String style;
	double strength;
	
	public Beer(String name, String style, double strength)
	{
		this.name=name;
		this.style=style;
		this.strength=strength;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public String getSytle() 
	{
		return this.style;
	}
	
	public double getStrength()
	{
		return this.strength;
	}
	
	public String toString() {
		return this.name+" "+this.style+" "+this.strength;
	}
	
}
