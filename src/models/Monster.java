package models;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Random;
import java.io.*;

public class Monster{

	
	
	private ArrayList<Monster> MonsterList = new ArrayList<Monster>();
	
	public void addMonster(Monster create) {
		MonsterList.add(create);
	}
	public void printMonsterList() {
		for (int i = 0; i < MonsterList.size(); i++) {
			Monster temp = MonsterList.get(i);
			System.out.println(temp);
		}
	}
		
		
	
	/** boolean attack()
	{
		
		Random attack = new Random();
		if(attack.nextDouble() < attackChance)
		{
			return true;
		}
		else if(attack.nextDouble() > attackChance)
			{
				return false;
			}
		return false;
		
	}
	public boolean chanceFlee()
	{
		Random fled = new Random();
		if(fled.nextDouble() < attackChance)
		{
			return true;
		}
		else if(fled.nextDouble() > attackChance)
		{
			return false;
		}
		return false;
		
	}
	*/
	public static void main(String[] args) {
		
		Monster monsterList = new Monster();
		try
		{
			
			File mediaFile = new File("Monster.txt");
			
			Scanner fileReader = new Scanner(mediaFile);
			
			while (fileReader != null && fileReader.hasNext()) {

				String name = fileReader.nextLine();
				String desc = fileReader.nextLine();
				String weapon = fileReader.nextLine();
				String strength = fileReader.nextLine();
				String armor = fileReader.nextLine();
				String health = fileReader.nextLine();
				String attackChance = fileReader.nextLine();
				String weaponDrop = fileReader.nextLine();
				String flee = fileReader.nextLine();
				
				
	
				

			}

		} catch (

		FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monsterList.printMonsterList();
	}

		
	}	

 /** public static void main( String args[] )
{
	String file = "Monsters.txt";
	String line = null;
	try{
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(file);
		while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
		}
		bufferedReader.close();         
    }
	catch(IOException ex) {
		ex.printStackTrace();
	}
	
} */


