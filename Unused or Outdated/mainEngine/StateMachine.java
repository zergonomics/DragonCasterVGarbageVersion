package mainEngine;

public class StateMachine {
	public enum State {
		COMBAT, MAINMENU, WORLDMAP
	};
	
	public State currentState;
	
	// Constructor
	public StateMachine() {
	}

	// Sets state
	public void changeState(State s) {
		currentState = s;
	}

	// Takes action based on state
	public State doState() {
		switch (currentState) {
		case COMBAT: controlCombat(); break;
		case MAINMENU: controlMainMenu(); break;
		case WORLDMAP: controlWorldMap(); break;
		}
		return currentState;
	}
	
	private void controlCombat() {};
	private void controlMainMenu() {};
	private void controlWorldMap() {};
}
