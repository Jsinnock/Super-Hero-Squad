package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controllers.Controller;

public class TabPanel extends JPanel{

	private JPanel topPanel=new JPanel();
	private JButton statsTab=new JButton("Stats");
	private JButton invTab=new JButton("Inventory");
	private JButton cmdTab=new JButton("CMD Menu");

	private ActionListener toStatTab=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//inventory.setVisible(false);
			cmd.setVisible(false);
			stats.setVisible(true);
		}
	};
	private ActionListener toInvTab=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			stats.setVisible(false);
			cmd.setVisible(false);
			//inventory.setVisible(true);
		}
	};
	private ActionListener toCmdTab=new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//inventory.setVisible(false);
			stats.setVisible(false);
			cmd.setVisible(true);
		}
	};

	private JPanel tabsPanel=new JPanel();
	//private InvPanel inventory=new InvPanel();
	private StatsPanel stats=new StatsPanel();
	private CmdPanel cmd=new CmdPanel();
	
	public TabPanel(){
		statsTab.addActionListener(toStatTab);
		//statsTab.addActionListener(Controller.statUpdate);
		//invTab.addActionListener(toInvTab);
		//invTab.addActionListener(Controller.invUpdate);
		cmdTab.addActionListener(toCmdTab);
		
		setLayout(new BorderLayout());
		//topPanel.add(invTab);
		topPanel.add(statsTab);
		topPanel.add(cmdTab);
		add(topPanel,BorderLayout.PAGE_START);
		//tabsPanel.add(inventory);
		tabsPanel.add(stats);
		stats.setVisible(false);
		tabsPanel.add(cmd);
		cmd.setVisible(false);
		add(tabsPanel,BorderLayout.CENTER);
		
	}

}
