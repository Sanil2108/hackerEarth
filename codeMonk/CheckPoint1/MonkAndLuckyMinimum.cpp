#include <iostream>

using namespace std;

int main(){
	int T;
	cin>>T;

	for(int i=0;i<T;i++){
		int n;
		cin>>n;
		long arr[n];
		long min;
		for(int j=0;j<n;j++){
			cin>>arr[j];
			if(j==0){
				min=arr[j];
			}else if(min>arr[j]){
				min=arr[j];
			}
		}

		int count = 0;
		for(int j=0;j<n;j++){
			if(min==arr[j]){
				count++;
			}
		}

		cout<<(count%2==0?"Unlucky\n":"Lucky\n");

	}
}