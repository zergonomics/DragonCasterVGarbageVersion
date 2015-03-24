package combat;

/**
 * Variable stat
 * Contains functions to allow
 * flat and multiplicative modifications
 * 
 * @author Kevin
 *
 */
public class VarStat{
	int maxValue;	// Maximum
	int curValue;	// Current
	int flatMod; // Flat modifier
	double multMod; // Multiplier
	
	public VarStat(int val) {
		maxValue = val;
		curValue = val;
		flatMod = 0;
		multMod = 0.0;
	}
	
	// Functions to reset the modifications
	public void resetAll() {
		flatMod = 0;
		multMod = 0;
	}
	
	public void resetFlat() {
		flatMod = 0;
	}
	
	public void resetMult() {
		multMod = 0;
	}
	
	
	// Getters and Setters for flat modifications
	public void setFlatMod(int val) {
		flatMod = val;
	}
	
	public int getFlatMod() {
		return flatMod;
	}
	
	// Getters and Setters for flat modifications
	public void setmultMod(double val) {
		multMod = val;
	}
	
	public double getmultMod() {
		return multMod;
	}
	
	/* Getter for the overall value
	 * 
	 * Multiplication comes before flat addition
	 * Also need to think about flooring or ceiling
	 *  although it's not a huge deal
	 */
	public int get() {
		return (int)(curValue * multMod + flatMod);
	}
	
	// Setter for the base value
	public void set(int val) {
		curValue = val;
	}
}
