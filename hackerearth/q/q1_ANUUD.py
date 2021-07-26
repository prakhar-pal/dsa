#/usr/bin/python3
import math
def calculate():
    """get output"""
    size = int(input())
    arr = [int(n) for n in input().split(" ")]
    arr.sort()
    out = []
    start = 0
    end = size-1
    while start <= end:
        if start != end:
            out.append(arr[start])
            out.append(arr[end])
        else:
            out.append(arr[start])
        start = start + 1
        end = end - 1
    print(" ".join([str(n) for n in out]))

if __name__ == "__main__":
    test_cases = int(input())
    for i in range(test_cases):
        calculate()
