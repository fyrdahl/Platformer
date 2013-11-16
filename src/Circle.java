public class Circle extends RigidBody {
	private float radius;
	
	public Circle(float r,Vector pos, Vector velocity, float mass){
		super(pos,velocity,mass);
		this.setRadius(r);
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
}
