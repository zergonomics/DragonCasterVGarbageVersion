package states;

import java.awt.event.KeyEvent;

import buttons.stateChangeButtons.CombatButton;
import actors.BaseObject;

/**
 * Main menu state
 * Title screen and relevant buttons
 * 
 * @author KevinWa
 *
 */
@SuppressWarnings("serial")
public class MainMenu extends State{
	
	public MainMenu() {
		super();
		
		// Adding in the objects
		BaseObject titleImage = new BaseObject("Images/titlescreen.png").x(400).y(200);
		CombatButton startButton = (CombatButton) new CombatButton("Images/startbutton.png").x(400).y(300);
		CombatButton combatButton = (CombatButton) new CombatButton("Images/combatbutton.png").x(400).y(350);
		
		// Load in all objects needed
		objects.add(titleImage);
		objects.add(startButton);
		objects.add(combatButton);
	}

	@Override
	public void useInput(int code) {
		switch(code) {
			case KeyEvent.VK_UP:
				break;
			case KeyEvent.VK_DOWN:
				break;
		}
	}

	@Override
	public void stateLoop() {}
}
