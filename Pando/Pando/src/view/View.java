package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame{

	private LoginPanel login=new LoginPanel();
	//private NewUserPanel create;
	private StartPanel start=new StartPanel();
	private MapPanel map=new MapPanel();
	private TabPanel tab=new TabPanel();
	private ConsolePanel console=new ConsolePanel();
	
	public View(){
		map.setPreferredSize(new Dimension(300,300));
		tab.setPreferredSize(new Dimension(300,300));
		console.setPreferredSize(new Dimension(600,300));
		Container c= getContentPane();
		c.add(login,BorderLayout.PAGE_START);
		c.add(start,BorderLayout.CENTER);
		c.add(map,BorderLayout.LINE_START);
		c.add(tab,BorderLayout.LINE_END);
		c.add(console,BorderLayout.PAGE_END);
		start.setVisible(false);
		map.setVisible(false);
		tab.setVisible(false);
		console.setVisible(false);
		//login.setVisible(true);
		c.setVisible(true);
	}
	
	public void login(){
		login.setVisible(false);
		start.setVisible(true);
		start.getLabel().setVisible(false);
		pack();
	}
	public void start(){
		login.setVisible(false);
		start.setVisible(false);
		map.setVisible(true);
		tab.setVisible(true);
		console.setVisible(true);
		pack();
	}
	public void exit(){
		map.setVisible(false);
		tab.setVisible(false);
		console.setVisible(false);
		start.setVisible(true);
		start.getLabel().setVisible(false);
		pack();

	}
	public void logout(){
		start.setVisible(false);
		login.setVisible(true);
		login.showt();
		pack();

	}
	public void killed(){
		map.setVisible(false);
		tab.setVisible(false);
		console.setVisible(false);
		start.setVisible(true);
		start.getLabel().setVisible(true);
		pack();

	}
	
	public ConsolePanel getConsole(){return console;}
	public TabPanel getTab(){return tab;}
	public LoginPanel getLogin(){return login;}
	public StartPanel getStart(){return start;}

}
