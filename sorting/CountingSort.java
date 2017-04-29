class CountingSort{
    static int[] countingSort(int[] A){
        int max=A[0];
        for(int i=0;i<A.length;i++){
            if(max<A[i]){
                max=A[i];
            }
        }
        int[] aux=new int[max+1];
        for(int i=0;i<A.length;i++){
            aux[A[i]]++;
        }
        int[] C=new int[A.length];
        int j=0;
        for(int i=0;i<aux.length;i++){
            if(aux[i]!=0){
                C[j]=i;
                j++;
            }
        }
        return C;
    }
    public static void main(String[] args){
        int[] A={
            1, 10, 9, 6, 5, 3
        };
        A=countingSort(A);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}