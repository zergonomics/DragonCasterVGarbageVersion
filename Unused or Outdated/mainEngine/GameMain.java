package mainEngine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/*
 * Need to figure out how threads work
 */

@SuppressWarnings("serial")	// No idea what the serial error is. It's gone now.
public class GameMain extends JPanel {
	enum Direction {
		LEFT, RIGHT, UP, DOWN,
	};
	enum Gamestate {
		MAINMENU, WORLDMAP, COMBAT, GAMEOVER, EXIT,a
	}


	static final String TITLE = "Dragon Caster V";

	static int GAMEWIDTH = 800; // Width of window
	static int GAMEHEIGHT = 600; // Height of window
	static Gamestate state; // Current state of the game. See above.

	// Constructor
	// NO IDEA if these listeners can work in conjunction like this
	public GameMain() {
		@SuppressWarnings("unused")
		Gamestate state = Gamestate.MAINMENU;
		// Anonymous class for a listener
		KeyListener kListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				processKeyPressed(e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {} // Unused

			@Override
			public void keyTyped(KeyEvent e) {} // Unused
		};

		MouseListener mListener = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent m) {}

			@Override
			public void mouseEntered(MouseEvent m) {}

			@Override
			public void mouseExited(MouseEvent m) {}

			@Override
			public void mousePressed(MouseEvent m) {}

			@Override
			public void mouseReleased(MouseEvent m) {}
		};
		addKeyListener(kListener);	// Adds the listeners
		addMouseListener(mListener);
		setFocusable(true);			// Lets it get key events

		// Initialize the game objects
		gameInit();
		gameLoop();
	}

	/**
	 * Main Game Loop
	 * 		  v     <-   <-\
	 * 		Input			|
	 * 		  |				^
	 * 		Update State	|
	 * 		  |				^
	 * 		Draw		  	|
	 * 		  \_>___>___>__/
	 */
	private void gameLoop() {
		
	}

	/**
	 * All game initialization
	 */
	private void gameInit() {}

	/**
	 * Key reading
	 * @param keyCode	Inputed key
	 */
	public void processKeyPressed (int keyCode) {

		switch (state) {
		case MAINMENU:
			
		default:
			break;
		}

		// This is how you check keys:
		// case KeyEvent.VK_UP:
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GameMain game = new GameMain();
	}
}