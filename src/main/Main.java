package main;

import battle.Battle;
import grid.Point;
import character.Monster;
import character.Player;

public class Main {

	public static void main(String[] args) {
		
		//Name, Strength, Perception, Endurance, Charisma, Intelligence, Agility, Luck, Location
		Player a = new Player("Derp", 10, 10, 10, 10, 10, 10, 10, new Point(0, 0));
		//Name, Strength, Perception, Endurance, Charisma, Intelligence, Agility, Luck, Experience Gained, Location
		Monster b = new Monster("Derp1", 10, 10, 10, 10, 10, 10, 10, 1, new Point(0,0));
		
		Battle battle = new Battle(a, b);

	}

}
