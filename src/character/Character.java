package character;

import java.awt.image.BufferedImage;
import grid.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//Character class, to be implemented by subclass
public class Character {
	
	//Properties
	//List all properties here
	
	//Name
	protected String name;
	
	//Image
	public BufferedImage img;
	
	//Location
	public Point location;
	
	//Physical
	protected int hp;
	protected int maxHp;
	protected int mp;
	protected int maxMp;
	
	//Experience
	protected double exp;
	protected int level;
	
	//Required per level
	//Fill this out
	protected final double[] expLevel = {1,2,3,4,5,6,7,8,9,10,11};
	
	//SPECIAL stats
	protected int strength;
	protected int perception;
	protected int endurance;
	protected int charisma;
	protected int intelligence;
	protected int agility;
	protected int luck;
	
	//Derived Statistics
	protected int minDamage;
	protected int maxDamage;
	protected int criticalDamage;
	protected int sightRadius;
	protected double accuracy;
	protected double resistance;
	protected double criticalChance;
	protected int carryWeight;
	protected int regenPerTurn;
	
	//Default constructor
	public Character()
	{
	}
	
	//Custom constructor
	public Character(String name, int strength, int perception, int endurance, int charisma, int intelligence, int agility, int luck, Point location)
	{
		this.name = name;
		this.strength = strength;
		this.perception = perception;
		this.endurance = endurance;
		this.charisma = charisma;
		this.intelligence = intelligence;
		this.agility = agility;
		this.luck = luck;
		this.location = location;
		
		calculate();
	}
	
	//Calculate properties based upon SPECIAL
	public void calculate()
	{
		minDamage = strength / 2;
		maxDamage = strength * 2;
		criticalDamage = strength * 4;
		maxHp = endurance * 10;
		hp = maxHp;
		sightRadius = (int) (perception * 0.75);
		accuracy = perception / 10.0 + 0.4;
		resistance = endurance / 20.0;
		criticalChance = luck / 100.0;
		carryWeight = strength * 10 + 150; 
		regenPerTurn = strength;
	}
	
	//Attacking function
	public int attack()
	{
		//Minimum damage done
		int damage = 1;
		
		//Random number between minDamage and maxDamage
		damage = (int) (Math.random() * (maxDamage - minDamage)) + minDamage;
		
		//If critical
		if(Math.random() < criticalChance)
		{
			damage = criticalDamage;
		}
		
		//If "miss" or "fumble"
		else if(Math.random() >= accuracy)
		{
			damage = 1;
		}
		
		return damage;
	}
	
	//Heal
	public int heal()
	{
		//Heals for regenPerTurn
		hp += regenPerTurn;
		
		//Cap at max health
		if(hp > maxHp)
		{
			hp = maxHp;
		}
		
		return regenPerTurn;
	}
	
	//Defend against damage
	public boolean defend(int damage)
	{
		//Damage taken multiplied by resistance
		damage = (int) (damage*(1 - resistance));
		
		//Minimum damage is 1
		if(damage < 1)
		{
			damage = 1;
		}
		
		//Subtract
		hp -= damage;
		
		//Check if dead
		return dead();
	}
	
	//Check if dead
	public boolean dead()
	{
		if(hp <= 0)
		{
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getCriticalDamage() {
		return criticalDamage;
	}

	public void setCriticalDamage(int criticalDamage) {
		this.criticalDamage = criticalDamage;
	}

	public int getSightRadius() {
		return sightRadius;
	}

	public void setSightRadius(int sightRadius) {
		this.sightRadius = sightRadius;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getResistance() {
		return resistance;
	}

	public void setResistance(double resistance) {
		this.resistance = resistance;
	}

	public double getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(double criticalChance) {
		this.criticalChance = criticalChance;
	}

	public int getCarryWeight() {
		return carryWeight;
	}

	public void setCarryWeight(int carryWeight) {
		this.carryWeight = carryWeight;
	}

	public double[] getExpLevel() {
		return expLevel;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}

	public int getRegenPerTurn() {
		return regenPerTurn;
	}

	public void setRegenPerTurn(int regenPerTurn) {
		this.regenPerTurn = regenPerTurn;
	}
}
