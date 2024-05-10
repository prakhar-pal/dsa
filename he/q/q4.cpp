//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/hamiltonian-and-lagrangian/
#include <bits/stdc++.h>
#include <vector>
int main(){
    int size;
    std::cin>>size;
    int arr[size];
    for(int i=0;i<size;i++)
        std::cin>>arr[i];
    int biggest = -1;
    std::vector<int> vi;
    for(int i=size-1;i>=0;i--){
        if(biggest <= arr[i]){
            //std::cout<<arr[i]<<" ";
            biggest = arr[i];
            vi.push_back(arr[i]);
        }
    }
    //std::cout<<"\n";
    for(std::vector<int>::iterator it = vi.end() -1 ; it>=vi.begin();it--){
        std::cout<<*it<<" ";
    }
    std::cout<<"\n";
}
