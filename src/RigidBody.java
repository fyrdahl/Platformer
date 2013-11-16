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
		
		// Advance velocity and position with one Euler-step
		// v(t+dt) = v(t)+a*dt;
		// x(t+dt) = x(t)+v(t)*dt
				
		this.velocity.plus(new Vector(0.d,-9.82).times(dt));
		this.pos.plus(velocity.times(dt));
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public double getX(){
		return this.pos.getX();
	}
	public double getY(){
		return this.pos.getY();
	}
}
