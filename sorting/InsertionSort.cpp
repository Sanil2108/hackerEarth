#include<iostream>

using namespace std;

int * insertionSort(int n){
    int A[n];
    int A2[n];
    for(int i=0;i<n;i++){
        cin>>A[i];
        A2[i]=A[i];
    }
//    int *finalArr=new int[n];
    int finalArr[n];

    for(int i=0;i<n;i++){
        finalArr[i]=i+1;
    }

     for(int i=0;i<n;i++){
         int pos=i;
         int tempI=i;
         for(int j=i-1;j>=0;j--){
             if(A[j]>A[i]){
                 int temp=A[j];
                 A[j]=A[i];
                 A[i]=temp;

                 pos=finalArr[j]-1;
//                 int temp2=finalArr[j];
//                 finalArr[j]=i;
//                 finalArr[i]=j;
//
                 i-=1;

             }

//             cout<<"\n";
//             for(int j=0;j<n;j++){
//                 cout<<A[j]<<"\t";
//             }
         }
         int temp=finalArr[tempI];
         finalArr[tempI]=finalArr[pos];
         finalArr[pos]=temp;
     }

    for(int i=0;i<n;i++){
        cout<<finalArr[i]<<" ";
    }

    return finalArr;
}

int main(){
    /*
    int Arr[]={5, 6, 1, 7, 3, 8};
    int n=sizeof(Arr)/sizeof(Arr[0]);
    */
    int n;
    cin>>n;
//    int Arr[n];
//    for(int i=0;i<n;i++){
//        cin>>Arr[i];
//    }
//    int *A=Arr;
    insertionSort(n);
//    for(int i=0;i<n;i++){
//        cout<<*(A+i)<<" ";
//    }
    return 0;
}