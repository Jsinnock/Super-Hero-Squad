package models;

public class ItemPuzzle extends Puzzle{
	String itemNeeded;
	ItemPuzzle(String puzzleName, String roomLocation, String puzzleDescription,  String puzzleHint, String puzzleType, String itemNeeded) {
		super(puzzleName, roomLocation, puzzleDescription, puzzleHint, puzzleType);
		this.itemNeeded = itemNeeded;
	}
	
	public void setItemNeeded(String itemNeeded)
	{
		this.itemNeeded = itemNeeded;
	}
	
	public String getItemNeeded()
	{
		return itemNeeded;
	}
	
}
