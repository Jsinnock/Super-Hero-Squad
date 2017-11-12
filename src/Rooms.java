import java.util.Observable;

public class Rooms extends Observable{
	private String nameList;
	private String descriptionList;
	private String exitsList;
	private String monstersList;
	private String itemsList;
	private String puzzleList;
	
	Rooms(String nameList, String descriptionList, String exitsList, String monstersList,
			String itemsList, String puzzleList)
	{
		this.nameList = nameList;
		this.descriptionList = descriptionList;
		this.exitsList = exitsList;
		this.monstersList = monstersList;
		this.itemsList = itemsList;
		this.puzzleList = puzzleList;
	}
	
	public String getNameList() {
		return nameList;
	}
	
	public void setNameList(String nameList) {
		this.nameList = nameList;
	}
	
	public String getDescriptionList() {
		return descriptionList;
	}
	
	public void setDescriptionList(String descriptionList) {
		this.descriptionList = descriptionList;
	}
	
	public String getExitsList() {
		return exitsList;
	}
	
	public void setExitsList(String exitsList) {
		this.exitsList = exitsList;
	}
	
	public String getMonstersList() {
		return monstersList;
	}
	
	public void setMonstersList(String monstersList) {
		this.monstersList = monstersList;
	}
	
	public String getItemsList() {
		return itemsList;
	}
	
	public void setItemsList(String itemsList) {
		this.itemsList = itemsList;
	}
	
	public String getPuzzleList() {
		return puzzleList;
	}
	
	public void setPuzzleList(String puzzleList) {
		this.puzzleList = puzzleList;
	}

	/**
	private String[] name;

	private String[] description;

	private byte[] exits[];

	private byte[] monster;

	private ItemDrop[] items;

	private Puzzle[] puzzle;
	
	Rooms(){
		name=new String[]{
				"Staircase Sector","Lounge 1","Intensive Care 3","Operating Viewing Room",
				"Operating Room","Hallway 2","Lobby 1","Hallway 1",
				"Intensive Care Overflow 1","Intensive Care Overflow 2","Medical Wing Bathroom","Medical Laboratory",
				"Bathroom","Bedroom","Office","Planning Room",
				"Kitchen","Cafeteria","Short Hallway","Lounge",
				"Bathroom","Showers","North Hall","Recreation Room",
				"Locker Room","Laboratory","Storage Room","Captain's Hallway",
				"Command Room","Cryo-Storage","Incubation","Lobby",
				"DNA Library","Cryo-Storage","Incubation","Lobby",
				
		};
	};

	public String getName(byte id) {
		return name[id];
	}

	public String getDescr(byte id) {
		return description[id];
	}

	public byte[] getExits(byte id) {
		return exits[id];
	}

	public byte getMonster(byte id) {
		return monster[id];
	}

	public ItemDrop getItems(byte id) {
		return items[id];
	}

	public Puzzle getPuzzle(byte id) {
		return puzzle[id];
	}
	**/

}
