#include <iostream>

using namespace std;

int* countSort(int* A, int n){

    // int max=1000000;

    int max=*(A);
    for(int i=1;i<n;i++){
        if(max<*(A+i)){
            max=*(A+i);
        }
    }
    max++;

    int* Arr=new int[max];
    for(int i=0;i<max;i++){
        *(Arr+i)=0;
    }


    for(int i=0;i<n;i++){
        *(Arr+*(A+i))+=1;
    }

    //This does the regular count sort, though, now i am modifying this loop for the problem
    // int k=0;
    // for(int i=0;i<max;i++){
    //     if(*(Arr+i)!=0){
    //         *(A+k)=i;
    //         k++;
    //         *(Arr+i)-=1;
    //         i--;
    //         continue;
    //     }
    // }


    //For the problem
    // cout<<*(Arr+5);
    for(int i=0;i<max;i++){
        if(*(Arr+i)!=0){
            cout<<i<<" "<<*(Arr+i)<<"\n";
            *(Arr+i)=0;
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
    int *A=Arr;
    A = countSort(A, n);
    // for(int i=0;i<n;i++){
    //     cout<<*(A+i)<<" ";
    // }
    return 0;
}