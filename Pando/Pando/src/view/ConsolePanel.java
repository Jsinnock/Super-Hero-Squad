package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;


@SuppressWarnings("serial")
public class ConsolePanel extends JPanel {
	
	//shows the text display for the room, examined item, or puzzle
	//show buttons for puzzle options
	private JPanel puzzle= new JPanel();//Panel
	private static JLabel textDisplay= new JLabel("Text Display");
	private static String roomText;//room description
	private static String puzzleText;//puzzle text
	private JButton puz[]={new JButton(),new JButton(),new JButton()};
	private JButton attack=new JButton("Attack");
	private JPanel btns=new JPanel();
	//show buttons for navigation
	//buttons show the name of the room they lead to
	private JPanel navPanel=new JPanel();//Panel
	private JButton nav[]={new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()};
	
	
	//item display
	private JPanel interaction=new JPanel();//Panel
	private JButton examine=new JButton("Examine"),scan=new JButton("Scan"),pickup=new JButton("Pickup");
	private JList<String> itemDropList=new JList<String>();

	public ConsolePanel(){
		//add buttons to the panels
		puzzle.setLayout(new BorderLayout());
		puzzle.add(textDisplay,BorderLayout.CENTER);
		btns.add(puz[0]);
		btns.add(puz[1]);
		btns.add(puz[2]);
		btns.add(attack);
		puzzle.add(btns,BorderLayout.PAGE_END);
		//puzzle.add(puz[1],BorderLayout.PAGE_END);
		//puzzle.add(puz[2],BorderLayout.PAGE_END);
		//puzzle.add(attack,BorderLayout.PAGE_END);
		//puzzle.setPreferredSize(new Dimension(200,300));
		textDisplay.setPreferredSize(new Dimension(200,150));
		navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.PAGE_AXIS));
		navPanel.add(nav[0]);
		navPanel.add(nav[1]);
		navPanel.add(nav[2]);
		navPanel.add(nav[3]);
		navPanel.add(nav[4]);
		navPanel.add(nav[5]);
		navPanel.add(nav[6]);
		navPanel.add(nav[7]);
		interaction.setLayout(new BoxLayout(interaction, BoxLayout.PAGE_AXIS));
		interaction.add(examine);
		interaction.add(scan);
		interaction.add(pickup);
		interaction.add(itemDropList);
		
		//add the panels to the main panel
		JPanel l=new JPanel();
		JPanel r=new JPanel();
		l.setLayout(new BoxLayout(l,BoxLayout.LINE_AXIS));
		r.setLayout(new BoxLayout(r,BoxLayout.LINE_AXIS));
		l.add(puzzle);
		l.add(Box.createHorizontalGlue());
		l.add(navPanel);
		r.add(interaction);
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		add(l);
		add(Box.createHorizontalGlue());
		add(r);
	}
	/**
	 * add the actionListener to each of the buttons
	 * @param c
	 */
	public void addController(ActionListener c){
		int n=0;
		while(n<8){
			nav[n].addActionListener(c);
			n++;
		}n=0;
		while(n<3){
			puz[n].addActionListener(c);
			n++;
		}
		examine.addActionListener(c);
		scan.addActionListener(c);
		attack.addActionListener(c);
		pickup.addActionListener(c);
		
	}
	
	//methods for updating the buttons
	//called by the controller, which passes the text to display on the butttons
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
	public void updateInteraction(){
		puz[0].setVisible(false);
		puz[1].setVisible(false);
		puz[2].setVisible(false);
		examine.setVisible(true);
		scan.setVisible(true);
		pickup.setVisible(false);
		attack.setVisible(false);
		itemDropList.setVisible(false);
	}

	//combat
	public void updateAttack(boolean start){
		//true
		if(start){
			attack.setVisible(true);
			interaction.setVisible(false);
			puz[0].setVisible(false);
			puz[1].setVisible(false);
			puz[2].setVisible(false);
		}else{
			showRoomText();
			attack.setVisible(false);
			interaction.setVisible(true);
			navPanel.setVisible(true);
		}
		//show monster description and battle text(monster and player hp)
		//show attack button
		//hide interaction panel
		
		//false
		//hide desrc and text and attack button
		//show nav and interaction panels

		
	}
	public void scan(){
		itemDropList.setVisible(true);
		pickup.setVisible(true);
	}
	public void hideNav(){
		navPanel.setVisible(true);
	}

	//scan room
	public void updatePickupList(String[] itemNames){
		itemDropList.setListData(itemNames);
		
		}
	public void updatePuz(String[] puzOptions){
		int n=0;
		while(n<puzOptions.length){
			puz[n].setText(puzOptions[n]);
			puz[n].setVisible(true);
			n++;
		}while(n<3){
			puz[n].setVisible(false);
			n++;
		}
		
	}

	//methods for updating the text display
	public void showRoomText(){textDisplay.setText("<html><p style=\"width:200px\">"+roomText+"</p></html>");}
	public void showPuzzleText(){textDisplay.setText("<html><p style=\"width:200px\">"+puzzleText+"</p></html>");}
	public void showText(String txt){textDisplay.setText("<html><p style=\"width:200px\">"+txt+"</p></html>");}
	
	/**
	 * Set the values of the text descriptions for the room and its puzzle
	 * @param roomDescription
	 * @param puzzleDescription
	 */
	public void setRoomText(String roomDescription, String puzzleDescription){
		roomText=roomDescription;
		puzzleText=puzzleDescription;
	}
	/**
	 * Puzzles have multiple text descriptions
	 * @param puzzleDescription
	 */
	public void setPuzzleText(String puzzleDescription){
		puzzleText=puzzleDescription;
	}
	
	//getter methods for the buttons
	public JButton getNavButton(int id){return nav[id];}
	public JButton getPuzzleButton(int id){return puz[id];}
	public JButton getExamineButton(){return examine;}
	public JButton getScanButton(){return scan;}
	public JButton getAttackButton(){return attack;}
	public JButton getPickupButton(){return pickup;}
	public JList<String> getItemList(){return itemDropList;}
	
	
}
