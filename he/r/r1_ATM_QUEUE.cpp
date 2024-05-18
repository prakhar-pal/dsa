#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    int count = 1,current, prev=NULL;
    for(int i=0;i<n;i++){
        int current;
        cin>>current;
        if(prev != NULL){
            if (prev > current) count ++;
        }
        prev = current;
    }
    cout<<count<<endl;
}