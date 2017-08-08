#include <iostream>
#include <cstdlib>

using namespace std;

long* A;
int n;

void randPartition(int start, int end){
    int randomPivotPos = start + rand()%(end-start);

    int temp=*(A+randomPivotPos);
    *(A+randomPivotPos) = *(A+start);
    *(A+start) = temp;
}

int partition(int start, int end, long pivot){

    randPartition(start, end);

    long* newA=new long[n];
    int k=start;
    int pivotPos;
    

    for(int i=0;i<start;i++){
        *(newA+i)=*(A+i);
    }

    for(int i=end;i<n;i++){
        *(newA+i)=*(A+i);
    }

    int t=end;  
    for(int i=start;i<end+1;i++){
        if(*(A+i)<pivot){
            *(newA+k)=*(A+i);
            k++;
        }else if(*(A+i)>pivot){
            *(newA+t)=*(A+i);
            t--;
        }
    }
    pivotPos=k;
    *(newA+k)=pivot;
    k++;

    int i=0;
    // while(k<end+1){
    //     if(*(A+i)>pivot){
    //         *(newA+k)=*(A+i);
    //         k++;
    //     }
    //     i++;
    // }
    A=newA;

    // free(A);

    return pivotPos;
}

void quickSort(int start, int end){
    if(end==start){
        return;
    }else{
        int pivot=*(A+start);
        int pivotPos=partition(start, end, pivot);
        quickSort(start, pivotPos);
        quickSort(pivotPos+1, end);
    }
}

int main(){
    cin>>n;
    A=new long[n];
    for(int i=0;i<n;i++){
        cin>>A[i];
    }
    quickSort(0, n-1);
    // partition(1, 3, *(A+2));
    for(int i=0;i<n;i++){
        cout<<*(A+i)<<" ";
    }
    return 0;
}