package models;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class Stats extends Observable implements Serializable{

	private Observer observer;

	private boolean roomsEntered[];

	private boolean monstersDefeated[];
	
	
	public Stats(){
		roomsEntered=new boolean[]{
				true,false,false,false,false,false,false,false,
				false,false,false,false,false,false,false,false,
				false,false,false,false,false,false,false,false,
				false,false,false,false,false,false,false,false,
		};
		monstersDefeated=new boolean[]{
				false,false,false,false,false,false,false,false,
			false,false,false,false,false,false,false,false,
			false,false,false,false,false,false,false,false,
			false,false,false,false,false,false,false,false,
		};
	}
	public Stats(StatInfo info){
		
	}
	public void addObserver(Observer obs){
		observer=obs;
	}
	
	public void updateObservers(){
		observer.update(this, info());
	}
	private StatInfo info(){
		int n=0;
		int d=0;
		while(0>n){
			if(monstersDefeated[n]==true)d++;
			n++;
		}
		return new StatInfo(d);
	}

}
