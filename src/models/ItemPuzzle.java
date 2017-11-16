package models;

public class ItemPuzzle extends Puzzle{
	String itemNeeded;
	ItemPuzzle(String roomLocation, String puzzleDescription, String puzzleName, String puzzleHint, String itemNeeded) {
		super(roomLocation, puzzleDescription, puzzleName, puzzleHint);
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
