import java.util.Scanner;

class BinarySearchTree{
    public Node root;

    static class Node{
        long element;
        Node left;
        Node right;

        Node(){
            left = null;
            right = null;
        }
    }

    public BinarySearchTree(long[] values){
        root = new Node();
        root.element = values[0];

        for(int i = 1;i<values.length;i++){
            Node current = root;
            while(true){
                if(current.element>=values[i]){
                    if(current.left==null){
                        Node newNode = new Node();
                        current.left = newNode;
                        newNode.element = values[i];
                        break;
                    }else{
                        current = current.left;
                        continue;
                    }
                }else{
                    if(current.right==null){
                        Node newNode = new Node();
                        current.right=newNode;
                        newNode.element = values[i];
                        break;
                    }else{
                        current = current.right;
                        continue;
                    }
                }
            }
        }
    }

    public void print(Node n){
        System.out.println(n.element);
        if(n.left != null){
            print(n.left);
        }
        if(n.right != null){
            print(n.right);
        }
    }

    public long max(long a, long b){return (a>b)?a:b;}

    public long findHeight(Node n, int h){
        if(n.left != null && n.right!=null){
            return max(findHeight(n.left, h+1), findHeight(n.right, h+1));
        }else if (n.left != null){
            return findHeight(n.left, h+1);
        }else if (n.right != null){
            return findHeight(n.right, h+1);
        }else{
            return h;
        }

    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long A[] = new long[n];
        for (int i=0;i<n;i++){
            A[i] = in.nextLong();
        }
        BinarySearchTree bst = new BinarySearchTree(A);
        // bst.print(bst.root);
        System.out.println(bst.findHeight(bst.root, 1));
    }
}