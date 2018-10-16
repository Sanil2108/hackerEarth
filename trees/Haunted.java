import java.util.*;

class Heap{
    static class Ghost{
        int age;
        int titlesWon;

        public Ghost(int age, int titlesWon){
            this.age=age;
            this.titlesWon=titlesWon;
        }

        public static Ghost biggerGhost(Ghost a, Ghost b){
            if(a.titlesWon>b.titlesWon){
                return a;
            }else if(a.titlesWon<b.titlesWon){
                return b;
            }else{
                if(a.age>b.age){
                    return a;
                }else{
                    return b;
                }
            }
        }
    }

    Ghost[] ghosts;
    int index;

    public Heap(int size){
        ghosts = new Ghost[size+1];
        index = 1;

        initGhosts();
        makeHeap();
    }

    public void initGhosts(){
        index = ghosts.length+1;
        for(int i=1;i<ghosts.length;i++){
            ghosts[i] = new Ghost(i, 0);
        }
    }

    public void makeHeap(){
        for(int i=ghosts.length/2;i>0;i--){
            maxHeapify(i);
        }
    }

    public void add(Ghost g){
        ghosts[index] = g;
        bubbleUp(index);
        index++;
    }

    public int find(int age){
        for(int i=1;i<ghosts.length;i++){
            if(ghosts[i].age == age){
                return i;
            }
        }
        return -1;
    }

    public void increaseTitlesWon(int age){
        int index = this.find(age);
        Ghost g = ghosts[index];
        g.titlesWon++;

        bubbleUp(index);
    }

    public void bubbleUp(int index){
        int parent = index/2;
        if(parent<=0){
            return;
        }
        if(Ghost.biggerGhost(ghosts[index], ghosts[parent]) == ghosts[index]){
            Ghost temp = ghosts[parent];
            ghosts[parent] = ghosts[index];
            ghosts[index] = temp;
            bubbleUp(parent);
        }else{
            maxHeapify(index);
        }
    }

    public void maxHeapify(int index){
        int left = index * 2;
        int right = index * 2 + 1;

        int largest = 0;
        if(left<ghosts.length && right<ghosts.length){
            if(Ghost.biggerGhost(ghosts[left], ghosts[right]) == ghosts[left]){
                if(Ghost.biggerGhost(ghosts[index], ghosts[left]) == ghosts[index]){
                    return;
                }else{
                    largest = left;
                }
            }else{
                if(Ghost.biggerGhost(ghosts[index], ghosts[right]) == ghosts[index]){
                    return;
                }else{
                    largest = right;
                }
            }
        }else if(left>=ghosts.length && right<ghosts.length){
            if(Ghost.biggerGhost(ghosts[index], ghosts[right]) == ghosts[right]){
                largest = right;
            }else{
                return;
            }
        }else if(right>=ghosts.length && left<ghosts.length){
            if(Ghost.biggerGhost(ghosts[index], ghosts[left]) == ghosts[left]){
                largest = left;
            }else{
                return;
            }
        }else{
            return;
        }

        Ghost temp=ghosts[index];
        ghosts[index] = ghosts[largest];
        ghosts[largest] = temp;

        maxHeapify(largest);

        return;
    }

    public Ghost max(){
        return ghosts[1];
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long M = s.nextInt();

        Heap h = new Heap(M);

        for(int i = 0;i<N;i++){
            int ghost = s.nextInt();
            h.increaseTitlesWon(ghost);

            Ghost max = h.max();
            System.out.print(max.age + " " + max.titlesWon + "\n");
        }
    }
}