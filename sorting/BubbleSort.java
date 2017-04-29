class BubbleSort{
    static int[] bubbleSort(int[] A){
        for(int i=1;i<A.length;i++){
            for(int j=i;j<A.length;j++){
                if(A[j-1] > A[j]){
                    int temp=A[j-1];
                    A[j-1]=A[j];
                    A[j]=temp;
                }
            }
        }
        return A;
    } 
    public static void main(String[] args){
        int[] A={
            1, 4, 2, 6, 5, 3
        };
        A=bubbleSort(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}