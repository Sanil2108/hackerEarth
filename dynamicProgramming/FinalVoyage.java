import java.util.*;
class Solution1{
    static int max(int ... args){
        int max=args[0];
        for(int i=1;i<args.length;i++){
            if(max<args[i]){
                max=args[i];
            }
        }
        return max;
    }
    public static void main(String[] args){
        int T;
        Scanner in=new Scanner(System.in);
        T=in.nextInt();
        for(int i=0;i<T;i++){
            int N=in.nextInt();
            int L=in.nextInt();
            int[] weights=new int[N];
            int[] values=new int[N];
            int[][] A=new int[L+1][N+1];
            for(int i2=0;i2<N;i2++){
                weights[i2]=in.nextInt();
            }
            for(int i2=0;i2<N;i2++){
                values[i2]=in.nextInt();
            }
            for(int i2=1;i2<=L;i2++){
                for(int j=1;j<=N;j++){
                    // if(i2==1){
                    //     values[j-1]=in.nextInt();
                    // }
                    if(i2-weights[j-1]>=0){
                        A[i2][j]=max(
                            A[i2-weights[j-1]][j-1]+values[j-1], A[i2-1][j], A[i2][j-1]
                        );
                    }else{
                        A[i2][j]=max(
                            A[i2-1][j], A[i2][j-1]
                        );
                    }
                }
            }

            System.out.println(A[L][N]);
        }
    }
}