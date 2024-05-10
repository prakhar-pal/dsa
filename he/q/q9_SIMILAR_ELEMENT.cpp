#include <bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    int arr[n];
    int marker[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
        marker[i] = -1;
    }
    int pointer = 0;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int diff = abs(arr[i]-arr[j]);
            if(diff == 1){
                if(marker[i] == -1 && marker[j] == -1){
                    pointer++;
                    marker[i] = marker[j] = pointer;
                }else{
                    if(marker[i]!=-1){
                        marker[j] = marker[i];
                    }else{
                        marker[i] = marker[j];
                    }
                }
            }
        }
    }
    int element_count = 0;
    int pointer_values[pointer+1];
    for(int i=0;i<=pointer;i++){
        pointer_values[i] = 0;
    }
    for(int i=0;i<n;i++){
        if(marker[i]!=-1){
            // cout<<marker[i]<<" ";
            //element_count++;
            pointer_values[marker[i]]++;
        }
    }
    for(int i=0;i<=pointer;i++)
        element_count += pointer_values[i]*(pointer_values[i]-1)/2;
    // cout<<endl;
    cout<<element_count<<endl;
    return 0;
}
