import jdk.nashorn.internal.runtime.regexp.joni.Warnings;

import java.util.Scanner;

class PriorityQueue{
    long[] A;
    int index;
    int size;

    public PriorityQueue(int size){
        this.A = new long[size+1];
        index = 1;
        this.size = 0;
    }

    public PriorityQueue(long[] original){
        this.A = original;
        int temp = original.length/2;
        if (temp%2!=0){
            temp++;
        }
        for(int i=temp;i>0;i--) {
            max_heapify(i);
        }
        index = A.length;
        size = A.length - 1;
    }

    public long max(){
        return A[1];
    }

    public long delMax(){
        long temp = A[1];
        bubbleDown(1);
        size--;
        return temp;
    }

    public void reduceTopValue(){
        A[1]--;
        max_heapify(1);
    }

    public void bubbleDown(int index){
        int left = index * 2;
        int right = index * 2 + 1;
        int largest = left;

        if(left<A.length && right<A.length){
            largest = (A[left]>A[right])?left:right;
        }else if (left>=A.length && right>=A.length){
            A[index] = -1;
            return;
        }else if(left>=A.length){
            largest = right;
        }else{
            largest = left;
        }

        long temp = A[largest];
        A[largest] = A[index];
        A[index] = temp;

        bubbleDown(largest);

    }

    public void increaseSize(int n){
        long[] newA = new long[A.length + n];
        for(int i=0;i<A.length;i++){
            newA[i] = A[i];
        }
        A = newA;
        size = newA.length - 1;
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

    public void checkHeap(){
        int temp = A.length/2;
        if (temp%2!=0){
            temp++;
        }
        for(int i=A.length - 1;i>0;i--) {
            max_heapify(i);
        }
    }

    public boolean checkHeap2(){
        long max=0;
        int maxIndex = 0;
        for(int i =1;i<A.length;i++){
            if(A[i]>max) {
                maxIndex = i;
                max = A[i];
            }
        }
        return max==A[1];
    }

    public void addToHeap(long a){
        A[index] = a;
        bubbleUp(index);
        size += 1;
        index++;
    }

    public void print(){
        for(int i = 1;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
        System.out.println();
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
            if(A[left]>A[index]){
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
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        long[] A = new long[m+1];
        A[0] = 0;
        for(int i=1;i<=m;i++){
            A[i] = scanner.nextLong();
        }
        PriorityQueue p = new PriorityQueue(A);
        long total = 0;
        for(int i=0;i<n;i++){
            total += p.max();
            p.reduceTopValue();

        }
        System.out.println(total);
    }
}