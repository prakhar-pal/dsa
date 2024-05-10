#include<bits/stdc++.h>
int mod = pow(10,9)+7;
int solve (long long* A,int N ) {
   // Write your code here
   if(N>=64) return 0;
    long long int presence_count = pow(2,N-1);
    long long int out = 0;
    for(int i=0;i<N;i++)
        if(A[i]>=presence_count){
            out += (A[i]%mod);
            out = out % mod;
        }
    return out;
}

int main() {
    int T;
    std::cin>>T;
    for(int t_i=0; t_i<T; t_i++)
    {
        int N;
        std::cin>>N;
        int i_A;
        //long long *A = (long long *)malloc(sizeof(long long));
        long long A[N];
        for(i_A=0; i_A<N; i_A++)
        	std::cin>>A[i_A];
            //scanf("%lld", &A[i_A]);
        int out_ = solve(A,N);
        printf("%d", out_);
        printf("\n");
    }
}
