package models;
import java.util.Observable;

public class Puzzle extends Observable{
	String roomLocation;
	String puzzleDescription;
	String puzzleName;
	String puzzleHint;
	
	Puzzle(String roomLocation, String puzzleDescription, String puzzleName, String puzzleHint)
	{
		this.roomLocation = roomLocation;
		this.puzzleDescription = puzzleDescription;
		this.puzzleName = puzzleName;
		this.puzzleHint = puzzleHint;
	}
	
	public void setRoomLocation(String roomLocation)
	{
		this.roomLocation = roomLocation;
	}
	
	public void setRoomDescription(String puzzleDescription)
	{
		this.puzzleDescription = puzzleDescription;
	}
	
	public void setPuzzleName(String puzzleName)
	{
		this.puzzleName = puzzleName;
	}
	
	
	
	
}
