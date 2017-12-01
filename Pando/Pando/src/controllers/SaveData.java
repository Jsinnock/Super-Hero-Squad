package controllers;

import models.*;
/**
 * object used by the load feature, so that the method only has one parameter
 *
 */
public class SaveData {

	private String roomID;
	private CombatObject co;
	private Inventory inv;
	private Progress progress;
	private Stats stats;
	
	public SaveData(String r,CombatObject c,Inventory i,Progress p,Stats s){
		roomID=r;
		co=c;
		inv=i;
		progress=p;
		stats=s;
	}
	
	public String getRoomID() {return roomID;}
	public CombatObject getCo() {return co;}
	public Inventory getInv() {return inv;}
	public Progress getProgress() {return progress;}
	public Stats getStats() {return stats;}
	
}
