import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class Platformer {
	
	// Game-state flag
	private boolean running = true;
	
	// Keep tabs on bodies
	private List<RigidBody> rigidBodies = new ArrayList<RigidBody>();
	
	// FPS-independet time stepping
	private static long lastFrame;
	
	public void initOpenGL(String windowTitle, int width, int height)
	{
		try
		{
			DisplayMode[] dm = Display.getAvailableDisplayModes();
            for (DisplayMode mode : dm) {
                    if (mode.getHeight() == height && mode.getWidth() == width && mode.getBitsPerPixel() == 32) {
                            Display.setDisplayMode(mode);
                    }
            }
            
            Display.setTitle(windowTitle);
            Display.create();

            // Set the projection mode
            GL11.glLoadIdentity();
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glOrtho(0, Display.getDisplayMode().getWidth(), 0, Display.getDisplayMode().getHeight(), 1, -1);
            
            // Some more OpenGL settings
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.4f);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING); 
            GL11.glDisable(GL11.GL_FOG);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            
            // Flush white
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
			
            // Log spam
			System.out.println("Running OpenGL version ["+glGetString(GL_VERSION)+"].");
		}
		catch( LWJGLException lwjglException )
		{
			// You shall not pass...
			throw new RuntimeException("Could not initiate LWJGL", lwjglException);
		}
	}

	private static long getTime() {
		return (Sys.getTime()*1000) / Sys.getTimerResolution();
	}
	
	private static double getDelta() {
		long currentTime = getTime();
		double delta = (double) currentTime - (double) lastFrame;
		lastFrame = getTime();
		return delta;
	}
	
	public void initAndRun(String windowTitle, int width, int height)
	{
		initOpenGL(windowTitle,width,height);
		run();
	}
 
	public void run()
	{
		// Make sure we get a delta for first loop
		lastFrame = getTime();
		
		Circle test = new Circle(5,new Vector(0,0),new Vector(40,100),1);
		rigidBodies.add(test);
		
		// Here be game loop
		while(running)
		{
			exitLogic(); // Are we exiting?
			input(); // Fetch input
			update(); // Updates in game logic goes here
			render();
			
			Display.update(); // Tell OpenGL to update
			Display.sync(60);
			
		}
 
		Display.destroy();
		System.exit(0);
	}
	
	public void exitLogic(){
		if(Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				running=false;
		}
	}
	
	public void input(){
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			// Do a barrel roll!
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			// Do a barrel roll!
		}
	}
	
	public void update(){
		double dt = getDelta()/100;
		
		for(RigidBody p : rigidBodies){
			p.timestep(dt);
		}
	}
	
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		GL11.glPushMatrix();
		GL11.glColor3f(0.f,0.f,0.f);
		for(RigidBody p : rigidBodies){
			GL11.glTranslated(p.getX(), p.getY(),0);
			GL11.glScalef(8, 8, 1);
			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
			GL11.glVertex2d(0,0);
			for(int i = 0; i <= 16; i++){
			    double angle = Math.PI * 2 * i / 8;
			    GL11.glVertex2f((float)Math.cos(angle), (float)Math.sin(angle));
			}
		}
		
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	 
	public static void main(String[] args) {
		Platformer platformerTest = new Platformer();
		platformerTest.initAndRun("Platformer Test",800,600);
	}
}
