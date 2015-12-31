package projectGraph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * Class GraphFileReader
 * 
 * Uses a simple GML file to construct a graph
 * The GML file is generated with the application 
 * GetNet based on netvizz
 * 
 * @author Moussa Diarra
 */
public class GraphFileReader {
	
	private String filePath;
	private Vector<String> graphData;
	private Vector<Node>allNodes;
	private Vector<Edge>allEdges;

	/**
	 * Constructor
	 * 
	 * @param filePath
	 * 			The path of the GML file
	 */
	public GraphFileReader(String filePath) {
		super();
		this.filePath = filePath;
		graphData = new Vector<String>();
		allNodes = new Vector<Node>();
		allEdges = new Vector<Edge>();
		loadData();
		createNodes();
		createEdges();
	}

	/**
	 * Copy all the data, line by line,  from the GML file to a vector.
	 */
	private void loadData() {
		try {

			InputStream ips = new FileInputStream(filePath);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;

			while ((line = br.readLine()) != null) {

				graphData.add(line.trim());
			}
			br.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * Returns the graph's data
	 * 
	 * @return A vector that contains the graph's data
	 */
	public Vector<String> getGraphData() {
		return graphData;
	}
	
	/**
	 * Creates all the nodes of the graph
	 * 
	 * @return The total nodes created
	 */
	private int createNodes() {
		String id;
		String label;
		for(int i=0; i<graphData.size(); i++){
			String s = graphData.elementAt(i);
			if(s.equals("node")){
				id = graphData.elementAt(i+2);
				label = id;
				
				id = id.substring(3,id.length());
				label = label.substring(3, label.length());
				Node n = new Node(Integer.parseInt(id), label);
				allNodes.add(n);
			}
			if (s.equals("node [")){
				id = graphData.elementAt(i+1);
				label = graphData.elementAt(i+2);
				//get rid of the extra characters:
				id = id.substring(3,id.length());
				label = label.substring(7, label.length()-1);
				Node n = new Node(Integer.parseInt(id), label);
				allNodes.add(n);
			}
		}
		return allNodes.size();
	}
	
	/**
	 * Returns all the graph's nodes
	 * 
	 * @return A vector that contains the graph's nodes
	 */
	public Vector<Node> getAllNodes() {
		return allNodes;
	}

	/**
	 * Creates all the graph's edges
	 * 
	 * @return A vector that contains all the graph's edges
	 */
	private int createEdges() {
		String tempS, tempT;

		for(int i=0; i<graphData.size(); i++){
			String s = graphData.elementAt(i);
			Node source =null, target=null;
			int sourceID, targetID;
			
			if (s.equals("edge [" ) || s.equals("edge")){
				int x1 = 1, x2 =2;
				if(s.equals("edge")){
					x1 = 2;
					x2 = 3;
				}
				tempS  = graphData.elementAt(i+x1);
				tempT = graphData.elementAt(i+x2);
				//get rid of extra characters
				tempS = tempS.substring(7, tempS.length());
				tempT = tempT.substring(7, tempT.length());
				sourceID = Integer.parseInt(tempS);
				targetID = Integer.parseInt(tempT);
				
				for(Node n : allNodes){
					if(n.getId()==sourceID)source = n;
					if(n.getId()==targetID)target = n;
				}
				Edge e = new Edge(source, target);
				allEdges.add(e);
			}
		}
		return allEdges.size();
	}
	
	/**
	 * Returns all the graph's edges
	 * 
	 * @return vector that contains all the graph's edges
	 */
	public Vector<Edge> getAllEdges() {
		return allEdges;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "karate.gml";
		GraphFileReader r = new GraphFileReader(path);
		
		System.out.println(r.getAllNodes());			
	}
}
