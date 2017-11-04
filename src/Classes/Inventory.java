package entity;

import classes.InventoryTab;

public class Inventory {

	// can have more than one of each type of consumable
	//this keeps track of how many
	private int[] usables= new int[5];
	//keep track of whether or not the player has each weapon
	private boolean[] weapons= new boolean[5];
	//can be 0-5 to tell which of the 5 weapons is equipped. 0 means no weapon equipped
	private byte equipt;
	//keep track of whether or not the player has each item
	private boolean[] items= new boolean[13];
	//the Inventory Tab (View) updates based on what items the player has,
	//	so it observes the Inventory class.
	private InventoryTab inventoryObserver;
	
	private int consumableCapacity;
	
	
	//Singleton Constructor
	private Inventory(){
		
	}
	private static class Holder{
		private static final Inventory i = new Inventory();
	}
	public static Inventory getInventory(){
		return Holder.i;
	}
	//end Singleton Constructor

	/**
	 * get the database index of the currently equipped weapon
	 * @return 
	 */
	public byte getEqupt() {
		return equipt;
	}

	/**called by the management controller when the player clicks one of the radio buttons.
	 * change the currently equipped weapon
	 * @param w - database index of the weapon to switch to
	 */
	public void equipWeapon(byte w) {
		if(weapons[w])equipt=w;
	}

	/**
	 * check to see if an item is in the inventory
	 * @param id - database index of the item to check for
	 * @return
	 */
	public boolean checkForItem(byte id) {
		return items[id];
	}

	/**
	 * Use a consumable, removing it from the inventory and applying its effect
	 * @param id type of consumable to use
	 */
	public void useConsumable(byte id) {

	}

	/**
	 * 
	 */
	public void notifyObserver() {
		inventoryObserver.update();
	}

	/**
	 * Remove an item from the  room's ItemDrop and add it to the inventory
	 * @param id item id for the artifact database
	 * @param type type of Artifact 'w'=weapon, 'i'=item, 'c'=consumable
	 * @return
	 */
	public void pickupItem(byte id, char type) {
		
	}

	/**
	 * Drop item from the inventory into the room's ItemDrop()
	 * @param id
	 */
	public void dropItem(byte id) {

	}

}
