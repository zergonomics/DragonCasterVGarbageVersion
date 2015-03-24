package actors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadingImage {

	BufferedImage image;
	int drawPriority;

	public LoadingImage(String path) {
		image = loadImage(path);
		drawPriority = 0;
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
}
