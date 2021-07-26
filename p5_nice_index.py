#https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/best-index-1-45a2f8ff/
from math import floor,sqrt
n = int(raw_input())
arr = [int(num) for num in raw_input().split()]
# create cost array corresponding to arr
# so e.g. arr=[1,3,5] gives cost=[1,4,9]
cost = []
if n>1:
	cost.append(arr[0])
i=1
while i<n:
	cost.append(arr[i]+cost[i-1])
	i = i+1
#print "cost array is ",cost
i=0
max_special_sum = None
# The following loop calculates the special some at particular index
while i < n:
	# steps is the number of times we can select next set of numbers, e.g. if we select [1],[3,5] then the number of steps is 2
	# so step*(step+1)/2 < L , where L is length of array from index i, so L = n-i. 
	# Also step is an int, so we get the following euqation.
	steps = int(floor((sqrt(8*(n-i)+1)-1)/2))
	# no_of_elements = total number of elements for which can be selected for special sum, on index i
	no_of_elements = steps*(steps+1)/2
	maxi = cost[i+no_of_elements-1] - (0 if i==0 else cost[i-1])
	#print "i=",i,"\nsteps ",steps," no_of_elements ",no_of_elements, " maxi ",maxi
	if max_special_sum is None or max_special_sum < maxi:
		max_special_sum = maxi
	i = i+1
print (max_special_sum if max_special_sum is not None else 0)



# Solution #1
# n = int(raw_input())
# arr = [int(num) for num in raw_input().split(" ")]
# print arr
# maxi = None
# for i in range(n):
# 	step = 1
# 	sumi = 0
# 	j = i
# 	while j + step <= n:
# 		# print type(end), type(sumi), type(j)
# 		sumi = sumi + sum(arr[j:j+step])
# 		j = j+step
# 		step = step+1
# 	if maxi == None or sumi > maxi:
# 		maxi = sumi
# print maxi

