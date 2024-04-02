// factorial function
function fact(n) {
	if(n<=0) {
		return { value: 1, tens: 0};
	}
	const _fact = fact(n-1);
	let newValue = _fact.value*n;
	let newTens = _fact.tens;
	while(newValue % 10 === 0) {
		newValue/=10;
		newTens = newTens + 1;
	}
	// console.log('calculating for:',n, ' new tens:', newTens);
	return {
		value: newValue,
		tens: newTens
	};
}


console.log('fact(5):',fact(5))
console.log('fact(10):',fact(10))
console.log('fact(20):',fact(20))
console.log('fact(23):',fact(23))
console.log('fact(25):',fact(25))
console.log('fact(26):',fact(26))
