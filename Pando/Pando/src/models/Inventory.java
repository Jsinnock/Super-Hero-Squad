package models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Handles player inventory management
 *
 */
@SuppressWarnings("serial")
public class Inventory extends Observable implements Serializable{

	private transient Observer observer;
	private LinkedList<Item> items;
	private LinkedList<Weapon> weapons;
	private LinkedList<Usable> usables;
	private int equipped=0;
	
	public Inventory(){
		weapons=new LinkedList<Weapon>();
		items=new LinkedList<Item>();
		usables=new LinkedList<Usable>();
	}
	public void addObserver(Observer o){
		observer=o;
	}

	public void updateObservers(){
		String[] names[]=new String[3][20];
		int n=0;
		while(n<items.size()){names[0][n]=items.get(n).getName();}
		n=0;
		while(n<weapons.size()){names[1][n]=weapons.get(n).getName();}
		n=0;
		while(n<usables.size()){names[2][n]=usables.get(n).getName();}
		observer.update(this, names);
	}

	public void equip(int id){equipped=id;}
	public Weapon getEquipped(){return weapons.get(equipped);}
	/**
	 * One function for getting an artifact of any type
	 * @param tab - type of artifact to get
	 * @param index - the item that is selected in the inventory display
	 * @return
	 */
	public Artifact getArtifact(char tab,int index){
		if(tab=='i')return items.get(index);
		if(tab=='w')return weapons.get(index);
		if(tab=='c')return usables.get(index);
		return null;
	}
	/**
	 * 
	 * @param a
	 */
	public void add(Artifact a){
		if(a==null)return;
		if(a.getType()=='i')items.add((Item)a);
		if(a.getType()=='w')weapons.add((Weapon)a);
		if(a.getType()=='c')usables.add((Usable)a);
		updateObservers();
	}
	/**
	 * remove a usable from the inventory
	 * only usables can be dropped
	 * @param id
	 * @return the usable that was removed
	 */
	public Usable drop(int id){
		if(id<0)return null;
		Usable u=usables.get(id);
		usables.remove(id);
		updateObservers();
		return u;
	}
	/**
	 * determine if a specific item is in the inventory
	 * @param id - the Artifact id to check for
	 * @return
	 */
	public boolean has(String id){
		int n=0;
		if(id.startsWith("I")){
			while(n<items.size()){
				if(id.equals(items.get(n).getID()))return true;
				n++;
			}
		}
		if(id.startsWith("W")){
			while(n<items.size()){
				if(id.equals(weapons.get(n).getID()))return true;
				n++;
			}
		}
		if(id.startsWith("C")){
			while(n<items.size()){
				if(id.equals(usables.get(n).getID()))return true;
				n++;
			}
		}
		return false;
	}
	
}
