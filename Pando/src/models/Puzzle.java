package models;

public  class Puzzle {
	
	Puzzle(){
		
	}
	private static final String[] 
			start={
					"There is a comfortable bed in here. Resting on it will restore your health",
					"After searching doctors computer you find an audio log. The audio log echoes across the room “I began running tests after salvaging the remains of the crew member. The body was severely burned with what appears to be hydrochloric acid… I need to finish the simulator to see what kind of material will protect against this.”",
					"After hearing a noise coming from one of the stalls, your curiosity gets the best of you and forces you to investigate.",
					"There is a closet that has three buttons on it",
					"There is a cabinet that has three buttons on it",
					"The keypad reads “Please enter the captain’s key.”",
					"You start picking up large pieces of debris and moving them out of the way in order to move further into the room. After working for nearly half an hour, you clear a path to a side wall of the room. Blending in with the instruments and tools in the room, there is what looks like a high-tech gas mask locked away in an undamaged glass case.",
					"As you look at the screen you see a long list of incomprehensible numbers and letters that appear to be a code of some kind, and you notice a rather hard to ignore gap in the code",
					"As you examine the still intact incubator you notice slots where you could possibly place 3 vials of some kind, you notice a glowing yellow vial and pick it up"
								},
			solve={
					"",
					"Simulation successful. Plastic was not destroyed",
					"",//
					"You find X Files . You take these significant files and use them for research.",
					"You find Alien X . You take this significant item and use it for research.",
					"You hear the click of two locks disengaging. The contents of the first compartment are much higher quality things than the previous compartments: finer clothes, battle armor, weapons, and field supplies.",
					"The lock breaks and the door to the case opens. You reach in and grab the gas mask. Gas Mask added to inventory.",
					"Arboretum Unlocked",
					"The machine presents you with a demon bane flower, which you hesitantly take"	
								},
			fail={
					"",
					"Simulation failed. Material Destroyed",
					"",//
					"",//
					"",//
					"You don’t have the right key for this keyhole, keep an eye out for it.",
					"You grab a metal piece of debris and smash the glass case, reach in and grab the gas mask. When you pull the mask out, you scrape your arm along a shard of glass protruding from the top of the case. You lose 30 health points. Gas Mask added to inventory.",
					"You do not know what the code is maybe you should look around for it",
					"Maybe you should look for more vials"
			},
			option[]={
					{"Rest on bed"},
					{"Test Plastic","Test Metal","Test Glass"},			
					{"Open first Stall","Open second Stall","Open third Stall",},			
					{"Button 1","Button 2","Button 3"},
					{"Button 1","Button 2","Button 3"},			
					{"Open cabinet"},			
					{"Break glass","Force lock"},			
					{"Enter Code"},			
					{"Try Combination A","Try Combination B","Try Combination C"},					
								};
	
	public void getOption(){}
	public String getText(){
		return "puzzle";
	}
	public static String start(String id){
		if(id.equals(""))return null;
		char[] c=id.toCharArray();
		System.out.println(c);
		return start[Character.getNumericValue(c[1])];
	}
	public static String solve(String id){
		char[] c=id.toCharArray();
		return solve[Character.getNumericValue(c[1])];
	}
	public static String fail(String id){
		char[] c=id.toCharArray();
		return fail[Character.getNumericValue(c[1])];
	}
	public static String[] options(String id){
		char[] c=id.toCharArray();
		return option[Character.getNumericValue(c[1])];
	}

}
