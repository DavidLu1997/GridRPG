package grid;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import character.Monster;
import character.MonsterList;
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
	
	//Monsters on the grid
	public ArrayList<ArrayList<Monster>> monsters;
	
	//The Player
	public Player player;
	
	//Monster List
	public MonsterList list;
	
	//Standard initialization
	public Grid(Player player) {
		this.grid = new ArrayList<ArrayList<Tile>>();
		this.monsters = new ArrayList<ArrayList<Monster>>();
		this.player = player;
		this.list = new MonsterList();
		
		//Get randomized board
		randomGrid();
		randomMonsters(Integer.max(player.getLevel()-1, 1), Integer.min(player.getLevel(), player.maxLevel), player.getLevel() * 4);
	}
	
	//Custom constructor, unused
	public Grid(ArrayList<ArrayList<Tile> > grid, ArrayList<ArrayList<Monster> > monsters, Player player) {
		this.grid = grid;
		this.monsters = monsters;
		this.player = player;
		this.list = new MonsterList();
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
	
	//Construct grid of random monsters given min level, max level, and total level
	public void randomMonsters(int minLevel, int maxLevel, int total) {
		//Clear existing
		monsters.clear();
		
		//Add nulls
		for(int i = 0; i < sizeX; i++) {
			monsters.add(new ArrayList<Monster>());
			for(int j = 0; j < sizeY; j++) {
				monsters.get(i).add(null);
			}
		}
		
		//Get valid monsters
		ArrayList<Monster> validMonsters = list.validMonster(minLevel, maxLevel);
		
		int count = 0;
		int rand = 0, x = 0, y = 0;
		
		//Choose monsters
		//TODO Make random better
		while(count <= total) {
			//Get index of monster
			rand = (int)(Math.random() * validMonsters.size());
			
			//Get x coordinate
			x = (int)(Math.random() * sizeX);
			while(x == player.location.x)
				x = (int)(Math.random() * sizeX);
			
			//Get y coordinate
			y = (int)(Math.random() * sizeY);
			while(y == player.location.y)
				y = (int)(Math.random() * sizeY);
			
			//Add monster
			monsters.get(x).set(y, validMonsters.get(rand).clone());
			
			count += validMonsters.get(rand).getLevel();
		}
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
		
		//Draw tiles and monsters visible to player
		for(int i = 0; i < visible.size(); i++) {
			//Only draw if valid
			if(visible.get(i).x >= 0 && visible.get(i).x < sizeX && visible.get(i).y >= 0 && visible.get(i).y < sizeY){
				g.drawImage(grid.get(visible.get(i).x).get(visible.get(i).y).img, visible.get(i).x * gridX, visible.get(i).y * gridY, null);
			if(monsters.get(visible.get(i).x).get(visible.get(i).y)!=null&&monsters.get(visible.get(i).x).get(visible.get(i).y).img != null)
				g.drawImage(monsters.get(visible.get(i).x).get(visible.get(i).y).img, visible.get(i).x * gridX, visible.get(i).y * gridY, null);
			}
		}
		
		//Draw player
		g.drawImage(player.img, player.location.x * gridX, player.location.y * gridY, null);
	}
	
	//Repaint
	public void tick() {
		this.repaint();
	}
}
