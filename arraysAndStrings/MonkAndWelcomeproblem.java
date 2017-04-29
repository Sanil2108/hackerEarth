import java.util.*;

class MonkAndWelcomeproblem {
    public static void main(String[] args ) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] A=new int[N];
        int[] B=new int[N];
        int[] C=new int[N];
        for(int i=0;i<N;i++){
            A[i]=scanner.nextInt();
        }
        for(int i=0;i<N;i++){
            B[i]=scanner.nextInt();
            C[i]=A[i]+B[i];
            System.out.print(C[i]+" ");
        }
    }
}
