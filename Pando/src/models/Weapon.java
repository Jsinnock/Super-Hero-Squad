package models;

import java.io.File;

public class Weapon extends Artifact {

	private int damage;
	public Weapon(File file, String id) {
		super(file, id);
		type='w';
		// TODO Auto-generated constructor stub
	}
	protected void populateFields(String[] data){
		super.populateFields(data);
		damage=Integer.parseInt(data[3]);
	}
	public int getDamage() {
		return damage;
	}
	
	
}
