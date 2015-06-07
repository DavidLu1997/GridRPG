package character;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import grid.Point;

public enum MonsterType {
	Dog,
	Horse,
	Moose,
	Wolf,
	Bear,
	Elephant;
	
	public String name;
	public int s, p, e, c, i, a, l, exp, lvl;
	
	public void readStats() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("monsters/" + this.toString().toLowerCase() + ".txt"));
			System.out.println("Reading " + "monsters/" + this.toString().toLowerCase() + ".txt");
			name = br.readLine();
			System.out.println("Name: " + name);
			s = (int)Integer.parseInt(br.readLine());
			System.out.println("S: " + s);
			p = (int)Integer.parseInt(br.readLine());
			System.out.println("P: " + p);
			e = (int)Integer.parseInt(br.readLine());
			System.out.println("E: " + e);
			c = (int)Integer.parseInt(br.readLine());
			System.out.println("C: " + c);
			i = (int)Integer.parseInt(br.readLine());
			System.out.println("I: " + i);
			a = (int)Integer.parseInt(br.readLine());
			System.out.println("A: " + a);
			l = (int)Integer.parseInt(br.readLine());
			System.out.println("L: " + l);
			exp = (int)Integer.parseInt(br.readLine());
			System.out.println("Experience: " + exp);
			lvl = (int)Integer.parseInt(br.readLine());
			System.out.println("Level: " + lvl);
		} catch (FileNotFoundException e) {
			System.out.println("Reading " + "monsters/" + this.toString().toLowerCase() + ".txt");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString() {
		switch(this) {
		case Dog:
			return "Dog";
		case Horse:
			return "Horse";
		case Moose:
			return "Moose";
		case Wolf:
			return "Wolf";
		case Bear:
			return "Bear";
		case Elephant:
			return "Elephant";
		default:
			return "";
		}
	}
	
	public MonsterType reverse(String s) {
		switch(s) {
		case "Dog":
			return Dog;
		case "Horse":
			return Horse;
		case "Moose":
			return Moose;
		case "Wolf":
			return Wolf;
		case "Bear":
			return Bear;
		case "Elephant":
			return Elephant;
		default:
			return Dog;
		}
	}
	
	public int numMonsters() {
		return 6;
	}
}
