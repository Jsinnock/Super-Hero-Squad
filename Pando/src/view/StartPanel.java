package view;

import java.awt.event.ActionEvent;
import javax.swing.*;

import controllers.Controller;

public class StartPanel extends JPanel{

	private JButton newGame=new JButton("New Game"),loadGame=new JButton("LoadGame"),logout=new JButton("Logout");
	private JLabel text=new JLabel("You are dead");

	public StartPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(text);
		add(newGame);
		add(loadGame);
		add(logout);
	}
	public void addController(Controller c){
		newGame.addActionListener(c);
		loadGame.addActionListener(c);
		logout.addActionListener(c);
	}

	public JButton getNewGame() {
		return newGame;
	}

	public JButton getLoadGame() {
		return loadGame;
	}

	public JButton getLogout() {
		return logout;
	}
	public JLabel getLabel(){return text;}
	

}
