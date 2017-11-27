package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import controllers.FileConfig;

public class Room {
	
	private File file;
	
	String id,name,description,puzzle;
	String[] exits;//ids for the rooms that can be traveled into
	boolean mon;//is there a monster for this room
	Monster monster;//
	LinkedList<Artifact> itemDrop;

	public Room(File file, String id, LinkedList<Artifact> items, Monster mon){//created when a save file is loaded
		//changing room doesn't create a new object, it reassigns the values
		this.file=file;
		enterRoom(id,items,mon);//enter the room from the save file
	}
	/**
	 * Change the properties of the room object to suit the new room
	 * The controller handles whether or not the player can change rooms,
	 * 	so thats not handled here
	 * @param id  		room to move into
	 * @param newRoom	false if this room has been entered before
	 * @param monster	monster that was escaped from.
	 */
	public void enterRoom(String id, LinkedList<Artifact> items, Monster mon){
		String[] data = readDataFromFile(id);
		this.id=data[0];
		name=data[1];
		description=data[2];
		String[] e=data[3].split(",");
		exits=new String[e.length];
		int n=0;
		while(n<e.length){exits[n]=e[n];
			n++;}
		puzzle=data[4];
		this.mon=Boolean.parseBoolean(data[5]);
		if(Boolean.parseBoolean(data[5])){
			if(mon==null)monster=new Monster(FileConfig.monsterfile,data[6]);
			else monster=mon;}
		if(items==null){//populate item field with default data from file
			itemDrop=new LinkedList<Artifact>();
			itemDrop.add(Artifactory.newArtifact(data[7]));
		}else itemDrop=items;
	}
	
	//read data from file to populate fields
	private String[] readDataFromFile(String id){
		String[] field=null;
		
		try {
			FileReader fr=new FileReader(file);
			BufferedReader reader=new BufferedReader(fr);
			String line;
			try{
				while((line=reader.readLine())!=null){
					if(line.startsWith(id)){
						field=line.split(";;");
					}
				}if(field==null)System.out.println("id:" +id + " not found in data file");
			}catch( IOException e ){}
			try {reader.close();} catch (IOException e) {e.printStackTrace();}
			try {fr.close();} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {System.out.println("Data file not found");}
		return field;
	}

	public void spawn(Monster m){
		monster=m;
	}

	public void kill(){
		monster=null;
	}
	//getter methods
	public String getID(){return id;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	public int getExits(){return exits.length;}
	public String getExit(int id) {
		if(id>getExits())return null;
		return exits[id];
	}
	public String getPuzzle() {return puzzle;}
	public boolean isMon() {return mon;}
	public Monster getMonster() {
		if(monster!=null)return monster;
		return null;
	}
	public LinkedList<Artifact> getItemDrop() {return itemDrop;}

}
