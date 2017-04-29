import java.util.Scanner;
class ModuloBasedSorting{
    public static void main(String[] args){
        int N;
        int k;
        Scanner in=new Scanner(System.in);
        N=in.nextInt();
        k=in.nextInt();
        int[] arr=new int[N];
        int[][][] sorted=new int[k][2][];
        for(int i=0;i<N;i++){
            arr[i]=in.nextInt();
            sorted[arr[i]%k][0]++;
            sorted[arr[i]%k][1]++;
        }
        int i=0;
        while(i<sorted.length){
            if(sorted[i]>0){
                System.out.print(+" ");
                sorted[i]--;
            }else{
                i++;
            }
        }
    }
}