package pigrun;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TopObstacle {

	private Image topObstacle;
	private float x;
	private float y;
	private float vx;
	
	Random random = new Random();
	
	static public final int WIDTH = 100;
	static public final int IMAGE_HEIGHT = 700;

	public TopObstacle(float x, float y, float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		topObstacle = new Image("res/topobstacle.png");
	}

	public void render() {
		topObstacle.draw(x - WIDTH/2,PigRunGame.Game_Height - (y + IMAGE_HEIGHT));
	}
	
	public void update() {
	    updatemovement();  
	    updateWrapAround();
	  }

	private void updateWrapAround() {
	 if(x < -WIDTH/2){
		 x = PigRunGame.Game_Width+WIDTH/2;
		 randomY();
	 }
	}

	public void updatemovement() {
	  x += vx;
	}
	
	public void randomY() {
	    y = 250 + random.nextInt(200);
	  }
	
	public float getX() { 
		return x; }
	
	public float getY() { 
		return y; }

}
