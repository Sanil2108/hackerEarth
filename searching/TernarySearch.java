import java.util.*;
class TernarySearch{
	public static int ternarySearch(int[] A, int target, int start, int end){
		int mid1 = (int)((start+end)/3f);
		int mid2 = (int)((start+end)*(2f/3));
		if(A[mid1] == target){
			return mid1;
		}else if(A[mid2] == target){
			return mid2;
		}else{
			if(target<A[mid1] && target>A[start]){
				return ternarySearch(A, target, start, mid1);
			}else if(target>A[mid1] && target<A[mid2]){
				return ternarySearch(A, target, mid1, mid2);
			}else{
				return ternarySearch(A, target, mid2, end);
			}
		}

	}
	public static void main(String[] args){
		int[] A={
			1, 4, 5, 10, 20, 24, 26, 28, 31
		};
		System.out.println(ternarySearch(A, 10, 0, A.length)+1);
	}
}