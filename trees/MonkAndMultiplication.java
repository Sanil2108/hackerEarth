import java.util.Scanner;

class Heap{
    long[] A;
    int index;

    public Heap(int size){
        this.A = new long[size+1];
        index = 1;
    }

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
            if(A[right]>A[index]){
                largest = right;
            }else{
                return;
            }
        }else{
            if(A[leftq]>A[index]){
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
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        Heap h=new Heap(n);

        for(int i=0;i<n;i++){
            h.addToHeap(in.nextLong());
            if(h.index < 4){
                System.out.println(-1);
            }else{
                int lengthToTraverse = (h.index < 8)?h.A.length:8;
                long max1 = -1;
                long max2 = -1;
                for(int j=2;j<lengthToTraverse;j++){
                    if(h.A[j]>max1){
                        if(max1 > max2){
                            max2 = max1;
                        }
                        max1 = h.A[j];
                    }else if(h.A[j]>max2){
                        max2 = h.A[j];
                    }
                }
                System.out.println(h.A[1] * max1 * max2);
            }
        }
    }
}