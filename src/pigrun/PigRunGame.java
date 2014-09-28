package pigrun;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class PigRunGame extends BasicGame {

	public static final int Game_Width = 1200;
	public static final int Game_Height = 600;
	public static final float Background_VX = -5;
	public static final float Pig_Jump_Vy = 13;
	public static final float G = (float) -0.4;
	public static final float Obstacle_VX = -5;
	public static final int BottomObstacle_COUNT = 5;
	public static final int TopObstacle_COUNT = 4;
	
	private boolean isStarted;
	private boolean isJumped;
	private boolean isGameover;
	
	private Background background;
	private Pig pig;
	private BottomObstacle[] bottomObstacles;
	private TopObstacle[] topObstacles;
	
	private int pattern = 0;
	private int lastpattern = 0;
	private Random random;
	private float time = 0;
	public float timer = 0;
	
	
	public PigRunGame(String title) {
		super(title);
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		background.render();
		pig.render();
		for(BottomObstacle bottomobstacle : bottomObstacles){
			bottomobstacle.render();
		}
		for(TopObstacle topobstacles : topObstacles){
			topobstacles.render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		background = new Background(-Game_Width/8,0,Background_VX);
		pig = new Pig(Game_Width/5,Game_Height - Game_Height/2+65,Pig_Jump_Vy);
		random = new Random();
		initBottomObstacle();
		initTopObstacle();
		isStarted = false;
		isJumped = false;
		isGameover = false;
		}

	private void initTopObstacle() throws SlickException{
		topObstacles = new TopObstacle[TopObstacle_COUNT];
		TopObstacle topobstacle ;
		for(int i = 0 ; i < TopObstacle_COUNT; i++){
			if(i == 0){
				topobstacle = new SlidingTopObstacleDownward(Game_Width/2 + 150 + 500*i, Game_Height/2, Obstacle_VX);
			} 
			else if(i == TopObstacle_COUNT - 1){
				topobstacle = new SlidingTopObstacleUpWard(Game_Width/2 + 150 + 500*i, Game_Height/12, Obstacle_VX);
			}else{
				topobstacle = new TopObstacle(Game_Width/2 + 150 + 500*i, Game_Height/2, Obstacle_VX);
			}
			topobstacle.getpattern(pattern, lastpattern);
			topobstacle.getnumber(i);
			topObstacles[i] = topobstacle;
		}
	}

	private void initBottomObstacle() throws SlickException {
		bottomObstacles = new BottomObstacle[BottomObstacle_COUNT];
		BottomObstacle bottomobstacle ;
		for(int i = 0; i < BottomObstacle_COUNT; i++){
			if( i % 2 == 0){
				bottomobstacle = new BottomObstacle(Game_Width/2 - 100 + 500*i, Game_Height - Game_Height/2+65, Obstacle_VX);
			} 
			else{
				bottomobstacle = new MediumObstacle(Game_Width/2 - 100 + 500*i, Game_Height - Game_Height/2+65, Obstacle_VX);
			}
			bottomobstacle.getpattern(pattern, lastpattern);
			bottomobstacle.getnumber(i);
			bottomObstacles[i] = bottomobstacle;
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if((isStarted == true)&& (!isGameover)){
			background.update();
				if(isJumped == true){
					pig.update();
				}
			for(BottomObstacle bottomobstacle : bottomObstacles){
				bottomobstacle.update();
			}
			
			for(TopObstacle topobstacles : topObstacles){
			topobstacles.update();}
			}
			updatePatternObstacle();
			if(checkCollisionBottomObstacle()){
				isGameover = true;
			}
			checkCollisionBottomObstacle();
			time += delta;
			if(time >= 1000){
				time  = 0;
				timer++ ;
			}
		}
	
	private void updatePatternObstacle() {
		if(bottomObstacles[0].getZeroCollideScreen()){
			lastpattern = pattern;
			pattern = random.nextInt(2);
			System.out.println(lastpattern + " " + pattern);
			bottomObstacles[0].zerocollide = false;
		}
		for(int i = 0; i < BottomObstacle_COUNT; i++){
			bottomObstacles[i].lastpattern = lastpattern;
			bottomObstacles[i].pattern = pattern;
		}
	}

	private boolean checkCollisionBottomObstacle() {
		boolean isCollideBottomObstacle = false;
		for(BottomObstacle bottomobstacle : bottomObstacles){
			if(bottomobstacle.isCollideBottomObstacle(pig)){
				isCollideBottomObstacle = true;
				System.out.println("Collision!");
			}
		}
		return isCollideBottomObstacle;
	}

	@Override
	  public void keyPressed(int key, char c) {
		if(Pig.check_jump < 2){
			if (key == Input.KEY_SPACE) {
				isJumped = true;
				pig.jump();
				Pig.check_jump ++ ;
				}
			}
			if (key == Input.KEY_ENTER) {
				isStarted = true;
			}
	}
	
	public static void main(String[] args) {
	    try {
	      PigRunGame game = new PigRunGame("PigRun Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(Game_Width, Game_Height, false);
	      appgc.setMinimumLogicUpdateInterval(1000 / 60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}
