#include <iostream>

using namespace std;

long counter;

long getNumberOfInversions(long* A, int n){
    long inversions=0;
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            if(*(A+j)<*(A+i)){
                inversions++;
            }
        }
    }
    return inversions;
}

long* sort(long* A, long m, long* B, long n){
    long i=0, j=0, k=0;
    long* C=new long[m+n];
    while(i<m && j<n){
        if(*(A+i)>*(B+j)){
            *(C+k)=*(B+j);
            j+=1;
            counter=counter+m-i;
        }else{
            *(C+k)=*(A+i);
            i+=1;
        }
        k++;
    }
    while(i<m){
        *(C+k)=*(A+i);
        i+=1;
        k++;
    }
    while(j<n){
        *(C+k)=*(B+j);
        j+=1;
        k++;
    }
    return C;
}

long* mergeSort(long* A, long start, long end){
    if(end-start<1){
        long* temp=new long[1];
        temp[0]=*(A+start);
        return temp;
    }else{
        long mid=(start+end)/2;
        return sort(mergeSort(A, start, mid), mid-start+1, mergeSort(A, mid+1, end), end-mid);
    }
}

int main(){
    counter=0;
    long n;
    cin>>n;
    long Arr[n];
    for(long i=0;i<n;i++){
        cin>>Arr[i];
    }
    // int Arr[]={
    //         1, 6, 3, 2, 7
    // };
    long* A=Arr;
    // cout<<getNumberOfInversions(A, n)<<"\n\n";
    A=mergeSort(A, 0, n);
    // for(int i=0;i<n;i++){
    //     cout<<*(A+i)<<"\t";
    // }
    cout<<counter;
    return 0;
}