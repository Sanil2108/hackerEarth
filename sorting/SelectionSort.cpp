#include <iostream>

using namespace std;

int * selectionSort(int * A, int n, int x){
    for(int i=0;i<x;i++){
        int min=i;
        for(int j=i+1;j<n;j++){
            if(*(A+min)>*(A+j)){
                min=j;
            }
        }
        int temp=*(A+min);
        *(A+min)=*(A+i);
        *(A+i)=temp;
    }
    return A;
}

int main(){
    int n, x;
    cin>>n>>x;
    int Arr[n];
    for(int i=0;i<n;i++){
        cin>>Arr[i];
    }
    int * A=Arr;
    A=selectionSort(A, n, x);
    for(int i=0;i<n;i++){
        cout<<A[i]<<" ";
    }
    return 0;
}