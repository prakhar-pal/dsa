        //https://www.hackerearth.com/practice/algorithms/searching/ternary-search/practice-problems/algorithm/monk-visits-coderland-4/editorial/
        #include<bits/stdc++.h>
        #include<vector>
        #include<climits>
        int main(){
            int t;
            std::cin>>t;
            while(t--){
                // std::cout<<"test"<<t<<std::endl;
                int size;
                std::cin>>size;
                long long cost[size],petrol[size];
                int i = 0;
                while(i<size){
                    std::cin>>cost[i];
                    // std::cout<<"in cost"<<i<<std::endl;
                    i++;
                }
                i = 0;
                while(i<size){
                    std::cin>>petrol[i];
                    // std::cout<<"petrol "<<i<<std::endl;
                    i++;
                }
                long long total_cost = 0;
                int min_price = 1000000ll ;
                i=0;
                while(i<size){
                    if(cost[i] < min_price)
                        min_price = cost[i];
                    total_cost += petrol[i]*min_price;
                    i++;
                }
                std::cout<<total_cost<<"\n";
            }
        }
 