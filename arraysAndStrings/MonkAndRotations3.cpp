#include <iostream>

using namespace std;

void swap(long *A, long count_, int length) {
	int temp2, temp;
	for (int i = 0; i < length; i++) {
		temp = (i + count_*(length - 1)) % length;
		cout << A[temp] << " ";
	}
}

int main() {
	int T;
	std::cin >> T;
	for (int j = 0; j < T; j++) {
		int N, S;
		cin >> N;
		cin >> S;
		long *A=new long[N];
		for (int i = 0; i < N; i++) {
			int temp;
			cin >> A[i];
			//cout << A[i];
		}
		swap(A, S, N);
		cout << "\n";
	}
	return 0;
}
