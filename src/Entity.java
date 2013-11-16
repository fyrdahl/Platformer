public class Entity {
	
	// An entity is any game object 
	// that has a position in the game world
	
	private int x;
	private int y;
	private boolean isSolid; // Probably useful for collision detection
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isSolid() {
		return isSolid;
	}
	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}
	
}
