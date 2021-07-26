#/usr/bin/python3
#https://www.codechef.com/problems/FRUITS
import math
t = int(input())
out = []
for i in range(t):
    n,m,k = map(int,input().split(" "))
    small = math.floor(k/2)
    big = k - small
    if n > m:
        n,m = m,n
    # print(i,small,big,n,m, n1,m1)
    out.append(m-min([n+k,m]))
    # out.append(abs(n+small-m-big))
for i in range(t):
    print(out[i])
