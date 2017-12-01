package models;

import java.io.File;

@SuppressWarnings("serial")
public class Item extends Artifact {

	
	public Item(File file, String id) {
		super(file, id);
		type='i';
	}

}
