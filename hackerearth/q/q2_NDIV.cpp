#include<bits/stdc++.h>
int main(){
    int a,b,n;
    std::cin>>a>>b>>n;
    int small = a<b?a:b;
    int big = a>b?a:b;
    int ndiv_count = 0;
    for(int num=small;num<=big;num++){
        int div_count = 0;
        int max_iter = sqrt(num);
        for(int i=1;i<=max_iter;i++){
             // std::cout<<num<<"%"<<i<<(num%i==0)<<std::endl;
             if(num%i==0){
               div_count = div_count + (i*i==num ? 1 : 2);
             }
        }
        // std::cout<<"div count for "<<num<<" is"<<div_count<<std::endl;
        if(div_count==n) ndiv_count++;
    }
    std::cout<<ndiv_count<<std::endl;
}
