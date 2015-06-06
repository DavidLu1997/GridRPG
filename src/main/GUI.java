package main;

import grid.Point;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
	public Role role = Role.Warrior;
	public Player player;
	
	JFrame frame;
	JTextField nameField;
	ButtonGroup group;
	
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
		
		//Main panel
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(pane1, BorderLayout.PAGE_START);
		pane.add(pane2, BorderLayout.CENTER);
		
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
			break;
		}
	}
}
