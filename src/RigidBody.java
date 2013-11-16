public class RigidBody {
	
	private Vector pos;
	private Vector velocity;
	private double mass;

	// Dummy constructor
	public RigidBody(){}
	
	public RigidBody(Vector pos, Vector velocity, double mass){
		this.setMass(mass);
		this.pos = pos;
		this.velocity = velocity;
	}
	
	public void timestep(double dt){
		// Advance position with one Euler-step
		// x(t+dt) = x(t)+v(t)*dt
		
		this.pos.plus(velocity.times(dt));
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
}
