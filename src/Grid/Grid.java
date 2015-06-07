package grid;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import character.Character;
import character.Player;
import item.Item;

public class Grid extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Dimensions of block
	public final int gridX = 40;
	public final int gridY = 40;
	
	//Number of blocks
	public final int sizeX = 16;
	public final int sizeY = 16;
	
	//Fog tile
	public Tile fog = new Tile(TileType.Fog);
	
	//Grid tiles
	public ArrayList<ArrayList<Tile>> grid;
	
	//Characters on the grid
	public ArrayList<ArrayList<Character>> characters;
	
	//The Player
	public Player player;
	
	//Standard initialization
	public Grid(Player player) {
		this.grid = new ArrayList<ArrayList<Tile>>();
		this.characters = new ArrayList<ArrayList<Character>>();
		this.player = player;
	}
	
	//Custom constructor, unused
	public Grid(ArrayList<ArrayList<Tile> > grid, ArrayList<ArrayList<Character> > characters, Player player) {
		this.grid = grid;
		this.characters = characters;
		this.player = player;
	}
	
	//Generate random grid of tiles
	public void randomGrid() {
		//Clear existing grid
		grid.clear();
		
		//Temp tiletype for function
		TileType temp = TileType.Grassland;
		
		//Construct grid
		for(int i = 0; i < sizeX; i++) {
			grid.add(new ArrayList<Tile>());
			for(int j = 0; j < sizeY; j++) {
				grid.get(i).add(new Tile(temp.randomTile()));
			}
		}
	}
	
	//Construct grid of random monsters given number, min level, and max level
	public void randomCharacters(int numMonster, int minLevel, int maxLevel) {
		//Clear existing
		characters.clear();
		
	
		
	}
	
	//Repaint
	public void paint(Graphics g) {
		//Paint raw graphics
		int x = 0, y = 0;
		for(int i = 0; i < grid.size(); i++) {
			for(int j = 0; j < grid.get(i).size(); j++) {
				x = i * gridX;
				y = j * gridY;
				//Draw fog all over the place
				g.drawImage(fog.img, x, y, null);
			}
		}
		
		//Get visible locations
		ArrayList<Point> visible = player.visibleLocations();
		
		//Draw tiles and characters visible to player
		for(int i = 0; i < visible.size(); i++) {
			g.drawImage(grid.get(visible.get(i).x).get(visible.get(i).y).img, visible.get(i).x * gridX, visible.get(i).y * gridY, null);
			g.drawImage(characters.get(visible.get(i).x).get(visible.get(i).y).img, visible.get(i).x * gridX, visible.get(i).y * gridY, null);
		}
		
		//Draw player
		g.drawImage(player.img, player.location.x * gridX, player.location.y * gridY, null);
	}
	
	//Repaint
	public void tick() {
		this.repaint();
	}
}
