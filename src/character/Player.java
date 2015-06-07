package character;

import grid.Point;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//Main Player Class
//Inherits all methods from Character class
public class Player extends Character {
	
	//Player starting coordinates
	private final int startX = 8;
	private final int startY = 8;
	
	//Get role
	public Role role;
	
	//Maximum level, preset
	public final int maxLevel = 10;
	
	//Unused full constructor
	public Player(String name, int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck, Point location)
	{
		super(name, strength, perception, endurance, charisma, intelligence, agility, luck, location);
		level = 1;
	}
	
	//Constructor given name and role
	public Player(String name, Role role)
	{
		this.role = role;
		this.location = new Point(startX, startY);
		this.name = name;
		this.level = 1;
		setStrength(this.role.s);
		setPerception(this.role.p);
		setEndurance(this.role.e);
		setCharisma(this.role.c);
		setIntelligence(this.role.i);
		setAgility(this.role.a);
		setLuck(this.role.l);
		
		try
		{
			img = ImageIO.read(new File("roles/" + role + ".png"));
		}
			catch(IOException e){
				System.out.println("Image " + "roles/" + role + ".png" + " not found.");
		}
		
		calculate();
	}
	
	//Gain exp and check for level up
	public void gainExp(double exp)
	{
		this.exp += exp;
		
		if(this.exp >= this.expLevel[this.level] && this.level + 1 < this.expLevel.length)
		{
			levelUp();
		}
	}
	
	//Calculate visible locations to player, returns list of visible points
	public ArrayList<Point> visibleLocations()
	{
		//Simple circle
		ArrayList<Point> visible = new ArrayList<Point>();
		for(int i = location.x - sightRadius; i <= location.x + sightRadius; i++)
		{
			for(int j = location.y - sightRadius; j <= location.y + sightRadius; j++)
			{
				if(location.shortestDistance(new Point(i, j)) < sightRadius)
					visible.add(new Point(i, j));
			}
		}
		
		return visible;
	}
	
	//Check for level up
	private void levelUp()
	{
		this.exp -= this.expLevel[this.level];
		this.level++;
		
		switch(this.role)
		{
		case Warrior:
			this.strength++;
			this.perception++;
			this.endurance++;
			this.charisma++;
			this.intelligence++;
			this.agility++;
			this.luck++;
			break;
		case Paladin:
			this.strength++;
			this.perception++;
			this.endurance++;
			this.charisma++;
			this.intelligence++;
			this.agility++;
			this.luck++;
			break;
		case Hunter:
			this.strength++;
			this.perception++;
			this.endurance++;
			this.charisma++;
			this.intelligence++;
			this.agility++;
			this.luck++;
			break;
		case Rogue:
			this.strength++;
			this.perception++;
			this.endurance++;
			this.charisma++;
			this.intelligence++;
			this.agility++;
			this.luck++;
			break;
		default:
			break;
			
		}
		
		calculate();
	}
}
