# https://www.codechef.com/problems/TRAINSET
t = int(input())
out = []
for i in range(t):
    n = int(input())
    unique_items = {}
    duplicated_items = {}
    for j in range(n):
        w,i = input().split(" ")
        i = int(i)
        if w not in unique_items:
            unique_items[w] = {"value": i,"count": 1}
        elif w in unique_items and unique_items[w]["value"] == i:
            unique_items[w]["count"] = unique_items[w]["count"] + 1
        else:
            count = duplicated_items[w]["count"] if w in duplicated_items else 0
            duplicated_items[w] = {"value": i, "count": count + 1}
    # print("unique items",unique_items)
    # print("duplicated items",duplicated_items)
    for word in duplicated_items:
        if unique_items[word]["count"] < duplicated_items[word]["count"]:
            unique_items[word]["count"] = duplicated_items[word]["count"]
    total = 0
    for word in unique_items:
        total = total + unique_items[word]["count"]
    out.append(total)
for i in range(t):
    print(out[i])