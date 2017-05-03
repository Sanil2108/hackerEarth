#include <iostream>

using namespace std;

int  bubbleSort(int *A, int n){
    int counter=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i-1;j++){
            if(*(A+j)>*(A+j+1)){
                int temp=*(A+j+1);
                *(A+j+1)=*(A+j);
                *(A+j)=temp;
                counter+=1;
            }
        }
    }
    return counter;
}

int main(){
    int n;
    cin>>n;
    int Arr[n];
    for(int i=0;i<n;i++){
        cin>>Arr[i];
    }
    int *A=Arr;
    int counter = bubbleSort(A, n);
    cout<<counter;
    // for(int i=0;i<n;i++){
    //     cout<<A[i]<<"\t";
    // }
    return 0;
}