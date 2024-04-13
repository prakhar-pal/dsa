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
            return  mid-1
        return bs_le(arr, val, start, mid-1)
arr = [1,3,5,7,7]
val = 8
arr.sort()
print(max(arr)>val)
out = bs_le(arr,val,0,len(arr)-1)
print(out)