public class Vector {

	private double x;
	private double y;
	
	// Constructor
	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Vector(){
		this.x = 0;
		this.y = 0;
	}
	
	// Dot product
	public double dot(Vector that) {
		return (this.x*that.getX() + this.y*that.getY());
	}
	
	// Euclidian norm
	public double magnitude() {
		return Math.sqrt(this.dot(this));
	}
	
	// Euclidian distance
	public double distance(Vector that){
		return this.minus(that).magnitude();
	}
	
	// Difference
	public Vector minus(Vector that){
		Vector tmp = new Vector(this.x-that.getX(),this.y-that.getY());
		return tmp;
	}
	
	public void plus(Vector that){
		this.x+=that.getX();
		this.y+=that.getY();
	}
	
	public Vector times(double a){
		Vector tmp = new Vector(this.x * a, this.y * a);
		return tmp;
	}
	
	// Getters/setters
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
}
