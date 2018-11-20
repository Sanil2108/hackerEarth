#include <iostream>
#include <vector>

using namespace std;

class Stack{
public:
	vector<int> array;
	Stack(){

	}

	void add(int element){
		array.push_back(element);
	}

	int top(){
		return array.back();
	}

	void removeTop(){
		array.pop_back();
	}

	bool empty(){
		return array.empty();
	}

	void doEmpty(){
		array.clear();
	}
};

int main(){
	Stack s;

	unsigned int n;
	cin>>n;

	int array[n];
	int blockStarts[n];
	int blockIndex=0;
	int blockSizes[n];
	for(int i=0;i<n;i++){
		array[i]=0;
		blockStarts[i]=0;
		blockSizes[i]=0;
	}
	for(int i=0;i<n;i++){
		int newNumber;
		cin>>newNumber;

		if(s.empty()){
			s.add(newNumber);
		}else{
			int currentTop = s.top();
			if(currentTop == -newNumber && newNumber<0){
				array[i]=array[i-1]+2;
				s.removeTop();
			}else{
				s.add(newNumber);
			}
		}
	}

	int max=array[0];
	for(int i=0;i<n;i++){
		if(i!=0){
			if(array[i-1]!=0 && array[i]==0){
				blockSizes[blockIndex]=array[i-1];
				blockStarts[blockIndex]=i-array[i-1];
				blockIndex++;
			}
		}

		// cout<<array[i]<<" ";
		if(max<array[i]){
			max=array[i];
		}
	}

	if(array[n-1]!=0){
		blockSizes[blockIndex]=array[n-1];
		blockStarts[blockIndex]=n-array[n-1];
		blockIndex++;
	}

	int finalArray[n];
	int finalArrayIndex=0;
	int currentCount=0;
	int maxCount=0;
	for(int i=0;i<n;i++){
		finalArray[i]=0;
	}

	// cout<<"\n";
	// for(int i=0;i<blockIndex;i++){
	// 	cout<<blockStarts[i]<<"\t";
	// }
	// cout<<"\n";
	// for(int i=0;i<blockIndex;i++){
	// 	cout<<blockSizes[i]<<"\t";
	// }
	// cout<<"\n";
	currentCount=blockSizes[0];
	for(int i=1;i<blockIndex;i++){
		if(maxCount<currentCount){
			maxCount=currentCount;
		}
		if(blockStarts[i-1]+blockSizes[i-1]==blockStarts[i]){
			currentCount+=blockSizes[i];
		}else{
			currentCount=0;
		}
	}

	if(maxCount<currentCount){
		maxCount=currentCount;
	}

	cout<<maxCount<<"\n";

}