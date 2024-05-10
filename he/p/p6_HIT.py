#https://www.codechef.com/problems/HIT

def find_range(arr):
    length = len(arr)
    packet_length = int(length/4)
    x = packet_length
    y = packet_length*2
    z = packet_length*3
    if arr[x-1] == arr[x] or arr[y-1] == arr[y] or arr[z-1] == arr[z]:
        return "-1"
    return " ".join([str(arr[x]),str(arr[y]),str(arr[z])])


t = int(input())
out = []
for i in range(t):
    n = int(input())
    arr = [int(d) for d in input().split(" ")]
    arr.sort()
    out.append(find_range(arr))
for o in out:
    print(o)

    
