package character;

import grid.Point;

public class Monster extends Character {
	
	private int expGained;
	
	public Monster(String name, int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck, int expGained, int level, Point location)
	{
		super(name, strength, perception, endurance, charisma, intelligence, agility, luck, location);
		
		this.expGained = expGained;
		this.level = level;
	}
	
	public Point AINextMove(Point player)
	{
		return location.nextInShortestPath(player);
	}
	
	public Monster clone()
	{
		Monster m = new Monster(name, expGained, expGained, expGained, expGained, expGained, expGained, expGained, expGained, expGained, location);
		
		m.setName(this.name);
		m.setStrength(this.strength);
		m.setPerception(this.perception);
		m.setEndurance(this.endurance);
		m.setCharisma(this.charisma);
		m.setIntelligence(this.intelligence);
		m.setAgility(this.agility);
		m.setLuck(this.luck);
		m.setExpGained(this.expGained);
		m.setLocation(this.location);
		m.calculate();
		
		return m;
	}
	
	//AI next move when hit by player
	//Always attack for now
	public int AIBattleNextMove(Player p)
	{
		return 1;
	}
	
	public int getExpGained()
	{
		return expGained;
	}
	
	public void setExpGained(int expGained)
	{
		this.expGained = expGained;
	}
}
