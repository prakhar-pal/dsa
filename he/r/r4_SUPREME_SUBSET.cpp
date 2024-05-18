#include <bits/stdc++.h>
// #include <set>

// using namespace std;
int main(){
    int n;
    long m;
    std::cin>>n>>m;
    long long arr[n];
    long long max = -1;
    std::vector<long long> supreme_set;
    std::set <long long> unique_numbers;
    std::map<long long, int> multiplicity;
    for(int i=0;i<n;i++){
        std::cin >> arr[i];
        unique_numbers.insert(arr[i]);
        if(multiplicity[arr[i]]) multiplicity[arr[i]]++;
        else multiplicity[arr[i]] = 1;
        if(arr[i]>max) max = arr[i];
    }
    bool visited[m];
    memset(visited, false, m);
    for (std::set<long long>::iterator it = unique_numbers.begin(); it != unique_numbers.end(); it++){
        long long start = *it % m;
        if(visited[start])
            continue;
        std::vector<long long> temp_ss;
        while (start < max){
            visited[start] = true;
            if (unique_numbers.find(start) != unique_numbers.end()){
                for(int i=0;i<multiplicity[start];i++)
                    temp_ss.push_back(start);
            }
            start += m;
        }
        int temp_size = temp_ss.size() ;
        int ss_size = supreme_set.size();
        if(temp_size>=ss_size){
            if(temp_size>ss_size)
                supreme_set = temp_ss;
            int starting_temp = *temp_ss.begin();
            int start_supreme_set = *supreme_set.begin();
            if(starting_temp<start_supreme_set)
                supreme_set = temp_ss;
        }
    }
    int size = supreme_set.size();
    std::cout<<size<<"\n";
    for(std::vector<long long>::iterator it = supreme_set.begin(); it!= supreme_set.end();it++)
        std::cout<<*it<<" ";
    std::cout<<"\n";
    return 0;
}