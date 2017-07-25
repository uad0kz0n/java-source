package maze.astar;

import maze.MazeNode;

public class AStarNode implements MazeNode {
	private int hCosts = 0;
	private int gCosts = 0;
	private int xAxis = 0;
	private int yAxis = 0;
	private AStarNode previous = null;

	public AStarNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AStarNode(int xAxis, int yAxis) {
		super();
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}

	@Override
	public int getXAxis() {

		return this.xAxis;
	}

	@Override
	public int getYAxis() {
		return this.yAxis;
	}

	@Override
	public void setXAxis(int xAxis) {
		this.xAxis=xAxis;
	}

	@Override
	public void setYAxis(int yAxis) {
		this.yAxis=yAxis;

	}

	 

	public AStarNode getPrevious() {
		return previous;
	}

	public void setPrevious(AStarNode previous) {
		this.previous = previous;
	}

	public int getHCosts() {
		return hCosts;
	}

	public void setHCosts(int hCosts) {
		this.hCosts = hCosts;
	}

	public int getGCosts() {
		return gCosts;
	}

	public void setGCosts(int gCosts) {
		this.gCosts = gCosts;
	}

	public void setHCosts(AStarNode end) {
		this.hCosts = Math.abs((this.getXAxis() - end.getXAxis() + this.getYAxis() - end.getYAxis()));

	}

	public void setGCosts(AStarNode previousNode, int basicCost) {
		this.setGCosts(previousNode.getGCosts() + basicCost);
	}
	
	public int calculateGCosts(AStarNode previousNode, int basicCost) {
		return previousNode.getGCosts() + basicCost;
	}

	public int getFCosts() {
		 
		return this.getGCosts()+this.getHCosts();
	}

	@Override
	public String toString() {
		return "AStarNode [hCosts=" + hCosts + ", gCosts=" + gCosts + ", xAxis=" + xAxis + ", yAxis=" + yAxis + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xAxis;
		result = prime * result + yAxis;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AStarNode other = (AStarNode) obj;
		if (xAxis != other.xAxis)
			return false;
		if (yAxis != other.yAxis)
			return false;
		return true;
	}
	
	
	
}
