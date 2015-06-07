package character;

import grid.Point;

import java.util.ArrayList;

public class MonsterList {
	
	//Level difference between player and monster
	public final int levelRange = 1;
	
	public ArrayList<Monster> list;
	
	public MonsterList()
	{
		list = new ArrayList<Monster>();
		list.add(new Monster(MonsterType.Dog));
		list.add(new Monster(MonsterType.Horse));
		list.add(new Monster(MonsterType.Moose));
		list.add(new Monster(MonsterType.Wolf));
		list.add(new Monster(MonsterType.Bear));
		list.add(new Monster(MonsterType.Elephant));
	}
	
	//Returns list of valid monsters
	public ArrayList<Monster> validMonster(int minLevel, int maxLevel) {
		ArrayList<Monster> l = new ArrayList<Monster>();
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).level >= minLevel && list.get(i).level <= maxLevel) {
				l.add(list.get(i).clone());
			}
		}
		
		return l;
	}
	
}
