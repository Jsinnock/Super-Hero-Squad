
public class ItemPuzzle extends Puzzle{
	String itemNeeded;
	
	boolean isItemEquipped()
	{
		if(itemNeeded == "1")
		{
			return true;
		}
		else return false;
	}
	
}
