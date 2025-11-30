class Stack {
    items: number[] = [];
    push(item: number) {
        this.items.push(item);
    }
    pop(): number | undefined {
        return this.items.pop();
    }
    isEmpty() {
        return this.items.length === 0;
    }
    empty() {
        return this.isEmpty();
    }
}

class MyQueue {
    mainStack: Stack;
    secondaryStack: Stack;
    constructor() {
        this.mainStack = new Stack();
        this.secondaryStack = new Stack();

    }

    push(x: number): void {
        this.mainStack.push(x);
    }

    pop(): number {
        let lastitem;
        while(true) {
            let item = this.mainStack.pop();
            if(!item) {
                continue;
            }
            if(this.mainStack.empty()) {
                lastitem = item;
                break;
            }
            this.secondaryStack.push(item);
        }
        while(!this.secondaryStack.empty()) {
            
        }
        return lastitem || -1;
    }

    peek(): number {
        
    }

    empty(): boolean {
        return this.mainStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
