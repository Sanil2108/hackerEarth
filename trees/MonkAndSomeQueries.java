import java.util.*;

public class MonkAndSomeQueries{
    static class MaxHeap{
        int[] elements;
        int index;
        int size;

        public MaxHeap(int size){
            elements = new int[size+1];
            index = 1;
            size = 0;
        }

        public void bubbleUp(int i){
            int parent = i/2;
            if(parent<=0){
                return;
            }
            if(elements[parent]<elements[i]){
                int temp = elements[parent];
                elements[parent] = elements[i];
                elements[i] = temp;
                bubbleUp(parent);
            }else{
                maxHeapify(i);
            }
        }

        public int find(int e){
            for(int i=1;i<elements.length;i++){
                if(elements[i] == e){
                    return i;
                }
            }
            return -1;
        }

        public int delete(int e){
            int index = find(e);
            if(index == -1){
                return -1;
            }
            elements[index] = -1;
            bubbleDown(index);
            return index;
        }

        public void maxHeapify(int i){
            int left = i*2;
            int right = i*2 + 1;

            int largest;

            if(left<=size && right<=size){
                largest = (elements[left]>elements[right])?left:right;
            }else if(left>size && right<=size){
                largest = right;
            }else if(right>size && left<=size){
                largest = left;
            }else{
                largest = i;
            }

            if(elements[largest]>elements[i]){
                int temp = elements[largest];
                elements[largest] = elements[i];
                elements[i] = temp;
            }
        }

        public void bubbleDown(int i){
            int left = i*2;
            int right = i*2 + 1;

            int largest;

            if(left<=size && right<=size){
                largest = (elements[left]>elements[right])?left:right;
            }else if(left>size && right<=size){
                largest = right;
            }else if(right>size && left<=size){
                largest = left;
            }else{
                elements[i] = -1;
                return;
            }

            int temp = elements[largest];
            elements[largest] = elements[i];
            elements[i] = temp;
        }

        public void addElement(int e){
            elements[index] = e;
            bubbleUp(index);
            index++;
            size++;
        }

        public void print(){
            System.out.println();
            for(int i=1;i<elements.length;i++){
                System.out.print(elements[i]+"\t");
            }
            System.out.println();
        }

    }

    static class MinHeap{

        int[] elements;
        int index;
        int size;

        public MinHeap(int size){
            elements = new int[size+1];
            index = 1;
            size = 0;
        }

        public void bubbleUp(int i){
            int parent = i/2;
            if(parent<=0){
                return;
            }
            if(elements[parent]>elements[i]){
                int temp = elements[parent];
                elements[parent] = elements[i];
                elements[i] = temp;
                bubbleUp(parent);
            }else{
                minHeapify(i);
            }
        }

        public int find(int e){
            for(int i=1;i<elements.length;i++){
                if(elements[i] == e){
                    return i;
                }
            }
            return -1;
        }

        public int delete(int e){
            int index = find(e);
            if(index == -1){
                return -1;
            }
            elements[index] = 1000000;
            bubbleDown(index);
            return index;
        }

        public void minHeapify(int i){
            int left = i*2;
            int right = i*2 + 1;

            int smallest;

            if(left<=size && right<=size){
                smallest = (elements[left]>elements[right])?right:left;
            }else if(left>size && right<=size){
                smallest = right;
            }else if(right>size && left<=size){
                smallest = left;
            }else{
                smallest = i;
            }

            if(elements[smallest]>elements[i]){
                int temp = elements[smallest];
                elements[smallest] = elements[i];
                elements[i] = temp;
            }
        }

        public void bubbleDown(int i){
            int left = i*2;
            int right = i*2 + 1;

            int smallest;

            if(left<=size && right<=size){
                smallest = (elements[left]>elements[right])?right:left;
            }else if(left>size && right<=size){
                smallest = right;
            }else if(right>size && left<=size){
                smallest = left;
            }else{
                elements[i] = 1000000;
                return;
            }

            int temp = elements[smallest];
            elements[smallest] = elements[i];
            elements[i] = temp;
        }

        public void addElement(int e){
            elements[index] = e;
            bubbleUp(index);
            index++;
            size++;
        }

        public void print(){
            System.out.println();
            for(int i=1;i<elements.length;i++){
                System.out.print(elements[i]+"\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int Q=in.nextInt();
        MinHeap minHeap = new MinHeap(Q);
        MaxHeap maxHeap = new MaxHeap(Q);
        for(int i=0;i<Q;i++){
            int T = in.nextInt();
            if(T==1){
                int X = in.nextInt();
                minHeap.addElement(X);
                maxHeap.addElement(X);
            }else if(T==2){
                int X = in.nextInt();
                int temp = minHeap.delete(X);
                if(temp==-1){
                    System.out.println(-1);
                    continue;
                }
                maxHeap.delete(X);
            }else if(T==3){
                System.out.println(maxHeap.elements[1]);
            }else if(T==4){
                System.out.println(minHeap.elements[1]);
            }
        }
    }
}