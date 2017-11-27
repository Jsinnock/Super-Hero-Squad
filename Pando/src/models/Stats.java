package models;

import java.util.Observable;

import databases.Rooms;
import view.StatsPanel;

public class Stats {

	private StatsPanel observer;

	private boolean roomsEntered[];

	private boolean monstersDefeated[];
	
	private boolean doorsUnlocked;
	
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
	public void addObserver(StatsPanel obs){
		observer=obs;
	}
	
	public void updateObservers(){
		observer.update(info());
	}
	private StatInfo info(){
		int n=0;
		int d=0;
		while(Rooms.COUNT>n){
			if(monstersDefeated[n]==true)d++;
			n++;
		}
		return new StatInfo(d);
	}

}
