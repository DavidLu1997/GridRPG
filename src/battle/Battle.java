package battle;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import character.Character;
import character.Monster;
import character.Player;

public class Battle extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Player
	private Player a;
	
	//Monster
	private Monster b;
	
	//Panel
	private JPanel panel;
	
	//Who's turn it is
	private boolean turn;
	
	//Is someone dead?
	private boolean hasEnded;
	
	//Name of Player
	private JLabel nameA;
	
	//Name of Monster
	private JLabel nameB;
	
	//HP of Player
	private JLabel hpA;
	
	//HP of Monster
	private JLabel hpB;
	
	//Attack button
	private JButton attackA;
	
	//Heal button
	private JButton healA;
	
	//Run button
	private JButton runA;
	
	//Continue button
	private JButton end;
	
	//Last Action line
	private JLabel lastAction;
	
	//Battle between player and monster
	public Battle(Player a, Monster b)
	{
		this.a = a;
		this.b = b;
		
		//Make JFrame
		this.setTitle(a.getName() + " vs " + b.getName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 200);
		turn = true;
		hasEnded = false;
		
		//Start
		start();
		this.setVisible(true);
	}
	
	//Start function, makes everything
	public void start()
	{
		this.panel = new JPanel();
		this.panel.setLayout(new BorderLayout());
		
		
		this.getContentPane().add(panel);
		this.repaint();
	}

	//Actionlistener
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
	//Kill
	public void exit()
	{
		setVisible(false);
	}
}
