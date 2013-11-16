
public class Plane extends RigidBody {

	private Vector normal;
	private double d;
	
	public Plane(Vector n, double d){
		super(n.times(-d),new Vector(),0);
		this.normal = n;
		this.d = d;
	}
	
	public void GenerateContact(RigidBody that){
		
	}
	
}
