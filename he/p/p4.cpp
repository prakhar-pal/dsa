//https://www.hackerearth.com/practice/basic-programming/complexity-analysis/time-and-space-complexity/practice-problems/algorithm/vowel-game-f1a1047c/
#include<bits/stdc++.h>
#include<vector>
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t--){
        string str;
        cin>>str;
        char vowels[] = {"a", "e", "i", "o", "u"};
        //char ch = 'a';
        vector<int> positions;
        for(int i=0;i<str.length();i++){
            char ch = tolower(str.c_str()[i]);
            bool isVowel = false;
            for(int j=0;j<5;j++){
                if(ch == vowels[j].c_str())
                    isVowel = true;
            }
            if(isVowel)
                positions.push_back(i+1);
        }
        int sum = 0;
        for(vector<int>::iterator it = positions.begin(); it!= positions.end(); it++){
            sum += *it;
        }
        cout<<2*sum<<endl;
    }
}
