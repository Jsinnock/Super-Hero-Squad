package databases;
public final class Items extends Artifact {
	
	//there are 13 items
	Items(){
		name=new String[]{
				"",
				//Parts to the vaccine[1-3]
				"Mysterious Vial", "Piece of alien meteorite","Alien X",
				//Keys[4-6]
				"Mysterious Key","Office Key","Captian's Key",
				//suit[7,8]
				"Hazmat Suit","Gas Mask",
				//vials[9-11]
				"Blue Vial","Pink Vial", "Gold Vial",
				//other[12,13]
				"X Files", "Demon's Bane Flower","Reinforced Armor"
		};
		description=new String[]{
				"",
				//vaccine parts[2-4]
				"A special vial coated with a mysterious substance",
				"Part of an alien meteorite that the crew excavated",
				"A powerful allergen that instantly kills one’s immune system and their whole well-being, mutating them into something inhuman",
				//keys
				"A metal key that must open a door",
				"Looks like a normal key",
				"A metal key used to unlock something",
				//Suit
				"A full-body suit designed to keep harmful toxins away from the wearer. The face mask is missing, however",
				"A mask that goes over the wearer’s head and filters out all harmful substances in the air",
				//Vials
				"A vial similar to the ones in the DNA Library, it glows light blue",
				"A vial similar to the ones in the DNA Library, it glows bright pink",
				"A vial similar to the ones in the DNA Library, it glows golden yellow",
				//other
				"Recorded documentation of all experiments and research done while in space. Most importantly it contains reports on events leading up to the virus spreading throughout the ship",
				"A beautiful flower that seems to survive unattached to the ground, the veins running through its petals give a faint glow as a heavenly scent fills the room",
				"A set of fine leather armor with metal plates reinforcing vulnerable areas"
		};
	}

}
