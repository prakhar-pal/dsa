#include <bits/stdc++.h>
using namespace std;
void change_value(int *value){
	*value = 10;
}
void change_value2(int &value){
	value = 100;
}
int main(){
	int value = 0;
	change_value(&value);
	cout<<"change value:"<<value<<endl;
	int value2 = -1;
	change_value2(value2);
	cout<<"change value2:"<<value2<<endl;
}
