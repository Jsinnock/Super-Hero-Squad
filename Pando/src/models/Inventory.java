package models;

import java.util.LinkedList;

import view.InvPanel;

public class Inventory {

	private InvPanel observer;
	private LinkedList<Item> items;
	private LinkedList<Weapon> weapons;
	private LinkedList<Usable> usables;
	private int equipped=0;
	
	public Inventory(){
		weapons=new LinkedList<Weapon>();
		items=new LinkedList<Item>();
		usables=new LinkedList<Usable>();
	}
	public void addObserver(InvPanel o){
		observer=o;
	}

	public void updateObservers(){
		String[] names[]=new String[][]{};
		int n=0;
		while(n<items.size()){
			names[0][n]=items.get(n).getName();
		}n=0;
		while(n<weapons.size()){
			names[1][n]=weapons.get(n).getName();
		}n=0;
		while(n<usables.size()){
			names[2][n]=usables.get(n).getName();
		}
		observer.update(names);
	}

	public void equip(int id){
		equipped=id;
	}
	public Weapon getEquipped(int id){
		return weapons.get(id);
	}
	public Artifact getArtifact(char tab,int index){
		if(tab=='i')return items.get(index);
		if(tab=='w')return weapons.get(index);
		if(tab=='c')return usables.get(index);
		return null;
	}
	public void add(Artifact a){
		if(a.getType()=='i')items.add((Item)a);
		if(a.getType()=='w')weapons.add((Weapon)a);
		if(a.getType()=='c')usables.add((Usable)a);
		updateObservers();
	}
	
	public Usable drop(int id){
		Usable u=usables.get(id);
		usables.remove(id);
		updateObservers();
		return u;
	}
	
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
