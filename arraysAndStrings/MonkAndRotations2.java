import java.util.Scanner;
import java.lang.*;
class MonkAndRotations2{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int j=0;j<T;j++){
            int N=in.nextInt();
            int S=in.nextInt();
            in.nextLine();
            StringBuilder builder=new StringBuilder(in.nextLine());
            String[] A=builder.toString().split("\\s");
            swap(A, S);
            System.out.println();
        }
    }
    public static void swap(String[] A, long count){
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