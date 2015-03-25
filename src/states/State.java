package states;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import actors.BaseObject;

/**
 * Abstract class for states
 * 
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public abstract class State extends JPanel{

	// Overall list of objects (buttons, characters, ect.)
	// within the state
	protected List<BaseObject> objects;
	
	// Constructor
	public State() {
		objects = new ArrayList<BaseObject>();
	}

	public abstract void useInput(int input);

	public List<BaseObject> getObjects() {
		return objects;
	}

	// This is the update loop
	public abstract void stateLoop();
}
