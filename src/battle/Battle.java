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

	private Player a;
	private Monster b;
	
	private JPanel panel;
	
	private boolean turn, hasEnded;
	
	private JLabel nameA;
	private JLabel nameB;
	private JLabel hpA;
	private JLabel hpB;
	private JButton attackA;
	private JButton healA;
	private JButton runA;
	private JButton end;
	private JLabel lastAction;
	
	
	public Battle(Player a, Monster b)
	{
		this.a = a;
		this.b = b;
		
		this.setTitle(a.getName() + " vs " + b.getName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300, 200);
		turn = true;
		hasEnded = false;
		start();
		this.setVisible(true);
	}
	
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

	public void actionPerformed(ActionEvent e) 
	{
		Object src = e.getSource();
		
		if(hasEnded && src == end)
		{
			exit();
		}
		
		if(turn)
		{
			if(src == attackA)
			{
				int damage = a.attack();
				hasEnded = b.defend(damage);
				if(hasEnded)
				{
					lastAction.setText(b.getName() + " has been slain.");
					hpB.setText("HP: " + 0 + " / " + b.getMaxHp());
				}
				else
				{
					lastAction.setText(b.getName() + " has been hit for " + damage + ".");
					hpB.setText("HP: " + b.getHp() + " / " + b.getMaxHp());
				}
			}
			else if(src == healA)
			{
				int healed = a.heal();
				hpA.setText("HP: " + a.getHp() + " / " + a.getMaxHp());
				lastAction.setText(a.getName() + " has healed for " + healed + ".");
			}
			
			else if(src == runA)
			{
				exit();
			}
			
			attackA.setEnabled(false);
			healA.setEnabled(false);
			runA.setEnabled(false);
			end.setEnabled(true);
			turn = false;
		}
		else if(!turn)
		{
			int damage = b.attack();
			hasEnded = a.defend(damage);
			if(hasEnded)
			{
				lastAction.setText(a.getName() + " has been slain.");
				hpA.setText("HP: " + 0 + " / " + a.getMaxHp());
			}
			else
			{
				lastAction.setText(a.getName() + " has been hit for " + damage + ".");
				hpA.setText("HP: " + a.getHp() + " / " + a.getMaxHp());
			}
			
			attackA.setEnabled(true);
			healA.setEnabled(true);
			runA.setEnabled(true);
			end.setEnabled(false);
			turn = true;
		}
		
		if(hasEnded)
		{
			attackA.setEnabled(false);
			healA.setEnabled(false);
			runA.setEnabled(false);
			end.setText("Close");
			end.setEnabled(true);
		}
	}
	
	public void exit()
	{
		setVisible(false);
		dispose();
	}
}
