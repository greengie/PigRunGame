package pigrun;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TopObstacle {

	protected Image topObstacle;
	protected float x;
	protected float y1;
	protected float y;
	protected float vx;
	
	
	Random random = new Random();
	
	static public final int WIDTH = 100;
	static public final int IMAGE_HEIGHT = 700;
	static public final int space = 100;
	
	protected int lastpattern = 0;
	protected int pattern = 0;
	protected int[] patternWidth = new int[]{2500};
	protected int number;
	protected boolean zerocollide = false;

	public TopObstacle(float x, float y, float vx) throws SlickException {
		this.x = x;
		this.y1 = y;
		this.vx = vx;
		topObstacle = new Image("res/topobstacle.png");
	}

	public void render() {
		topObstacle.draw(x - WIDTH,PigRunGame.Game_Height - (y1 + IMAGE_HEIGHT + space ));
	}
	
	public void update() {
		//System.out.println(getY());
		updatemovement();  
	    updateWrapAround();
	 }

	protected void updateWrapAround() {
		 if(x < -100){
			
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
			 randomY(); 
		}
	}

	public void updatemovement() {
	  x += vx;
	  
	 }
	
	protected void randomY1() {
	    y1 = 300 + random.nextInt(100);
	}
	protected void randomY(){
		y1 = 420 + random.nextInt(100);
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
	 
	
	 public float getX() { 
			return x;
			}
	 
	 public float getnewY() { 
			y = PigRunGame.Game_Height - y1 - space ;
		 	return y;
			}
	 
	public boolean isCollideTopObstacle(Pig p) {
	    return CollisionDetector.isCollideTopObstacle(getX(), getnewY(), p.getX(), p.getY());
	  }

}
