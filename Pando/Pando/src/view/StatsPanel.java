package view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class StatsPanel extends JPanel implements Observer{
	
	private JPanel stat[]= {new JPanel(),new JPanel(),new JPanel()};

	private Label statName[]={new Label("Health: "),new Label("Rooms Discovered: "),new Label("Kills: ")};

	private Label statValue[]={new Label("Value"),new Label("Value"),new Label("Value")};
	
	public StatsPanel(){
		this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		int n=0;
		while(n<stat.length){
		stat[n].add(statName[n]);
		stat[n].add(statValue[n]);
		add(stat[n]);
		n++;
		}
	}
	public void update(Observable o,Object info){
		System.out.println("J");
		int[] i = (int[])info;
		statValue[0].setText(Integer.toString(i[0]));
		statValue[1].setText(Integer.toString(i[1]));
		statValue[2].setText(Integer.toString(i[2]));
	}

}
