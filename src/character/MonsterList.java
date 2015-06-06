package character;

import java.util.ArrayList;

public class MonsterList {
	
	//Level difference between player and monster
	public final int levelRange = 1;
	
	public ArrayList<Monster> list = new ArrayList<Monster>();
	
	public MonsterList()
	{
		//TODO Read all monsters
	}
	
	//Returns the next monster to be fought
	public Monster nextMonster(int level)
	{
		ArrayList<Monster> temp = new ArrayList<Monster>();
		
		//Find all valid monsters
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).level <= level + levelRange && list.get(i).level >= level - levelRange)
			{
				temp.add(list.get(i).clone());
			}
		}
		
		//Return random valid monster
		if(temp.size() > 0)
			return temp.get((int)(Math.random()*temp.size()));
		else
			return list.get((int)(Math.random()*list.size()));
	}
}
