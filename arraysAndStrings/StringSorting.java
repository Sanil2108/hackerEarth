import java.util.*;
class StringSorting{
    public static char[] insertionSort(char[] arr, int start, int end){
        for(int i=start+1;i<=end;i++){
            for(int j=i-1;j>=start;j--){
                if((int)arr[j] < (int)arr[i]){
                    char temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                    // System.out.println(new String(arr)+" "+i+" "+j);
                    i-=1;
                }
            }
        }
        return arr;
    }
    // public static char[] sort(char[] arr1, int start1, int end1, char[] arr2, int start2, int end2){
    //     int i=start1;
    //     int j=start2;
    //     char[] ans=new char[end1-start1+end2-start2];
    //     while(i<end1 && j<end2){
    //         if((int)arr1[i] > )
    //     }
    // }
    // public static char[] mergeSort(char[] arr, int start, int end){
    //     int mid=(start+end)/2;
    //     return arr;
    // }
    public static void main(String[] args){
        // Scanner in=new Scanner(System.in);
        // int T=in.nextInt();
        // for(int i=0;i<T;i++){
        //     String str=in.next();
        //     int a=in.nextInt();
        //     int b=in.nextInt();
        //     char[] arr=str.toCharArray();
        //     System.out.println(new String(insertionSort(arr, a, b)));
        // }
        System.out.println(new String(mergeSort("abcddcba".toCharArray(), 2, 6)));
    }
}