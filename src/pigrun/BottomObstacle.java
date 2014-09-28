package pigrun;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;





public class BottomObstacle {
	  public static final float WIDTH = 100;
	  static public final int IMAGE_HEIGHT = 150;
	  static public final int Error = 10;
	  
	  private Image bottomObstacle;
	  protected float x;
	  protected float y;
	  protected float vx;
	  
	  protected int lastpattern = 0;
	  protected int pattern = 0;
	  protected int[] patternWidth = new int[]{2500};
	  protected int number;
	  public boolean zerocollide = false;
	 
	  public BottomObstacle(float x, float y , float vx) throws SlickException {
		this.x = x;
		this.y = y;
		this.vx = vx;
		bottomObstacle = new Image("res/bottomobstacle.png");
		
	}
	  
	  public void render() {
		bottomObstacle.draw(x-WIDTH,y-IMAGE_HEIGHT/2+Error);
	  }
	  public void update() {
		    updatemovement();  
		    updateWrapAround();
		  }

	 private void updateWrapAround() {
		 if(x < -100){
			 System.out.println(number);
			 if(number == 0){
				 zerocollide = true;
			 }
			 if(lastpattern == 0 && pattern == 0){
				 x = 2500;
			 }
			 else if(lastpattern == 0 && pattern == 1){
				 if(number%2 == 0)
				    x = 2500;
				 else
					x = 2100;
			 }
			 else if(lastpattern == 1 && pattern == 0){
				 if(number%2 == 0)
				    x = 2500;
				 else
					x = 2900;
			 }
			 else if(lastpattern == 1 && pattern == 1){
				x = 2500;
			 }
		 }
	}
	 
	 public boolean getZeroCollideScreen(){
		 return zerocollide;
	 }
	 public void getnumber(int i){
		  number = i;
	 }
	 public void getpattern(int pattern,int lastpattern){
		 this.pattern = pattern;
		 this.lastpattern =lastpattern;
	 }

	public void updatemovement() {
		  x += vx;
	}
	
	public float getX() { 
			return x; 
			}
	 
	 public float getY() { 
			return y; 
			}
	public boolean isCollideBottomObstacle(Pig p) {
	    return CollisionDetector.isCollideBottomObstacle(x, y, p.getX(), p.getY());
	  }
	public boolean isCollideMediumObstacle(Pig p) {
	    return CollisionDetector.isCollideMediumObstacle(x, y, p.getX(), p.getY());
	  }
}
