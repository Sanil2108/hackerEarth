#include<iostream>

using namespace std;

int * insertionSort(int * A, int n){
    for(int i=1;i<n;i++){
        for(int j=i-1;j>=0;j--){
            if(A[j]>A[i]){
                int temp=A[j];
                A[j]=A[i];
                A[i]=temp;
                i-=1;
            }
        }
    }
    return A;
}

int main(){
    int n;
    cin>>n;
    int Arr[n];
    for(int i=0;i<n;i++){
        cin>>Arr[i];
    }
    int *A=new int[n];
    for(int i=0;i<n;i++){
        *(A+i)=Arr[i];
    }
    A = insertionSort(A, n);

    int* finalArr=new int[n];

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(*(A+j)==Arr[i]){
                finalArr[i]=j+1;
                break;
            }
        }
    }

//    for(int i=0;i<n;i++){
//        cout<<*(A+i) <<" ";
//    }

    for(int i=0;i<n;i++){
        cout<<*(finalArr+i)<<" ";
    }

    return 0;
}