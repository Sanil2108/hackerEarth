import java.util.Scanner;

public class BinarySearchTree{
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
                if(current.element>values[i]){
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

    public Node find(long element, Node n){
        if(element == n.element){
            return n;
        }
        if(element>n.element){
            return find(element, n.right);
        }else{
            return find(element, n.left);
        }
    }

    public void print(long element){
        Node n = find(element, this.root);
        print(n);
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

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long A[] = new long[n];
        for (int i=0;i<n;i++){
            A[i] = in.nextLong();
        }
        BinarySearchTree bst = new BinarySearchTree(A);
        long t = in.nextLong();
        bst.print(t);
    }
}