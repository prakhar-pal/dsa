const Heap = require("./Heap.js");
// class MaxHeap {
//   constructor(a = []) {
//     this.h = a.slice();
//     for (let i = (this.h.length >> 1) - 1; i >= 0; i--) this.down(i);
//   }
//   up(i) {
//     const h = this.h;
//     while (i > 0) {
//       const p = (i - 1) >> 1;
//       if (h[p] >= h[i]) break;
//       [h[p], h[i]] = [h[i], h[p]];
//       i = p;
//     }
//   }
//   down(i) {
//     const h = this.h, n = h.length;
//     while (true) {
//       let l = 2 * i + 1, r = l + 1, m = i;
//       if (l < n && h[l] > h[m]) m = l;
//       if (r < n && h[r] > h[m]) m = r;
//       if (m === i) break;
//       [h[m], h[i]] = [h[i], h[m]];
//       i = m;
//     }
//   }
//   push(x) {
//     this.h.push(x);
//     this.up(this.h.length - 1);
//   }
//   pop() {
//     const h = this.h;
//     if (!h.length) return;
//     const v = h[0];
//     const x = h.pop();
//     if (h.length) {
//       h[0] = x;
//       this.down(0);
//     }
//     return v;
//   }
//   peek() { return this.h[0]; }
//   size() {
//     return this.h.length;
//   }
// }

class MaxHeap extends Heap {
  constructor(a=[]) {
    super(a, (a, b) => a > b);
  }
}

module.exports = MaxHeap;
