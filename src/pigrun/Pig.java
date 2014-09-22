package pigrun;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Pig {

	private Image pig;
	float x;
	float y;
	private float vjump;
	private float vy;
	private float Pig_HP;
	public static int check_jump;
	public static float ground_height = PigRunGame.Game_Height - PigRunGame.Game_Height/2 + 65;
	public static final int WIDTH = 100;
	public static final int HEIGHT = 100;
	
	
	public Pig(float x, float y, float vjump) throws SlickException {
		this.x = x;
		this.y = y;
		this.vy = vjump;
		this.vjump = vjump;
		Pig_HP = 5;
		check_jump = 0;
		pig = new Image("res/pig.png");		
	}

	public void render() {
		pig.draw(x-(WIDTH),y);
	}
	public void update() {
			y -= vy;
			vy += PigRunGame.G;
			if(y >= ground_height){
				vy = 0;
				check_jump = 0;
			}
	}
	public void setVy(float vy) {
	    this.vy = vy;
	  }
	public void jump() {
		vy = vjump;
		
	  }
	 public boolean isCollideGround() {
		 	if(y >= ground_height){
		 		return true;
		 		}
		 	return false;
	 }
	 public boolean isCollideBottomObstacle(BottomObstacle b) {
		    return CollisionDetector.isCollideBottomObstacle(x, y, b.getX(), b.getY());
		  }

	
	

}
