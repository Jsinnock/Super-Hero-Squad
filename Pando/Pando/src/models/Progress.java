package models;

import java.io.Serializable;
import java.util.LinkedList;

import controllers.FileConfig;
/**
 * Stores the progress that the player has made so far
 *
 */
@SuppressWarnings("serial")
public class Progress implements Serializable{

	private boolean code1=false,code2=false,plasticTray=false,
			puz[]=new boolean[9];
	private Stats observer;
	
	//save data for rooms
	private String[] roomEntered;//save each room id for every room that has been entered
	@SuppressWarnings("unchecked")
	private LinkedList<Artifact> itemDrop[]=new LinkedList[42];
	private String[] monsterDefeated;//save room id for every room in which the monster is defeated
	private String[] escapedMonsters;//save room id for every entered room in which there is a monster that is still alive
	private Monster[] monster=new Monster[42];// save every monster that was escaped from. 
	/**
	 * create a progress with the default values
	 */
	public Progress(){
		roomEntered=new String[42];
		int n=0;
		while(n<roomEntered.length){
			itemDrop[n]=new LinkedList<Artifact>();
			n++;
		}
		monsterDefeated=new String[42];
		escapedMonsters=new String[42];
		n=0;
		while(n<escapedMonsters.length){
			monster[n]=new Monster(FileConfig.monsterfile," ");
			n++;
		}
	}
	/**
	 * called by the controller when loading a save file
	 */
	public Progress(String[] re,LinkedList<Artifact>[] i,String[] md,String[] em,Monster[] m){
		roomEntered=re;
		itemDrop=i;
		monsterDefeated=md;
		escapedMonsters=em;
		monster=m;
	}
	
	
	public void addObserver(Stats o){
		observer=o;
	}
	
	/**
	 * Check to see if a room has been entered
	 * @param id  room id for the room to check
	 * @return
	 */
	public boolean getRoomEntered(String id){
		int n=0;
		while(n<roomEntered.length){
			if(roomEntered[n]!=null)if(roomEntered[n].equals(id))return true;
			n++;
		}return false;
	}
	
	/**
	 * called by the puzzle class when the puzzle is solved
	 */
	public void puzzle(int n){puz[n]=true;}
	public boolean getMonsterDefeated(String id){
		int n=0;
		while(n<monsterDefeated.length){
			if(monsterDefeated[n]!=null)if(monsterDefeated[n].equals(id))return true;
			n++;
		}return false;
	}
	public boolean getEscaped(String id){
		int n=0;
		while(n<escapedMonsters.length){
			if(escapedMonsters[n]!=null)if(escapedMonsters[n].equals(id))return true;
			n++;
		}return false;
	}
	public Monster getMonster(String id){
		int n=0;
		while(n<escapedMonsters.length){
			if(escapedMonsters[n]!=null)if(escapedMonsters[n].equals(id))return monster[n];
			n++;
		}return null;
	}
	/**
	 * return whether or not a puzzle has been completed
	 * @param n
	 * @return
	 */
	public boolean puz(int n){return puz[n];}
	/**
	 * get the itemlist that was saved for the room
	 * returns null if the room hasn't been entered before
	 * @param id 	room id to get the items for
	 * @return
	 */
	public LinkedList<Artifact> getItems(String id){
		int n=0;
		while(n<roomEntered.length){
			if(roomEntered[n]!=null)if(roomEntered[n].equals(id))return itemDrop[n];
			n++;
		}return null;
	}
	/**
	 * called by the controller when the room is changed
	 * updates rooms entered, monsters defeated, and saves the items that are in the room
	 * @param id
	 * @param items			
	 * @param monDefeated	true if the monster in this room is killed
	 * @param monster		true if this room has a monster in it by default
	 */
	public void addRoom(String id,LinkedList<Artifact> items,boolean monDefeated,Monster monster){
		
		if(getRoomEntered(id)){//if this room has been entered before, then update it instead of adding it to the list
			itemDrop[getIndex(id)]=items;
			if(getMonsterDefeated(id));//if monster was not already defeated, then it was escaped from
			else if(monDefeated){//the monster is defeated now so remove it from the escaped list and add to defeated list
				int n=0;
				while(n<monsterDefeated.length){
					if(monsterDefeated[n]==null){
						monsterDefeated[n]=id;
					}n++;
				}n=0;
				//monsterDefeated[monsterDefeated.length]=id;
				while(n<escapedMonsters.length){//find the monster in the escaped list and remove it
					if(escapedMonsters[n]!=null)if(escapedMonsters[n].equals(id))escapedMonsters[n]=null;
					n++;
				}n=0;
			}
			//if you escape again, then nothing needs to be changed
		}else{//first time adding this room to the list
			//iterate through the list and find the first one that is not null
			int n=0;
			while(n<roomEntered.length){
				if(roomEntered[n]==null){
					roomEntered[n]=id;
					break;
				}n++;
			}n=0;
			while(n<itemDrop.length){
				if(itemDrop[n]==null){
					itemDrop[n]=items;
					break;
				}n++;
			}n=0;
			//itemDrop[itemDrop.length]=items;
			if(monster!=null){
				if(monDefeated) {
					while(n<monsterDefeated.length){
						if(monsterDefeated[n]==null){
							monsterDefeated[n]=id;
						}n++;
					}n=0;
					//monsterDefeated[monsterDefeated.length]=id;
				}
				else {
					while(n<escapedMonsters.length){
						if(escapedMonsters[n]==null){
							escapedMonsters[n]=id;
						}n++;
					}n=0;
					//escapedMonsters[escapedMonsters.length]=id;
				}
			}
		}observer.updateRooms(countRooms());
	}
	/**
	 * get the index(in the list of saved rooms) of a specific room
	 * 
	 */
	private int getIndex(String room){
		int n=0;
		while(n<roomEntered.length){
			if(roomEntered[n]!=null)if(roomEntered[n].equals(room))return n;
			n++;
		}return -1;
	}
	/**
	 * count the number of rooms that have been entered
	 * @return
	 */
	private int countRooms(){
		int i=0,c=0;
		while(i<42){
			if(roomEntered!=null)c++;
			i++;
		}return c;
	}
	public boolean isCode1() {return code1;}
	public void setCode1(boolean code1) {this.code1 = code1;}
	public boolean isCode2() {return code2;}
	public void setCode2(boolean code2) {this.code2 = code2;}
	public boolean isPlasticTray() {return plasticTray;}
	public void setPlasticTray(boolean plasticTray) {this.plasticTray = plasticTray;}
}
