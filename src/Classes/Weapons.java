package databases;
public final class Weapons extends Artifact {

	//there are 5 weapons
	private int[] damageBoostList={
			0, 1,2,
			3,5,6
	};
	Weapons(){
		name=new String[]{
				"","Syringe","Wrench",
				"Kitchen Knife", "Longsword","Energy Blaster"
		};
		description=new String[]{
				"",
				"A syringe half filled with a mysterious green goo",
				"When not in the toolbag, the rusty and trusty wrench can be a heavy hitting weapon.",
				"A 9.5 inch kitchen knife specifically used to cut food, but can do serious damage when used as a weapon.",
				"A long, single-sided straight sword with a pointed tip. It is very sharp.",
				"An experimental weapon originally made for mining."
		};
	}

	public int getDmg(byte id) {
		return damageBoostList[id];
	}

}
