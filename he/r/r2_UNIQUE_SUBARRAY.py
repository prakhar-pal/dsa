#!/usr/bin/python3

# import libraries for input/ output handling 
# on generic level 
import atexit, io, sys 
  
# A stream implementation using an in-memory bytes  
# buffer. It inherits BufferedIOBase. 
buffer = io.BytesIO() 
sys.stdout = buffer
  
# print via here 
@atexit.register 
def write(): 
    sys.__stdout__.write(buffer.getvalue()) 
 

def get_next_index(arr, index):
    # returns last_index for current unique subarray and
    #next_index for finding next unique subarray
	s = set()
	m = {}
	for index in range(index,len(arr)):
		if arr[index] in s:
			return m[arr[index]]+1, len(s)
		s.add(arr[index])
		m[arr[index]] = index
	return len(arr), len(s)
def get_unique_subarray_count(length):
	return length*(length+1)*(length+2)/6
 
#print("Enter number of test cases")
t = int(raw_input())
out = []
for i in range(t):
	#print("Enter case ",i)
	n = int(raw_input())
	arr = [int(num) for num in raw_input().split(" ")]
	current_index = 0
	# last_unique_index = None
	unique_subarray_count = 0
	# arr_map = set()
	#print("Entering while loop")
	while True:
		next_index, length = get_next_index(arr, current_index)
		#print("current index is ",current_index," last index is",last_index)
		# length = last_index - current_index + 1
		n_uniques_sac = get_unique_subarray_count(length)
		unique_subarray_count = unique_subarray_count + n_uniques_sac
		#print("new unique subarrays are ",n_uniques_sac," and total count is", unique_subarray_count)
		current_index = next_index
		if current_index == len(arr):
			break
	out.append(unique_subarray_count)
#print("out is ",out)
for val in out:
	print(val)
