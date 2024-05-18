//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/polygon-possible/
#include <bits/stdc++.h>
void solve(){
    int n,biggest = -1, sum=0;
    std::cin>>n;
    for(int i=0;i<n;i++){
        int num;
        std::cin>>num;
        if(num>biggest)
            biggest = num;
        sum+=num;
    }
    if((sum-biggest)>biggest)
        std::cout<<"Yes\n";
    else
        std::cout<<"No\n";
}
int main(){
    int t;
    std::cin>>t;
    while(t--){
        //std::cout<<"solving\n";
        solve();
    }
    return 0;
}
