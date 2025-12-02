
var MinStack = function() {
    this.stack = [];
    this.minStack = [];
};

/**
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
    this.stack.unshift(val);
    if(this.minStack.length === 0 || val <= this.minStack[0]) {
        this.minStack.unshift(val);
    }
  console.log(this.stack, this.minStack);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    const valu = this.stack.shift();
    if(valu === this.minStack[0]) {
        this.minStack.shift();
    }
    return valu;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
  return this.stack[0];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minStack[0];
};


const minStack0 = new MinStack();
minStack0.push(-2);
minStack0.push(0);
minStack0.push(-3);
console.log(minStack0.getMin());
minStack0.pop();
console.log(minStack0.top());
console.log(minStack0.getMin());
