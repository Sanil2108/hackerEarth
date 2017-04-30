import java.util.*;
class MultiDimensional{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int[][] A;
        int N=in.nextInt();
        int M=in.nextInt();
        A=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                A[i][j] = in.nextInt();
            }
        }
        int[][] C=new int[M][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                C[j][i]=A[i][j];
            }
        }
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
    }
}