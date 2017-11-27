package models;

public class CombatObject {

	private int health,armor,damage,wpnDmg;

	CombatObject(int hp,int amr, int dmg){
		health=hp;
		armor=amr;
		damage=dmg;
		wpnDmg=0;
	}

	public boolean getAttacked(CombatObject attacker){
		setHealth(getHealth()-armor(attacker.getDamage()));
		if(getHealth()>0)return false;
		else return true;
	}
	public int armor(int dmg){
		if(dmg>getArmor())return dmg-getArmor();
		else return 0;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getDamage() {
		return damage+wpnDmg;
	}
	public void setDmg(int add){
		damage+=add;
	}
	public void setWpnDmg(int w){
		wpnDmg=w;
	}
	
}
