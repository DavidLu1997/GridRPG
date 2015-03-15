package main;

import java.util.Scanner;

import battle.Battle;
import grid.Point;
import character.Monster;
import character.MonsterList;
import character.Player;
import character.Role;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		//Name, Strength, Perception, Endurance, Charisma, Intelligence, Agility, Luck, Location
		Player a = new Player("Derp", new Point(0,0), Role.Warrior);
		
		int choice;
		System.out.println("Choose your adventure!");
		System.out.println("1. Battle");
		System.out.println("2. Movement");
		choice = in.nextInt();
		switch(choice)
		{
		case 1:
			MonsterList monster = new MonsterList();
			Monster m;
			Battle b;
			while(a.getLevel() < a.maxLevel)
			{
				m = monster.nextMonster(a.getLevel());
				b = new Battle(a, m);
				
				while(b.isVisible())
				{
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(a.getHp() > 0)
				{
					a.gainExp(m.getExpGained());
					System.out.println("You've gained " + m.getExpGained() + " experience points!");
					System.out.println("You are currently level " + a.getLevel() + ".");
				}
				else
				{
					System.out.println("You are dead.");
					break;
				}
			}
			
			if(a.getLevel() > a.maxLevel)
			{
				System.out.println("You have won the game!");
			}
			break;
		case 2:
			System.out.println("Incomplete");
			break;
		}
	}

}
