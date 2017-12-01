package controllers;

import java.io.*;

import models.*;
import models.Player;

public class Profile {

	private String password;
	private File saveFile;
	private File otherFile;

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
		otherFile=new File(name+".pr");
		saveFile=new File(name+".bi");
		if(otherFile.exists()){
			FileInputStream i=new FileInputStream(otherFile);
			DataInputStream d=new DataInputStream(new BufferedInputStream(i));
			String p=d.readUTF();
			System.out.println(p);
			System.out.println(word);

			System.out.println(word.getBytes("UTF-8"));
			d.close();
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
		otherFile=new File(name+".pr");
		if(saveFile.exists())return false;
		else {
			password=word;
			return true;
		}
	}
	
	/**
	 * retrieve co,room,progress,stats,inventory from the player, and write them to a binary file
	 * @return  false if the save didnt work
	 * @throws IOException 
	 */
	public boolean save(Player player,String roomID) throws IOException{
		FileOutputStream o,oo;
		ObjectOutputStream out;
	
		//byte[] pass=password.getBytes("UTF-8"),r=roomID.getBytes("UTF-8");
		try {	
			oo = new FileOutputStream(otherFile);
			DataOutputStream d=new DataOutputStream(new BufferedOutputStream(oo));
			d.writeUTF(password);
			d.writeUTF(roomID);
			d.close();
			oo.close();
			o = new FileOutputStream(saveFile);
			try { 
				out=new ObjectOutputStream(o);
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
	 * @throws IOException 
	 */
	public SaveData load() throws ClassNotFoundException, IOException{
		FileInputStream i,ii;
		ObjectInputStream in;
		try {	ii= new FileInputStream(otherFile);
		DataInputStream d=new DataInputStream(new BufferedInputStream(ii));
		d.readUTF();//System.out.println(d);
		String s=d.readUTF();System.out.println(s);
		d.close();
		ii.close();
		i= new FileInputStream(saveFile);
			try {	in=new ObjectInputStream(i);
			SaveData sd;
			sd=new SaveData(s,(CombatObject)in.readObject(),
					(Inventory)in.readObject(),(Progress)in.readObject(),(Stats)in.readObject());
			in.close();
			i.close();
			return sd;
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {e.printStackTrace();}
		return null;
	}
	/**
	 * called by the controller when a new game is started
	 * @return false if the file does not exist so the controller knows to save a file for a newly created account
	 */
	public boolean exists(){return saveFile.exists();}
	@SuppressWarnings("serial")
	private class PassRoom implements Serializable{
		String[] s = new String[2];
	}
}
