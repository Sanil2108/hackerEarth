class MergeSort{
    static int[] mergeSort(int[] A, int start, int end){
        if(end-start==1){
            int[] C={
                A[start]
            };
            return C;
        }else{
            int mid=(start+end)/2;
            return merge(mergeSort(A, start, mid), mergeSort(A, mid, end));
        }
    }
    static int[] merge(int[] A, int[] B){
        int i=0, j=0, k=0;
        int[] C=new int[A.length+B.length];
        while(i<A.length && j<B.length){
            if(A[i]<B[j]){
                C[k]=A[i];
                i++;
            }else{
                C[k]=B[j];
                j++;
            }
            k++;
        }

        while(i<A.length){
            C[k]=A[i];
            i++;
            k++;
        }

        while(j<B.length){
            C[k]=B[j];
            j++;
            k++;
        }

        return C;
    }
    public static void main(String[] args){
        int[] A={
            1, 10, 9, 6, 5, 3
        };
        A=mergeSort(A, 0, A.length);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}