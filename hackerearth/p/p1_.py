#https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/
import math
class Compartment:
	def __init__(self,start,end):
		self.start = start
		self.end = end
		self.total = self.start + self.end
	def getFront(self,num):
		if num > self.end or num < self.start:
			print self.start,self.end
			raise ValueError("Incorrect number asked")
		return self.total - num
	def getPosition(self,num):
		mod3 = num % 3
		if mod3 == 2:
			return "MS"
		if (mod3 == 0 and (num % 6 == 0)) or ( mod3 == 1 and (num%6==1)):
			return "WS"
		else:
			return "AS"

t = int(raw_input())
#N = int(raw_input())
MAX = 108
compartments = []
for value in range(1,MAX+1,12):
	compartments.append(Compartment(value, value+11))
out = []
for case in range(t):
	num = int(raw_input())
	compartment_no = int(math.ceil((num*1.0/12))) - 1
	#print "Compartment no is ",compartment_no
	front = compartments[compartment_no].getFront(num)
	position = compartments[compartment_no].getPosition(num)
	#print front,position
	out.append(str(front)+" "+position)
for o in out:
	print o