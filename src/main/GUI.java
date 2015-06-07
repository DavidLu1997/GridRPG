package main;

import grid.Point;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import character.Player;
import character.Role;

//GUI Class, contains most GUI components
public class GUI implements ActionListener {
	
	public String name;
	public Role role = Role.Hunter;
	public Player player;
	
	//Global variables
	JFrame frame;
	JTextField nameField;
	ButtonGroup group;
	ArrayList<JLabel> stats;
	
	//Booleans for condition
	boolean started = false;
	
	//Get basic information
	public void start() {
		
		//JFrame
		frame = new JFrame("GridRPG");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Name panel
		JPanel pane1 = new JPanel(new BorderLayout());
		
		//Prompt
		JLabel label1 = new JLabel("What is your name?");
		pane1.add(label1, BorderLayout.PAGE_START);
		
		//Textfield
		nameField = new JTextField(20);
		nameField.setActionCommand("name");
		nameField.addActionListener(this);
		pane1.add(nameField, BorderLayout.CENTER);
		
		//Roles panel
		JPanel pane2 = new JPanel(new BorderLayout());
		
		JLabel label2 = new JLabel("Choose your class:");
		pane2.add(label2, BorderLayout.PAGE_START);
		
		//Role radio buttons
		
		//Hunter
		JRadioButton b1 = new JRadioButton(Role.Hunter.toString());
		b1.setActionCommand(Role.Hunter.toString());
		b1.addActionListener(this);
		b1.setSelected(true);
		
		//Paladin
		JRadioButton b2 = new JRadioButton(Role.Paladin.toString());
		b2.setActionCommand(Role.Paladin.toString());
		b2.addActionListener(this);
		
		//Rogue
		JRadioButton b3 = new JRadioButton(Role.Rogue.toString());
		b3.setActionCommand(Role.Rogue.toString());
		b3.addActionListener(this);
		
		//Warrior
		JRadioButton b4 = new JRadioButton(Role.Warrior.toString());
		b4.setActionCommand(Role.Warrior.toString());
		b4.addActionListener(this);
		
		group = new ButtonGroup();
		group.add(b1);
		group.add(b2);
		group.add(b3);
		group.add(b4);
		
		//Button panel
		JPanel radio = new JPanel();
		radio.setLayout(new BoxLayout(radio, BoxLayout.PAGE_AXIS));
		radio.add(b1);
		radio.add(b2);
		radio.add(b3);
		radio.add(b4);
		
		pane2.add(radio, BorderLayout.CENTER);
		
		//Information Panel
		JPanel pane3 = new JPanel();
		pane3.setLayout(new BoxLayout(pane3, BoxLayout.PAGE_AXIS));
		
		JLabel info = new JLabel("Stats: ");
		
		stats = new ArrayList<JLabel>(7);
		role.readStats();
		stats.add(new JLabel("Strength: " + role.s));
		stats.add(new JLabel("Perception: " + role.p));
		stats.add(new JLabel("Endurance: " + role.e));
		stats.add(new JLabel("Charisma: " + role.c));
		stats.add(new JLabel("Intelligence: " + role.i));
		stats.add(new JLabel("Agility: " + role.a));
		stats.add(new JLabel("Luck: " + role.l));
		
		for(int i = 0; i < stats.size(); i++) {
			pane3.add(stats.get(i));
		}
		
		//Main panel
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(pane1, BorderLayout.PAGE_START);
		pane.add(pane2, BorderLayout.WEST);
		pane.add(pane3, BorderLayout.EAST);
		
		//Button
		JButton start = new JButton("Start");
		start.setMnemonic(KeyEvent.VK_ENTER);
		start.setActionCommand("start");
		start.addActionListener(this);
		pane.add(start, BorderLayout.PAGE_END);
		
		//Show frame
		frame.setContentPane(pane);
		frame.pack();
		frame.setVisible(true);
	}

	//ActionListener
	public void actionPerformed(ActionEvent e) {
		if(started) {
			switch(e.getActionCommand())
			{
			//Start button
			case "start":
				this.name = nameField.getText();
				this.role = role.reverse(group.getSelection().getActionCommand());
				System.out.println("Your name is " + name);
				System.out.println("Your role is " + role);
				player = new Player(name, role);
				frame.dispose();
				started = true;
				break;
			default:
				this.role = role.reverse(group.getSelection().getActionCommand());
				System.out.println(role + " role selected.");
				role.readStats();
				stats.get(0).setText("Strength: " + role.s);
				stats.get(1).setText("Perception: " + role.p);
				stats.get(2).setText("Endurance: " + role.e);
				stats.get(3).setText("Charisma: " + role.c);
				stats.get(4).setText("Intelligence: " + role.i);
				stats.get(5).setText("Agility: " + role.a);
				stats.get(6).setText("Luck: " + role.l);
				frame.revalidate();
				frame.repaint();
				break;
			}
		}
		else {
			
		}
	}
}
