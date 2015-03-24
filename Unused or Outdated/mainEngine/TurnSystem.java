package mainEngine;

import actors.Character;
import buttonTree.Button;
import buttonTree.MenuButton;

public class TurnSystem {

		private Character participants[];
		@SuppressWarnings("unused")
		private Button menu;	// Top most branch of the menu tree within this state
		
		/**
		 * Initializes the turn system
		 * @param initialParticipants
		 */
		public TurnSystem(Character initialParticipants[], MenuButton menuRoot) {
			participants = initialParticipants;
			menu = menuRoot;
			setupInitiative();
		}
		
		/**
		 * Sorts the list of participants based on speed
		 */
		private void setupInitiative() {
			int i, j;
			for (i = 1; i < participants.length; i++) {
				j = i;
				while (j > 0 && (participants[j - 1].getSpeed() > participants[j].getSpeed())) {
					swap(participants, j);
					j -= 1;
				}
			}
		}
		
		/**
		 * Helper function for findInitiative that swaps actors
		 * @param lst	List of actors
		 * @param pos	Position to swap (with previous)
		 */
		private void swap(Character lst[], int pos) {
			Character temp = participants[pos - 1];
			participants[pos - 1] = participants[pos];
			participants[pos] = temp;
		}

		/**
		 * Gets input from the user
		 * 
		 */
		public void getInput(int keyCode) {
			
		}
}
