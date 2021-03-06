package pigrun;

import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;



public class PigRunGame extends BasicGame {

	public PigRunGame(String title) {
		super(title);
	
	}

	public static final int Game_Width = 1200;
	public static final int Game_Height = 600;
	public static final double Background_VX = -3;
	public static final float Pig_Jump_Vy = 13;
	public static final float G = (float) -0.4;
	public static final double Obstacle_VX = -5;
	public static final int BottomObstacle_COUNT = 5;
	public static final int TopObstacle_COUNT = 4;
	
	public static int score ;
	public boolean isStarted;
	public boolean isJumped;
	public boolean isGameover;
	public boolean isGamePause;
	
	private Background background;
	private Pig pig;
	private BottomObstacle[] bottomObstacles;
	private TopObstacle[] topObstacles;
	
	private int pattern = 0;
	private int lastpattern = 0;
	private Random random;
	public float time = 0;
	public static float timer = 0;
	
	private Music music;
	private Sound sound;
	private Sound sound1;
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		background.render();
		for(BottomObstacle bottomobstacle : bottomObstacles){
			bottomobstacle.render();
		}
		for(TopObstacle topobstacles : topObstacles){
			topobstacles.render();
		}
		pig.render();
		
		g.drawString("Score " + score, 1000, 0);
		g.drawString("HP " + pig.Pig_HP, 500, 0);
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
		initMusicAndSound();
		}

	private void initMusicAndSound() throws SlickException {
		music = new Music("res/theme-song.ogg");
		music.setVolume(0.4f);
		music.loop();
		sound = new Sound("res/jumping.wav");
		sound1 = new Sound("res/box-impact.ogg");
	}

	private void initTopObstacle() throws SlickException{
		topObstacles = new TopObstacle[TopObstacle_COUNT];
		TopObstacle topobstacle ;
		for(int i = 0 ; i < TopObstacle_COUNT; i++){
			if(i == 0 || i == 1){
				topobstacle = new SlidingTopObstacleUpWard(Game_Width/2 + 150 + 500*i, Game_Height/2, Obstacle_VX);
			} 
			else if(i == 2){
				topobstacle = new TopObstacle(Game_Width/2 + 150 + 500*i, Game_Height/2, Obstacle_VX);
			}
			else{
				topobstacle = new SlidingTopObstacleDownward(Game_Width/2 + 150 + 500*i, Game_Height/2, Obstacle_VX);
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
		if((isStarted == true)&& (!isGameover)&&(isGamePause != true)){
				background.update();
				if(isJumped == true){
					pig.update();
				}
				for(BottomObstacle bottomobstacle : bottomObstacles){
				bottomobstacle.update();
				}
			
				for(TopObstacle topobstacles : topObstacles){
				topobstacles.update();
				}
					
			updatePatternObstacle();
			checkCollisionBottomObstacle();
			checkCollisionTopObstacle();
			
			if(checkCollisionBottomObstacle() &&(pig.Pig_HP > 0) ){
				pig.Pig_HP--;
				sound1.play();
			}
			if(checkCollisionTopObstacle() && (pig.Pig_HP > 0)){
				pig.Pig_HP--;
				sound1.play();
			}
			if(pig.Pig_HP == 0){
				isGameover = true;
			}
			
			time += delta;
			updateScore();
		}
	}
	
	public void updateScore() {
		
		if(time >= 1000 && (!isGameover)&& (isStarted == true)){
			time = 0;
			timer++ ;
			}
		//System.out.println(timer);
		score = (int) (timer*999);
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
		
		if(topObstacles[0].getZeroCollideScreen()){
			lastpattern = pattern;
			pattern = random.nextInt(2);
			System.out.println(lastpattern + " " + pattern);
			topObstacles[0].zerocollide = false;
		}
		for(int i = 0; i < TopObstacle_COUNT; i++){
			topObstacles[i].lastpattern = lastpattern;
			topObstacles[i].pattern = pattern;
		}
		
	}
	
	private boolean checkCollisionTopObstacle() {
		boolean isCollideTopObstacle = false;
		for(int i = 0; i < TopObstacle_COUNT; i++){
			if(topObstacles[i].isCollideTopObstacle(pig)){
				isCollideTopObstacle = true;
				//System.out.println("Collision!");
			}
		}
		return isCollideTopObstacle;
	}
	
	private boolean checkCollisionBottomObstacle() {
		boolean isCollideBottomObstacle = false;
		for(int i = 0; i < BottomObstacle_COUNT; i++){
				if( i % 2 == 0){
					if(bottomObstacles[i].isCollideBottomObstacle(pig)){
							isCollideBottomObstacle = true;
						}
					}
				else{
					if(bottomObstacles[i].isCollideMediumObstacle(pig)){
						isCollideBottomObstacle = true;
					}
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
				sound.play();
				}
			}
		if (key == Input.KEY_A) {
				isStarted = true;
			}
		if(key == Input.KEY_ESCAPE){
			isGamePause = true;
		}
		if(key == Input.KEY_ENTER){
			isGamePause = false;
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
