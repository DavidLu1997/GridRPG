package main;

import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import battle.Battle;
import grid.Point;
import character.Monster;
import character.MonsterList;
import character.MonsterType;
import character.Player;
import character.Role;

public class Main {
	
	//Variables
	static String name;
	static Role role;
	
	public static void main(String[] args) {
		
		//Initialize GUI
		GUI gui = new GUI();
		
		//Start game
		gui.start();
		
		Battle b = new Battle(new Player("Derp", Role.Hunter), new Monster(MonsterType.Bear));
	}
		
}
