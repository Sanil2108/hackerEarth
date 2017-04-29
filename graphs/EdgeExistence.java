import java.util.*;
class EdgeExistence{
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

		public UndirectedGraph(){
			adjacencyMatrix = new int[MIN_NODES][MIN_NODES];
		}

		public UndirectedGraph(int rootElement){
			root=new Node(rootElement);
			adjacencyMatrix = new int[MIN_NODES][MIN_NODES];
			numberOfNodes=1;
		}

		public Node addNode(int value){
			if(root == null){
				root=new Node(value);
				numberOfNodes++;
			}else{
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
	}

	public static void main(String[] args){
		UndirectedGraph graph=new UndirectedGraph();
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int M=in.nextInt();

		ArrayList<Node> allNodes=new ArrayList<Node>();
		for(int i=0;i<N;i++){
			allNodes.add(graph.addNode(i));
		}

		int[][] AB=new int[M][2];
		for(int i=0;i<M;i++){
			AB[i][0]=in.nextInt();
			AB[i][1]=in.nextInt();
			// allNodes.get()
		}



		int Q=in.nextInt();
		int[][] AB_Q=new int[Q][Q];
		for(int i=0;i<Q;i++){
			AB_Q[i][0]=in.nextInt();
			AB_q[i][1]=in.nextInt();
		}
	}
}