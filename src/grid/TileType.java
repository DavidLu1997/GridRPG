package grid;

public enum TileType {
	Grassland("grassland.png", "Grassland"), 
	Tundra("tundra.png", "Tundra"), 
	Desert("desert.png", "Desert"), 
	Woodland("woodland.png", "Woodland"), 
	Hills("hills.png", "Hills");
	
	private final String image;
	private final String name;
	TileType(String image, String name)
	{
		this.image = image;
		this.name = name;
	}
	
	public String getImageName()
	{
		return this.image;
	}
	
	public String toString()
	{
		return this.name;
	}
}
