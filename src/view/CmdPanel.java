package view;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class CmdPanel extends JPanel {

	private JButton saveGame=new JButton("Save Game");

	private JButton loadGame=new JButton("Load Game");

	private JButton exitGame=new JButton("Exit Game");

	//private ActionEvent toStartMenu;
	
	public CmdPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(saveGame);
		add(loadGame);
		add(exitGame);
		
	}

}
