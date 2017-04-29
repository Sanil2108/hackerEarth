import java.util.Scanner;
class BeingGreedyForWater{
	public static int[] mergeSort(int[] A, int start, int end){
		int mid=(start+end)/2;
		if(end-start==1){
			int[] temp={A[start]};
			return temp;
		}else{
			return sort(mergeSort(A, start, mid), mergeSort(A, mid, end));
		}
	}

	public static int[] mergeSort(int[] A){
		return mergeSort(A, 0, A.length);
	}

	public static int[] sort(int[] A, int[] B){
		int i=0;
		int j=0;
		int k=0;
		int[] C = new int[A.length+B.length];
		while(i<A.length && j<B.length){
			if(A[i]>B[j]){
				C[k]=B[j];
				j++;
			}else{
				C[k]=A[i];
				i++;
			}
			k++;
		}

		while(i<A.length){
			C[k]=A[i];
			k++;
			i++;
		}

		while(j<B.length){
			C[k]=B[j];
			k++;
			j++;
		}

		return C;
	}

	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0;i<T;i++){
			int N=in.nextInt();
			int X=in.nextInt();
			int[] A=new int[N];
			for(int j=0;j<N;j++){
				A[j]=in.nextInt();
			}
			A = mergeSort(A);

			int total=0;
			int totalBottles=0;
			int j=0;
			while(total<=X && j<A.length){
				total+=A[j];
				if(total>X){
					break;
				}
				// System.out.println(total);
				j++;
				totalBottles++;
			}
			System.out.println(totalBottles);
		}
	}
}