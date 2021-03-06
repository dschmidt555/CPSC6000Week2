package rocketDecorator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main implements ActionListener{
	

	
	rocketFactory factory = new rocketFactory();
	

	private int boosterCount = 0;
	private int turboCount = 0;
	private int warpDriveCount = 0;
	private static String rocketType;
	private int finalCost;
	private int finalRange=0;
	private JLabel costLabel;
	private JLabel rangeLabel;
	private JLabel descLabel;
	private JLabel label00;
	private JLabel label;
	private JLabel label2;
	private JPanel panel;
	private JFrame frame;
	private JLabel turboLabel;
	private JLabel warpDriveLabel;
	private JLabel titleLabel;
	
	public Main() {
		titleLabel = new JLabel("Build your Rocket.  Select your rocket type, add boosters, turbos or warp drives and see your rocket's range and cost");
		frame = new JFrame();
		label00 = new JLabel("Rocket Type: ");
		label = new JLabel("# Boosters: ");
		label2 = new JLabel();
		costLabel = new JLabel("TESt");
		costLabel = new JLabel("Cost");
		rangeLabel = new JLabel("Range: ");
		descLabel = new JLabel("Description");
		turboLabel = new JLabel("# Turbo: ");
		warpDriveLabel = new JLabel("#Warp Drives: ");
		
		
		//Buttons----------------------------------------------
		JButton button = new JButton("Add Booster");
		button.addActionListener(new Action1());
		
		
		JButton button2 = new JButton("Add Turbo");
		button2.addActionListener(new Action2());
		
		JButton buttonWarp = new JButton("Add Warp Drive");
		buttonWarp.addActionListener(new ActionWarp());
		//Buttons----------------------------------------------
		
		//Drop down menus 
		String[] test = {"Light", "Medium", "Heavy"};
		JComboBox testList = new JComboBox(test);
		testList.setSelectedIndex(0);
		testList.addActionListener(new Action0());
		
		
		//Add panels to screen 
		panel = new JPanel();
		panel.add(titleLabel);
		panel.add(label00);
		panel.add(testList);
		panel.add(label2);
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30,20,20));
		panel.setLayout(new GridLayout(0,1));
		panel.add(label2);
		panel.add(label);
		panel.add(button);
		panel.add(turboLabel);
		panel.add(button2);
		panel.add(warpDriveLabel);
		panel.add(buttonWarp);
		panel.add(costLabel);
		panel.add(rangeLabel);
		panel.add(descLabel);
		panel.add(costLabel);
		
		
		//Set frame 
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(800,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Rocket");
		frame.setVisible(true);
	}

	private void add(JComboBox testList) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
	
	
		
	//GUI
	new Main();
	
	//GUI
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//count++;
		//label.setText("# Clicks: " + count);	
		
	}
	
	//Method called from drop down menu
	public class Action0 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox<String> combo = (JComboBox<String>) e.getSource();
			rocketType = (String) combo.getSelectedItem();
			
			//FACTORY ===============================================================**
			
			//create the type of rocket from the factory 
			factory.createRocket(rocketType);
			
			//if changed, updates the range and cost:
			finalCost=0;
			finalRange=0;
			
			//update the cost and range 
			finalCost+=factory.createRocket(rocketType).cost();
			finalRange+=factory.createRocket(rocketType).range();
			
			//update the text labels on the GUI
			descLabel.setText(factory.createRocket(rocketType).description);
			rangeLabel.setText("Range: " + finalRange);
			costLabel.setText("Cost: " + finalCost);
			
		
		
		}
	}
	
	//Method to update cost, range for adding booster
	public class Action1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Update booster count 
			boosterCount++;
			label.setText("# Boosters: " + boosterCount);
			
			//update cost 
			finalCost+=factory.createRocket(rocketType).cost()+45;
			costLabel.setText("Cost: " + finalCost);
			
			//update range
			finalRange+=factory.createRocket(rocketType).range()+1000;
			rangeLabel.setText("Range: " + finalRange);
			
			//update description
			descLabel.setText(factory.createRocket(rocketType).description + ", with Booster");
					
		}
	}

	//Method to update cost, range for adding Turbo
	public class Action2 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//Update turbo count 
			turboCount++;
			turboLabel.setText("# Turbos: " + turboCount);
			
			//update cost 
			finalCost+=factory.createRocket(rocketType).cost()+60;
			costLabel.setText("Cost: " + finalCost);
			
			//update range
			finalRange+=factory.createRocket(rocketType).range()+1200;
			rangeLabel.setText("Range: " + finalRange);
			
			//update description
			descLabel.setText(factory.createRocket(rocketType).description + ", with Turbo");
				

		}
	}
	
	//Method to update cost, range for adding Warp Drive
	public class ActionWarp implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			//Update Warp Drive count 
			warpDriveCount++;
			warpDriveLabel.setText("# Warp Drives: " + warpDriveCount);
			
			//update cost 
			finalCost+=factory.createRocket(rocketType).cost()+1000000;
			costLabel.setText("Cost: " + finalCost);
			
			//update range
			finalRange+=factory.createRocket(rocketType).range()+50000000;
			rangeLabel.setText("Range: " + finalRange);
			
			//update description
			descLabel.setText(factory.createRocket(rocketType).description + ", with Warp Drive");
			
			
		}
	}

}
