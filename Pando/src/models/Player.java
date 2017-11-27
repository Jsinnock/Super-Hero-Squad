package models;

public class Player {

	private Inventory inventory;
	private CombatObject co;
	private Stats stats;
	private Progress p;

	public Player(){
		inventory=new Inventory();
		stats=new Stats();
		co=new CombatObject(100,10,20);
		p=new Progress();
		
	}
	public Player(SaveData s){
		inventory=s.getInv();
		co=s.getCo();
		stats=s.getStats();
		p=s.getProgress();
	}
	private byte currentRoom;
	public void setRoom(byte id){currentRoom=id;}
	public byte getCurrentRoom(){return currentRoom;}
	
	public Stats getStats(){return stats;}
	public Inventory getInv(){return inventory;}
	public CombatObject getCO(){return co;}
	public Progress getProgress(){return p;}

}
