import java.util.Scanner;

class Heap{

    static class Element{
        long id;
        long change;
        long newScore;

        @Override
        public String toString(){
            return id+" "+newScore;
        }

        public static Element bigger(Element e1, Element e2){
            if(e1 == null){
                return e2;
            }
            if(e2 == null){
                return e1;
            }
            if(e1.change > e2.change){
                return e1;
            }else if(e1.change < e2.change){
                return e2;
            }else{
                if(e1.id > e2.id){
                    return e1;
                }else{
                    return e2;
                }
            }
        }
    }

    Element[] A;
    int index;

    public Heap(Element[] original){
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

    // public void increaseSize(int n){
    //     long[] newA = new long[A.length + n];
    //     for(int i=0;i<A.length;i++){
    //         newA[i] = A[i];
    //     }
    //     A = newA;
    // }

    //     public long max(){
    //     return A[1];
    // }

    public Element delMax(){
        Element temp = A[1];
        bubbleDown(1);
        return temp;
    }

    // public void reduceTopValue(){
    //     A[1]--;
    //     max_heapify(1);
    // }

    public Element[] sort(){
        Element[] sorted = new Element[A.length - 1];
        for(int i=1;i<A.length;i++){
            sorted[i-1] = this.delMax();
        }
        return sorted;
    }

    public void bubbleDown(int index){
        int left = index * 2;
        int right = index * 2 + 1;
        int largest = left;

        if(left<A.length && right<A.length){
            largest = (Element.bigger(A[left], A[right]) == A[left])?left:right;
        }else if (left>=A.length && right>=A.length){
            A[index] = null;
            return;
        }else if(left>=A.length){
            largest = right;
        }else{
            largest = left;
        }

        Element temp = A[largest];
        A[largest] = A[index];
        A[index] = temp;

        bubbleDown(largest);

    }

    public void bubbleUp(int index){
        int parent = index/2;
        if(parent>0){
            if(Element.bigger(A[parent], A[index]) == A[index]){
                Element temp = A[parent];
                A[parent] = A[index];
                A[index] = temp;

                bubbleUp(parent);

                max_heapify(parent);
            }
        }
    }

    // public void addToHeap(long a){
    //     A[index] = a;
    //     bubbleUp(index);
    //     index++;
    // }


    public void max_heapify(int index){
        Element temp;

        int left = index * 2;
        int right = index * 2 + 1;

        int largest = index;

        if(left<A.length && right<A.length){
            largest = (Element.bigger(A[left], A[right]) == A[left])?left:right;
            if(Element.bigger(A[largest], A[index]) == A[index]){
                return;
            }
        }else if (left>=A.length && right>=A.length){
            return;
        }else if(left>=A.length){
            if(Element.bigger(A[right], A[index]) == A[right]){
                largest = right;
            }else{
                return;
            }
        }else{
            if(Element.bigger(A[left], A[index]) == A[left]){
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
        int T = scanner.nextInt();

        Element[] elements = new Element[T+1];
        int elementIndex = 1;
        for(int i=0;i<T;i++){
            long postId = scanner.nextLong();
            long initPoints = scanner.nextLong();
            long posts = scanner.nextLong();
            long like = scanner.nextLong();
            long comment = scanner.nextLong();
            long share = scanner.nextLong();

            long newPoints = posts*50 + like*5 + comment*10 + share*20;
            Element e = new Element();
            e.change = newPoints - initPoints;
            e.id = postId;
            e.newScore = newPoints;

            elements[elementIndex] = e;
            elementIndex++;
        }

        Heap h = new Heap(elements);
        Element[] sorted = h.sort();
        for(int i=0;i<((sorted.length>5)?5:sorted.length);i++){
            System.out.println(sorted[i]);
        }
    }
}