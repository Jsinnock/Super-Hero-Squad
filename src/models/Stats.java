package models;

import java.util.Observable;


import view.StatsPanel;

public class Stats {

	private static StatsPanel observer;

	private boolean roomsEntered[];

	private static boolean monstersDefeated[]=new boolean[]{
			false,false,false,false,false,false,false,false,
			false,false,false,false,false,false,false,false,
			false,false,false,false,false,false,false,false,
			false,false,false,false,false,false,false,false,
	};
	
	private boolean doorsUnlocked;
	
	public Stats(){
		roomsEntered=new boolean[]{
				true,false,false,false,false,false,false,false,
				false,false,false,false,false,false,false,false,
				false,false,false,false,false,false,false,false,
				false,false,false,false,false,false,false,false,
		};
	}
	public Stats(StatInfo info){
		
	}
	public static void addObserver(StatsPanel obs){
		observer=obs;
	}
	
	public static void updateObservers(){
		observer.update(info());
	}
	private static StatInfo info(){
		int n=0;
		int d=0;
		while(Rooms.COUNT>n){
			if(monstersDefeated[n]==true)d++;
			n++;
		}
		return new StatInfo(d);
	}

}
