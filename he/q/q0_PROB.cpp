#include <iostream>
using namespace std;
int main(){
    int t;
    cin>>t;
    float out[t];
    for(int i=0;i<t;i++){
        int a,b,c,d;
        cin>>a>>b>>c>>d;
        out[i] = a*1.0/(a+b);
    }
    for(int i=0;i<t;i++)
        cout<<out[i]<<endl;
}
