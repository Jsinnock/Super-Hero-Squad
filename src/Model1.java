
public class Model {
	

	public String add(String first, String second)
	{
		
		int one = Integer.parseInt(first);
		int two = Integer.parseInt(second);
		return one + "+" + two+ "=" + (one+two);

		
	}
	
	public String subtract (String first, String second)
	{
		int one = Integer.parseInt(first);
		int two = Integer.parseInt(second);
		return one + "-" + two+ "=" + (one-two);
		
	}
	
	public String divide (String first, String second)
	{
		int one = Integer.parseInt(first);
		int two = Integer.parseInt(second);
		return one + "/" + two+ "=" + (one/two);
		
	}
	
	public String multiply (String first, String second)
	{
		int one = Integer.parseInt(first);
		int two = Integer.parseInt(second);
		return one + "*" + two+ "=" + (one*two);
		
	}
	
}
