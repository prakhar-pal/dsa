'''
# Sample code to perform I/O:

name = raw_input()          # Reading input from STDIN
print 'Hi, %s.' % name      # Writing output to STDOUT

# Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
'''

# Write your code here

d = int(raw_input())
out = []
count = 0
for case in range(d):
    r,x = [int(num) for num in raw_input().split(" ")]
    print r,x
    if r*22/7 < 100*x:
        count = count +1
print count
