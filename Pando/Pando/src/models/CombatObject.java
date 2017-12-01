package models;

import java.io.Serializable;
import java.util.Observable;

/**
 * Used to implement combat behavior
 *
 */
@SuppressWarnings("serial")
public class CombatObject extends Observable implements Serializable{

	private Stats observer;
	private int health,armor,damage,wpnDmg;

	CombatObject(int hp,int amr, int dmg){
		health=hp;
		armor=amr;
		damage=dmg;
		wpnDmg=0;
	}
	/**
	 * Apply damage
	 * @param attacker 
	 * @return true if the attack resulted in a kill
	 */
	public boolean getAttacked(CombatObject attacker){
		setHealth(getHealth()-armor(attacker.getDamage()));
		if(getHealth()>0)return false;
		else return true;
	}
	/**
	 * Evaluate how much damage gets past the armor
	 * used to ensure armor does not make applied damage negative
	 * @param dmg
	 * @return
	 */
	private int armor(int dmg){
		if(dmg>getArmor())return dmg-getArmor();
		else return 0;
	}
	public void addObserver(Stats o){
		observer=o;
		observer.updateStats(this.health);
	}
	public int getHealth() {return health;}
	public void setHealth(int health) {
		this.health = health;
		if(observer!=null)observer.updateStats(this.health);
		}
	public int getArmor() {return armor;}
	public void setArmor(int armor) {this.armor = armor;}
	public int getDamage() {return damage+wpnDmg;}
	public void setDmg(int add){damage+=add;}
	public void setWpnDmg(int w){wpnDmg=w;}
	
}
