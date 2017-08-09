#include <iostream>

using namespace std;

class Queue{
    public:
    int m_size;
    int *m_A;
    int m_front, m_rear;

    Queue(int size){
        m_front = -1;
        m_rear = -1;
        m_size = size;
        m_A = new int[size];
    }

    void enqueue(int val){
        if(m_front == -1 && m_rear == -1){
            m_front = 0;
        }
        m_rear++;
        *(m_A+m_rear) = val;
    }

    int dequeue(){
        int item = *(m_A+m_front);
        if(m_front == m_rear){
            m_front = -1;
            m_rear = -1;
        }else{
            m_front++;
        }
        return item;
    }

    void traverse(){
        for(int i=m_front;i<m_rear;i++){
            cout<<*(m_A+i)<<"\t";
        }
        cout<<"\n";
    }

    bool isEmpty(){
        if(m_front == -1){
            return true;
        }
        return false;
        
    }
};

int main(){
    // Queue q(10);
    // q.enqueue(1);
    // q.enqueue(2);
    // q.enqueue(3);
    // q.traverse();
    // q.dequeue();
    // q.dequeue();
    // q.traverse();
    // q.dequeue();
    // cout<<q.isEmpty()<<"\n";

    int T;
    cin >> T;

    Queue q(T);

    for(int i=0;i<T;i++){
        char c;
        cin >> c;
        if(c == 'E'){
            int val;
            cin>>val;
            q.enqueue(val);
            cout<<q.m_rear - q.m_front + 1;
        }else{
            if(q.isEmpty()){
                cout<<"-1 0";
            }else{
                cout<<q.dequeue()<<" ";
                if(q.isEmpty()){
                    cout<<0;
                }else{
                    cout<<q.m_rear - q.m_front + 1;
                }
            }
        }

        cout<<"\n";
    }

    return 0;
}