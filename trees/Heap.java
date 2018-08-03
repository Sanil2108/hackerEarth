import java.util.Scanner;

public class Heap{
    long[] A;
    int index;

    public Heap(long[] original){
        this.A = original;
        int temp = original.length/2;
        if (temp%2!=0){
            temp++;
        }
        for(int i=temp;i>0;i--) {
            max_heapify(i);
        }
        index = A.length;
    }

    public void increaseSize(int n){
        long[] newA = new long[A.length + n];
        for(int i=0;i<A.length;i++){
            newA[i] = A[i];
        }
        A = newA;
    }

    public void bubbleUp(int index){
        int parent = index/2;
        if(parent>0){
            if(A[parent]<A[index]){
                long temp = A[parent];
                A[parent] = A[index];
                A[index] = temp;

                bubbleUp(parent);

                max_heapify(parent);
            }
        }
    }

    public void addToHeap(long a){
        A[index] = a;
        bubbleUp(index);
        index++;
    }


    public void max_heapify(int index){
        long temp;

        int left = index * 2;
        int right = index * 2 + 1;

        int largest = index;

        if(left<A.length && right<A.length){
            largest = (A[left]>A[right])?left:right;
            if(A[largest]<A[index]){
                return;
            }
        }else if (left>=A.length && right>=A.length){
            return;
        }else if(left>=A.length){
            if(A[largest]>A[index]){
                largest = right;
            }else{
                return;
            }
        }else{
            if(A[largest]>A[index]){
                largest = left;
            }else{
                return;
            }
        }

        temp = A[largest];
        A[largest] = A[index];
        A[index] = temp;

        max_heapify(largest);
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int initSize = scanner.nextInt();
        long[] arr = new long[initSize+1];
        for(int i=1;i<=initSize;i++){
            arr[i] = scanner.nextLong();
        }
        Heap h = new Heap(arr);
        int maxIncreaseSize = scanner.nextInt();
        h.increaseSize(maxIncreaseSize);
        for(int i=0;i<maxIncreaseSize;i++){
            int op=scanner.nextInt();
            if(op == 1){
                h.addToHeap(scanner.nextLong());
            }else {
                System.out.println(h.A[1]);
            }
        }


//
//        long[] arr = {0, 100, 90, 80, 60, 70, 50, 40, 65};
////        int[] arr = {0, 0, 2, 6, 10, 4, 7, 3};
//        Heap h = new Heap(arr);
//        h.increaseSize(1);
//        h.addToHeap(62);
//        System.out.println(h);
    }
}