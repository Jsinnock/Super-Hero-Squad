package models;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class Stats extends Observable implements Serializable{

	//private Observer observer;

	private int health,roomsEntered,monstersDefeated;

	public Stats(){
		roomsEntered=0;
		monstersDefeated=0;
	}
	
	private int[] info(){
		return new int[]{health,roomsEntered,monstersDefeated};
	}
	public void updateRooms(int i){
		roomsEntered=i;
		notifyO();
	}
	public void getKill(){
		monstersDefeated++;
		notifyO();
	}
	
	public void updateStats(int hp) {
		health=hp;
		notifyO();
	}
	public void notifyO(){
		this.setChanged();
		System.out.println("j");
		notifyObservers(info());
	}
}
