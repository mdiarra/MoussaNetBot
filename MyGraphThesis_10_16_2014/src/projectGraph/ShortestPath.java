package projectGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 * Class ShortestPath, using Breadth First Search
 * 
 * Constructs a tree from a graph using Breadth First Search
 * 
 * @author Noussa Diarra
 */
public class ShortestPath {
	private Graph g;
	private Vector<Node>tree; //Will contain the tree made out the graph
	private Queue<Node> queue;//for the BFS
	private Vector<Node>visitedNodes;
	private Vector<Node>shortestPath = new Vector<>();
	private boolean pathfound = false;

	/**
	 * Constructor
	 * @param g 
	 * 			The graph to transform into tree
	 * @param start
	 * 			The summit of the tree
	 */
	public ShortestPath(Graph g, Node start, Node target) {
		this.g = g;
		this.tree = new Vector<Node>();
		this.queue = new LinkedList<Node>();
		this.visitedNodes = new Vector<Node>();
		searchForPath(start, target);
	}
	
	/**
	 * Starts the tree construction
	 * @param source
	 * 			summit of the tree
	 */
	private void searchForPath(Node source, Node target){
		
		source.setParent(null);
		source.setVisited(true);
		queue.add(source);
		//Start constructing tree and stop when target found
		while (source != target & tree.size()<7 & !queue.isEmpty() & !pathfound) {
			Node current = queue.remove();
			tree.add(current);

			for (Node n : g.getSuccessorsOf(current)) {
				if (!visitedNodes.contains(n)) {
					n.setParent(current);
					visitedNodes.add(n);
					queue.add(n);
					if(n==target){
						tree.add(n);
						pathfound  = true;
						break;
					}
				}
			}
			
		}
		
		if(!pathfound)tree.removeAllElements(); //if target not found clear tree
		else{//construct path from target to source
			Stack<Node> temp = new Stack<>();// will contain the reverse path
			Stack<Node> revPath = new Stack<>();
			temp.push(target);
			revPath.push(target);
			Node parent;
			do {
				parent = temp.lastElement().getParent();
				revPath.push(parent);
				if (parent == null)
					break;
				temp.add(parent);
			} while (parent != source);
			//reconstruct path from start source to target
			while (!revPath.isEmpty())
				shortestPath.add(revPath.pop());
		}
	}
	
	/**
	 * Returns the constructed tree
	 * @return The tree made out of the graph
	 */
	public Vector<Node> getShortestPath() {
		return shortestPath;
	}
	
}
