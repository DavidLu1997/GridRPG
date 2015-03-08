package character;

import java.util.ArrayList;

public class MonsterList {
	
	//Monsters
	public final Monster m1 = new Monster("M1", 1, 1, 1, 1, 1, 1, 1, 1, 1, null);
	public final Monster m2 = new Monster("M2", 2, 2, 2, 2, 2, 2, 2, 2, 2, null);
	public final Monster m3 = new Monster("M3", 3, 3, 3, 3, 3, 3, 3, 3, 3, null);
	public final Monster m4 = new Monster("M4", 4, 4, 4, 4, 4, 4, 4, 4, 4, null);
	public final Monster m5 = new Monster("M5", 5, 5, 5, 5, 5, 5, 5, 5, 5, null);
	public final Monster m6 = new Monster("M6", 6, 6, 6, 6, 6, 6, 6, 6, 6, null);
	
	//Level difference between player and monster
	public final int levelRange = 1;
	
	public ArrayList<Monster> list = new ArrayList<Monster>();
	
	public MonsterList()
	{
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
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
		
		reset();
		
		//Return random valid monster
		if(temp.size() > 0)
			return temp.get((int)(Math.random()*temp.size()));
		else
			return list.get((int)(Math.random()*list.size()));
	}
	
	//Reset list
	private void reset()
	{
		list.clear();
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
	}
}
