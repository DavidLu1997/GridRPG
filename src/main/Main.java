package main;

import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import battle.Battle;
import grid.Point;
import character.Monster;
import character.MonsterList;
import character.Player;
import character.Role;

public class Main {
	
	//Variables
	static String name;
	static Role role;
	
	public static void main(String[] args) {
		
		//Initialize GUI
		GUI gui = new GUI();
		
		//Get player name
		gui.getName();
		name = gui.name;
		System.out.println("Your name is " + name);
		
		//Get player role
		gui.getRole();
		role = gui.role;
		System.out.println("Your role is " + role);
		
		//TODO Initialize grid
		
		//TODO Initialize monsters
	}
		
}
