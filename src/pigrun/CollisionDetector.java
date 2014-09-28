package pigrun;

public class CollisionDetector {
	static boolean isCollideBottomObstacle(float bottomX, float bottomY, float pigX, float pigY) {
		if(Math.abs(pigX - bottomX) <= BottomObstacle.WIDTH/2 + 5){
			if((pigY <= bottomY - BottomObstacle.IMAGE_HEIGHT )){
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}
	
	static boolean isCollideMediumObstacle(float mediumX, float mediumY, float pigX,float pigY) {
		if(Math.abs(pigX - mediumX) <= MediumObstacle.WIDTH/2 + 5)
		{
			if((pigY <= mediumY - MediumObstacle.IMAGE_HEIGHT + 8))
			{
				return false;
			}
			else{
				return true;
			}
		}
		return false;
	}

	static boolean isCollideTopObstacle(float topX, float topY, float pigX,float pigY) {
		if(Math.abs(pigX - topX) <= TopObstacle.WIDTH/2 + 5)
		{
			if((pigY >= topY - TopObstacle.IMAGE_HEIGHT/5 + 5))
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
