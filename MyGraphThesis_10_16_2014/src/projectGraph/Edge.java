package projectGraph;

/**
 * Class Edge
 * 
 * @author Moussa Diarra
 *
 */
public class Edge {
	private Node source;
	private Node target;

	/**
	 * Constructor
	 * 
	 * @param source
	 * 			Source node
	 * @param destination
	 * 			Destination node
	 */
	public Edge(Node source, Node destination) {
		super();
		this.source = source;
		this.target = destination;
	}
	
	/**
	 * Returns the source node
	 * 
	 * @return The source node
	 */
	public Node getSource() {
		return source;
	}
	
	/**
	 * Sets the source node
	 * 
	 * @param source
	 * 			New source node
	 */
	public void setSource(Node source) {
		this.source = source;
	}
	
	/**
	 * Returns the target node
	 * 
	 * @return The target node
	 */
	public Node getTarget() {
		return target;
	}
	
	/**
	 * Sets the target node
	 * 
	 * @param destination
	 * 			New target node
	 */
	public void setTarget(Node destination) {
		this.target = destination;
	}
	
	@Override
	public String toString() {
		return  source.getLabel() + "--" + target.getLabel();
	}
	
}
