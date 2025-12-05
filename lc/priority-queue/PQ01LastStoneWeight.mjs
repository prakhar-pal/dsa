import MaxHeapTwo from "../core/js/MaxHeap.js";
import assert from "assert";
/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function(stones) {
    const heap = new MaxHeapTwo(stones);
    while(heap.size() >= 2) {
        const first = heap.pop();
        const second = heap.pop();
        if(first !== second) {
            heap.push(Math.abs(first-second));
        }
    }
    return heap.peek() ?? 0;
};

assert(lastStoneWeight([2,7,4,1,8,1]) === 1);
