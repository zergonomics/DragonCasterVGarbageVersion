package states.combatState;

import states.State;
import actors.Actor;

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
		
		int distanceFromSide = (int)(screenWidth - (numTilesWide * TILEWIDTH)) / 2;
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
	public Actor[] getActors() {
		return entities;
	}
	
	@Override
	public Tile[][] getTiles() {
		return tiles;
	}

	@Override
	public void useInput(int input) {}

	@Override
	public void update() {}
}
