import MaxHeap from "../js/MaxHeap.js";
import assert from 'assert';
const heap = new MaxHeap([1, 2, 3, 4]); // [4, [2,3,1]]
assert(heap.peek() === 4); 
heap.pop(); // [3, [1,2]]
assert(heap.peek() === 3);
heap.push(10); // [10, [1,2,3]]
assert(heap.peek() === 10);
heap.pop(); // [3, [1,2]]
heap.pop(); [2, [1]];
assert(heap.peek() === 2);
