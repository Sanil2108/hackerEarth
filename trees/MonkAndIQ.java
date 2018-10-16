import java.util.*;

public class MonkAndIQ{
    static class MinHeap{

        int[] elements;
        int index;
        int size;
        int numberOfElements;

        public MinHeap(int size){
            elements = new int[size+1];
            index = 1;
            size = 0;
            numberOfElements = 0;
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

        public int find(int e, int i){
            if(e == elements[i]){
                return i;
            }
            if(e < elements[i]){
                return -1;
            }
            int left = i*2;
            int right = i*2 + 1;

            int leftResult = -1;
            int rightResult = -1;
            if(left<=size && right<=size){
                leftResult = find(e, left);
                rightResult = find(e, right);
            }else if(left<=size && right>size){
                leftResult = find(e, left);
            }else if(right<=size && left>size){
                rightResult = find(e, right);
            }else{
                return -1;
            }

            return (rightResult == -1)?leftResult:rightResult;
        }

        public int find(int e){
            boolean isEmpty=true;
            for(int i=1;i<elements.length;i++){
                if(elements[i] == e){
                    return i;
                }
                if(elements[i]>0){
                    isEmpty = false;
                }
            }
            if(isEmpty){
                return -1;
            }
            return -1;
        }

        public int delete(int e){
            if(numberOfElements == 0){
                return -1;
            }
            int index = find(e);
            if(index == -1){
                return -1;
            }
            elements[index] = 1000000;
            bubbleDown(index);
            numberOfElements --;
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
            numberOfElements++;
        }

        public void print(){
            System.out.println();
            for(int i=1;i<elements.length;i++){
                System.out.print(elements[i]+"\t");
            }
            System.out.println();
        }

        public int extractMin(){
            int temp = elements[1];
            elements[1] = 1000000;
            bubbleDown(1);
            return temp;
        }

    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int C = in.nextInt();
        int P = in.nextInt();
        int N = in.nextInt();
        for(int i=0;i<N;i++){
            
        }
    }
}