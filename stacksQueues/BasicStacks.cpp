#include <iostream>

using namespace std;

class Stack{
    public:
    int top;
    int* A;

    Stack(int size){
        top=-1;
        A = new int[size];
    }

    void push(int val){
        top++;
        *(A+top)=val;
    }

    int pop(){
        return *(A+top--);
    }

    void print(){
        int i=0;
        cout<<"top = "<<top<<"\n";
        for(;i<=top;i++){
            cout<<A[i]<<"\n";
        }
    }
};

int main(){

    int T;
    cin >> T;

    Stack stack(T);

    for(int i=0;i<T;i++){
        int type;
        cin >> type;
        if(type==1){
            if(stack.top == -1){
                cout<<"No Food";
            }else{
                cout<<stack.pop();
            }
        }else{
            int val;
            cin >> val;
            stack.push(val);
        }

        cout<<"\n";
    }

    return 0;
}