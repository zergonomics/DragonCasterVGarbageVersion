package states.combatState;

import java.io.IOException;

import actors.BaseObject;

/**
 * Tile for the combat to be performed upon.
 * Idk what else to tell you about this
 * @author Kevin
 *
 */
public class Tile extends BaseObject{

	// Not the same as draw location
	// Because we have variable map sizes we
	// change the tile size and position when
	// displaying there
	BaseObject entity;
	
	// UNIMPLEMENTED
	int heightLevel;
	String status;	
	
	// Constructor without an entity initially
	// within the tile
	public Tile(String path) {
		super(path);
		entity = null;
		status = "Normal";
	}
	
	// Constructor that allows for an entity to
	// be initially placed in the tile
	public Tile(BaseObject entity, String path) throws IOException {
		super(path);
		this.entity = entity;
	}
	
	public BaseObject getEntity() {
		return entity;
	}
	
	public boolean isEmpty() {
		return (entity == null);
	}
	
	public String getStatus() {
		return status;
	}
	
	// Sets the tile type/status
	public void setType(int type) {
		switch(type) {
		default:
			status = "Normal";
			break;
		}
	}
}
