class InsertionSort{
    static int[] insertionSort(int[] A){
        for(int i=1; i<A.length; i++){
            for(int j=i; j>=0; j--){
                if(A[j]>A[i]){
                    int temp=A[j];
                    A[j]=A[i];
                    A[i]=temp;
                    i--;
                }
            }
        }
        return A;
    }
    public static void main(String[] args){
        int[] A={
            1, 10, 9, 6, 5, 3
        };
        A=insertionSort(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}