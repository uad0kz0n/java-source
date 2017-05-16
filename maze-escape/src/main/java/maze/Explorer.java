package maze;

import java.util.List;

public interface Explorer {
	List<MazeNode> findPath(int[][] inputmap, int startX,int startY, int endX,int endY);
	
}
