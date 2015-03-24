package buttonTree;

/**
 * Abstract class for a button.
 * The two subclasses are:
 * MenuButton: a button that contains a list of buttons as a menu
 * ActionButton: a button that does some specific task
 * 
 * Since the menu system will be a tree, we have
 * MenuBottons as branches within the tree
 * and ActionButtons as the leaves.
 * 
 * Probably could have named them as such, but
 * I think this is more descriptive.
 * @author Kevin
 *
 */
public abstract class Button {

	private boolean selected;
	private boolean visible;
	private String text;
	
	public Button() {
		selected = false;
		visible = false;
		text = "";
	}
	
	/**
	 * This is what the button will do
	 * Or maybe just how the animation changes
	 */
	public void activate() {}
	
	// Returns text
	// Primarily created so that warning for a variable
	// not in use doesn't show up.
	// Will probably remove when the drawing parts get coded
	public String getText() {
		return text;
	}
	
	// Not sure if the below are needed
	
	public void toggleSelect() {
		selected = selected ^ true; // xor with true
	}
	
	public void toggleVisible() {
		visible = visible ^ true;
	}
	
	public void display() {
		if (visible) {
			// Do displaying here
		}
	}
	
}
