//Problem :
//Let us say that you are given a number N, minimum steps to write it as the sum of 1, 3 and 4.
class Solution{
    public static int min(int... vals){
        int min=vals[0];
        for(int i=1;i<vals.length;i++){
            if(vals[i]<=0){
                continue;
            }
            if(min>vals[i]){
                min=vals[i];
            }
        }
        return min;
    }
    public static void main(String[] args){
        int[] numbers={1,3};
        int n=10;
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            int temp[]=new int[numbers.length];
            for(int j=0;j<numbers.length;j++){
                if(i-numbers[j]<0){
                    continue;
                }
                temp[j]=A[i-numbers[j]]+1;
            }
            A[i]=min(temp);
        }

        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+"\t");
        }
        System.out.println();
    }
}