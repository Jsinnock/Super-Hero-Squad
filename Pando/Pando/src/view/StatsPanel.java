package view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class StatsPanel extends JPanel implements Observer{
	
	private JPanel stat[]= {new JPanel()};

	private Label statName[]={new Label("Stat Name: ")};

	private Label statValue[]={new Label("Value")};
	
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
		statValue[0].setText(info.toString());
	}

}
