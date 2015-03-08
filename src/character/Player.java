package character;

import grid.Point;

import java.util.ArrayList;

//Main Player Class
//Inherits all methods from Character class
public class Player extends Character {
	
	public Role role;
	
	public Player(String name, int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck, Point location)
	{
		super(name, strength, perception, endurance, charisma, intelligence, agility, luck, location);
	}
	
	public Player(String name, Point location, Role role)
	{
		this.role = role;
		this.name = name;
		this.location = location;
		switch(this.role)
		{
		case Warrior:
			setStrength(1);
			setPerception(1);
			setEndurance(1);
			setCharisma(1);
			setIntelligence(1);
			setAgility(1);
			setLuck(1);
			break;
		case Paladin:
			setStrength(1);
			setPerception(1);
			setEndurance(1);
			setCharisma(1);
			setIntelligence(1);
			setAgility(1);
			setLuck(1);
			break;
		case Hunter:
			setStrength(1);
			setPerception(1);
			setEndurance(1);
			setCharisma(1);
			setIntelligence(1);
			setAgility(1);
			setLuck(1);
			break;
		case Rogue:
			setStrength(1);
			setPerception(1);
			setEndurance(1);
			setCharisma(1);
			setIntelligence(1);
			setAgility(1);
			setLuck(1);
			break;
		case Priest:
			setStrength(1);
			setPerception(1);
			setEndurance(1);
			setCharisma(1);
			setIntelligence(1);
			setAgility(1);
			setLuck(1);
			break;
		case Mage:
			setStrength(1);
			setPerception(1);
			setEndurance(1);
			setCharisma(1);
			setIntelligence(1);
			setAgility(1);
			setLuck(1);
			break;
		case Monk:
			setStrength(1);
			setPerception(1);
			setEndurance(1);
			setCharisma(1);
			setIntelligence(1);
			setAgility(1);
			setLuck(1);
			break;
		default:
			break;
			
		}
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
		case Priest:
			this.strength++;
			this.perception++;
			this.endurance++;
			this.charisma++;
			this.intelligence++;
			this.agility++;
			this.luck++;
			break;
		case Mage:
			this.strength++;
			this.perception++;
			this.endurance++;
			this.charisma++;
			this.intelligence++;
			this.agility++;
			this.luck++;
			break;
		case Monk:
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
