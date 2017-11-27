package databases;


import java.util.LinkedList;

import controllers.Puzzle;
import models.Artifact;

public class Rooms {
	/*
	 * name description
	 * exits itemList
	 * monster puzzle
	 */
	public static final int COUNT=32;
	private final String[] name=new String[]{
			"Stairs",
			"Lounge 1",
			"Intensive Care 3",
			"Operating Viewing Room",
			"Operating Room",
			"Hallway 2",
			"Lobby 1",
			"Hallway 1",
			"Intensive Care Overflow 1",
			"Intensive Care Overflow 2",
			"Medical Wing Bathroom",
			"Medical Laboratory",
			"2nd floor"
	};
	private final String[] description=new String[]{
			//first floor (12)
			"Using only the flickering lights from the LED’s in your suit, you carefully make your way up the stairs holding onto the railing as your boots grip the bloody floor. At the top, there are two large automatic double doors to the east opening and closing as if being blocked by something.",
			"As you enter the dimly lit room, a feeling of normalcy overcomes you. This was once a social place full of life as you see a tv flickering and half eaten dishes on the table. Whoever was present left this place with urgency.",
			"A vast room full of raggedy beds and worn blood-stained medical rags. Most of the beds are occupied by what seems to be empty vessels of the crew. To the west is a supply closet that could contain useful supplies.",
			"A very long room filled with mostly shattered windows. Peering through the broken glass, you witness an automated operating machine on the fritz. Perhaps the room contains details on what happened to the crew",
			"Entering the oddly shaped room, the self operating robot seems to be attempting to examine the remains of what appears to be a skeleton with a perfectly intact plastic cafeteria tray still being clenched.",
			"A surprisingly lit corridor. Illuminated on the wall is a medi-kit",
			"A massive room with the floors covered in ceiling tiles from where part of the ceiling caved in. The tables and chairs are scattered along the room.",
			"You walk this long hallway until you intersect a large slimy substance that appears to awaken.",
			"After defeating the grotesque being, you gain access to a seemingly untouched room with beds that still seem to be made.",
			"Unlike it’s adjoined room, this room seems as if a struggle broke out. There are claw marks running across the thick metal walls and a stench of sewage in the air. The bathroom to the right could be contributing to the smell.",
			"The showers appear to still be running, and the flooded bathroom makes it hard to shift through the stalls. There seems to be a noise coming from one of the stalls.",
			"A high-tech facility that has chemistry sets with strange substances in them. A set of notes are laying on the desk with a video log acting as a paper holder. In the corner of the room is a broken glass case with a piece of an earthy material still occupying the case.",
			//second floor
			"2nd floor"
			
			//Third floor
	};
	//private static final Puzzle[] puzzle;
	private static LinkedList<Artifact> itemDrop;
	//private static final byte[] monster;
	private final byte[][] exits=new byte[][]{
		new byte[]{1,12},
		new byte[]{0,2},
		new byte[]{1,3,9,11},
		new byte[]{2,4,5},
		new byte[]{3},
		new byte[]{3,6},
		new byte[]{5,7},
		new byte[]{6,8},
		new byte[]{7,9},
		new byte[]{8,10,2},
		new byte[]{9},
		new byte[]{2},
		new byte[]{0},
	};
	
	
	private Rooms(){	}
	private static class Room {private static final Rooms rooms=new Rooms();}
	public static final Rooms getRooms(){return Room.rooms;}
	public String getName(byte id) {
		return name[id];
	}
	
	public String getDescription(byte id) {
		return description[id];
	}
	/*
	public static Puzzle getPuzzle(byte id) {
		return puzzle[id];
	}
	public static byte getDefaultitemdrop(byte id) {
		return defaultItemDrop[id];
	}
	public static byte getMonster(byte id) {
		return monster[id];
	}
	*/
	//return the list of exits
	public byte[] getExits(byte id) {
		return exits[id];
	}
	
	public LinkedList<Artifact> getItems(){
		return itemDrop;
	}

	
}
