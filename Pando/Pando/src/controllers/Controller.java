package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import models.*;
import view.*;
/**
 * Controller object receives input commands from the view objects and manipulates the model objects
 * @author Jon
 *
 */
public class Controller implements ActionListener{
	
	private View frame;
	private Room rooms;
	private Player player;
	private boolean battle=false;//true if there is a monster in the room
	private Profile profile=new Profile();//create the profile object to read and write save files
	
	/**
	 * 
	 * @param frame
	 */
	public Controller(View frame){
		this.frame=frame;	
	}
	
	/**
	 * called when a button on the view is pressed
	 * evaluates which button was pressed and calls the appropriate method
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Navigation Buttons in the console
		if(e.getSource()==frame.getConsole().getNavButton(0))navRoom(0);
		if(e.getSource()==frame.getConsole().getNavButton(1))navRoom(1);
		if(e.getSource()==frame.getConsole().getNavButton(2))navRoom(2);
		if(e.getSource()==frame.getConsole().getNavButton(3))navRoom(3);
		if(e.getSource()==frame.getConsole().getNavButton(4))navRoom(4);
		if(e.getSource()==frame.getConsole().getNavButton(5))navRoom(5);
		if(e.getSource()==frame.getConsole().getNavButton(6))navRoom(6);
		if(e.getSource()==frame.getConsole().getNavButton(7))navRoom(7);
		//Puzzle Buttons in the console
		if(e.getSource()==frame.getConsole().getPuzzleButton(0)){puz(0,rooms.getPuzzle());}
		if(e.getSource()==frame.getConsole().getPuzzleButton(1)){puz(1,rooms.getPuzzle());}
		if(e.getSource()==frame.getConsole().getPuzzleButton(2)){puz(2,rooms.getPuzzle());}
		//Interaction Buttons in the console
		if(e.getSource()==frame.getConsole().getExamineButton()){examineRoom();}
		if(e.getSource()==frame.getConsole().getScanButton()){scanRoom();}
		if(e.getSource()==frame.getConsole().getAttackButton()){attack();}
		//Item pickup buttons in the console
		if(e.getSource()==frame.getConsole().getPickupButton()){pickupItems();}
		

		//Buttons from the tab panel
		//make sure that the inventory is up to date when any of its buttons are pressed
		if(		(e.getSource()==frame.getTab().getInvButton())
				||(e.getSource()==frame.getTab().getINV().getItemTab())
				||(e.getSource()==frame.getTab().getINV().getWpnTab())
				||(e.getSource()==frame.getTab().getINV().getUsablesTab())
			){player.getInv().updateObservers();}
		if(e.getSource()==frame.getTab().getStatButton()){player.getStats().notifyO();}


		//Buttons in the command menu
		if(e.getSource()==frame.getTab().getCMD().getSaveButton()){try {
			save();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		if(e.getSource()==frame.getTab().getCMD().getLoadButton()){try {load();} catch (ClassNotFoundException e1) {e1.printStackTrace();} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		if(e.getSource()==frame.getTab().getCMD().getExitButton()){exitGame();}
		
		//buttons in the Inventory menu
		if(e.getSource()==frame.getTab().getINV().getUse()){useItem();}
		if(e.getSource()==frame.getTab().getINV().getDrop()){dropItem();}
		if(e.getSource()==frame.getTab().getINV().getExamine()){examineItem();}
		
		//Buttons involved with logging in
		if(e.getSource()==frame.getLogin().getEnter()){try {
			login();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		if(e.getSource()==frame.getLogin().getCreate()){try {
			createProfile();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		
		if(e.getSource()==frame.getStart().getNewGame()){try {
			newGame();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}
		if(e.getSource()==frame.getStart().getLoadGame()){try {
			load();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}frame.start();}
		if(e.getSource()==frame.getStart().getLogout()){logout();}
		
	}
	
	
	/**Save to a binary file
	 * add current room to progress(otherwise this is done when a new room is entered)
	 * record id of current room
	 * write progress,inventory,co,and stats objects to binary file and save it
	 * @throws IOException 
	 */
	private void save() throws IOException{
		player.getProgress().addRoom(rooms.getID(), rooms.getItemDrop(), !battle, rooms.getMonster());
		if(profile.save(player,rooms.getID())){frame.getConsole().showText("Save Successful");
		}else frame.getConsole().showText("Save Unsuccessful");
	}
	/**Load from a binary file
	 * read data from file and create progress, inventory, and stats objects, and get the current room id
	 * create a new player object and room object
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	private void load() throws ClassNotFoundException, IOException{
		SaveData save=profile.load();
		if(save != null){
			player=new Player(save);
			player.getInv().addObserver(frame.getTab().getINV());
			player.getStats().addObserver(frame.getTab().getStats());
			System.out.println(save.getRoomID());
			rooms=new Room(FileConfig.roomFile,save.getRoomID(),
					save.getProgress().getItems(save.getRoomID()),save.getProgress().getMonster(save.getRoomID()));
			updateConsole();//reset the console display
			if(rooms.isMon()&&!player.getProgress().getMonsterDefeated(rooms.getID())){
				activateBattle();
				frame.getConsole().showText(rooms.getMonster().getDescription());
			}
		}else frame.getConsole().showText("Load Unsuccessful");
	}

	/**
	 * create a new Player object with the default values
	 * start in room 1 
	 * launch the game gui
	 * make a save file only if one does not already exist
	 * @throws IOException 
	 */
	private void newGame() throws IOException{
		player=new Player();
		player.getInv().addObserver(frame.getTab().getINV());
		player.getStats().addObserver(frame.getTab().getStats());
		rooms=new Room(FileConfig.roomFile,"A01",null,null);
		frame.start();
		if(!profile.exists())save();//automatically save only if there is no save file
		updateConsole();
		frame.getConsole().showRoomText();
	}
	/**
	 * Hide the game gui and show the startup gui
	 */
	private void exitGame(){frame.exit();}
	/**
	 * Return the view to the login screen
	 */
	private void logout(){frame.logout();}
	/**
	 * try to get a profile from the string in the username textField
	 * check if the profile's password matches the String in the password text field
	 * Load the save datas for that profile
	 * 
	 * Iterate through all of the profiles to find a matching username
	 * if username is found, then eval password
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	private void login() throws ClassNotFoundException, IOException{
		if(profile.tryLogin(frame.getLogin().getNameField().getText(), frame.getLogin().getPwField().getText().toString())){
			frame.login();
		}else frame.getLogin().failLogin();
	}
	/**
	 * Start a new game with a new user account, and save the new account
	 * @throws UnsupportedEncodingException 
	 */
	private void createProfile() throws UnsupportedEncodingException{
		if(profile.newUser(frame.getLogin().getNameField().getText(), frame.getLogin().getPField().getText().toString())){
			try {
				newGame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else frame.getLogin().failCreate();
		
	}

	/**
	 * called when a navigation button is pressed
	 * @param id  exit that was chosen (not the id of the new room!)
	 * 	i.e. navRoom(0) is called if the first button on the nav list is selected
	 */
	private void navRoom(int id){
		String newRoom=rooms.getExit(id);//get the id of the room to go to
		//evaluate if the player is able to go through the specified door
		if(battle){//if there is a battle going on, evaluate escape chances
			if(rooms.getMonster().getEscChance()<=Math.random()){
				frame.getConsole().showText("Escape attampt failed");//display failed escape attempt text
				if(monsterAtk())getKilled();
				frame.getConsole().hideNav();//hide nav buttons
				return;//don't change room
			}
		}
		
		//locked doors
		if(rooms.getID().equals("D5")){
			if(!player.getProgress().puz(7)){
				frame.getConsole().showText("The door is locked");
				return;}
		}
		if(rooms.getID().equals("A3")&&newRoom.equals("A10"))if(!player.getInv().has("I6")){
			frame.getConsole().showText("The door is locked");
			return;
		}
		if(rooms.getID().equals("A3")&&newRoom.equals("A12"))if(!player.getProgress().getMonsterDefeated("A8")){
			frame.getConsole().showText("The door is blocked");
			return;
		}
		frame.getConsole().updateAttack(false);
		battle=false;
		player.getProgress().addRoom(newRoom, rooms.getItemDrop(), !battle,rooms.getMonster());//update the roomsEntered in the progress object
		//if the room has already been entered, update the room object with the values saved in progress
		rooms.enterRoom(newRoom, player.getProgress().getItems(newRoom), player.getProgress().getMonster(newRoom));
		updateConsole();//reset the console display
		if(rooms.isMon()&&!player.getProgress().getMonsterDefeated(newRoom)){
			activateBattle();
			frame.getConsole().showText(rooms.getMonster().getDescription());
		}
	}
	/**
	 * Update the view to display the information for the new room
	 */
	private void updateConsole(){
		//update the text display
		String p;
		if(!rooms.getPuzzle().equals(" "))p=Puzzle.start(rooms.getPuzzle());
		else p=rooms.getDescription();
		frame.getConsole().setRoomText(rooms.getDescription(), p);
		frame.getConsole().showRoomText();
		//update the nav buttons
		String[] exits= new String[]{"","","","","","","",""};
		int n=0;
		while(rooms.getExits()>n){
			Room room = new Room(FileConfig.roomFile,rooms.getExit(n),null,null);
			exits[n]=room.getName();
			n++;
		}
		frame.getConsole().updateAttack(false);
		frame.getConsole().updateNav(exits);
		frame.getConsole().updateInteraction();
		frame.getMap().update(rooms.getName());
	}
	/**Evaluates the logic for each puzzle option
	 * Called when one of the puzzle options is selected
	 * @param n - which one of the option buttons was pressed
	 * @param id - puzzle that the option is for
	 */
	private void puz(int n,String id){
		if(id.equals("P0")){
			player.getCO().setHealth(100);
			frame.getConsole().showText(Puzzle.solve("P0"));
		}
		if(id.equals("P1")){
			if(n==0){
				player.getProgress().setPlasticTray(true);
				frame.getConsole().showText(Puzzle.solve("P1"));
			}else frame.getConsole().showText(Puzzle.fail("P1"));
		}
		if(id.equals("P2")){
			spawnMonster(new Monster(FileConfig.monsterfile,"M5"));
			if(n==2)rooms.getItemDrop().add(Artifactory.newArtifact("I6"));
		}
		if(id.equals("P3")){
			if(Math.random()>0.5)frame.getConsole().showText(Puzzle.solve("P3"));
			else spawnMonster(new Monster(FileConfig.monsterfile,"M3"));
		}
		if(id.equals("P4")){
			if(Math.random()>0.5)frame.getConsole().showText(Puzzle.solve("P4"));
			else spawnMonster(new Monster(FileConfig.monsterfile,"M4"));
		}
		if(id.equals("P5")){
			if(player.getInv().has("I01")){
				frame.getConsole().showText(Puzzle.solve("P5"));
				player.getInv().add(Artifactory.newArtifact("I4"));
				player.getInv().add(Artifactory.newArtifact("W3"));
				player.getInv().add(Artifactory.newArtifact("C0"));
			}else frame.getConsole().showText(Puzzle.fail("P5"));
		}
		if(id.equals("P6")){
			player.getInv().add(Artifactory.newArtifact("I10"));
			if(n==0){
				if(player.getCO().getHealth()>30)player.getCO().setHealth(player.getCO().getHealth()-30);
				else player.getCO().setHealth(1);
				frame.getConsole().showText(Puzzle.solve("P6"));
			}else{
				if(Math.random()>0.25){
					if(player.getCO().getHealth()>50)player.getCO().setHealth(player.getCO().getHealth()-50);
					else player.getCO().setHealth(1);
				}
				frame.getConsole().showText(Puzzle.fail("P6"));
			}
		}
		if(id.equals("P7")){
			if(player.getProgress().isCode2()){
				frame.getConsole().showText(Puzzle.solve("P7"));
				player.getProgress().puzzle(7);
			}else frame.getConsole().showText(Puzzle.fail("P7"));
		}
		if(id.equals("P8")){
			if(player.getInv().has("I2")&&player.getInv().has("I3")){
				if(n==1){
					player.getInv().add(Artifactory.newArtifact("I11"));
					frame.getConsole().showText(Puzzle.solve("P8"));
				}else spawnMonster(new Monster(FileConfig.monsterfile,"M5"));
			}else frame.getConsole().showText(Puzzle.fail("P8"));
		}
		
	}

	/**Starts a battle with a monster
	 * called when a monster is spawned, or if there is one in the room by default
	 * Hide option for scan room
	 * show option for 
	 * get combat Object for the Monster
	 * Evaluate if monster attacks first
	 * 
	 */
	private void activateBattle(){
		battle=true;
		frame.getConsole().updateAttack(true);
		if(Math.random()>rooms.getMonster().getAtkChance())if(monsterAtk())getKilled();
	}
	/**
	 * mark the monster as defeated
	 * add item to itemdrop
	 * unhide scan button
	 */
	private void winBattle(){
		Artifact a=rooms.getMonster().getItem();
		if(a!=null)rooms.getItemDrop().add(a);			
		if(rooms.getItemDrop().size()>0){
		String[] s=new String[rooms.getItemDrop().size()];
		int n=0;
		while(n<rooms.getItemDrop().size()){
			s[n]=rooms.getItemDrop().get(n).getName();
			n++;
		}
		frame.getConsole().updatePickupList(s);}
		rooms.kill();
		frame.getConsole().updateAttack(false);
		updateConsole();
		player.getStats().getKill();
		battle=false;
	}
	/**
	 * display the startup screen when the player is defeated
	 */
	private void getKilled(){
		frame.killed();
		battle=false;//
	}
	/**
	 * Called by certain puzzles if the wrong option is chosen
	 * @param m - monster object that the puzzle wants to spawn
	 */
	private void spawnMonster(Monster m){
		rooms.spawn(m);
		activateBattle();
	}
	
	/**Called when Examine Room button is clicked
	 * 
	 * change the text to display the room's description 
	 * 
	 */
	private void examineRoom(){
		frame.getConsole().showRoomText();
	}
	/**Called when Scan Room Button is clicked
	 * activate a puzzle if there is one in the current room
	 * for each artifact in the room's item drop, make a pickupItem button
	 * 	-call ConsolePanel.newButton(), which makes a button and adds a pickupItem[] actionListener to it
	 * then tell the console to display the buttons
	 */
	private void scanRoom(){
		frame.getConsole().showPuzzleText();//show puzzle text
		if(!rooms.getPuzzle().equals(" "))frame.getConsole().updatePuz(Puzzle.options(rooms.getPuzzle()));
		
		if(!rooms.getPuzzle().equals(" "))Puzzle.start(rooms.getPuzzle());
		frame.getConsole().scan();//show itemlist and pickup buttons
		String[] itemNames= new String[rooms.getItemDrop().size()];
		int n=0;
		while(n<rooms.getItemDrop().size()){itemNames[n]=rooms.getItemDrop().get(n).getName();n++;}
		frame.getConsole().updatePickupList(itemNames);
	}
	/**
	 * initiate an attack exchange where the player attacks the monster and then the monster attacks the player
	 */
	private void attack(){
		frame.getConsole().showText(rooms.getMonster().getDescription());
		if(playerAttack())winBattle();
		else if(monsterAtk())getKilled();
		System.out.println(player.getCO().getHealth());
		if(rooms.getMonster()!=null)System.out.println(rooms.getMonster().getCO().getHealth());
	}
	/**
	 * monster's combat object attacks the player's
	 * @return true if the player was killed
	 */
	private boolean monsterAtk(){return player.getCO().getAttacked(rooms.getMonster().getCO());}
	/**
	 * player's combat object attacks the monster's
	 * @return true if the monster was killed
	 */
	private boolean playerAttack(){return rooms.getMonster().getCO().getAttacked(player.getCO());}

	/**
	 * get the selected item from the view List
	 * get the items description variable, then send it to the consonle text display
	 */
	private void examineItem(){
		String text=player.getInv().getArtifact(frame.getTab().getINV().getTab(),frame.getTab().getINV().getSelected()).getDescription();
		frame.getConsole().showText(text);
		
	}
	/**
	 * if it is a weapon, then equip it and update the damage of the combat object
	 * if it is a consumable then remove it from the inventory and activate its effect
	 */
	private void useItem(){
		if(frame.getTab().getINV().getTab()=='w'){
			player.getInv().equip(frame.getTab().getINV().getSelected());
			player.getCO().setWpnDmg(player.getInv().getEquipped().getDamage());
		}
		if(frame.getTab().getINV().getTab()=='c'){
			Usable u=player.getInv().drop(frame.getTab().getINV().getSelected());
			if(u==null)return;
			if(u.getID().equals("C0"))player.getCO().setHealth(100);
			if(u.getID().equals("C1"))player.getCO().setDmg(u.getValue());
			if(u.getID().equals("C2")){
				if(rooms.getMonster()!=null)rooms.getMonster().getCO().setArmor(0);
				else player.getInv().add(u);//can't use it if there is no monster
			}
			
		}
	}
	
	/**Pick up all the utems in the room's item drop
	 * Retrieve the item from index in the room's item list, and add it to the inventory
	 * make sure the item list display is empty
	 */
	private void pickupItems(){
		int n=0;
		while(rooms.getItemDrop().size()>n){
			player.getInv().add(rooms.getItemDrop().remove(n));
			n++;
		}
		//update the item list
		String[] itemNames={""};
		n=0;
		while(n<rooms.getItemDrop().size()){
			itemNames[n]=rooms.getItemDrop().get(n).getName();
			n++;
		}
		frame.getConsole().updatePickupList(itemNames);
	}
	/**
	 * get selected usable from the list (returns index of the inventory slot)
	 * get the value of the item index in that slot of the inventory
	 * 	-add an item to the current room's itemdrop using that item index
	 * set the value of that slot to zero in the inventory
	 * 
	 */
	private void dropItem(){if(frame.getTab().getINV().getSelected()>=0)rooms.getItemDrop().add( player.getInv().drop( frame.getTab().getINV().getSelected() ) );}

}
