package models;

import java.io.File;

@SuppressWarnings("serial")
public class Usable extends Artifact {

	private int value;
	public Usable(File file, String id) {
		super(file, id);
		type='c';
	}

	protected void populateFields(String[] data){
		super.populateFields(data);
		value=Integer.parseInt(data[3]);
	}
	public int getValue() {return value;}
}
