import java.util.Scanner;

public class BinaryTree{
    Node root;

    BinaryTree(int root){
        this.root = new Node(root, null, null, null);
    }

    public Node insert(String where, int value){
        char[] arr = where.toCharArray();
        Node currentRoot = this.root;
        for(char c : arr){
            if(c == 'L'){
//                if(currentRoot.left == null){
//                    currentRoot.left = new Node(value, null, null, currentRoot);
//                    currentRoot.isLeaf = false;
//                    return currentRoot.left;
//                }
                if(currentRoot.left == null){
                    currentRoot.left = new Node(-1, null, null, currentRoot);
                }
                currentRoot = currentRoot.left;
            }else{
//                if(currentRoot.right == null){
//                    currentRoot.right = new Node(value, null, null, currentRoot);
//                    currentRoot.isLeaf = false;
//                    return currentRoot.right;
//                }
                if(currentRoot.right == null){
                    currentRoot.right = new Node(-1, null, null, currentRoot);
                }
                currentRoot = currentRoot.right;
            }
        }
        currentRoot.value = value;
        return currentRoot;
    }

    public int getDistance(Node originalA, Node originalb, Node a, Node b){
        // if(a.parent == null && b.parent == null){
        //     return (originalA.level - a.parent.level) + (originalb.level - b.parent.level);
        // }
        // if(a.parent == null){
        //     return getDistance(originalA, originalb, a, b.parent);
        // }
        // if(b.parent == null){
        //     return getDistance(originalA, originalb, a.parent, b);
        // }
        if(a.parent == b.parent){
            return (originalA.level - a.parent.level) + (originalb.level - b.parent.level);
        }else{
            if(a.level == b.level){
                a=a.parent;
                b=b.parent;
                return getDistance(originalA, originalb, a, b);
            }else if(a.level < b.level){
                b=b.parent;
                return getDistance(originalA, originalb, a, b);
            }else{
                a=a.parent;
                return getDistance(originalA, originalb, a, b);
            }
        }
    }

    int maxDiameter = 0;
    // public int getMaxDiameter(Node root){
    //     if(getHeight(root.left)>getHeight(root.right)){

    //     }
    // }

    public int getHeight(Node root){
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return getHeight(root.right)+1;
        }
        if(root.right == null){
            return getHeight(root.left)+1;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight>rightHeight){
            if(leftHeight+rightHeight+1 > maxDiameter){
                maxDiameter = leftHeight+rightHeight+1;
            }
            return leftHeight+1;
        }else{
            if(rightHeight+leftHeight+1 > maxDiameter){
                maxDiameter = rightHeight+leftHeight+1;
            }
            return rightHeight+1;
        }
    }

    public void traverse(Node current){
        System.out.println(current.value);
        if(current.left != null){
            traverse(current.left);
        }
        if(current.right!=null){
            traverse(current.right);
        }
    }

    public static void main(String[] args){
//        BinaryTree binaryTree = new BinaryTree(1);
//        Node a = binaryTree.insert("L", 2);
//        binaryTree.insert("R", 3);
//        binaryTree.insert("LL", 4);
//        binaryTree.insert("LR", 5);
//        binaryTree.insert("RR", 6);
//        Node b = binaryTree.insert("LLL", 7);
//        binaryTree.insert("LRL", 8);
//        binaryTree.insert("RRL", 10);
//        binaryTree.insert("RRR", 9);
//        binaryTree.insert("LLLL", 11);
//        binaryTree.traverse(binaryTree.root);
//        System.out.println(binaryTree.getHeight(binaryTree.root));
//        System.out.println(binaryTree.maxDiameter);

//        BinaryTree binaryTree = new BinaryTree(1);
//        binaryTree.insert("L", 2);
//        binaryTree.insert("LL", 4);
//        binaryTree.insert("LR", 5);
//        binaryTree.insert("R", 3);
//        binaryTree.getHeight(binaryTree.root);
//        System.out.println(binaryTree.maxDiameter);

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int X = in.nextInt();
        BinaryTree binaryTree = new BinaryTree(X);
        for(int j=0;j<T-1;j++){
            String where = in.next();
            int k = in.nextInt();
            binaryTree.insert(where, k);
        }
        binaryTree.getHeight(binaryTree.root);
//        binaryTree.traverse(binaryTree.root);
        System.out.println(binaryTree.maxDiameter);
    }

    class Node{
        public int value;
        public Node left;
        public Node right;
        public boolean isLeaf = true;
        public int level=0;
        public Node parent;

        Node(int value, Node left, Node right, Node parent){
            this.value = value;
            this.left = left;
            this.right = right;
            if(parent!=null){
                this.parent = parent;
                this.level = parent.level + 1;
            }
        }
    }
}