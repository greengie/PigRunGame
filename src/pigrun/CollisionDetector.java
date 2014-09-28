package pigrun;

public class CollisionDetector {
	static boolean isCollideBottomObstacle(float bottomX, float bottomY, float pigX, float pigY) {
		if(Math.abs(pigX - bottomX) <= BottomObstacle.WIDTH/2 + 10){
			if((pigY <= bottomY - BottomObstacle.IMAGE_HEIGHT )){
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}

	static boolean isCollideTopObstacle(float topX, float topY, float pigX,float pigY) {
		if(Math.abs(pigX - topX) <= BottomObstacle.WIDTH/2 + 15)
		{
			if((pigY >= topY - TopObstacle.IMAGE_HEIGHT/2 + 100))
			{
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}
}
