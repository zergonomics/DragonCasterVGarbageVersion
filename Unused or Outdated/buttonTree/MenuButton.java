package buttonTree;

import java.util.HashMap;
import java.util.Map;


// Branch of the button tree

// This button returns a list of buttons
// in order to act as a sub-menu.
// Ex. MenuButton magic		-> 	ActionButton fireball, heal, ect.
public class MenuButton extends Button{

	private HashMap<String, Button> subButtons;
	private Button parentButton;
	
	public MenuButton(Button parent) {
		super();
		subButtons = new HashMap<String, Button>();
		parentButton = parent;
	}
	
	public void addButton(String name, Button newButton) {
		subButtons.put(name, newButton);
	}
	
	public Map<String, Button> getButtons() {
		return subButtons;
	}
	
	// Gets the right button based on name.
	// 	Returns null if the name is not found
	//	That ^ should never occur!
	public Button getButton(String name) {
		Button temp = subButtons.get(name);
		if (temp == null)
			System.err.println("Error: this button/menu cannot be found! \n\t"
							 + "Wrong name or does not exist?");
		return temp;
	}
	
	public Button getParent() {	// I need an adult
		return parentButton;
	}
	
}
