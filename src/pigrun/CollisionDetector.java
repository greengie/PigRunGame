package pigrun;

public class CollisionDetector {
	static boolean isCollideBottomObstacle(float bottomX, float bottomY, float pigX, float pigY) {
		if(Math.abs(pigX - bottomX) <= BottomObstacle.WIDTH/2 + 15){
			if((pigY <= bottomY - BottomObstacle.IMAGE_HEIGHT )){
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}
}
