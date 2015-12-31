package projectGraph;

/**
 *  Class Node
 * 
 * @author Moussa Diarra
 */
public class Node {
	private int id;
	private String label;
	private Node parent;
	private boolean visited = false;
	/**
	 * Constructor
	 * 
	 * @param id
	 * 			The node id
	 * @param label
	 * 			The node label
	 */
	public Node(int id, String label) {
		super();
		this.id = id;
		this.label = label;
		this.parent = null;
	}
	/**
	 * Returns the node's id
	 * 
	 * @return The node's id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the node's id
	 * @param id
	 * 			New node's id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the node's label
	 * 
	 * @return The node's label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Sets the node's label
	 * 
	 * @param label
	 * 			New node's label
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * Returns the node's parent
	 * 
	 * @return The node's parent
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * Sets the node's parent
	 * 
	 * @param parent
	 * 			New parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	/**
	 * Sets the node to visited or not visited
	 * 
	 * @param visited
	 * 			True if visited and false if not
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	/**
	 * Returns whether the node is visited or not
	 * 
	 * @return <code>True</code> if the node has been visited
	 */
	public boolean isVisited(){
		return visited;
	}
	
	@Override
	public String toString() {
		return "[(" + id + ")" + label + "]";
	}
		
}
