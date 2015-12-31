package projectGraph;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		  Graph graph1 = new Graph(false); Graph graph2 = new Graph(false);
//		  Node a = new Node(1, "a"); Node b = new Node(2, "b"); Node c = new
//		  Node(3, "c"); Node d = new Node(4, "d"); Node e = new Node(5, "e");
//		  Node f = new Node(6, "f"); Node g = new Node(6, "g"); Node h = new
//		  Node(4, "h"); Node i = new Node(5, "i"); Node j = new Node(6, "j");
//		  Node k = new Node(6, "k");
//		  
//		  graph1.addNode(a); graph1.addNode(b); graph1.addNode(c);
//		  graph1.addNode(d); graph1.addNode(e); graph1.addNode(f);
//		  
//		  graph2.addNode(a); graph2.addNode(b); graph2.addNode(c);
//		  graph2.addNode(d); graph2.addNode(e); graph2.addNode(f);
//		  graph2.addNode(g); graph2.addNode(h); graph2.addNode(i);
//		  graph2.addNode(j); graph2.addNode(k);
//		  
//		  
//		  
//		  Edge e1 = new Edge(a, b); Edge e2 = new Edge(a, c); Edge e3 = new
//		  Edge(c, d); Edge e4 = new Edge(b, e); Edge e5 = new Edge(e, d); Edge
//		  e6 = new Edge(d, f);
//		  
//		  Edge x1 = new Edge(a, b); Edge x2 = new Edge(b, c); Edge x3 = new
//		  Edge(b, d); Edge x4 = new Edge(b, e); Edge x5 = new Edge(b, f); Edge
//		  x6 = new Edge(a,g); Edge x7 = new Edge(a, h); Edge x8 = new Edge(g,
//		  j); Edge x9 = new Edge(h, j); Edge x10 = new Edge(h, i); Edge x11 =
//		  new Edge(i, k); Edge x12 = new Edge(i, j);
//		  
//		  
//		  graph1.addEdge(e1); graph1.addEdge(e2); graph1.addEdge(e3);
//		  graph1.addEdge(e4); graph1.addEdge(e5); graph1.addEdge(e6);
//		  
//		  graph2.addEdge(x1); graph2.addEdge(x2); graph2.addEdge(x3);
//		  graph2.addEdge(x4); graph2.addEdge(x5); graph2.addEdge(x6);
//		  graph2.addEdge(x7); graph2.addEdge(x8); graph2.addEdge(x9);
//		  graph2.addEdge(x10); graph2.addEdge(x11); graph2.addEdge(x12);
		  
//		  System.out.println("-------------------Shortest path-------------------"
//		  ); System.out.println("Path a,k: " + graph2.getShortestPath(a, k));
//		  System.out.println("Path f,j: " + graph2.getShortestPath(f, j));
//		  System.out.println("Path j,b: " + graph2.getShortestPath(j, b));
//		  
//		  System.out.println("-------------------Degree-------------------");
//		  System.out.println("Degree b: " + graph2.getDegreeOf(b));
//		  System.out.println("Degree a: " + graph2.getDegreeOf(a));
//		  System.out.println("Degree g: " + graph2.getDegreeOf(g));
//		  
//		  System.out.println("-------------------Closeness-------------------");
//		  System.out.println("Closeness b: " + graph2.getClosenessOf(b));
//		  System.out.println("Closeness a: " + graph2.getClosenessOf(a));
//		  System.out.println("Closeness g: " + graph2.getClosenessOf(g));
//		  
//		  System.out.println("-------------------Betweenness-------------------"
//		  ); System.out.println("betweenness b: " +
//		  graph2.getBetweennessOf(b)); System.out.println("betweenness a: " +
//		  graph2.getBetweennessOf(a)); System.out.println("betweenness g: " +
//		  graph2.getBetweennessOf(g));
//		 
//		GraphFileReader gfr1 = new GraphFileReader("myFacebookData2.gml");
//		Graph graph3 = new Graph("myFacebookData2.gml", false);
		Graph graph4 = new Graph("karate.gml", false);

		
//		Node n1=null,n2=null,n3=null;
//		for (Node n : graph3.getAllNodes()){
//			
//			if(n.getLabel().contains("Diarrah"))n1=n;
//			if(n.getId()==77)n2=n;
//			if(n.getId()==18)n3=n;
//		}
		//System.out.println(n1 + ", " + n2 + ", " + n3);
		
		//System.out.println(" Betweenness: " + graph3.getBetweenness2Of(n2));
		
//		for(int i = 272; i< graph3.getAllNodes().size(); i++){
//			Node n = graph3.getAllNodes().elementAt(i);
//			System.out.println(n + " : " + graph3.getBetweenness2Of(n));
//			//System.out.println("");
//		}
		
		
//		for(int x = 0; x< graph3.getAllNodes().size(); x++){
//		Node n = graph3.getAllNodes().elementAt(x);
//		//System.out.println(n + " : " + graph2.OneToAllPath(n));
//		System.out.println(n);
//		graph3.OneToAllPath(n);
//	}

		//System.out.println(graph2.getBetweenness2Of(k));
		//graph3.getBetweennessDistribution();
		
//		System.out.println("Path1 : " + graph3.getShortestPath(n2, n3));
//		System.out.println("Path2 : " + new ShortestPath(graph3, n2, n3).getShortestPath());
		
//		System.out.println(graph4.getAllEdges());

		System.out.println(graph4.getDegreeDistribution());
		System.out.println(graph4.getClosenessDistribution());
		System.out.println(graph4.getBetweennessDistribution());
	}

}
