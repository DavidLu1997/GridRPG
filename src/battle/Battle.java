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
		
		JPanel A = new JPanel();
		JPanel B = new JPanel();
		
		A.setLayout(new BoxLayout(A, BoxLayout.Y_AXIS));
		B.setLayout(new BoxLayout(B, BoxLayout.Y_AXIS));
		
		nameA = new JLabel(a.getName() + "");
		A.add(nameA);
		nameB = new JLabel(b.getName() + "");
		B.add(nameB);
		hpA = new JLabel("HP: " + a.getHp() + " / " + a.getMaxHp());
		A.add(hpA);
		hpB = new JLabel("HP: " + b.getHp() + " / " + b.getMaxHp());
		B.add(hpB);
		attackA = new JButton("Attack");
		attackA.addActionListener(this);
		A.add(attackA);
		healA = new JButton("Heal");
		healA.addActionListener(this);
		A.add(healA);
		runA = new JButton("Run");
		runA.addActionListener(this);
		A.add(runA);
		lastAction = new JLabel("");
		lastAction.setAlignmentX(Component.CENTER_ALIGNMENT);
		lastAction.setAlignmentY(Component.CENTER_ALIGNMENT);
		end = new JButton("Continue");
		end.addActionListener(this);
		A.add(end);
		end.setEnabled(false);
		
		this.panel.add(A, BorderLayout.WEST);
		this.panel.add(B, BorderLayout.EAST);
		this.panel.add(lastAction, BorderLayout.SOUTH);
		this.getContentPane().add(panel);
		this.repaint();
	}

	//Actionlistener
	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		
		//End if someone's dead
		if(hasEnded && src == end)
		{
			exit();
		}
		
		//If its the player's turn
		if(turn)
		{
			//Player wants to attack
			if(src == attackA)
			{
				int damage = a.attack();
				
				//Hit monster
				hasEnded = b.defend(damage);
				
				//If monster is dead
				if(hasEnded)
				{
					lastAction.setText(b.getName() + " has been slain.");
					hpB.setText("HP: " + 0 + " / " + b.getMaxHp());
				}
				
				//Otherwise
				else
				{
					lastAction.setText(b.getName() + " has been hit for " + damage + ".");
					hpB.setText("HP: " + b.getHp() + " / " + b.getMaxHp());
				}
			}
			
			//Players wants to heal
			else if(src == healA)
			{
				int healed = a.heal();
				hpA.setText("HP: " + a.getHp() + " / " + a.getMaxHp());
				lastAction.setText(a.getName() + " has healed for " + healed + ".");
			}
			
			//Player wants to run
			else if(src == runA)
			{
				exit();
			}
			
			//Set buttons
			attackA.setEnabled(false);
			healA.setEnabled(false);
			runA.setEnabled(false);
			end.setEnabled(true);
			turn = false;
		}
		
		//Monster's turn
		else if(!turn)
		{
			//Monster always attacks
			switch(b.AIBattleNextMove(a))
			{
				//Attacks
				case 1:
					int damage = b.attack();
					hasEnded = a.defend(damage);
					//If player dead
					if(hasEnded)
					{
						lastAction.setText(a.getName() + " has been killed.");
						hpA.setText("HP: " + 0 + " / " + a.getMaxHp());
					}
					
					//Otherwise
					else
					{
						lastAction.setText(a.getName() + " has been hit for " + damage + ".");
						hpA.setText("HP: " + a.getHp() + " / " + a.getMaxHp());
					}
					break;
				//Heals
				case 2:
					int healed = b.heal();
					lastAction.setText(b.getName() + " has healed for " + healed + ".");
					hpB.setText("HP: " + b.getHp() + " / " + b.getMaxHp());
					break;
			}
			
			//Set buttons
			attackA.setEnabled(true);
			healA.setEnabled(true);
			runA.setEnabled(true);
			end.setEnabled(false);
			turn = true;
		}
		
		//If someone's dead
		if(hasEnded)
		{
			attackA.setEnabled(false);
			healA.setEnabled(false);
			runA.setEnabled(false);
			end.setText("Close");
			end.setEnabled(true);
		}
	}
	
	//Kill
	public void exit()
	{
		setVisible(false);
	}
}
