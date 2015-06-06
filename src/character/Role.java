package character;

public enum Role {
	Warrior, Paladin, Hunter, Rogue, Priest, Mage, Monk;
	
	public String toString()
	{
		switch(this)
		{
		case Warrior:
			return "Warrior";
		case Paladin:
			return "Paladin";
		case Hunter:
			return "Hunter";
		case Rogue:
			return "Rogue";
		case Priest:
			return "Priest";
		case Mage:
			return "Mage";
		case Monk:
			return "Monk";
			default:
				return "";
		}
	}
}
