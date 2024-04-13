#/usr/bin/python3
#https://www.codechef.com/problems/DISCSHOP
from math import pow
def get_num_from_str(str):
    return 
t = int(input())
out = []
for i in range(t):
    num_str = input()
    min = int(num_str)
    num_len = len(num_str)
    for i in range(0, num_len):
        # print("index:",i)
        left = num_str[:i] if i > 0 else ""
        # print("left",left)
        right = num_str[i+1:] if i < num_len -1 else ""
        # print("right",right)
        temp = int(left + right)
        if temp < min:
            min = temp   
    out.append(min)
for i in range(t):
    print(out[i])