import java.util.Scanner;
class ArrayInversions{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for(int i=0;i<T;i++){
            int N=in.nextInt();
            int counter=0;
            int[][] A=new int[N][N];
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    A[k][j]=in.nextInt();
                }
            }

            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    boolean currentInverted=false;
                    int current=A[k][j];
                    for(int l=k;l>=0;l--){
                        if(A[l][j]>A[k][j]){
                            currentInverted=true;
                            counter++;
                            break;
                        }
                    }
                    if(!currentInverted){
                        for(int l=j;l>=0;l--){
                            if(A[k][l]>A[k][j]){
                                currentInverted=true;
                                counter++;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(counter);
        }
    }
}