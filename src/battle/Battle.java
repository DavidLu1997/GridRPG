package battle;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
	
	//Top panel
	private JPanel top;
	
	//Stats panels
	private JPanel statsA, statsB;
	
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
		
		//Initialize top
		top = new JPanel(new FlowLayout());
		
		//Add image of player
		top.add(new JLabel(new ImageIcon(a.img)));
		
		//Add label of player
		top.add(new JLabel(a.getName()));
		
		//Add vs
		top.add(new JLabel(" vs. "));
		
		//Add label of monster
		top.add(new JLabel(b.getName()));
		
		//Add image of monster
		top.add(new JLabel(new ImageIcon(b.img)));
		
		//Add top to panel
		panel.add(top, BorderLayout.PAGE_START);
		
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
