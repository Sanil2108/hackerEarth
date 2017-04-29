class UndirectedGraph{
	int[][] adjacencyMatrix;
	int numberOfNodes;
	Node root;

	static final int MIN_NODES=1;

	static class Node{
		private static int id=0;
		public int m_id;
		public int element;
		public Node(int element){
			this.element = element;
			m_id=id++;
		}
	}

	public UndirectedGraph(int rootElement){
		root=new Node(rootElement);
		adjacencyMatrix = new int[MIN_NODES][MIN_NODES];
		numberOfNodes=1;
	}

	public Node addNode(int value){
		if(numberOfNodes+1<MIN_NODES){
			Node node=new Node(value);
			numberOfNodes++;
			return node;
		}else{
			Node node=new Node(value);
			numberOfNodes++;


			//very expensive
			int[][] newAdjacencyMatrix=new int[numberOfNodes][numberOfNodes];
			for(int i=0;i<numberOfNodes-1;i++){
				for(int j=0;j<numberOfNodes-1;j++){
					newAdjacencyMatrix[i][j]=adjacencyMatrix[i][j];
				}
			}
			adjacencyMatrix=newAdjacencyMatrix;


			return node;
		}
	}

	public void addEdge(Node to, Node from){
		adjacencyMatrix[to.m_id][from.m_id]++;
		adjacencyMatrix[from.m_id][to.m_id]++;
	}

	public void printAdjacencyMatrix(){
		for(int i=0;i<numberOfNodes;i++){
			for(int j=0;j<numberOfNodes;j++){
				System.out.print(adjacencyMatrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public Node getRoot(){
		return root;
	}

	public boolean isEdge(Node to, Node from){
		return adjacencyMatrix[to.id][from.id]==1;
	}



	public static void main(String[] args){
		UndirectedGraph graph=new UndirectedGraph(1);
		// graph.addEdge(graph.getRoot(), graph.addNode(2));
		// graph.printAdjacencyMatrix();
		
	}
}