import java.util.Scanner;

class BinarySearchTree{
    public Node root;
    public int size;

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
        size = values.length;

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
        if(n.left != null){
            print(n.left);
        }
        System.out.println(n.element);
        if(n.right != null){
            print(n.right);
        }
    }

    int index = 0;
    public long[] getSortedArray(Node n, long[] sortedArray){
        if(n.left != null){
            sortedArray = getSortedArray(n.left, sortedArray);
        }
        sortedArray[index] = n.element;
        index += 1;
        if(n.right != null){
            sortedArray = getSortedArray(n.right, sortedArray);
        }
        return sortedArray;
    }

    // public long[] getSortedArray(){
    //     long[] sortedArray = new long[size];
    //     int index = 0;
    //     Node current = root;
    //     while(true){
    //         if(current.right == null && current.left == null){
    //             sortedArray[index] = current.element;
    //             break;
    //         }
    //         while (current.left!=null){
    //             current = current.left;
    //         }
    //         sortedArray[index] = current.element;
    //         index++;
    //         if (current.right != null){
    //             current = current.right;
    //             continue;
    //         }
    //     }
    //     return sortedArray;
    // }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int j=0;j<T;j++){
            int n = in.nextInt();
            int x = in.nextInt();
            long A[] = new long[n];
            for (int i=0;i<n;i++){
                A[i] = in.nextLong();
            }
            BinarySearchTree bst = new BinarySearchTree(A);
            long[] arr = new long[bst.size];
            arr = bst.getSortedArray(bst.root, arr);
            // for(int i=0;i<arr.length;i++){
            //     System.out.print(arr[i] + "\t");
            // }
            int common = 0;
            for(int i=1;i<arr.length;i++){
                if(arr[i] == arr[i-1]){
                    common ++;
                }
            }
            int distinct = arr.length - common;
            if(distinct == x){
                System.out.println("Good");
            }else if(distinct>x){
                System.out.println("Average");
            }else{
                System.out.println("Bad");
            }

        }
    }
}