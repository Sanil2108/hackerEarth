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

};

class Stack{
    public:
    int top;
    int m_size;
    int * A;

    Stack(int size){
        m_size = size;
        A = new int[m_size];
        top = -1;
    }

    void push(int val){
        A[++top] = val;
    }

    int pop(){
        int item = A[top];
        top--;
        return item;
    }

    void traverse(){
        for(int i=0;i<=top;i++){
            cout<<A[i]<<"\t";
        }
        cout<<"\n";
    }

    int size(){
        return top+1;
    }

    int total(){
        int total = 0;
        for(int i=0;i<=top;i++){
            total+=A[i];
        }
        return total;
    }

};

int main(){
    int N;
    int * A;
    int Q, X;
    
    cin>>N;
    A = new int[N];

    Stack stack(N);
    Queue queue(N);

    for(int i=0;i<N;i++){
        cin>>A[i];
        queue.enqueue(A[i]);
    }
    cin >> Q;
    cin >> X;

    for(int i=0;i<Q;i++){
        string s;
        cin >> s;

        if(s == "Harry"){
            int temp = queue.dequeue();
            stack.push(temp);
        }else if (s == "Remove"){
            stack.pop();
        }

        if(stack.total() == X){
            cout<<stack.size();
            return 0;
        }
    }

    cout<<"-1";

    return 0;
}