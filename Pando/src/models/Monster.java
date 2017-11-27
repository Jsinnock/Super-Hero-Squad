package models;

import java.io.File;

public class Monster extends DataFile {
	
	
	private CombatObject co;
	private float atkChance,escChance;
	private Artifact item;
	
	public Monster(File file, String id) {
		super(file, id);
		// TODO Auto-generated constructor stub
	}
	protected void populateFields(String[] data){
		super.populateFields(data);
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
		System.out.println(data[3]);
		System.out.println(data[4]);
		System.out.println(data[5]);
		System.out.println(data[6]);
		String[] s= data[3].split(",");
		co=new CombatObject(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
		atkChance=Float.parseFloat(data[4]);
		escChance=Float.parseFloat(data[5]);
		item=Artifactory.newArtifact(data[6]);
		/*if(!data[6].equals(" ")){
		String[] i= data[6].split(",");
		int n=0;
		while(n<i.length){
		System.out.println(i[n]);
			item[n]=Artifactory.newArtifact(i[n]);
			n++;
		}}*/
	}

	public CombatObject getCO(){
		return co;
	}
	public float getAtkChance() {
		return atkChance;
	}
	public float getEscChance() {
		return escChance;
	}
	public Artifact getItem(){
		return item;
	}

	
}
