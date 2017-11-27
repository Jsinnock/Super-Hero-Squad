package models;

import java.io.File;

public class Usable extends Artifact {

	private int value;
	public Usable(File file, String id) {
		super(file, id);
		type='c';
		// TODO Auto-generated constructor stub
	}

	protected void populateFields(String[] data){
		super.populateFields(data);
		value=Integer.parseInt(data[3]);
	}
	public int getValue() {
		return value;
	}
}
