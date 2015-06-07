package grid;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import character.Character;
import character.Player;
import item.Item;

public class Grid extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final int gridX = 40;
	public final int gridY = 40;
	
	//Grid tiles
	public ArrayList<ArrayList<Tile>> grid;
	
	//Characters on the grid
	public ArrayList<ArrayList<Character>> characters;
	
	//The Player
	public Player player;
	
	public Grid(Player p)
	{
		grid = new ArrayList<ArrayList<Tile>>();
		characters = new ArrayList<ArrayList<Character>>();
		player = p;
	}
	
	public Grid(ArrayList<ArrayList<Tile> > grid, ArrayList<ArrayList<Character> > characters, Player player)
	{
		this.grid = grid;
		this.characters = characters;
		this.player = player;
	}
	
	public void paint(Graphics g)
	{
		int x = 0, y = 0;
		for(int i = 0; i < grid.size(); i++)
		{
			for(int j = 0; j < grid.get(i).size(); j++)
			{
				x = i * gridX;
				y = j * gridY;
				
				g.drawImage(grid.get(i).get(j).img, x, y, null);
			}
		}
		
		g.drawImage(player.img, player.location.x * gridX, player.location.y * gridY, null);
	}
	
	public void tick()
	{
		this.repaint();
		
		
	}
}
