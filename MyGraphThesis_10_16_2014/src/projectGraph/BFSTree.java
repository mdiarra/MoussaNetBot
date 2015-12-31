package projectGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Class Breadth First Search
 * 
 * Constructs a tree from a graph using Breadth First Search
 * 
 * @author Noussa Diarra
 */
public class BFSTree {
	private Graph g;
	private Vector<Node>tree; //Will contain the tree made out the graph
	private Queue<Node> queue;//for the BFS
	private Vector<Node>visitedNodes;

	/**
	 * Constructor
	 * @param g 
	 * 			The graph to transform into tree
	 * @param summit 2909 blodget 
	 * 			The summit of the tree
	 */
	public BFSTree(Graph g, Node summit) {
		this.g = g;
		this.tree = new Vector<Node>();
		this.queue = new LinkedList<Node>();
		this.visitedNodes = new Vector<Node>();
		constructTree(summit);
	}
	
	/**
	 * Starts the tree construction
	 * @param summit
	 * 			summit of the tree
	 */
	private void constructTree(Node summit){
		summit.setParent(null);
		summit.setVisited(true);
		queue.add(summit);
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			tree.add(current);
			for (Node n : g.getSuccessorsOf(current)) {
				if (!visitedNodes.contains(n)) {
					n.setParent(current);
					visitedNodes.add(n);
					queue.add(n);
				}
			}
		}
		
	}
	
	/**
	 * Returns the constructed tree
	 * @return The tree made out of the graph
	 */
	public Vector<Node> getTree() {
		return tree;
	}
	
}
