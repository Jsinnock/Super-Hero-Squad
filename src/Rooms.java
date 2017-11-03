public class Rooms {

	private String[] name;

	private String[] description;

	private byte[] exits[];

	private byte[] monster;

	private ItemDrop[] items;

	private Puzzle[] puzzle;

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

}
