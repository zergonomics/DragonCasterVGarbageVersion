package actors;

import combat.VarStat;
import constants.Constants;

/**
 * ABSTRACT class for a generic character.
 * Contains all stats and basic abilities
 * 
 * @author Kevin
 *
 */
public class Actor extends BaseObject {

	private VarStat health;
	private VarStat mana;
	private VarStat shield;
	private VarStat defence;
	private VarStat speed;
	private int exp;
	private int level;
	private int action;

	public Actor(String path) {
		super(path);
		health = new VarStat(10);
		mana = new VarStat(10);
		shield = new VarStat(10);
		defence = new VarStat(10);
		speed = new VarStat(10);
		exp = 0;
		level = 1;
		
		action = 0;
	}
	
	public Actor (int h, int m, int sh, int d, int sp, String path) {
		super(path);
		health = new VarStat(h);
		mana = new VarStat(m);
		shield = new VarStat(sh);
		defence = new VarStat(d);
		speed = new VarStat(sp);
		exp = 0;
		level = 1;
		
		action = 0;
	}

	/** COMBAT ABILITIES **/
	
	/**
	 * Function to allow a character to
	 * take a turn. Not sure how do do this
	 * @return	True: If the turn is still going
	 * 			False: If the turn has ended
	 * 
	 * 	Example code using turn:
	 * 		while(running) {
	 * 			running = turn();
	 * 		}
	 * 
	 * This way it runs until an action (other than 0)
	 * is returned
	 */
	public boolean turn() {
			switch (action) {
				case 0: return true; // No action so far
				case 1: cAttack(); break;
				case 2: cDefend(); break;
				case 3: cSpells(); break;
				case 4: cUseItem(); break;
				default: System.out.println("This move does not exist!"); return true;
		}
		return false;
	}

	private void cAttack() {}
	private void cDefend() {}
	private void cSpells() {}
	private void cUseItem() {}

	/** STAT RETURNS **/
	public int getHealth() {
		return health.get();
	}

	public int getMana() {
		return mana.get();
	}

	public int getShield() {
		return shield.get();
	}
	
	public int getDefence() {
		return defence.get();
	}
	
	public int getSpeed() {
		return speed.get();
	}
	
	public int getExp() {
		return exp;
	}
		
	// SETTERS or modifiers
	
	/**
	 * Function to add experience
	 * @param toAdd
	 * @return
	 */
	public int addExp(int toAdd) {
		exp += toAdd;
		return exp;
	}
	
	public void setLevel(int lvl) {
		level = lvl;
	}
	
	// OTHER FUNCTIONS
	
	public int checkLevel() {
		int i;
		// If experience is somehow 0, we return level 1
		// and set experience to 0
		if (exp < 0) {
			exp = 0;
			return 1;
		}
		// We can use 1 based indexing since
		// we set the size to 101 and set the
		// 0th index to nothing
		for(i = 1; i <= 100; i++) {
			if (Constants.levelThresholds[i] >= exp)
				break;
		}
		level = i;
		return level;
	}

	/** MAP MOVEMENT
	 *  This should probably be moved
	 *  into the group object that will
	 *  only be used in order to move
	 *  around on the map
	 */
	public void mMove() {}
	public void mTeleport() {}
}
