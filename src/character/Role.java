package character;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public enum Role {
	Warrior, Paladin, Hunter, Rogue;
	
	public int s, p, e, c, i, a, l;
	
	public void readStats() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("roles/" + this.toString().toLowerCase() + ".txt"));
			System.out.println("Reading " + "roles/" + this.toString().toLowerCase() + ".txt");
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
		} catch (FileNotFoundException e) {
			System.out.println("roles/" + this.toString().toLowerCase() + ".txt not found");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String toString() {
		switch(this)
		{
		case Warrior:
			return "Warrior";
		case Paladin:
			return "Paladin";
		case Hunter:
			return "Hunter";
		case Rogue:
			return "Rogue";
		default:
			return "Warrior";
		}
	}
	
	public Role reverse(String s) {
		switch(s)
		{
		case "Warrior":
			return Warrior;
		case "Paladin":
			return Paladin;
		case "Hunter":
			return Hunter;
		case "Rogue":
			return Rogue;
		default:
			return Warrior;
		}
	}
}
