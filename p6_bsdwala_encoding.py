#https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/
def get_primes(num):
	if num <= 2 and num >= 0:
		return True
	arr = []
	is_prime = []
	for i in range(num+1):
		arr.append(i)
		is_prime.append(True)
	is_prime[1] = True
	is_prime[2] = True
	current_num = 2
	while current_num <=num:
		if is_prime[current_num]:
			i = 2
			while i*current_num <= num:
				is_prime[i*current_num] = False
				i = i + 1
		current_num = current_num + 1
	primes = []
	for num in range(len(is_prime)):
		if is_prime[num]:
			primes.append(num)
	return primes




def get_nearest_prime(number,primes):	
	i = 0
	length = len(primes)
	if length>0 and number<primes[0]:
		return primes[0]
	while i < (length-1):
		if number>primes[i] and (number < primes[i+1]): #if i+1<length else True):
			left = number-primes[i]
			right = (primes[i+1]-number)
			if left<=right:
				return primes[i]
			else:
				return primes[i+1]
		i = i+1
	return primes[length-1]

def get_sequence_arr(a,b):
	return [num for num in range(a,b+1)]

t = int(raw_input())
total_primes = get_primes(256)
ranges = [[65,90],
		 [97,122]
]
legal_primes = []
for prime in total_primes:
	if (prime>=65 and prime<=90) or (prime>=97 and prime<=122):
		legal_primes.append(prime)
print legal_primes
for prime in legal_primes:
	print chr(prime)
magical_strings = []
for case in range(t):
	length = int(raw_input())
	s = list(raw_input())
	#print "INPUT->s ",s
	#print primes
	for index in range(len(s)):
		ascii_code = ord(s[index])
		if ascii_code not in legal_primes:
			nearest_prime = get_nearest_prime(ascii_code,legal_primes)
			print s[index]," \'s ascii code ",ascii_code," is not prime and nearest prime is ",nearest_prime
			s[index] = chr(nearest_prime)
			print "so it becomes ",s[index]
	#print "AFTER FOR->",s
	s = ''.join(s)
	magical_strings.append(s)
for mgk in magical_strings:
	print mgk
