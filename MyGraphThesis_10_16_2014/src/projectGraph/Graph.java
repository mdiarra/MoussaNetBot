package projectGraph;

import java.util.Vector;

/**
 * Class Graph
 * 
 * @author Moussa Diarra
 */
public class Graph {
	private Vector<Node> allNodes = new Vector<>();
	private Vector<Edge> allEdges = new Vector<>();
	private boolean isDirected;

	/**
	 * Constructor
	 * 
	 * @param isDirected
	 *            <code>True</code> if the graph is directed
	 */
	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	/**
	 * Constructor
	 * 
	 * @param allNodes
	 *            Vector of nodes
	 * @param allEdges
	 *            Vector of edges
	 * @param isDirected
	 *            <code>True</code> if the graph is directed
	 */
	public Graph(Vector<Node> allNodes, Vector<Edge> allEdges,
			boolean isDirected) {
		this.isDirected = isDirected;
		this.allNodes = allNodes;
		for (Edge e : allEdges)
			this.addEdge(e);
	}
	
	public Graph(String filePath, boolean isDirected){
		GraphFileReader gfr = new GraphFileReader(filePath);
		this.isDirected = isDirected;
		this.allNodes = gfr.getAllNodes();
		for (Edge e : gfr.getAllEdges())
			this.addEdge(e);
	}

	/**
	 * Returns the nodes of the graph
	 * 
	 * @return A vector that contains all the nodes of the graph
	 */
	public Vector<Node> getAllNodes() {
		return allNodes;
	}
	
	public int getNodesCount(){
		return allNodes.size();
	}

	/**
	 * Returns the edges of the graph
	 * 
	 * @return A vector that contains all the edges of the graph
	 */
	public Vector<Edge> getAllEdges() {
		return allEdges;
	}
	
	public int getEdgesCount(){
		int edges = allEdges.size();
		if(!isDirected)edges = edges /2;
		
		return edges;
	}

	/**
	 * Adds a node to the graph
	 * 
	 * @param node
	 *            New node to add
	 */
	public void addNode(Node node) {
		allNodes.add(node);
		System.out.println("Node " + node + " added!");
	}

	/**
	 * Removes a node from the graph
	 * 
	 * @param node
	 *            Node to remove
	 */
	public void removeNode(Node node) {
		allNodes.remove(node);
		System.out.println("Node " + node + " removed!");
	}

	/**
	 * Adds an edge between two nodes
	 * 
	 * @param edge
	 *            The edge to add
	 */
	public void addEdge(Edge edge) {
		if (allNodes.contains(edge.getSource())
				& allNodes.contains(edge.getTarget())) {
			allEdges.add(edge);
			if (!isDirected)// double ways
				allEdges.add(new Edge(edge.getTarget(), edge.getSource()));
			// System.out.println("Edge " + edge + " added!");
		} else
			System.out
					.println("Error ! \nCan't add edge because one or more nodes are missing");
	}

	/**
	 * Remove an edge from the graph
	 * 
	 * @param edge
	 *            The edge to remove
	 */
	public void removeEdge(Edge edge) {

		allEdges.remove(edge);
		System.out.println("Edge " + edge + " removed!");
	}

	/**
	 * Returns the predecessors of a node
	 * 
	 * @param node
	 *            The node from which to get the predecessors
	 * @return A vector that contains all the node's predecessors
	 */
	public Vector<Node> getPredecessorsOf(Node node) {
		Vector<Node> temp = new Vector<>();
		for (int i = 0; i < allEdges.size(); i++) {
			if (allEdges.elementAt(i).getTarget() == node)
				temp.add(allEdges.elementAt(i).getSource());
		}
		return temp;
	}

	/**
	 * Returns all the successors of a node
	 * 
	 * @param node
	 *            The node from which to get the successors
	 * @return A vector that contains all the successors
	 */
	public Vector<Node> getSuccessorsOf(Node node) {
		Vector<Node> temp = new Vector<>();
		for (int i = 0; i < allEdges.size(); i++) {
			if (allEdges.elementAt(i).getSource() == node)
				temp.add(allEdges.elementAt(i).getTarget());
		}
		return temp;
	}

	/**
	 * Returns the degree of a given node
	 * 
	 * @param node
	 *            The node from which to get the degree
	 * @return The degree of the node
	 */
	public int getDegreeOf(Node node) {
		int inDegree, outDegree, degree;
		inDegree = getPredecessorsOf(node).size();
		outDegree = getSuccessorsOf(node).size();

		degree = inDegree + outDegree;
		if (!isDirected)
			degree = degree / 2;

		return degree;
	}
	
	public Vector<Integer> getDegreeDistribution(){
		Vector<Integer>degrees = new Vector<>();
		for(Node n : allNodes){
			degrees.add(getDegreeOf(n));
		}
		
		return degrees;
	}

