package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;


@SuppressWarnings("serial")
public class InvPanel extends JPanel implements Observer {

	private JPanel topPanel=new JPanel();
	private JButton itemTab=new JButton("Items"),wpnTab=new JButton("Weapons"),useTab=new JButton("Usables");
	private ActionListener toItemTab,toWpnTab,toUseTab;
	private char tab='i';// the currently selected tab
		
	private JPanel listPanel=new JPanel();
	private JList<String> itemList=new JList<String>(),wpnList=new JList<String>(),useList=new JList<String>();
	
	private JPanel bottomPanel=new JPanel();
	private JButton use=new JButton(),examine=new JButton("examine"),drop=new JButton("Drop");
	
	public InvPanel(){
		//populate lists from the inventory
		
		
		setLayout(new BorderLayout());
		topPanel.add(itemTab);
		topPanel.add(wpnTab);
		topPanel.add(useTab);
		listPanel.add(itemList);
		listPanel.add(wpnList);
		listPanel.add(useList);
		bottomPanel.add(use);
		bottomPanel.add(examine);
		bottomPanel.add(drop);
		use.setVisible(false);
		drop.setVisible(false);
		add(topPanel,BorderLayout.PAGE_START);
		add(listPanel,BorderLayout.CENTER);
		add(bottomPanel,BorderLayout.PAGE_END);
		
		toItemTab=new ActionListener(){public void actionPerformed(ActionEvent e){
			tab='i';
			wpnList.setVisible(false);
			useList.setVisible(false);
			itemList.setVisible(false);
			use.setVisible(false);
			drop.setVisible(false);
		}};
		toWpnTab=new ActionListener(){public void actionPerformed(ActionEvent e){
			tab='w';
			wpnList.setVisible(true);
			useList.setVisible(false);
			itemList.setVisible(false);
			use.setVisible(true);
			use.setText("Equip");
			drop.setVisible(false);
		}};
		toUseTab=new ActionListener(){public void actionPerformed(ActionEvent e){
			tab='c';
			wpnList.setVisible(false);
			useList.setVisible(false);
			itemList.setVisible(true);
			use.setVisible(true);
			use.setText("Use");
			drop.setVisible(true);
		}};
		itemTab.addActionListener(toItemTab);
		wpnTab.addActionListener(toWpnTab);
		useTab.addActionListener(toUseTab);
	}
	public void addController(ActionListener c){
		use.addActionListener(c);
		examine.addActionListener(c);
		drop.addActionListener(c);
	}
	
	public void update(Observable o,Object names){
		String s[][]=(String[][])names;
		itemList.setListData(s[0]);
		wpnList.setListData(s[1]);
		useList.setListData(s[2]);
		
	}
	public JButton getItemTab(){return itemTab;}
	public JButton getWpnTab(){return wpnTab;}
	public JButton getUsablesTab(){return useTab;}
	public int getSelected(){
		if(tab=='c')return useList.getSelectedIndex();
		if(tab=='w')return wpnList.getSelectedIndex();
		if(tab=='i')return itemList.getSelectedIndex();
		return 0;
	}
	public char getTab(){return tab;}
	
	public JButton getUse() {
		return use;
	}
	public JButton getExamine() {
		return examine;
	}
	public JButton getDrop() {
		return drop;
	}
	

}
