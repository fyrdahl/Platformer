import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class Platformer {
	
	// Setting a state variable
	private boolean running = true;
	
	public void initOpenGL(String windowTitle, int width, int height)
	{
		try
		{
			DisplayMode[] dm = Display.getAvailableDisplayModes();
            for (DisplayMode mode : dm) {
                    if (mode.getHeight() == height && mode.getWidth() == width
                                    && mode.getBitsPerPixel() == 32) {
                            Display.setDisplayMode(mode);
                    }
            }
            Display.setTitle(windowTitle);
            Display.create();

            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();

            GL11.glOrtho(0, Display.getDisplayMode().getWidth(), 0, Display.getDisplayMode().getHeight(), 1, -1);

            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();

            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glAlphaFunc(GL11.GL_GREATER, 0.4f);
           
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_LIGHTING); 
            GL11.glDisable(GL11.GL_FOG);
            GL11.glDisable(GL11.GL_TEXTURE_2D);
            
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
			
			System.out.println("Running OpenGL version ["+glGetString(GL_VERSION)+"].");
		}
		catch( LWJGLException lwjglException )
		{
			throw new RuntimeException("Could not initiate LWJGL", lwjglException);
		}
	}

	public void initAndRun(String windowTitle, int width, int height)
	{
		initOpenGL(windowTitle,width,height);
		run();
	}
 
	public void run()
	{
		while(running)
		{
			exitLogic();
			input();
			update();
			render();
			Display.update();
			Display.sync(60);
			
		}
 
		Display.destroy();
		System.exit(0);
	}
	
	public void exitLogic(){
		if(Display.isCloseRequested() || Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
         running=false;
	}
	
	public void input(){
		//Handle input, duh
	}
	
	public void update(){
		//Take a guess
	}
	
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	 
	public static void main(String[] args) {
		Platformer platformerTest = new Platformer();
		platformerTest.initAndRun("Jalla jalla",800,600);
	}
}