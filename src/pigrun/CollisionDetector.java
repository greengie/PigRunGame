package pigrun;

public class CollisionDetector {
	static boolean isCollideBottomObstacle(float pigX, float pigY, float bX, float bY) {
		if(Math.abs(pigX - bX) <= BottomObstacle.WIDTH/2){
			if((pigY <= bY - 50)){
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}
}
