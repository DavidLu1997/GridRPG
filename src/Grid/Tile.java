package grid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	public BufferedImage img;
	public TileType type;
	
	public Tile(TileType type)
	{
		this.type = type;
		
		try
		{
			img = ImageIO.read(new File("images/" + type.getImageName()));
		}
			catch(IOException e){
				System.out.println("Image " + "images/" + type.getImageName() + " not found.");
		}
	}
}
