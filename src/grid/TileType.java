package grid;

public enum TileType {
	Grassland("grassland.png", "Grassland"), 
	Tundra("tundra.png", "Tundra"), 
	Desert("desert.png", "Desert"), 
	Woodland("woodland.png", "Woodland"), 
	Hills("hills.png", "Hills"),
	Fog("fog.png", "Fog");
	
	private final String image;
	private final String name;
	TileType(String image, String name) {
		this.image = image;
		this.name = name;
	}
	
	public String getImageName() {
		return this.image;
	}
	
	public String toString() {
		return this.name;
	}
	
	public int numTileTypes() {
		return 5;
	}
	
	public TileType randomTile() {
		int choice = (int)(Math.random() * numTileTypes());
		
		switch(choice) {
		case 0:
			return Grassland;
		case 1:
			return Tundra;
		case 2:
			return Desert;
		case 3:
			return Woodland;
		case 4:
			return Hills;
		default:
			return Grassland;
		}
	}
}
