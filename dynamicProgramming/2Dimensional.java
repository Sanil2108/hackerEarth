import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] originalMatrix=new int[n][m];
        int[][] A=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                originalMatrix[i][j]=in.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    A[i][j]=originalMatrix[i][j];
                }
                if(i!=0 && j!=0){
                    A[i][j]=A[i-1][j]+A[i][j-1]+originalMatrix[i][j]-A[i-1][j-1];
                }
                if(i==0 && j!=0){
                    A[i][j]=A[i][j-1]+originalMatrix[i][j];
                }
                if(i!=0 && j==0){
                    A[i][j]=A[i-1][j]+originalMatrix[i][j];
                }
                // System.out.print(A[i][j]+"\t");
            }
            // System.out.println();
        }
        
        int Q=in.nextInt();
        for(int i=0;i<Q;i++){
            int X=in.nextInt();
            int Y=in.nextInt();
            System.out.println(A[X-1][Y-1]);
        }
    }
}