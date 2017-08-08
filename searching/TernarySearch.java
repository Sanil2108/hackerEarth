import java.util.*;
class TernarySearch{
	public static int ternarySearch(int[] A, int start, int end){
		int mid1 = (int)((start+end)/3f);
		int mid2 = (int)((start+end)*(2f/3));
		if(A[mid1] > A[mid1-1] && A[mid1] < A[mid1+1]){
			return mid1;
		}else if(A[mid2] > A[mid2-1] && A[mid2] < A[mid2+1]){
			return mid2;
		}else{
			int abs1 = A[abs(start-mid1)];
			int abs2 = A[abs(mid1-mid2)];
			int abs3 = A[abs(mid2-end)];
			if(abs1>abs2 && abs1 > abs3){
				return ternarySearch(A, start, mid1);
			}
			if(abs2>abs1 && abs2>abs3){
				return ternarySearch(A, mid1, mid2);
			}
			if(abs3>abs2 && abs3>abs1){
				return ternarySearch(A, mid2, end);
			}
			return -1;
		}
	}

	public static int abs(int a){
		if(a>=0){
			return a;
		}else{
			return -a;
		}
	}

	// public static int ternarySearch(int[] A, int target, int start, int end){
	// 	int mid1 = (int)((start+end)/3f);
	// 	int mid2 = (int)((start+end)*(2f/3));
	// 	if(A[mid1] == target){
	// 		return mid1;
	// 	}else if(A[mid2] == target){
	// 		return mid2;
	// 	}else{
	// 		if(target<A[mid1] && target>A[start]){
	// 			return ternarySearch(A, target, start, mid1);
	// 		}else if(target>A[mid1] && target<A[mid2]){
	// 			return ternarySearch(A, target, mid1, mid2);
	// 		}else{
	// 			return ternarySearch(A, target, mid2, end);
	// 		}
	// 	}
	// }
	public static int fun(int a){
		return 2*a*a - 12*a + 7;
	}
	public static int findingMeno(int a, int b){
			// int mid1 = (int)((a+b)/3f);
			// int mid2 = (int)((a+b)*(2/3f));

			// if(isLowest(mid1)){
			// 	return mid1;	
			// }
			// if(isLowest(mid2)){
			// 	return mid2;
			// }

			int[] arr = new int[b-a+1];
			for(int i=a;i<=b;i++){
				arr[i]=fun(a);
			}

			return ternarySearch(arr, a, b+1);
	}
	public static void main(String[] args){
		int[] A={
			1, 4, 5, 8, 10, 20, 24, 26, 28, 31
		};
		System.out.println(ternarySearch(A, 0, A.length));
	}
}