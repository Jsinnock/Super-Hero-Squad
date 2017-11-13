package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class View extends JFrame{

	//private LoginPanel login;

	//private NewUserPanel create;

	//private StartPanel start;

	private MapPanel map=new MapPanel();

	private TabPanel tab=new TabPanel();

	private ConsolePanel console=new ConsolePanel();
	
	public View(){
		map.setPreferredSize(new Dimension(300,300));
		tab.setPreferredSize(new Dimension(300,300));
		console.setPreferredSize(new Dimension(600,300));
		Container c= getContentPane();
		c.add(map,BorderLayout.LINE_START);
		c.add(tab,BorderLayout.LINE_END);
		c.add(console,BorderLayout.PAGE_END);
	}
	public ConsolePanel getConsole(){
		return console;
	}

}
