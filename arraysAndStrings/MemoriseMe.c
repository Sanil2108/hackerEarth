#include <stdio.h>

int main() {
    int i, temp, size;
    int arr[100000];
    
    scanf("%d", &size);
    
    for (i = 0; i < size; i ++){
        scanf("%d", &temp);
        arr[temp]++;
    }
   
    scanf("%d", &size);
    
   for (i = 0; i < size; i ++){
        scanf("%d", &temp);
        if (arr[temp]==0) {
            printf("NOT PRESENT\n");
        }
        else {
            printf("%d\n", arr[temp]);
        }
        
    }
}