//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/in-an-array-9fbe4c12/
#include <bits/stdc++.h>
int main(){
    int n,k,x,y;
    std::cin>>n>>k>>x>>y;
    int arr[n];
    for(int i=0;i<n;i++)
        std::cin>>arr[i];
    int count = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if (i == j)
                continue;
            if( (arr[i]+arr[j])%k == x && (arr[i]*arr[j])%k == y)
                count++;
        }
    }
    std::cout<<int(count/2)<<"\n";
    return 0;
}