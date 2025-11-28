
// class Queue {
//     items = []
//     push(val) {
//         this.items.push(val)
//     }
//     pop() {
//         return this.items.shift();
//     }
//     empty() {
//         return this.items.length === 0;
//     }
// }


var MyStack = function() {
    this.mainQueue = new Queue();
    this.secondaryQueue = new Queue();
};

/** 
 * @param {number} x
 * @return {void}
 */
MyStack.prototype.push = function(x) {
    this.mainQueue.push(x);
};

/**
 * @return {number}
 */
MyStack.prototype.pop = function() {
    let lastitem;
    while(true) {
        let item = this.mainQueue.pop();
        if(this.mainQueue.empty()) {
            lastitem = item;
            break;
        }
        this.secondaryQueue.push(item);
    }
    this.mainQueue = this.secondaryQueue;
    this.secondaryQueue = new Queue();
    return lastitem;
};

/**
 * @return {number}
 */
MyStack.prototype.top = function() {
    let lastitem = this.pop();
    this.mainQueue.push(lastitem);
    return lastitem;
};

/**
 * @return {boolean}
 */
MyStack.prototype.empty = function() {
    return this.mainQueue.empty();
};

/** 
 * Your MyStack object will be instantiated and called as such:
 * var obj = new MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */

let stack = new MyStack();
stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);
console.assert(stack.top() === 4);
stack.pop();
console.assert(stack.top() === 3);
stack.push(5);
console.assert(stack.top() === 5);
stack.pop();
stack.pop();
stack.pop();
console.assert(stack.top() === 1);
