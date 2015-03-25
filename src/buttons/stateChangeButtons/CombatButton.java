package buttons.stateChangeButtons;

import java.util.Deque;

import buttons.Button;
import constants.Constants;
import actors.Actor;
import states.State;
import states.combatState.Combat;

/**
 * This button brings us to the combat
 * state. Probably to be changed
 * @author Kevin
 *
 */
public class CombatButton extends Button {
	
	public CombatButton(String path) {
		super(path);
	}

	/**
	 * Most likely this will be changed so the
	 * collection of entities are added later
	 * And maybe the grid as well.
	 */
	@Override
	public void press(Deque<State> stateStack) {
		Actor[] actors = new Actor[1];
		actors[0] = new Actor("Images/basiccharacter.png");
		actors[0].x(300).y(400);
		
		int[][] grid = new int[][]
				{{0, 0, 0, 0, 0, 0}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 0, 0, 0, 0}, 
				 {0, 0, 0, 0, 0, 0}};
		State newState = new Combat(Constants.GAMEWIDTH, Constants.GAMEHEIGHT, grid, actors);

		stateStack.push(newState);
	}
}
