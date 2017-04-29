import java.util.Random;
class QuickSort{
    Random random=new Random();
    static int[] split(int[] A, int partition){
        int[] C=new int[A.length];
        int partitionN=A[partition];
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<A[partition]){
                count++;
            }
        }
        C[count]=A[partition];
        int i=0;
        int j=count+1;
        for(int k=0;k<A.length;k++){
            if(k!=partition) {
                if (A[k] < A[partition]) {
                    C[i] = A[k];
                    i++;
                } else {
                    C[j] = A[k];
                    j++;
                }
            }
        }
        return C;
    }
    static int[] quickSort(int[] A, int start, int end){
        if(end-start==1){
            int[] C={
                A[start]
            };
            return C;
        }else{
            // int pivot=random.nextInt(end)+start;
            // return quickSort(

            // );
        }
        return A;
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
        // A=quickSort(A, 0, A.length);
        A=split(A, 3);
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
    }
}