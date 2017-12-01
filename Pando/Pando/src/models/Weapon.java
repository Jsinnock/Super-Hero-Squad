package models;

import java.io.File;

@SuppressWarnings("serial")
public class Weapon extends Artifact {

	private int damage;
	public Weapon(File file, String id) {
		super(file, id);
		type='w';
	}
	protected void populateFields(String[] data){
		super.populateFields(data);
		damage=Integer.parseInt(data[3]);
	}
	public int getDamage() {return damage;}
	
	
}
