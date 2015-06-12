package character;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import grid.Point;

public class Monster extends Character {
	
	private int expGained;
	private MonsterType type;
	
	public Monster(MonsterType monster)
	{
		//Get stats
		monster.readStats();
		this.name = monster.name;
		this.strength = monster.s;
		this.perception = monster.p;
		this.endurance = monster.e;
		this.charisma = monster.c;
		this.intelligence = monster.i;
		this.agility = monster.a;
		this.luck = monster.l;
		this.expGained = monster.exp;
		this.level = monster.lvl;
		this.type = monster;
		
		//Get location
		this.location = new Point(0, 0);
		
		//Read image file
		try
		{
			img = ImageIO.read(new File("monsters/" + name + ".png"));
		}
			catch(IOException e){
				System.out.println("monsters/" + name + ".png" + " not found.");
		}
		
		//Calculate stats
		this.calculate();
		this.refresh();
	}
	
	public Monster clone()
	{
		return new Monster(type);
	}
}
