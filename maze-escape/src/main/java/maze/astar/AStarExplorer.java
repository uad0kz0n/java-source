/**
 * 
 */
package maze.astar;

import java.util.LinkedList;
import java.util.List;

import maze.Explorer;
import maze.MazeNode;

/**
 * @author seil.park@gmail.com
 *
 */
public class AStarExplorer implements Explorer  {
	private int [][] map;
	private AStarNode [][] nodes;
	
	LinkedList<AStarNode> openedList=null;
	LinkedList<AStarNode>  closedList = null;
	static final int BASIC_COST_FOR_MOVE=1;
	
	int[] up = { 0, -1 };// up
	int[] down = { 0, 1 };// down
	int[] right = { 1, 0 };// right
	int[] left = { -1, 0 };// left
	
	  private void initEmptyNodes(int width , int height) {
		  nodes=new AStarNode[width][height];
	        for (int i = 0; i < width; i++) {
	            for (int j = 0; j < height; j++) {
	                nodes[i][j] = new AStarNode(i, j);
	            }
	        }
	    }
	  
	public List<MazeNode> findPath(final int [][] input, int startX,int startY, int endX,int endY) {
		map=input.clone();
		initEmptyNodes(map.length, map[0].length);
		openedList = new LinkedList<>();
		closedList = new LinkedList<>();
        
		AStarNode start=new AStarNode(startX, startY);
		AStarNode end=new AStarNode(endX, endY);
		
		openedList.add(start); // add starting node to open list
		 
		AStarNode current = start;
        while (!openedList.isEmpty()) {
        	System.out.println("current : "+current);
            
        	closedList.add(current); // add current node to closed list
            openedList.remove(current); // delete current node from open list
        	
           
            
            List<AStarNode> adjacentNodes = findAdjacentNodes(current);
       
            
            for (AStarNode currentAdj :adjacentNodes ) {
            	if (!openedList.contains(currentAdj) ) { 
                    currentAdj.setPrevious(current); // set current node as previous for this node
                    currentAdj.setHCosts(end); // set h costs of this node (estimated costs to goal)
                    currentAdj.setGCosts(current,BASIC_COST_FOR_MOVE); // set g costs of this node (costs from start to this node)
                    openedList.add(currentAdj); // add node to openList
                } else { // node is in openList
                    if (currentAdj.getGCosts() > currentAdj.calculateGCosts(current,BASIC_COST_FOR_MOVE)) { // costs from current node are cheaper than previous costs
                        currentAdj.setPrevious(current); // set current node as previous for this node
                        currentAdj.setHCosts(current); // set g costs of this node (costs from start to this node)
                    }
                }
            }
            
             
            current = cheapestChild(adjacentNodes); // get node with lowest fCosts from openList
        	if(current==null){
        		System.out.println("Current null");
        		current=openedList.getLast();
        	}
            
            if ((current.getXAxis() == end.getXAxis())   && (current.getYAxis() == end.getYAxis())) { 
                return calcPath(start, current);
            }
            
 
        }
        return null; // unreachable
	}
 
	private List<AStarNode> findAdjacentNodes(MazeNode current) {
		List<AStarNode> adj = new LinkedList<>();
	    AStarNode left = move(current, this.left);
	    AStarNode right = move(current, this.right);
	    AStarNode up = move(current, this.up);
	    AStarNode down = move(current, this.down);
		if (left != null && !closedList.contains(left))
			adj.add(left);
		if (right != null && !closedList.contains(right))
			adj.add(right);
		if (up != null && !closedList.contains(up))
			adj.add(up);
		if (down != null && !closedList.contains(down))
			adj.add(down);

		return adj;
	}

	private AStarNode move(MazeNode current, int[] move) {
		int x = current.getXAxis() + move[0];
		int y = current.getYAxis() + move[1];
		
		if (x >= 0 && x < map.length && y >= 0 && y < map[current.getXAxis()].length && map[x][y] == 0 ) {
			return nodes[x][y];
		} else
			return null;
	}
	
	

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	private List<MazeNode> calcPath(MazeNode start, MazeNode end) {
		LinkedList<MazeNode> path = new LinkedList<>();
	    MazeNode curr = end;
	    while (true) {
	    	
	        curr = ((AStarNode)curr).getPrevious();
	        if (curr.equals(start)) {
	        	break;
	        }
	        path.add(curr);
	    }
	    return path;
	}

	private AStarNode cheapestChild(List<AStarNode> adjacentNodes) {
		
		AStarNode cheapest = null;
		for(AStarNode child : adjacentNodes){
			if(cheapest==null || (child.getFCosts() < cheapest.getFCosts() || (child.getFCosts() == cheapest.getFCosts()  &&  child.getHCosts() < cheapest.getHCosts()  )  ) ){
				 cheapest=child;
	          
			} 
		}
		 
	    return cheapest;
 
	}

}
