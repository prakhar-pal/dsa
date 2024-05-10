t = int(input())
while t:
    t = t -1
    str = input()
    vowels = ['a','e','i','o','u']
    str = str.lower()
    positions = []
    for index in range(len(str)):
        if str[index] in vowels:
            positions.append(index)
    total = 0
    str_len = len(str)
    for position in positions:
        total = total + (str_len-position)*(position+1)
    print(total)