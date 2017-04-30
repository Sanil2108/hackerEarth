#include <stdio.h>
#include <stdlib.h>

void swap(char * A, int ALength, long count){
    long temp2, temp;
    int i=0;
    for(i=0;i<ALength;i++){
        temp=(i+count*(ALength-1))%ALength;
        printf("%d", *(A+int(temp)));
    }
}

void main(){
    int T;int j;int N, S;

    scanf("%d", &T);
    for(j=0;j<T;j++){
        scanf("%d", &N);
        scanf("%d", &S);
    }
}