import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class commandMenu {
	
		// static string username;
		
	public static void main(String[] args) {
	    String Password = null;
		String Username = null;
		
		Scanner use = new Scanner(System.in);
		System.out.println("Enter your Username:");
		String username = use.next();
		
		System.out.println("Enter your Password:");
		String password = use.next();
		// createFile();
		
		
		System.out.println("Welcome to Pandorum " + username);
		if(username.equals(Username) && password.equals(Password) )
		{
			System.out.println("Welcome to Pandorum");
		}
		// else if(username.equals(Username)){
		//	System.out.println("Incorrect password");
		//}else if(password.equals(Password))
		//{System.out.println("Incorrect username");}
		//else {
		//System.out.println("Incorrect username and password");}
		
		
		
		
	}

	// private static void createFile() {
	// File f = new File("Pandorum" + username + ".txt");
	// if(!f.exists())
	// {
	// 	try
	// 	{
	// 		f.createNewFile();
	// 	}catch (IOexception e)
	// 	{
	// 		e.printStackTrace();
	// 	}
	// }
	// public static String getSavePath(){
	// 	return "" + username + ".txt";
	// }
		
		
		
	
	}

		

	

