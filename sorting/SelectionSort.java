class SelectionSort{
    static int[] selectionSort(int[] A){
        for(int i=0;i<A.length;i++){
            int smallest = i;
            for(int j=i;j<A.length;j++){
                if(A[j]<A[i]){
                    smallest=j;
                }
            }
            int temp=A[i];
            A[i]=A[smallest];
            A[smallest]=temp;
        }
        return A;
    }
    public static void main(String[] args){
        int[] A={
            1, 10, 9, 6, 5, 3
        };
        A=selectionSort(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}