#include <iostream>

using namespace std;

int main(){
    int T;
    cin>>T;
    for(int i=0;i<T;i++){
        int N;
        cin>>N;
        int A[N][N];
        for(int j=0;j<N;j++){
            for(int k=0;k<N;k++){
                cin>>A[j][k];
            }
        }

        int counter=0;
        for(int j=0;j<N;j++){
            for(int k=0;k<N;k++){
                for(int j2=j;j2<N;j2++){
                    for(int k2=k;k2<N;k2++){
                        if(A[j2][k2]<A[j][k]){
                            counter++;
                        }
                    }
                }
            }
        }
        cout<<counter<<"\n";
    }
    return 0;
}