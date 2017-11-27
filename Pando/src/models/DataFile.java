package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataFile {
	
	
	private File file;//file to get the data from
	
	protected String id,name,description;

	
	/**
	 * 
	 * @param file - file to read the data from
	 * @param id - id for the item to create
	 */
	DataFile(File file, String id){
		this.file=file;
		readDataFromFile(id);
	}
	
	/**read from the file and set the name and description fields
	 * 
	 * @param id - id for the item to create
	 */
	private void readDataFromFile(String id){
		try {
			FileReader fr=new FileReader(file);
			BufferedReader reader=new BufferedReader(fr);
			String line;
			String[] field=null;
			try{
				while((line=reader.readLine())!=null){
					if(line.startsWith(id)){
						field=line.split(";;");
						populateFields(field);
					}
				}if(field==null)System.out.println("id:" +id + " not found in data file");
			}catch( IOException e ){}
			try {reader.close();} catch (IOException e) {e.printStackTrace();}
			try {fr.close();} catch (IOException e) {e.printStackTrace();}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Data file not found");
			//e.printStackTrace();
		}
		
	}
	protected void populateFields(String[] data){
		id=data[0];
		name=data[1];
		description=data[2];
	}

	public String getID(){return id;}
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
