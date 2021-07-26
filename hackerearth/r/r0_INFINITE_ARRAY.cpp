//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/infinity-array-715a233b/
#include <bits/stdc++.h>
using namespace std;
int mod = 1000000007;
int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        long long arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];
        int q;
        cin>>q;
        long long l[q],r[q];
        for(int i=0;i<q;i++)
            cin>>l[i];
        for(int i=0;i<q;i++)
            cin>>r[i];
        long long sumArr[n];
        for(int i=0;i<n;i++)
            sumArr[i] = ((i > 0 ? sumArr[i - 1] : 0) + arr[i]) % mod;
        // cout<<"sumarr::"<<sumArr[n-1]<<"\n";
        for(int i=0;i<q;i++){
            long long repetitionCount = (r[i] - l[i] + 1) > n ? (r[i] - l[i] + 1) / n : 0;
            long long start = (l[i] - 1) % n;
            long long end = (r[i] - 1) % n;
            // start = start < 0 ? 0 : start;
            // end = end < 0 ? 0 : end;
            long long total = ((start <= end && start + end == n - 1) || (start > end && (end - start) == 1) ? 0 : start <= end ? (sumArr[end] - (start > 0 ? sumArr[start - 1] : 0)) : (sumArr[n - 1] - (start > 0 ? sumArr[start - 1] : 0) + sumArr[end])) % mod;
            // cout<<"\nlog::"<<"rc:"<<repetitionCount<<",start:"<<start<<",end:"<<end<<",total:"<<total<<",sumArr[n-1]:"<<sumArr[n-1]<<",rc*total:"<<repetitionCount*sumArr[n-1]<<"\n";
            total = (total + repetitionCount * sumArr[n - 1] % mod) % mod;
            cout << total << " ";
        }
        cout<<endl;
    }
}