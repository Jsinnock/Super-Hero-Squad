package models;

public class ItemPuzzle extends Puzzle{
	String itemNeeded;
	ItemPuzzle(String puzzleName, String roomLocation, String puzzleDescription,  String puzzleHint, String puzzleType, String itemNeeded) {
		super(puzzleName, roomLocation, puzzleDescription, puzzleHint, puzzleType);
		this.itemNeeded = itemNeeded;
	}
	boolean isItemInInventory()
	{
		if(itemNeeded == "1")
		{
			return true;
		}
		else return false;
	}
	
}
