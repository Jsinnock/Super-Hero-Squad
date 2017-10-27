
public class Puzzle extends {
	String roomLocation;
	String puzzleDescription;
	String puzzleName;
	
	Puzzle(String roomLocation, String puzzleDescription, String puzzleName)
	{
		this.roomLocation = roomLocation;
		this.puzzleDescription = puzzleDescription;
		this.puzzleName = puzzleName;
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
