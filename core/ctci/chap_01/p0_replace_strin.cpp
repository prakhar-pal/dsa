#include<iostream>
#include<cstdlib>
using namespace std;
char* ReplaceFun(char str[],int length);
int main()
{
	char str[] = "Count the number of spaces during the first scan of the string";
	cout<<"before:\n"<<str;
	char * str2 = ReplaceFun(str,sizeof(str)/sizeof(str[0]));
	cout<<"\nafter:\n"<<str2;
}

char* ReplaceFun(char str[], int length) {

		int spaceCount = 0, newLength, i = 0;
		for (i = 0; i < length; i++) {

		if (str[i] == ' ') {

		spaceCount++;

		}

		}

		newLength = length + spaceCount * 2;
		char *strn = (char*)malloc(newLength*sizeof(char));

		str[newLength] = '\0';

		for (i = length - 1; i >= 0; i--) {

		if (str[i] == ' ') {

		strn[newLength - 1] = '0';

		strn[newLength - 2] = '2';

		strn[newLength - 3] = '%';

		newLength = newLength - 3;

		} else {

		strn[newLength - 1] = str[i];

		newLength = newLength - 1;

		}

		}
		return strn;
}
