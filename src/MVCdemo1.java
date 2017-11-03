
public class MVCdemo {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to your personal calculator");
		System.out.println("Please Select from the listed operations and provide two parameters");
		System.out.println("*******************************************");
		Controller run = new Controller();
		while (true) {
			run.read();
		}
	}

}
