
class Controller implements java.awt.even.ACtionListener{
	
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
	Controller()
	{
		System.out.println("Controller()");
	}
	
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		System.out.println("Controller: acting on Model");
		model.incrementValue();
	}
	
	public void addModel(Model m)
	{
		System.out.println("Controller : adding model");
		this.model = m;
	}
	
	public void addView(View v)
	{
		System.out.println("Controller: adding view");
		this.view = v;
	}
	
	public void initModel(int x)
	{
		model.setValue(x);
	}

	
}
