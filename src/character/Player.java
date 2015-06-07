package character;

import grid.Point;

import java.util.ArrayList;

//Main Player Class
//Inherits all methods from Character class
public class Player extends Character {
	
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
		this.location = new Point(8, 8);
		this.name = name;
		this.level = 1;
		setStrength(this.role.s);
		setPerception(this.role.p);
		setEndurance(this.role.e);
		setCharisma(this.role.c);
		setIntelligence(this.role.i);
		setAgility(this.role.a);
		setLuck(this.role.l);
		
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
