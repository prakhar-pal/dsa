t = int(input())
out = []
for i in range(t):
    a, b, c, d = map(int, input().split(" "))
    out.append(a/(a+b))
for i in range(t):
    print(out[i])
