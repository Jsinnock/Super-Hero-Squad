package view;

import java.awt.*;
import javax.swing.*;

import controllers.Controller;

public class ConsolePanel extends JPanel {
	
	//shows the text display for the room, examined item, or puzzle
	//show buttons for puzzle options
	private JPanel puzzle= new JPanel();//Panel
	private static JLabel textDisplay= new JLabel("Text Display");
	private static String roomText;
	private static String itemText;
	private static String puzzleText;
	private JButton puz0=new JButton("Puzzle");
	private JButton puz1=new JButton("Puzzle");
	private JButton puz2=new JButton("Puzzle");
	private JButton puz3=new JButton("Puzzle");
	
	//show buttons for navigation
	//buttons show the name of the room they lead to
	private JPanel navPanel=new JPanel();//Panel
	private JButton nav[]=new JButton[]{
			new JButton("navigation"),
			new JButton("navigation"),
			new JButton("navigation"),
			new JButton("navigation"),
			new JButton("navigation")
	};
	

	private JPanel interaction=new JPanel();//Panel
	private JButton examine=new JButton("Examine");
	private JButton scan=new JButton("Scan");
	private JButton attack=new JButton("Attack");
	
	private JPanel items=new JPanel();//Panel
	//private JList<String> itemdropList;
	private JButton pickup=new JButton("Pickup");

	public ConsolePanel(){
		puzzle.setLayout(new BoxLayout(puzzle, BoxLayout.PAGE_AXIS));
		puzzle.add(textDisplay);
		puzzle.add(puz0);
		puzzle.add(puz1);
		puzzle.add(puz2);
		puzzle.add(puz3);
		puzzle.setPreferredSize(new Dimension(200,300));
		textDisplay.setPreferredSize(new Dimension(200,150));
		
		
		
		navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.PAGE_AXIS));
		/**
		nav[0].addActionListener(Controller.getCRAL(0));
		nav[1].addActionListener(Controller.changeRoom[1]);
		nav[2].addActionListener(Controller.changeRoom[2]);
		nav[3].addActionListener(Controller.changeRoom[3]);
		nav[4].addActionListener(Controller.changeRoom[4]);
		*/
		
		navPanel.add(nav[0]);
		navPanel.add(nav[1]);
		navPanel.add(nav[2]);
		navPanel.add(nav[3]);
		navPanel.add(nav[4]);
		
		interaction.setLayout(new BoxLayout(interaction, BoxLayout.PAGE_AXIS));
		interaction.add(examine);
		interaction.add(scan);
		interaction.add(attack);
		
		items.setLayout(new BoxLayout(items, BoxLayout.PAGE_AXIS));
		items.add(pickup);
		//items.add(itemdropList);
		
		JPanel l=new JPanel();
		JPanel r=new JPanel();
		l.setLayout(new BoxLayout(l,BoxLayout.LINE_AXIS));
		r.setLayout(new BoxLayout(r,BoxLayout.LINE_AXIS));
		l.add(puzzle);
		l.add(Box.createHorizontalGlue());
		l.add(navPanel);
		r.add(interaction);
		r.add(Box.createHorizontalGlue());
		r.add(items);
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		add(l);
		add(Box.createHorizontalGlue());
		add(r);
	}
	public void addController(Controller c){
		int n=0;
		while(n<5){
			nav[n].addActionListener(c);
			n++;
		}
	}
	
	public void updateNav(String[] roomNames){
		int n=0;
		while(n<roomNames.length){
			nav[n].setText(roomNames[n]);
			nav[n].setVisible(true);
			if(roomNames[n].equals(""))	nav[n].setVisible(false);
			n++;
			//hide remaining buttons when there are no more exits

				
			
		}
	}
	
	public void showRoomText(){
		textDisplay.setText("<html><p style=\"width:200px\">"+roomText+"</p></html>");
	}
	public void showPuzzleText(){
		textDisplay.setText(puzzleText);
	}
	public void showItemText(String itemDescription){
		itemText=itemDescription;
		textDisplay.setText(itemText);
	}
	public void setRoomText(String roomDescription, String puzzleDescription){
		roomText=roomDescription;
		puzzleText=puzzleDescription;
	}
	public void setPuzzleText(String puzzleDescription){
		puzzleText=puzzleDescription;
	}
	public JButton getNavButton(int id){
		return nav[id];
	}
	
}
