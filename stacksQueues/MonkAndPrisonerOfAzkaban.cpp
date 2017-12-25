#include <iostream>

using namespace std;

class Queue{
    public:
    int m_size;
    int * m_A;

    int front;
    int rear;

    Queue(int size){
        m_size = size;
        m_A = new int[size];

        front = -1;
        rear = -1;
    }

    void enqueue(int val){
        if(front == -1){
            front = 0;
        }
        rear++;
        m_A[rear] = val;
    }

    int dequeue(){
        int item = m_A[front];
        front++;
        if(front > rear){
            front = -1;
            rear = -1;
        }
        return item;
    }

    int size(){
        return rear - front + 1;
    }

    void traverse(){
        for(int i=front;i<=rear;i++){
            cout<<m_A[i]<<"\t";
        }
        cout<<"\n";
    }

    void getXandY(int i){
        int x=-1;
        int y=-1;

        int xi=i-1;
        int yi=i+1;

        bool xFound=false;
        bool yFound=false;

        while((!xFound || !yFound) || (xi>=0 && yi<rear-front+1)){
            if(!xFound){
                if(m_A[xi]>m_A[i]){
                    xFound = 1;
                }else{
                    xi--;
                }
            }
            if(!yFound){
                if(m_A[yi]>m_A[i]){
                    yFound=1;
                }else{
                    yi++;
                }
            }
        }

        cout<<xi<<" "<<yi;
    }

    int getX(int i){
        for(int j=i-1;j>=0;j--){
            if(m_A[j]>m_A[i]){
                return j+1;
            }
        }
        return -1;
    }

    int getY(int i){
        for(int j=i+1;j<rear-front+1;j++){
            if(m_A[j]>m_A[i]){
                return j+1;
            }
        }
        return -1;
    }

};

int main(){
    int N;
    cin >> N;

    Queue q(N);

    for(int i=0;i<N;i++){
        int temp;
        cin >> temp;
        q.enqueue(temp);
    }

    for(int i=0;i<N;i++){
        q.getXandY(i);
        cout<<"\n";
    }

    // for(int i=0;i<N;i++){
    //     int x = q.getX(i);
    //     int y = q.getY(i);
    //     cout<<x+y<<" ";
    // }
}