	/**
	 * Returns all the neighbors of a given node
	 * 
	 * @param node
	 *            The node from which to get the neighbors
	 * @return A vector that contains all the node's neighbors
	 */
	public Vector<Node> getNeighborsOf(Node node) {
		Vector<Node> temp = new Vector<>();
		for (Edge e : allEdges) {
			if (e.getSource() == node || e.getTarget() == node)
				temp.add(e.getSource());
		}
		return temp;
	}

	/**
	 * Returns the shortest path between two nodes
	 * 
	 * @param start
	 *            Starting node
	 * @param target
	 *            Target node
	 * @return The shortest path between the two nodes
	 */
	public Vector<Node> getShortestPath(Node start, Node target) {

		// BFSTree tree = new BFSTree(this, start);
		//
		// // constructing the path starting from the target and go to the start
		// Vector<Node> path = new Vector<>();
		// Stack<Node> temp = new Stack<>();// will contain the reverse path
		// if (start == target) {
		// path.add(start);
		// return path;
		// }
		// if (tree.getTree().contains(target)) {
		// temp.push(target);
		// Node parent;
		// do {
		// parent = temp.lastElement().getParent();
		// if (parent == null)
		// return path;
		// temp.add(parent);
		// } while (parent != start);
		// }
		// // reconstruct path from the top
		// while (!temp.isEmpty())
		// path.add(temp.pop());
		ShortestPath sp = new ShortestPath(this, start, target);
		return sp.getShortestPath();
	}

	/**
	 * Returns the closeness of a given node
	 * 
	 * @param node
	 *            The node from which to get the closeness
	 * @return The closeness of the node
	 */
	public float getClosenessOf(Node node) {
		float totalShortestPath = 0;
		for (Node n : allNodes) {
			float shorTestPathLengh = getShortestPath(node, n).size();
			if (shorTestPathLengh > 0)
				shorTestPathLengh -= 1;
			totalShortestPath += shorTestPathLengh;
		}
		float closeness = totalShortestPath / (allNodes.size() - 1);
		return closeness;   
	}
	
	public Vector<Float> getClosenessDistribution(){
		Vector<Float>closenesses = new Vector<>();
		for(Node n : allNodes)closenesses.add(getClosenessOf(n));
		return closenesses;
	}

	/**
	 * Returns the betweenness of a given node
	 * 
	 * @param node
	 *            the node from which to get the betweenness
	 * @return The node's betweenness
	 */

	public Vector<Path> OneToAllPath(Node node) {
		Vector<Path> paths = new Vector<>();
		for (Node n : allNodes) {
			Path p1 = new Path(node, n);
			p1.setPath(p1.getPath(node, n, this));
			paths.add(p1);

		}
		System.out.println(paths.size() + " paths found");
		return paths;
	}

	public Vector<Path> allToAllPath() {
		Vector<Path> paths = new Vector<>();
		for (int i = 0; i < allNodes.size(); i++) {
			Node node = allNodes.elementAt(i);
			for (int j = i; j < allNodes.size(); j++) {
				Node n = allNodes.elementAt(j);
				Path p1 = new Path(node, n);
				p1.setPath(p1.getPath(node, n, this));
				paths.add(p1);
				//System.out.println(p1 + ":::" + p1.path);
			}	
		}
		return paths;
	}
	
	public int getBetweennessOf(Node n){
		int betweenness = 0;
		int pathLength = 0;
		Vector<Path>allPaths = new Vector<>();
		allPaths = allToAllPath();
		for(Path p : allPaths){
			Vector<Node>path = p.path;
			if(p.getStartingNode() !=n & p.getEndingNode()!=n & path.contains(n)){
				betweenness++;
				pathLength = pathLength + path.size();
			}
		}
		//System.out.println("Betweenness " + n + " : " + betweenness);
		betweenness = betweenness/pathLength;
		return betweenness;
	}
	/////////////////////////////////////////
	public Vector<Double> getBetweennessDistribution(){
		System.out.println("*****Betweenness Distribution*****");
		Vector<Double>bdistribution = new Vector<>();
		double betweenness;
		double B_pathLength;//paths that contains the betweenness node
		//double NB_pathLength;//paths that does not contains the betweenness node
		Vector<Path>allPaths = new Vector<>();
		allPaths = allToAllPath();
		
		for(Node n : allNodes){
			betweenness = 0;
			B_pathLength = 0;
			//NB_pathLength = 0;
			for(Path p : allPaths){
				Vector<Node>path = p.path;
				if(p.getStartingNode() !=n & p.getEndingNode()!=n & path.contains(n)){
					betweenness++;
					B_pathLength = B_pathLength + path.size();
				}
				//NB_pathLength = allPaths.size() - B_pathLength ;
			}
			//if(pathLength>0)betweenness = betweenness/pathLength;
			//betweenness = B_pathLength/NB_pathLength;
			//System.out.println("Betweenness " + n + " : " + betweenness);
			bdistribution.add(betweenness);
			System.out.println(betweenness);
		}
		return bdistribution;
	}
}
