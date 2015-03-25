package buttons;

import java.awt.image.BufferedImage;
import java.util.Deque;

import actors.BaseObject;
import states.State;

/**
 * Abstract class for a button.
 * 
 * @author Kevin
 *
 */
public abstract class Button extends BaseObject{

	// Booleans checking if the button is
	// being hovered or being pressed.
	// Not sure if this is the best
	// way to do this
	private boolean isHovered;
	private boolean isPressed;
	// Separate image for hovered.
	// This should be changed to a general
	// form using sprite sheets.
	private BufferedImage hoveredImage;
	
	public Button(String path) {
		super(path);
		isHovered = false;
		seperateImages();
	}
	
	// This should be changed to the general form
	// of sprite sheets
	private void seperateImages() {
		int halfWidth = image.getWidth() / 2;
		int fullHeight = image.getHeight();
		BufferedImage temp;
		
		temp = image.getSubimage(0, 0, halfWidth, fullHeight);
		hoveredImage = image.getSubimage(halfWidth, 0, halfWidth, fullHeight);
		image = temp;
	}
	public void resetHovered() {
		isHovered = false;
	}
	
	public void setHovered() {
		isHovered = true;
	}
	
	public boolean getHovered() {
		return isHovered;
	}
	
	// Again, change to sprite sheet form
	@Override
	public BufferedImage getImage() {
		if (isHovered)
			return hoveredImage;	
		else
			return super.getImage();
	}
	
	public void resetPressed() {
		isPressed = false;
	}

	public void setPressed() {
		isPressed = true;
	}
	
	public boolean getPressed() {
		return isPressed;
	}

	public abstract void press(Deque<State> stateStack);
}
