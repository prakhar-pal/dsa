//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/charges-repel/
#include <bits/stdc++.h>
int main(){
    int size;
    std::cin>>size;
    std::string s;
    std::cin>>s;
    //std::cout<<size<<" "<<s<<std::endl;
    std::string out = "";
    for(int i=0;i<size;i++){
        int length = out.length();
        if(length == 0 || (length>0 && out[length-1] != s[i])){
            out.push_back(s[i]);
        }else{
            out.pop_back();
        }
    }
    std::cout<<out.length()<<"\n"<<out<<"\n";
}
