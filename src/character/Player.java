package character;

import grid.Point;

import java.util.ArrayList;

//Main Player Class
//Inherits all methods from Character class
public class Player extends Character {
	
	public Player(String name, int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck, Point location)
	{
		super(name, strength, perception, endurance, charisma, intelligence, agility, luck, location);
	}
	
	public void gainExp(double exp)
	{
		this.exp += exp;
		
		if(this.exp >= this.expLevel[this.level] && this.level + 1 < this.expLevel.length)
		{
			levelUp();
		}
	}
	
	public ArrayList<Point> visibleLocations()
	{
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
	
	private void levelUp()
	{
		this.exp -= this.expLevel[this.level];
		this.level++;
		
		this.strength++;
		this.perception++;
		this.endurance++;
		this.charisma++;
		this.intelligence++;
		this.agility++;
		this.luck++;
		
		calculate();
	}
}
