#include <bits/stdc++.h>
int main(){
    int t;
    std::cin>>t;
    while(t--){
        int n,k;
        std::cin>>n>>k;
        int alice[n],bob[n], max_bob = INT_MIN;
        for(int i=0;i<n;i++)
            std::cin>>alice[i];
        for(int i=0;i<n;i++){
            std::cin>>bob[i];
            if(bob[i]>max_bob)
                max_bob = bob[i];
        }
        int card_value = max_bob+1;
        int total_run_time = 0;
        for(int i=0;i<n;i++){
            if(alice[i]<card_value)
                total_run_time += card_value-alice[i];
        }
        total_run_time *= k;
        std::cout<<total_run_time<<"\n";
    }
}
