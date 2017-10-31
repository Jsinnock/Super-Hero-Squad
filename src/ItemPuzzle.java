
public class ItemPuzzle extends Puzzle{
	String itemNeeded;
	ItemPuzzle(String roomLocation, String puzzleDescription, String puzzleName, String itemNeeded) {
		super(roomLocation, puzzleDescription, puzzleName);
		this.itemNeeded = itemNeeded;
	}
	boolean isItemEquipped()
	{
		if(itemNeeded == "1")
		{
			return true;
		}
		else return false;
	}
	
}
