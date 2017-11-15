
public class Monster{

	private String name;
	private String desc;
	private String weapon;
	private int strength;
	private int armor;
	private int health;
	private double attackChance;
	private String weaponDrop;
	private int flee;
	
	
	public Monster(String n,String d,String w,int s, int a, int h,int ac, String wd,int f)
	{
		name = n;
		desc = d;
		weapon = w;
		strength = s;
		armor = a;
		health = h;
		attackChance = ac;
		weaponDrop = wd;
		flee = f;
		
		
		
	}
	public boolean attack()
	{
		
		if(attackChance == 1)
		{
			return true;
		}
		else if(attackChance < 1)
			{
				return false;
			}
		return false;
		
	}
	public boolean chanceFlee()
	{
		if(flee == 1)
		{
			return true;
		}
		else if(flee < 1)
		{
			return false;
		}
		return false;
		
	}
	
	

public static void main( String args[] )
{
	
	
}
}