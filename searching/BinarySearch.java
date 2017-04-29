import java.util.*;
class BinarySearch{

	public static int binarySearchAsc(int[] A, int target, int start, int end){
		int mid=(start+end)/2;
		if(A[mid] == target){
			return mid;
		}else{
			if(A[mid]>target){
				return binarySearchAsc(A, target, start, mid);
			}else{
				return binarySearchAsc(A, target, mid, end);
			}
		}
	}

	public static int binarySearchDesc(int[] A, int target, int start, int end){
		int mid=(start+end)/2;
		if(A[mid] == target){
			return mid;
		}else{
			if(A[mid]<target){
				return binarySearchDesc(A, target, start, mid);
			}else{
				return binarySearchDesc(A, target, mid, end);
			}
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] A=new int[N];
		for(int i=0;i<N;i++){
			A[i]=in.nextInt();
		}
		int q=in.nextInt();
		if(A[1]>A[0]){
			for(int i=0;i<q;i++){
				int temp=in.nextInt();
				System.out.println(binarySearchAsc(A, temp, 0, A.length)+1);
			}
		}else{
			for(int i=0;i<q;i++){
				int temp=in.nextInt();
				System.out.println(N-binarySearchDesc(A, temp, 0, A.length));
			}
		}
	}
}