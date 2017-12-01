package models;

import controllers.SaveData;
/**
 * player object that holds the data relevant to the player for the controller to use
 */
public class Player {

	private Inventory inventory;
	private CombatObject co;
	private Stats stats;
	private Progress p;
	/**
	 * Create a player object using the default values
	 */
	public Player(){
		inventory=new Inventory();
		stats=new Stats();
		co=new CombatObject(100,10,20);
		p=new Progress();
	}
	/**
	 * Create a player object using data from a save file
	 * @param s
	 */
	public Player(SaveData s){
		inventory=s.getInv();
		co=s.getCo();
		stats=s.getStats();
		p=s.getProgress();
	}
	
	public Stats getStats(){return stats;}
	public Inventory getInv(){return inventory;}
	public CombatObject getCO(){return co;}
	public Progress getProgress(){return p;}

}
