package controllers;

import java.io.*;

import models.*;
import models.Player;

public class Profile {

	private String password;
	private File saveFile;

	/**
	 * create a new profile object
	 * 
	 */
	public Profile(){}
	
	/**
	 * 
	 * try to find the username in the list of file names.
	 * 	if a match is found, open the file and retrieve the password
	 * 		if word matches password, then return true
	 * called by the controller when the login button is clicked
	 * @param name
	 * @param word
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public boolean tryLogin(String name,String word) throws IOException, ClassNotFoundException{
		saveFile=new File(name+".bi");
		if(saveFile.exists()){
			FileInputStream i=new FileInputStream(saveFile);
			ObjectInputStream in=new ObjectInputStream(i);
			int v=in.readInt();
			byte[] s=new byte[v];
			in.read(s);
			String p=in.readUTF();
			System.out.println(p);
			in.close();
			i.close();
			if(p.equals(word)){
				password=p;
				return true;
			}
		}return false;
	}

	/**
	 * evaluate if the account exists already, and if it dosnt, then set the varable to prepare for the account to be saved
	 * @param name
	 * @param word
	 * @return false if the username is already taken
	 */
	public boolean newUser(String name,String word){
		saveFile=new File(name+".bi");
		if(saveFile.exists())return false;
		else {
			password=word;
			return true;
		}
	}
	
	/**
	 * retrieve co,room,progress,stats,inventory from the player, and write them to a binary file
	 * @return  false if the save didnt work
	 * @throws UnsupportedEncodingException 
	 */
	public boolean save(Player player,String roomID) throws UnsupportedEncodingException{
		FileOutputStream o;
		ObjectOutputStream out;
		byte[] pass=password.getBytes("UTF-8"),r=roomID.getBytes("UTF-8");
		try {	o = new FileOutputStream(saveFile,false);
			try { out=new ObjectOutputStream(o);
			out.writeInt(pass.length);
				out.write(pass);
				out.writeInt(r.length);
				out.write(r);
				out.writeObject(player.getCO());
				out.writeObject(player.getInv());
				out.writeObject(player.getProgress());
				out.writeObject(player.getStats());
			out.close();
			o.close();
			return true;
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {e.printStackTrace();}
		if(saveFile.exists())saveFile.delete();
		return false;
	}
	/**
	 * read the data from the binary file and return it
	 * @return
	 * @throws ClassNotFoundException
	 */
	public SaveData load() throws ClassNotFoundException{
		FileInputStream i;
		ObjectInputStream in;
		try {	i= new FileInputStream(saveFile);
			try {	in=new ObjectInputStream(i);
			SaveData s;
			int l=in.readInt();//skip the first object
			in.read(new byte[l]);
			l=in.readInt();
		
			s=new SaveData(in.readUTF(),(CombatObject)in.readObject(),
					(Inventory)in.readObject(),(Progress)in.readObject(),(Stats)in.readObject());
			in.close();
			i.close();
			return s;
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {e.printStackTrace();}
		return null;
	}
	/**
	 * called by the controller when a new game is started
	 * @return false if the file does not exist so the controller knows to save a file for a newly created account
	 */
	public boolean exists(){return saveFile.exists();}
}
