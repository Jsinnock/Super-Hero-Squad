package models;

import java.io.File;
/**
 * parent class for objects that can be stored in the inventory
 *
 */
@SuppressWarnings("serial")
public class Artifact extends DataFile{

	protected char type;//used to determine the type of artifact
	public Artifact(File file, String id) {
		super(file, id);
		// TODO Auto-generated constructor stub
	}

	public char getType(){
		return type;
	}
	

}
