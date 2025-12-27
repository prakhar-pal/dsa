// https://leetcode.com/problems/surrounded-regions/description/
// graph, depth-first-search, reverse-thinking
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveOne = function(board) {
  const m = board.length;
  const n = board[0].length;
  const visited = Array.from({ length: m }).map(() => Array.from({ length: n }).fill(false));
  for (let i = 0; i < m - 1;i++) {
    for (let j = 0; j < n - 1;j++) {
      if(board[i][j] === 'O' && !visited[i][j]) {
        const indices = [];
        const result = findAllMatchingIndices(i, j, indices);
        if(!result) {
          for(let index of indices) {
            const [x, y] = index;
            board[x][y] = 'X';
          }
        }
      }
    }
  }
  function findAllMatchingIndices(i, j, indices) {
    if(visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    let isOnBorder = i === 0 || i === m - 1 || j === 0 || j === n - 1;
    indices.push([i, j]);
    if(i > 0 && !visited[i-1][j] && board[i-1][j] === 'O') {
      isOnBorder = findAllMatchingIndices(i - 1, j, indices) || isOnBorder;
    }
    if(i + 1 < m && !visited[i+1][j] && board[i+1][j] === 'O') {
      isOnBorder = findAllMatchingIndices(i + 1, j, indices) || isOnBorder;
    }
    if(j > 0 && !visited[i][j-1] && board[i][j-1] === 'O') {
      isOnBorder = findAllMatchingIndices(i, j - 1, indices)|| isOnBorder;
    }
    if(j + 1 < n && !visited[i][j+1] && board[i][j+1] === 'O') {
      isOnBorder = findAllMatchingIndices(i, j + 1, indices) || isOnBorder;
    }
    return isOnBorder;
  }
};

// https://www.youtube.com/watch?v=9z2BunfoZ5Y
// "reverse-thinking"
// find mark unsurrounded regions' cell with e.g. "T"
// rest of the regions are unsurrounded
//
/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
const solveTwo = function(board) {
  const m = board.length;
  const n = board[0].length;
  const visited = Array.from({ length: m }).map(() => Array.from({ length: n }).fill(false));
  for (let i = 0; i < m;i++) {
    for (let j = 0; j < n;j++) {
      if([0, m-1].includes(i) || [0, n-1].includes(j)) {
        // border indices
        capture(i, j);
      }
    }
  }
  for (let i = 0; i < m;i++) {
    for (let j = 0; j < n;j++) {
      if(board[i][j] === 'O') {
        // border indices
        board[i][j] = 'X';
      }
    }
  }

  for (let i = 0; i < m;i++) {
    for (let j = 0; j < n;j++) {
      if(board[i][j] === 'T') {
        // border indices
        board[i][j] = 'O';
      }
    }
  }

  function capture(i, j) {
    if(i>=0 && j>=0 && i<m && j < n && board[i][j] === 'O') {
      board[i][j] = 'T';
      capture(i + 1, j);
      capture(i - 1, j);
      capture(i, j + 1);
      capture(i, j - 1);
    }
  }
}

const solve = solveTwo;

const q1 = [["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"]];
solve(q1);
console.log(q1);


const q2 = [["X", "O", "X", "O", "X", "O"], ["O", "X", "O", "X", "O", "X"], ["X", "O", "X", "O", "X", "O"], ["O", "X", "O", "X", "O", "X"]];
solve(q2);
console.log(q2);

const q3 = [["X", "O", "O", "X", "X", "X", "O", "X", "O", "O"], ["X", "O", "X", "X", "X", "X", "X", "X", "X", "X"], ["X", "X", "X", "X", "O", "X", "X", "X", "X", "X"], ["X", "O", "X", "X", "X", "O", "X", "X", "X", "O"], ["O", "X", "X", "X", "O", "X", "O", "X", "O", "X"], ["X", "X", "O", "X", "X", "O", "O", "X", "X", "X"], ["O", "X", "X", "O", "O", "X", "O", "X", "X", "O"], ["O", "X", "X", "X", "X", "X", "O", "X", "X", "X"], ["X", "O", "O", "X", "X", "O", "X", "X", "O", "O"], ["X", "X", "X", "O", "O", "X", "O", "X", "X", "O"]];
solve(q3);
console.log(q3);
