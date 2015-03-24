package mainEngine;

import javax.swing.JFrame;

import buttonTree.*;

public class MainMenu {
	
	// Uppermost button
	// Contains all sub-menus. Maybe these classes should be
	// menus rather than buttons.
	MenuButton baseButton;
	
	public MainMenu() {
		
		// Establishes the JFrame settings and creates the game frame
		JFrame.setDefaultLookAndFeelDecorated(true);
		@SuppressWarnings("unused")
		JFrame mainFrame = new JFrame("Dragon Caster V");
		
		// How to set the frame icon to an image loaded from a file:
		// frame.setIconImage(new ImageIcon(imgURL).getImage());

		setupBaseMenu();
		setupStartMenu();
	}
	
	/**
	 * Setting up buttons on the topmost menu
	 */
	private void setupBaseMenu() {
		// Topmost Menu
		baseButton = new MenuButton(null);
		
		/**
		 * Start game button
		 * 		->	New game
		 * 		->	Load Game
		 */
		baseButton.addButton("Start", new MenuButton(baseButton));
		
		/**
		 * Game settings button
		 * 		-> All graphics changing buttons
		 */
		baseButton.addButton("Settings", new MenuButton(baseButton));
		
		/**
		 * Credits button
		 * 		Action button, no sub-buttons
		 */
		baseButton.addButton("Credits", new ActionButton());
	}
	
	/**
	 * Separated the menu from the sub-menus
	 * Is probably slower, but not by a huge amount?
	 * Only called when the menu needs to be initialized.
	 */
	private void setupStartMenu() {
		// Topmost Menu (Needs to be a menu)
		MenuButton start = (MenuButton) baseButton.getButton("Start");
		
		/**
		 * New Game
		 * 		Action Button
		 * 			Goes to a new game
		 */
		start.addButton("New Game", new ActionButton());
		
		/**
		 * Load Game buttons (1 - 10 save slots)
		 * 		All Action Buttons
		 * 			Go to loaded games
		 */
		
		for(int i = 0; i < 10; i++) {
			start.addButton("Load " + Integer.toString(i), new ActionButton());
		}
	}
}
