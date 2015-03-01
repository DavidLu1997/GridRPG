package grid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {
	public BufferedImage img;
	
	public Tile()
	{
		try
		{
			img = ImageIO.read(new File("default.png"));
		}
			catch(IOException e){
				System.out.println("Image default.png" + " not found.");
		}
	}
	
	public Tile(String name)
	{
		try
		{
			img = ImageIO.read(new File(name+".png"));
		}
			catch(IOException e){
				System.out.println("Image " + name + ".png" + " not found.");
		}
	}
}
