import java.util.Scanner;
class MonkAndRotations{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int j=0;j<T;j++){
            int N=in.nextInt();
            int S=in.nextInt();
            long[] A=new long[N];
            for(int i=0;i<N;i++){
                A[i]=in.nextLong();
            }
            swap(A, S);
            System.out.println();
        }
    }
    public static void swap(long[] A, long count){
        long temp2; long temp;
        for(int i=0;i<A.length;i++){
            temp=(i+count*(A.length-1))%A.length;
            System.out.print(A[(int)temp]+" ");
        }
    }
    public static int[] swap(int[] A){
        int temp=A[A.length-1];
        for(int i=A.length-1;i>=1;i--){
            A[i]=A[i-1];
        }
        A[0]=temp;
        return A;
    }
}