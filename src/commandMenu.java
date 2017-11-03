import java.awt.ActionEvent;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class commandMenu {

	public static void main(String[] args) {
		
	}
	public static int main1(String[] args)
	{
		int scan;
		Scanner input = new Scanner(System.in);
		
				
		System.out.println("Hello World");
		
		scan = input.nextInt();
		return scan;
	}
	private void saveButton(java.awt.ActionEvent evt) 
	{
		JFileChooser sv = new JFileChooser();
		
		int choice = sv.showOpenDialog(null);
		
		
	}
	

}
