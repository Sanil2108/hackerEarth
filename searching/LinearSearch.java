import java.util.*;
class LinearSearch{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[] A=new int[N];
		for(int i=0;i<N;i++){
			A[i] = in.nextInt();
		}
		for(int i=A.length-1;i>=0;i--){
			if(A[i] == M){
				System.out.println(i+1);
				return;
			}
		}
		System.out.println("-1");
	}
}