import java.util.Scanner;

public class Controller {

	Model model = new Model();
	View view = new View();
	private Scanner input;
	
			
	public void read()
	{
		String str = "";
		input = new Scanner(System.in);
		view.print("Add or Subtract or divide or multiply");
		str = input.nextLine();
		String parsStr[] = str.split(" ");
		if (parsStr[0].equalsIgnoreCase("add"))
		{
			view.print(model.add(parsStr[1], parsStr[2]));
			
		}
		else if (parsStr[0].equalsIgnoreCase("subtract"))
		{
			view.print(model.subtract(parsStr[1], parsStr[2]));
		}
		else if (parsStr[0].equalsIgnoreCase("divide"))
		{
			view.print(model.divide(parsStr[1], parsStr[2]));
		}
		else if (parsStr[0].equalsIgnoreCase("multiply"))
		{
			view.print(model.multiply(parsStr[1], parsStr[2]));
		}
		
	}
	
}
