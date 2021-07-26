#include <iostream>
#include <algorithm>
#include<cstring>
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t--){
        int size;
        cin>>size;
        int arr[size];
        for(int i=0;i<size;i++)
            cin>>arr[i];
        sort(arr,arr+size);
        int start = 0, end = size-1, position = 0, out[size];
        memset(out,0,size);
        while(start<=end && position < size){
            if(start!=end){
                out[position] = arr[start];
                out[position+1] = arr[end];
                position+=2;
            }
            else{
                out[position] = arr[start];
                position++;
            }
            start++;
            end--;
        }
        for(int i=0;i<size;i++)
            cout<<out[i]<<" ";
        cout<<endl;
    }
}
