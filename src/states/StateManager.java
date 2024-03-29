package states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import constants.Constants;
import buttons.Button;
import actors.BaseObject;

/** This is the main program thing
 * 
 * 	This thing changes the program states,
 *  gets input to send to the current state,
 *  and does the graphics painting
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class StateManager extends JPanel{
	
	static final int UPDATES_PER_SEC = 60;    // number of game update per second
	static final long UPDATE_PERIOD_NSEC = 1000000000L / UPDATES_PER_SEC;  // nanoseconds
	
	boolean gameover = false;
	boolean DEBUGGING = true;

	/**
	 * Stack for the game states. Each state is
	 * responsible for popping itself off of the
	 * state. Not entirely sure how to do that though.
	 */
	Deque<State> stateStack;

	public StateManager() throws IOException {
		// Initializes to the main menu
		stateStack = new ArrayDeque<State>();
		stateStack.push(new MainMenu());

		addKeyListener((KeyListener) new myKeyListener());
		addMouseListener((MouseListener) new myMouseListener());
		addMouseMotionListener((MouseMotionListener) new myMouseMotionListener());
	}
	
	public void gameStart() {
		Thread gameThread = new Thread() {
			@Override
			public void run() {
				gameLoop();
			}
		};
		gameThread.start();
	}
	
	public void gameLoop() {
		long beginTime, timeTaken, timeLeft;
		
		while(!gameover) {
			// Starting Time
			beginTime = System.nanoTime();
			
			stateStack.getFirst().stateLoop();
			repaint();
			
			// End Time and sleep to retain consistent FPS (Hopefully)
			timeTaken = System.nanoTime() - beginTime;
			timeLeft = (UPDATE_PERIOD_NSEC - timeTaken) / 1000000; // Converts to milliseconds
			try {
				Thread.sleep(timeLeft);
			} catch (InterruptedException e) {}
		}
	}
	
	public void checkHovered(MouseEvent e) {
		State tempState = stateStack.getFirst();
		List<BaseObject> tempList = tempState.getObjects();
		
		int l, r, t, b;
		
		int x = e.getX();
		int y = e.getY();
		
		for(BaseObject tempObj : tempList) {
			l = tempObj.getImageLeftX();
			r = tempObj.getImageRightX();
			t = tempObj.getImageTopY();
			b = tempObj.getImageBottomY();
			
			if(tempObj instanceof Button) {
				// I think I have to cast it to button
				// type. In the if statement above though,
				// we make sure it is a button type so there
				// shouldn't be problems.
				((Button) tempObj).resetHovered();
				if(x > l && x < r && y > t && y < b) {
					((Button) tempObj).setHovered();
					break;
				}
			}
		}
	}
	
	public void checkClicked(MouseEvent e) {
		State tempState = stateStack.getFirst();
		List<BaseObject> tempList = tempState.getObjects();
		
		int l, r, t, b;
		
		int x = e.getX();
		int y = e.getY();
		
		for(BaseObject tempObj : tempList) {			
			l = tempObj.getImageLeftX();
			r = tempObj.getImageRightX();
			t = tempObj.getImageTopY();
			b = tempObj.getImageBottomY();
			
			if(tempObj instanceof Button) {
				// I think I have to cast it to button
				// type. In the if statement above though,
				// we make sure it is a button type so there
				// shouldn't be problems.
				((Button) tempObj).getPressed();
				if(x > l && x < r && y > t && y < b) {
					((Button) tempObj).press(stateStack);
					break;
				}
			}
		}
		
	}
	
	/*
	 * Currently the idea behind the listeners is that
	 * they need to be somewhat global because no matter
	 * where you are you still need input reading.
	 * 
	 * I'm not sure if this is inefficient (sending the 
	 * state objects the input every time)
	 */

	// Internal class for overriding key listener
	public class myKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			stateStack.getFirst().useInput(e.getKeyCode());
		}
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}
	}
	
	// Internal class for overriding a mouse motion listener
	public class myMouseMotionListener implements MouseMotionListener {
		@Override
		public void mouseDragged(MouseEvent arg0) {}
		@Override
		public void mouseMoved(MouseEvent arg0) {
			checkHovered(arg0);
		}
	}

	// Internal class for overriding mouse listener
	public class myMouseListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			checkClicked(e);
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
	}

	/**
	 * Apparently this is called automatically. What a load of bull.
	 */
	@Override
	public void paint(Graphics g) {
		// Takes all of the objects to be drawn (SHOULD be sorted
		// by draw priority) and displays based on their top left corner
		List<BaseObject> tempList = stateStack.getFirst().getObjects();		
		for(BaseObject tempObj : tempList) {
			g.drawImage(tempObj.getImage(), tempObj.getImageLeftX(), tempObj.getImageTopY(), this);
			if(DEBUGGING) {
				g.setColor(Color.RED);
				g.drawRect(tempObj.getImageLeftX(), tempObj.getImageTopY(), tempObj.imageWidth(), tempObj.imageHeight());
			}
		}
	}
	
	// Run me baby
	public static void main(String[] args) throws IOException {
		StateManager manager = new StateManager();
		
		JFrame frame = new JFrame("Dragon Caster V");
		frame.add(manager);
		frame.setSize(Constants.GAMEWIDTH, Constants.GAMEHEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		manager.gameStart();
	}
}
