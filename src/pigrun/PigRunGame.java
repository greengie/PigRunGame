package pigrun;

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
	public static final float Pig_Jump_Vy = 12;
	public static final float G = (float) -0.35;
	public static final float Obstacle_VX = -4;
	public static final int BottomObstacle_COUNT = 3;
	public static final int MediumObstacle_COUNT = 2;
	
	private boolean isStarted;
	
	
	private Background background;
	private Pig pig;
	private BottomObstacle[] bottomObstacles;
	private MediumObstacle[] mediumObstacles;
	

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
		for(MediumObstacle mediumobstacle : mediumObstacles)
		mediumobstacle.render();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		background = new Background(-Game_Width/8,0,Background_VX);
		pig = new Pig(Game_Width/5,Game_Height - Game_Height/2+65,Pig_Jump_Vy);
		initBottomObstacle();
		initMediumObstacle();
		isStarted = false;
		
	}

	private void initMediumObstacle() throws SlickException {
		mediumObstacles = new MediumObstacle[MediumObstacle_COUNT];
		for(int i = 0; i < MediumObstacle_COUNT; i++){
			mediumObstacles[i] = new MediumObstacle(Game_Width + 400*i,Game_Height - Game_Height/2+65,Obstacle_VX);
		}
	}

	private void initBottomObstacle() throws SlickException {
		bottomObstacles = new BottomObstacle[BottomObstacle_COUNT];
		for(int i = 0; i < BottomObstacle_COUNT; i++){
			bottomObstacles[i] = new BottomObstacle(Game_Width/2+100+400*i, Game_Height - Game_Height/2+65, Obstacle_VX);
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(isStarted == true){
			background.update();
			pig.update();
			for(BottomObstacle bottomobstacle : bottomObstacles){
				bottomobstacle.update();
			}
			for(MediumObstacle mediumobstacle : mediumObstacles)
				mediumobstacle.update();
			}
		}
	
	@Override
	  public void keyPressed(int key, char c) {
		if(Pig.check_jump < 2){
			if (key == Input.KEY_SPACE) {
				pig.jump();
				isStarted = true;
				Pig.check_jump ++ ;
			}
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
