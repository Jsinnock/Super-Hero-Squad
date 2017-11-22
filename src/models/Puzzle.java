package models;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

public class Puzzle extends Observable{
	private String puzzleName;
	private String puzzleLocation;
	private String puzzleDescription;
	private String puzzleHint;
	private String puzzleType;
	
	Puzzle( String puzzleName, String puzzleLocation, String puzzleDescription, String puzzleHint, String puzzleType)
	{
		this.puzzleLocation = puzzleLocation;
		this.puzzleDescription = puzzleDescription;
		this.puzzleName = puzzleName;
		this.puzzleHint = puzzleHint;
		this.puzzleType = puzzleType;
	}
	
	public void setPuzzleLocation(String puzzleLocation)
	{
		this.puzzleLocation = puzzleLocation;
	}
	
	public String getPuzzleLocation()
	{
		return puzzleLocation;
	}
	
	public void setRoomDescription(String puzzleDescription)
	{
		this.puzzleDescription = puzzleDescription;
	}
	
	public String getPuzzleDescription()
	{
		return puzzleDescription;
	}
	
	public void setPuzzleName(String puzzleName)
	{
		this.puzzleName = puzzleName;
	}
	
	public String getPuzzleName()
	{
		return puzzleName;
	}
	
	public void setPuzzleHint(String puzzleHint)
	{
		this.puzzleHint = puzzleHint;
	}
	
	public String getPuzzleHint()
	{
		return puzzleHint;
	}
	public void setPuzzleType(String puzzleType)
	{
		this.puzzleType = puzzleType;
	}
	
	public String getPuzzleType()
	{
		return puzzleType;
	}
	
	
	
}