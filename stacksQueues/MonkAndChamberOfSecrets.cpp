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

    int* dequeue(int n){
        int* removed = new int[n];
        for(int i=front;i<front+n;i++){
            removed[i-front] = m_A[front+i];
        }
        front += n;
        if(front >= rear){
            front = -1;
            rear = -1;
        }
        return removed;
    }

};

int main(){
    int N, X;
    cin >> N;
    cin >> X;
    Queue queue(N);
    for(int i=0;i<N;i++){
        
    }
    return 0;
}