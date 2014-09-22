package pigrun;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TopObstacle {

	private Image topObstacle;
	protected float x;
	protected float y;
	protected float vx;
	
	Random random = new Random();
	
	static public final int WIDTH = 100;
	static public final int IMAGE_HEIGHT = 700;
	static public final int space = 150;

	public TopObstacle(float x, float y, float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		topObstacle = new Image("res/topobstacle.png");
	}

	public void render() {
		topObstacle.draw(x - WIDTH,PigRunGame.Game_Height - (y + IMAGE_HEIGHT + space));
	}
	
	public void update() {
	    updatemovement();  
	    updateWrapAround();
	  }

	public void updateWrapAround() {
	 if(x < -PigRunGame.Game_Width/2){
		 x = PigRunGame.Game_Width+PigRunGame.Game_Width/2;
		 randomY();
	 }
	}

	public void updatemovement() {
	  x += vx;
	}
	
	public void randomY() {
	    y = 200 + random.nextInt(200);
	  }
	
	public float getX() { 
		return x; }
	
	public float getY() { 
		return y; }

}
