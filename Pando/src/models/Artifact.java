package models;

import java.io.File;

public class Artifact extends DataFile{

	protected char type;
	public Artifact(File file, String id) {
		super(file, id);
		// TODO Auto-generated constructor stub
	}
	
	public char getType(){
		return type;
	}
	

}
