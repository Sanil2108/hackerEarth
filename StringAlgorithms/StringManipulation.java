import java.util.*;
class Solution{
    public static String sort(char[] init, int n, int m){
        int[] A=new int[127];
        for(int i=n;i<=m;i++){
            A[(int)init[i]]++;
        }
        int k=n;
        for(int i=126;i>=0;){
            if(A[i]!=0){
                A[i]--;
                init[k]=(char)i;
                k++;
            }else{
                i--;
            }
        }
        return new String(init);
        // return null;
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            String temp=in.next();
            int N=in.nextInt();
            int M=in.nextInt();
            System.out.println(sort(temp.toCharArray(), N, M));
        }
    }
}