package classes;

import javax.swing.*;
import controllers.*;

public class InventoryTab {

	
	//3 list displays for each type of artifact
	//Text display to show the equipt weapon
	//The 3 lists are radio buttons 
	
	private JRadioButton[] itemsList;
	//group the radio buttons into three groups
	//the fourth group is for keeping track of  which list is selected
	private ButtonGroup[] groupsICW ={ new ButtonGroup(), new ButtonGroup(), new ButtonGroup(), new ButtonGroup()};
	
	//index of the currently selected item
	private byte selected;
	
	//there are 3 types of artifact lists.
	// selectedType can be 'w','c','i'. (Weapon,Consumable,Item)
	private char selectedType;
	private JRadioButton[] weaponsList;
	private JRadioButton[] usablesList;
	//gets  the description of the item in the list
	private JButton examineItem = new JButton("Examine Item");	
	// if a consumable is selected, then use it
	// if a weapon is selected, then equip it
	//if an item is seected do nothing
	private JButton consumeItem = new JButton("Consume Item");
	//drop item only works if a consumable item is selected, they are the only ones that can be dropped
	private JButton dropItem = new JButton("Drop Item");

	
	public void init(){
		examineItem.addActionListener(InventoryCommands.examine);
		consumeItem.addActionListener(InventoryCommands.use);
		dropItem.addActionListener(InventoryCommands.drop);
		groupsICW[0].add(weaponsList[0]);
		groupsICW[0].add(usablesList[0]);
		groupsICW[0].add(itemsList[0]);
	}

	public void update() {

	}

	public char getSType(){
		return ' ';
	}
	public byte getSelected(){
		return 0;
	}
	
	public void setSelected(){
		
	}
	public void highlightItem(byte id) {
		selectedType='i';
		selected=id;
	}

	public void selectWeapon(byte id) {
		selectedType='w';
		selected=id;
	}

	public void selectConsumable(byte id) {
		selectedType='c';
		selected=id;
	}

	

}
