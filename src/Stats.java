
public class Stats {
	int health = 15;
	int kills = 0;
	int roomsDiscovered = 0;
	int itemsCollected = 0;
	int itemsUsed =0;
	
	public Stats(int health, int kills, int roomsDiscovered, int itemsCollected, int itemsUsed)
	{
		this.health = health;
		this.kills = kills;
		this.roomsDiscovered = roomsDiscovered;
		this.itemsCollected = itemsCollected;
		this.itemsUsed = itemsUsed;
	}
	
	public void setHealth(int health){
		this.health = health;
		
	}
}
