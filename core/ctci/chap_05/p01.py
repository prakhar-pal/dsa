# given m and n, make m's bit from i upto j (i<j) as a binary representation of n

#real output1
#values are m=50,n=20,i=1,j=4
#1 th bit of  20  is set?: False
#2 th bit of  20  is set?: False
#3 th bit of  20  is set?: True
#4 th bit of  20  is set?: False
#0
#shift amount is 0
#52
#time by f1: 0.0001246929168701172
#time by f2: 3.147125244140625e-05

from time import time
def ifNthBitSet(num,pos):
    temp = 1<<(pos-1)
    return (num & temp) == temp
def convertToBinary(num):
    print("coverting ",num)
    out=""
    while(num>=2):
        out = str(num%2)+out
        num = int(num/2)
        #print("new num is ",num)
    if(num==1):
        out = str(1)+out
    return out
def fun1(m,n,i,j):
    print("binary of {} is {}".format(m,convertToBinary(m)))
    print("binary of {} is {}".format(n,convertToBinary(n)))
    n = n<<(i-1)
    for k in range(i,j+1):
        print("starting value of m for loop is :{}".format(m))
        ofn = ifNthBitSet(n,k)
        print(k,"th bit of ",n," is set?:",ofn)
        ofm = ifNthBitSet(m,k)
        mask = 1<<(k-1)
        if ofn:
            m = m|mask
        else:
            m = m & ~mask
        print("new m is {}".format(convertToBinary(m)))
    return m

def fun2(m,n,i,j): # ctci book
    # this approach is 4 times faster than what i implemented
    maxi = ~0
    left =  maxi - ((1<<j)-1)
    shift_amt = i-1
    print("shift amount is {}".format(shift_amt))
    right = (1<<shift_amt)-1
    mask = left|right
    return (m&mask|n<<(i-1))

if __name__=="__main__":
    #m = int(input("Enter numbers:"))
    #n = int(input("Enter numbers:"))
    #print("Binary m={},n={}".format(convertToBinary(m),convertToBinary(n)))
    #i = int(input("Enter numbers:"))
    #j = int(input("Enter numbers:"))
    m = 52
    n=40
    i=2
    j=5
    print("values are m={},n={},i={},j={}".format(m,n,i,j))
    st1 = time()
    print("fun1:",fun1(m,n,i,j))
    et1= time()
    st2 = time()
    print("fun2:",fun2(m,n,i,j))
    et2 = time()
    print("time by f1:",(et1-st1))
    print("time by f2:",(et2-st2))






























