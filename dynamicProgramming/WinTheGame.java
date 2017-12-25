import java.util.*;
class Solution{
    public static float getWinProbability(int r, int g){
        float[] P=new float[g+2];
        float[] A=new float[g+2];
        A[1]=1;
        P[1]=r/(r+(float)g);
        for(int i=2;i<=g+1;i++){
            float temp=r/(float)(r+g-(i-2));
            float temp2=r/(float)(r+g-(i-1));
            A[i]=A[i-1]*(1-temp);
            P[i]=A[i]*temp2;
        }
        
        float total=0;
        for(int i=1;i<P.length;i+=2){
            // System.out.println(P[i]+"\t");
            total+=P[i];
        }
        // System.out.println("total = "+total+"\n");

        return total;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int r=in.nextInt();
            int g=in.nextInt();
            if(r<=0){
                System.out.println("1.000000");
                continue;
            }
            System.out.println(String.format("%.6f", getWinProbability(r, g)));
        }
    }
}