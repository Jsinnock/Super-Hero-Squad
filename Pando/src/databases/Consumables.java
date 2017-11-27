package databases;
public class Consumables extends Artifacts {

	//private String type;

	private int[] value={
			0,10,1,5,3
	};
	
	Consumables(){
		name=new String[]{
				"",
				"Med Pack",//1
				"Ammo",//2
				"Strength Potion",//3
				"Flash Grenade"//4
		};
		description= new String[]{
				"",
				"Item that restores health. Usually dropped by monsters or found throughout the ship",
				"Ammunition for the energy blaster. It looks like a battery pack",
				"A small glass tube with a thick, luminescent green liquid in it",
				"A grenade that releases a blinding light"
				
		};
	}

	public static void consume(byte id) {

	}

}
