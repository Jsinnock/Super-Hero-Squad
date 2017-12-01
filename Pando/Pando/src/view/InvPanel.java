package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	private JScrollPane lsi=new JScrollPane(itemList),lsw=new JScrollPane(wpnList),lsu=new JScrollPane(useList);
	
	private JPanel bottomPanel=new JPanel();
	private JButton use=new JButton(),examine=new JButton("examine"),drop=new JButton("Drop");
	
	public InvPanel(){
		//populate lists from the inventory
		
		
		setLayout(new BorderLayout());
		topPanel.add(itemTab);
		topPanel.add(wpnTab);
		topPanel.add(useTab);
		
		listPanel.add(lsi);
		listPanel.add(lsw);
		lsw.setVisible(false);
		listPanel.add(lsu);
		lsu.setVisible(false);
		listPanel.setPreferredSize(new Dimension(300,150));
		wpnList.setPreferredSize(new Dimension(300,150));
		itemList.setPreferredSize(new Dimension(300,150));
		useList.setPreferredSize(new Dimension(300,150));
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
			lsw.setVisible(false);
			lsu.setVisible(false);
			lsi.setVisible(true);
			use.setVisible(false);
			drop.setVisible(false);
		}};
		toWpnTab=new ActionListener(){public void actionPerformed(ActionEvent e){
			tab='w';
			lsw.setVisible(true);
			lsu.setVisible(false);
			lsi.setVisible(false);
			use.setVisible(true);
			use.setText("Equip");
			drop.setVisible(false);
		}};
		toUseTab=new ActionListener(){public void actionPerformed(ActionEvent e){
			tab='c';
			lsw.setVisible(false);
			lsi.setVisible(false);
			lsu.setVisible(true);
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
		String[] s[]=(String[][])names;System.out.println(s[2][0]);
		DefaultListModel<String> l0=new DefaultListModel<String>(),l1=new DefaultListModel<String>(),l2=new DefaultListModel<String>();
		int n=0;
		while(n<s[0].length){l0.addElement(s[0][n]);n++;}
		n=0;
		while(n<s[0].length){l1.addElement(s[1][n]);n++;}
		n=0;
		while(n<s[0].length){l2.addElement(s[2][n]);n++;}
		itemList=new JList<String>(l0);
		wpnList=new JList<String>(l1);
		useList=new JList<String>(l2);
		
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
