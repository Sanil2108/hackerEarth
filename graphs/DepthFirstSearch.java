import java.util.*;
class UndirectedGraph{
    int[][] adjacencyMatrix;
    int numberOfNodes;
    public Node root;

    static final int MIN_NODES=1;

    static class Node{
        private static int id=0;
        public int m_id;
        public int element;

        private Node[] children;
        public int n_children=0;
        private static final int MIN_CHILDREN_SIZE=10;

        public Node(int element){
            this.element = element;
            m_id=id++;
            children=new Node[MIN_CHILDREN_SIZE];
        }

        public void addChild(Node n){
            if(n_children>=children.length){
                Node[] newChildren=new Node[n_children+MIN_CHILDREN_SIZE];
                for(int i=0;i<children.length;i++){
                    newChildren[i]=children[i];
                }
                this.addChild(n);
            }else{
                children[n_children]=n;
                n_children++;
            }
        }

        public Node[] getChildren(){
            return children;
        }

        @Override
        public String toString(){
            return "[Node-"+m_id+"-"+element+"]";
        }
    }

    public UndirectedGraph(){
        root=null;
        adjacencyMatrix = new int[MIN_NODES][MIN_NODES];
        numberOfNodes=0;
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
        to.addChild(from);
        from.addChild(to);
    }

    public void printAdjacencyMatrix(){
        for(int i=0;i<numberOfNodes;i++){
            for(int j=0;j<numberOfNodes;j++){
                System.out.print(adjacencyMatrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public boolean isEdge(Node to, Node from){
        return adjacencyMatrix[to.id][from.id]==1;
    }

    private void DFS(Node n, boolean[] visited){
        if(!visited[n.m_id]){
            visited[n.m_id]=true;
            System.out.print(n.element+"\t");
            if(n.n_children==0){
                return;
            }
            for(int i=0;i<n.n_children;i++){
                DFS(n.children[i], visited);
            }
        }
    }

    public void DFS(){
        boolean[] visited=new boolean[numberOfNodes];
        DFS(root, visited);
    }

    private boolean[] DFSmodified(Node n, boolean[] visited){
        int nodesVisited=0;
        if(!visited[n.m_id]){
            nodesVisited++;
            visited[n.m_id]=true;
//            System.out.print(n.element+"\t");
            if(n.n_children!=0){
                for(int i=0;i<n.n_children;i++){
                    DFSmodified(n.children[i], visited);
                }
            }else{
                return visited;
            }
        }
        return visited;
    }

    public boolean[] DFSmodified(){
        boolean[] visited=new boolean[numberOfNodes];
        return DFSmodified(root, visited);
    }

    public static void problem(){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        UndirectedGraph graph=new UndirectedGraph();
        Node[] nodes=new Node[N];
        for(int i=0;i<N;i++){
            nodes[i]=graph.addNode(i);
        }
        for(int i=0;i<M;i++){
            int a=in.nextInt()-1;
            int b=in.nextInt()-1;
            graph.addEdge(nodes[a], nodes[b]);
        }
        int test=in.nextInt()-1;
        graph.root=nodes[test];

        boolean[] temp=graph.DFSmodified();
        int unreachable=0;
        for(boolean i:temp){
            if(!i){
                unreachable++;
            }
        }
        System.out.println(unreachable);
    }

    public static void main(String[] args){
        problem();
        // UndirectedGraph graph=new UndirectedGraph(0);
        // Node[] nodes=new Node[8];
        // nodes[0]=graph.root;
        // for(int i=1;i<nodes.length;i++){
        //     nodes[i]=graph.addNode(i);
        // }
        // graph.addEdge(nodes[0], nodes[1]);
        // graph.addEdge(nodes[0], nodes[2]);
        // graph.addEdge(nodes[0], nodes[3]);
        // graph.addEdge(nodes[1], nodes[4]);
        // graph.addEdge(nodes[1], nodes[5]);
        // graph.addEdge(nodes[2], nodes[6]);
        // graph.addEdge(nodes[2], nodes[7]);
        // graph.addEdge(nodes[3], nodes[7]);
        // graph.printAdjacencyMatrix();

        // System.out.println();
        // System.out.println();

        // graph.DFS();
        // System.out.println();
    }
}