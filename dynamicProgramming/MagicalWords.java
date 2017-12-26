import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int k=0;k<T;k++){
            String temp=in.next();
            char[] charArray=temp.toCharArray();
            int[][] A=new int[temp.length()][temp.length()];
            long total=0;
            for(int i=0;i<temp.length();i++){
                A[i][i]=1;
                total+=1;
                if(i<temp.length()-1){
                    A[i][i+1]=(charArray[i]==charArray[i+1])?2:0;
                    if(charArray[i]==charArray[i+1])
                        total+=4;
                }
            }
            for(int i=2;i<charArray.length;i++){
                for(int j=0;j<temp.length()-i;j++){
                    A[j][i+j]=(charArray[j]==charArray[i+j]&&A[j+1][i+j-1]!=0)?A[j+1][i+j-1]+2:0;
                    total+=A[j][i+j]*A[j][i+j];
                }
            }

            // for(int i=0;i<charArray.length;i++){
            //     for(int j=0;j<charArray.length;j++){
            //         System.out.print(A[i][j]+"\t");
            //     }
            //     System.out.println();
            // }

            System.out.println(total);
        }
    }
}