import java.util.*;
class Solution{
    static ArrayList<Long> factorials;
    static void calculateFactorials(int n){
        for(int i=factorials.size();i<=n;i++){
            factorials.add(i, (long)((i*factorials.get(i-1))%(Math.pow(10, 9)+7)));
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        factorials=new ArrayList<>();
        factorials.add(0,1L);
        factorials.add(1,1L);
        long T=in.nextLong();
        for(long i=0;i<T;i++){
            int temp=in.nextInt();
            if(temp>=factorials.size()){
                calculateFactorials(temp);
            }
            System.out.println(factorials.get(temp));
        }
    }
}