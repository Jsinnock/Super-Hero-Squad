package models;

import java.io.File;

@SuppressWarnings("serial")
public class Monster extends DataFile {
	
	
	private CombatObject co;
	private float atkChance,escChance;
	private Artifact item;
	
	public Monster(File file, String id) {
		super(file, id);
	}
	protected void populateFields(String[] data){
		super.populateFields(data);
		String[] s= data[3].split(",");
		co=new CombatObject(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
		atkChance=Float.parseFloat(data[4]);
		escChance=Float.parseFloat(data[5]);
		item=Artifactory.newArtifact(data[6]);
	}

	public CombatObject getCO(){return co;}
	public float getAtkChance() {return atkChance;}
	public float getEscChance() {return escChance;}
	public Artifact getItem(){return item;}

	
}
