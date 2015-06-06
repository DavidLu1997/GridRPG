package character;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public enum Role {
	Warrior(), Paladin(), Hunter(), Rogue();
	
	public int s, p, e, c, i, a, l;
	
	Role() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("roles/" + this.toString().toLowerCase() + ".txt"));
			s = (int)Integer.parseInt(br.readLine());
			p = (int)Integer.parseInt(br.readLine());
			e = (int)Integer.parseInt(br.readLine());
			c = (int)Integer.parseInt(br.readLine());
			i = (int)Integer.parseInt(br.readLine());
			a = (int)Integer.parseInt(br.readLine());
			l = (int)Integer.parseInt(br.readLine());
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
				return "";
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
