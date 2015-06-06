package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import character.Role;

//GUI Class, contains most GUI components
public class GUI implements ActionListener {
	
	public String name;
	public Role role;
	
	JFrame frame;
	JTextField nameField;
	
	//Get player name
	public void getName() {
		
		frame = new JFrame("GridRPG");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel pane = new JPanel(new BorderLayout());
		
		JLabel label = new JLabel("What is your name?");
		pane.add(label, BorderLayout.PAGE_START);
		
		nameField = new JTextField(20);
		nameField.setActionCommand("name");
		nameField.addActionListener(this);
		pane.add(nameField, BorderLayout.CENTER);
		
		JButton start = new JButton("Start");
		start.setMnemonic(KeyEvent.VK_ENTER);
		start.setActionCommand("start");
		start.addActionListener(this);
		pane.add(start, BorderLayout.PAGE_END);
		
		frame.setContentPane(pane);
		frame.pack();
		frame.setVisible(true);
	}
	
	//Get player role
	public void getRole() {
		frame = new JFrame("Class Selection");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel pane = new JPanel(new BorderLayout());
		
		JLabel label = new JLabel("Choose your class:");
		pane.add(label, BorderLayout.PAGE_START);
		
		//Role radio buttons
		JRadioButton b1 = new JRadioButton(Role.Hunter.toString());
		b1.setActionCommand(Role.Hunter.toString());
		b1.setSelected(true);
		
		JRadioButton b2 = new JRadioButton(Role.Mage.toString());
		b2.setActionCommand(Role.Mage.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case "start":
			this.name = nameField.getText();
			frame.dispose();
			break;
		}
		
	}
}
