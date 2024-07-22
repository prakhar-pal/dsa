#include<iostream>
#include<cstdlib>
using namespace std;

void rotate(int matrix[][4], int n) {

		for (int layer = 0; layer <= n / 2; ++layer)
		{

				int first = layer;

				int last = n - 1 - layer;

				for(int i = first; i < last; ++i)
				{

						int offset = i - first;

						int top = matrix[first][i]; // save top

						// left -> top

						matrix[first][i] = matrix[last-offset][first];

									 // bottom -> left
						matrix[last-offset][first] = matrix[last][last - offset];

									 // right -> bottom
						matrix[last][last - offset] = matrix[i][last];

						// top -> right
						matrix[i][last] = top; // right <- saved top

				}

		}
}

int main()
{
		int matrix[4][4] = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};
		int n = sizeof(matrix[0])/sizeof(matrix[0][0]);
		rotate(matrix,n);
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				cout<<matrix[i][j]<<" ";
			cout<<endl;
		}

}
