package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import databases.*;
import models.*;
import view.*;

public class Controller implements ActionListener{
	
	private static View frame;
	private static Rooms rooms=Rooms.getRooms();
	private static Player player=new Player();

	/**
	 * tell the stats object to call its observer's (StatsPanel) update() method
	 * called when the stats tab is clicked (TabPanel) 
	 */
	public static final ActionListener statUpdate=new ActionListener(){public void actionPerformed(ActionEvent arg0) {Stats.updateObservers();}};

	/**
	 * tell the inventory object to call its observer's (InvPanel) update() method
	 * called when the inventory tab is clicked (TabPanel)
	 */
	public static final ActionListener invUpdate=new ActionListener(){public void actionPerformed(ActionEvent arg0) {Inventory.updateObservers();}};

	/**
	 * create a new profile object and save it.
	 */
	public static final ActionListener createProfile=new ActionListener(){public void actionPerformed(ActionEvent arg0) {}};

	/**
	 * try to get a profile from the string in the username textField
	 * check if the profile's password matches the String in the password text field
	 * Load the save datas for that profile
	 */
	public static final ActionListener login=new ActionListener(){public void actionPerformed(ActionEvent arg0) {}};

	/**
	 * 
	 */
	public static final ActionListener logoutAction=new ActionListener(){public void actionPerformed(ActionEvent arg0) {}};

	/**
	 * create a new Player object with the default values
	 * launch the game gui
	 * 
	 */
	public static final ActionListener startNew=new ActionListener(){public void actionPerformed(ActionEvent arg0) {}};

	/**
	 * 
	 */
	public static final ActionListener loadSave=new ActionListener(){public void actionPerformed(ActionEvent arg0) {}};
	
	

	/**
	 * get the next room ID from the button that was pressed 
	 * 	-when the nav0 button in the ConsolePanel is pressed, it calls changeRoom[0]
	 * 
	 */
	public static final ActionListener changeRoom[]={
			
			/*
			new ActionListener(){public void actionPerformed(ActionEvent arg0) {nav(0);}},
			new ActionListener(){public void actionPerformed(ActionEvent arg0) {nav(1);}},
			new ActionListener(){public void actionPerformed(ActionEvent arg0) {nav(2);}},
			new ActionListener(){public void actionPerformed(ActionEvent arg0) {nav(3);}},
			new ActionListener(){public void actionPerformed(ActionEvent arg0) {nav(4);}}
			*/
	};
	public static ActionListener getCRAL(int i){
		return changeRoom[i];
	}
	
	private void nav(int id){
		byte room = player.getCurrentRoom();
		byte[] exits = rooms.getExits(room);
		byte newRoom=exits[id];
		changeRoom(room, newRoom);
	}
	
	/**
	 * if there is a monster in the room, call escapeBattle().
	 * 	-if it returns true, then proceed with changing room and save the monster's remaining health in playerstats
	 * 	-false, then 
	 * check if the door is locked
	 * 	-
	 * 	-
	 * set new room id to player's currentRoom
	 * 	reset the console's item display
	 * check for monsters
	 * 
	 * get the room's description and tell the consolePanel to display it
	 * get the room's list of exits and update the nav buttons 
	 * 	-only show two of the five buttons if the room only has two exits
	 * 	-change the text on the button to show the name of the room
	 * make sure the scan button is visible

	 * @param inRoom
	 * @param toRoom
	 */
	private void changeRoom(byte inRoom, byte toRoom){
		player.setRoom(toRoom);
		//if(Rooms.getPuzzle(toRoom)==null)
		frame.getConsole().setRoomText(rooms.getDescription(toRoom), rooms.getDescription(toRoom));
		frame.getConsole().showRoomText();
		//else ConsolePanel.setRoomText(Rooms.getDescription(toRoom), Rooms.getPuzzle(toRoom).getText());
		String[] exits= new String[]{"","","","",""};
		byte[] exit=rooms.getExits(toRoom);
		int n=0;
		while(exit.length>n){
			exits[n]=rooms.getName(exit[n]);
			n++;
		}
		frame.getConsole().updateNav(exits);
		
	}

	/**
	 * Hide option for scan room
	 * show option for 
	 * get combat Object for the Monster
	 * Evaluate if monster attacks first
	 * 
	 */
	private static final void activateBattle(byte monsterID){
		
	}
	
	/**
	 * mark the monster as defeated
	 * add item to itemdrop
	 * unhide scan button
	 */
	private static final void winBattle(byte monsterID){
		
	}
	
	/**
	 * evaluate if you escape from the monster or not
	 * @return
	 */
	private static final boolean escapeBattle(byte monsterID){
		if(Math.random()>=Monsters.getEscapeChance(monsterID))return true;
		return false;
	};

	/**Called when Examine Room button is clicked
	 * 
	 * change the text to display the room's description 
	 * 
	 */
	public static final ActionListener getRoomDesc=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};

	/**Called when Scan Room Button is clicked
	 * activate a puzzle if there is one in the current room
	 * for each artifact in the room's item drop, make a pickupItem button
	 * 	-call ConsolePanel.newButton(), which makes a button and adds a pickupItem[] actionListener to it
	 * then tell the console to display the buttons
	 */
	public static final ActionListener getItemDrop=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};

	public static final ActionListener atkAction=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};

	/**
	 * remove the artifact from the item drop and add it to the inventory
	 */
	public static final ActionListener pickupItem[]={new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}};

	/**
	 * 
	 */
	public static final ActionListener useItem=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};

	/**
	 * get the selected item from the view List
	 * get the items description variable, then send it to the consonle text display
	 */
	public static final ActionListener examineItem=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};

	/**
	 * get selected usable from the list (returns index of the inventory slot)
	 * get the value of the item index in that slot of the inventory
	 * 	-add an item to the current room's itemdrop using that item index
	 * set the value of that slot to zero in the inventory
	 * 
	 */
	public static final ActionListener dropItem=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};
	
	//Puzzle Actions

	
	public Controller(View frame){
		this.frame=frame;
		player.setRoom((byte) 0);
		changeRoom((byte)0,(byte)0);
	}
	private void createGUI(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public void start(){
		frame = new View();
		createGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==frame.getConsole().getNavButton(0))nav(0);
		if(e.getSource()==frame.getConsole().getNavButton(1))nav(1);
		if(e.getSource()==frame.getConsole().getNavButton(2))nav(2);
		if(e.getSource()==frame.getConsole().getNavButton(3))nav(3);
		if(e.getSource()==frame.getConsole().getNavButton(4))nav(4);
	}
	
}
