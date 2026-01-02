import assert from 'assert';
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    const visited =  Array.from({ length: m }, () => Array.from({ length: n }).fill(false));
    let count = 0;
    for(let i=0;i<m;i++) {
        for(let j=0;j<n;j++) {
            if(grid[i][j] === "1" && !visited[i][j]) {
                count++;
                markVisited(i,j);
            }
        }
    }
    function markVisited(i, j) {
        if(i < 0 || i >=m || j >= n || j < 0 || grid[i][j] === "0" || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        markVisited(i-1, j);
        markVisited(i+1, j);
        markVisited(i, j-1);
        markVisited(i, j+1);
    }
    return count;
};

const result1 = numIslands([["1","0","1","1","0","1","1"]]);
assert( result1=== 3, `result is ${result1}`);
