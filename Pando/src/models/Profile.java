package models;

import java.io.*;

public class Profile {

	private String username,password;
	private File saveFile;

	/**
	 * create a new profile object
	 * 
	 */
	public Profile(){
		
	}
	
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
			String p=(String)in.readObject();
			in.close();
			i.close();
			if(p.equals(word)){
				password=p;
				username=name;
				return true;
			}
		}return false;
	}

	public boolean newUser(String name,String word){
		saveFile=new File(name+".bi");
		if(saveFile.exists())return false;
		else {
			username=name;
			password=word;
			return true;
		}
	}
	
	/**
	 * retreive co,room,progress,stats,inventory
	 * @return  false if the save didnt work
	 */
	public boolean save(Player player,String roomID){
		FileOutputStream o;
		ObjectOutputStream out;
		try {	o = new FileOutputStream(saveFile,false);
			try { out=new ObjectOutputStream(o);
				out.writeChars(password);
				out.writeChars(roomID);
				out.writeObject(player.getCO());
				out.writeObject(player.getInv());
				out.writeObject(player.getProgress());
				out.writeObject(player.getStats());
			out.close();
			o.close();
			return true;
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {e.printStackTrace();}
		return false;
	}
	
	public SaveData load() throws ClassNotFoundException{
		FileInputStream i;
		ObjectInputStream in;
		try {	i= new FileInputStream(saveFile);
			try {	in=new ObjectInputStream(i);
			SaveData s;
			in.readObject();//skip the first object
			s=new SaveData((String)in.readObject(),(CombatObject)in.readObject(),
					(Inventory)in.readObject(),(Progress)in.readObject(),(Stats)in.readObject());
			in.close();
			i.close();
			return s;
			} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {e.printStackTrace();}
		return null;
	}
}
