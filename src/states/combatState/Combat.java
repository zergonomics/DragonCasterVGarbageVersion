package states.combatState;

import java.util.List;

import states.State;
import actors.Actor;
import actors.BaseObject;

/**
 * This is the combat state
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class Combat extends State {
	
	private int numTilesWide;
	private int numTilesHigh;
	private Tile[][] tiles;
	private boolean waitingForAction;
	private Actor[] entities;
	private int currentEntityNum;
	private int numEntities;
	
	static int TILEWIDTH = 32;
	static int TILEHEIGHT = 32;
	
	public Combat(int screenWidth, int screenHeight, int[][] t, Actor[] entities) {
		super();
		
		initializeGrid(screenWidth, screenHeight, t);
		this.entities = entities;
		currentEntityNum = 0;
		waitingForAction = true;
		
		// Load objects (buttons and menus) here
	}
	
	/**
	 * Returns all of the objects contained
	 * in the combat state
	 * This needs to be altered so that
	 * draw order is used:
	 * 		The objects are sorted into
	 * 		a temporary list based on
	 * 		draw priority and then the
	 * 		temporary list is returned
	 */
	@Override
	public List<BaseObject> getObjects() {
		List<BaseObject> temp = objects;

		for(Tile[] row : tiles) {
			for(Tile tile : row) {
				temp.add(tile);
			}
		}
		for(Actor entity : entities) {
			temp.add(entity);
		}
		
		return temp;
	}
	
	/**
	 * This should be called during the game loop
	 * (it's just the game loop for the current state)
	 * 
	 * In this one we loop through each character
	 * and get input for human characters and use
	 * AI otherwise
	 */
	@Override
	public void stateLoop() {
		numEntities = entities.length;
		Actor currentEntity = entities[currentEntityNum];
		
		while(waitingForAction) {
			// User characters will return true while waiting
			// for a command
			// AI will always return false
			waitingForAction = currentEntity.turn();
		}
		
		// Cycles through entities
		currentEntity = entities[(currentEntityNum + 1) % numEntities];
	}
	
	public void useInput() {}
	
	public void initializeGrid(int screenWidth, int screenHeight, int[][] t) {
		numTilesWide = t.length;
		numTilesHigh = t[0].length;
		tiles = new Tile[numTilesWide][numTilesHigh];
		
		int distanceFromSide = (int)(screenWidth - ((numTilesWide - 1) * TILEWIDTH)) / 2;
		int distanceFromTop = (int)(screenHeight / 3);
		
		// * Please note these may be reversed
		// because I don't know what I'm doing
		// Also this should be after the asterisks
				
		// Rows*
		for(int i = 0; i < numTilesWide; i++) {
			// Columns*
			for(int j = 0; j < numTilesHigh; j++) {
				Tile temp = new Tile("Images/basictile.png");
				temp.setType(t[i][j]);
				temp.x(distanceFromSide + TILEWIDTH * i).y(distanceFromTop + TILEHEIGHT * j);
				tiles[i][j] = temp;
			}
		}
	}

	@Override
	public void useInput(int input) {}
}
