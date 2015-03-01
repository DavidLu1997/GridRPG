package character;

import grid.Point;

public class Monster extends Character {
	
	private int expGained;
	
	public Monster(String name, int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck, int expGained, Point location)
	{
		super(name, strength, perception, endurance, charisma, intelligence, agility, luck, location);
		
		this.expGained = expGained;
	}
	
	public int getExpGained()
	{
		return expGained;
	}
	
	public Point AINextMove(Point player)
	{
		return location.nextInShortestPath(player);
	}
	
	//AI next move when hit by player
	//Always attack for now
	public int AIBattleNextMove(Player p)
	{
		return 1;
	}
}
