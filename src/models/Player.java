package models;

public class Player {

	private Inventory inventory;

	private CombatObject co;

	private Stats stats;

	private byte currentRoom;
	public void setRoom(byte id){
		currentRoom=id;
	}
	public byte getCurrentRoom(){
		return currentRoom;
	}

}
