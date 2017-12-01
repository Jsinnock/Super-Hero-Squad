package view;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MapPanel extends JPanel {

	private Image firstFloor,secondFloor,thirdFloor,fourthFloor;

	private JLabel roomName=new JLabel("");

	public MapPanel(){
	this.add(roomName);
	}
	public void update(String name){roomName.setText(name);}
	private Image roomMarker;
	private int markerX,markerY;


}
