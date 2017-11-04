package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.InventoryTab;
import databases.*;
import entity.Inventory;

public final class InventoryCommands {
	
	private static final InventoryTab view;
	private static Inventory inv;
	
	public static final ActionListener examine=new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(view.getSType()=='w')Weapons.getDescription(view.getSelected());
			else if(view.getSType()=='c')Consumables.getDescription(view.getSelected());
			else if(view.getSType()=='i')Items.getDescription(view.getSelected());
			else;
		}
		
	};
	public static final ActionListener use=new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(view.getSType()=='c')Consumables.consume(view.getSelected());
		}
		
	};
	public static final ActionListener equip=new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(view.getSType()=='w')inv.equipWeapon(view.getSelected());
		}
		
	};
	public static final ActionListener drop=new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	

}
