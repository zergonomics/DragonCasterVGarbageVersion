package constants;

public class Constants {
	// Experience thresholds for each level. It is size 101
	// so levels 1-100 are available (0 based indexing)
	public static int[] levelThresholds = new int[101];
	public static int GAMEWIDTH = 800;
	public static int GAMEHEIGHT = 600;
	
	// This sets the thresholds up (run once)
	public void setupLevelThresholds(int base, double mult) {
		int temp = base;
		int i;
		for (i = 1; i <= 100; i++) {
			levelThresholds[i] = temp;
			temp *= (1 + mult);
		}
	}
}
