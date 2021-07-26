#https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/monk-and-his-birthday-party/
#!/usr/bin/python3

import math
def bs_le(arr, val, start, end):
    # print('start',start,' end',end,'\n')
    if(start > end):
        return None
    mid = math.floor((start+end)/2)
    if arr[mid] == val:
        return mid
    if arr[mid] < val:
        if (mid + 1) < len(arr) and arr[mid+1] > val:
            return mid
        return bs_le(arr, val, mid+1, end)
    elif arr[mid] > val:
        if (mid-1) >= 0 and arr[mid-1] < val:
            return mid-1
        return bs_le(arr, val, start, mid-1)

t = int(input())
while t > 0:
    t = t-1
    n, m = [int(num) for num in input().split(" ")]
    eating_capacity = [int(num) for num in input().split(" ")]
    weight = [int(num) for num in input().split(" ")]
    cake_count = [int(num) for num in input().split(" ")]
    # print(weight,cake_count)
    weight_and_cake_count = []
    for i in range(n):
        weight_and_cake_count.append(
            {'weight': weight[i], 'count': cake_count[i]})
    # print(weight_and_cake_count)
    weight_and_cake_count = sorted(
        weight_and_cake_count, key=lambda x: x['weight'])
    weight = [num['weight'] for num in weight_and_cake_count]
    cake_count = [num['count'] for num in weight_and_cake_count]
    print("after sorting, weight:",weight, " cake count:",cake_count)
    eating_capacity.sort()
    eating_capacity_cake_map = []
    if eating_capacity[len(eating_capacity)-1] < weight[len(weight)-1]:
        print(-1)
        continue
    for index in range(len(eating_capacity)):
        edible_cake_index = bs_le(
            weight, eating_capacity[index], 0, len(weight)-1)
        eating_capacity_cake_map.append(edible_cake_index)
    time = 0
    zero_count = 0
    exit_loop = False
    while zero_count != n:
        time = time + 1
        for index in range(m):
            cake_index = eating_capacity_cake_map[index]
            if cake_index is None:
                print(-1)
                exit_loop = True
                break
            while cake_index >= 0 and cake_count[cake_index] == 0 :
                cake_index = cake_index - 1
            eating_capacity_cake_map[index] = cake_index
            cake_count[cake_index] = cake_count[cake_index] -1
            if cake_count[cake_index] == 0:
                zero_count = zero_count + 1
        if exit_loop :
            break
    if not exit_loop:
        print(time)
