package actors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class is for anything that needs
 * and image and coordinates
 * Needs rewriting. Probably.
 * @author Kevin
 *
 */
public class BaseObject {

	// x and y are center points
	protected BufferedImage image;
	int drawPriority;
	int x, y;

	
	// Default draw priority
	public BaseObject(String path) {
		image = loadImage(path);
		drawPriority = 0;
		x = 0;
		y = 0;
	}
	
	/*
	 * With these functions:
	 * 	x, y, priority
	 * 
	 * We can do a builder pattern
	 * initialization rather than
	 * lots of overloading
	 * 
	 * Ex.
	 * 		BaseObject title = new BaseObject().x(100).y(100).priority(5);
	 * 		This creates an object with
	 * 			drawX = 100
	 * 			drawY = 100
	 * 			drawPriority = 5
	 * 		Rather than the default 0's for all of them.
	 */
	public BaseObject x(int x) {
		this.x = x;
		return this;
	}
	
	public BaseObject y(int y) {
		this.y = y;
		return this;
	}
	
	public void priority(int priorityVal) {
		drawPriority = priorityVal;
	}

	
	/*
	 * Loads the image and returns the JLabel
	 * (Whatever that is)
	 */
	public BufferedImage loadImage(String imagePath) {
		File file = new File(imagePath);
		try {
			return ImageIO.read(file);
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int imageWidth() {
		return image.getWidth();
	}
	
	public int imageHeight() {
		return image.getHeight();
	}
	
	public int getImageLeftX() {
		return x - (int)(image.getWidth() / 2);
	}
	
	public int getImageTopY() {
		return y - (int)(image.getHeight() / 2);
	}
	
	public int getImageRightX() {
		return x + (int)(image.getWidth() / 2);
	}
	
	public int getImageBottomY() {
		return y + (int)(image.getHeight() / 2);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
