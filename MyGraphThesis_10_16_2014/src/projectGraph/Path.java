package projectGraph;

import java.util.Vector;

public class Path {
	private Node startingNode;
	private Node endingNode;
	public Vector<Node>path;
	
	public Path(Node startingNode, Node endingNode) {
		super();
		this.startingNode = startingNode;
		this.endingNode = endingNode;
		this.path = new Vector<Node>();
	}

	public Node getStartingNode() {
		return startingNode;
	}

	public void setStartingNode(Node startingNode) {
		this.startingNode = startingNode;
	}

	public Node getEndingNode() {
		return endingNode;
	}

	public void setEndingNode(Node endingNode) {
		this.endingNode = endingNode;
	}

	public Vector<Node> getPath(Node source, Node target, Graph g) {
		path = new ShortestPath(g, source, target).getShortestPath();
		return path;
	}
	
	public void setPath(Vector<Node> path){
		this.path = path;
	}

	@Override
	public String toString() {
		return "Path: [startingNode=" + startingNode + ", endingNode="
				+ endingNode + "]";
	}
	
	
}
