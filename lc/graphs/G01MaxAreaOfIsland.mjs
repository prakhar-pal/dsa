import assert from "assert";
/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    const m = grid.length;
    const n = grid[0].length;
    const visited =  Array.from({ length: m }, () => Array.from({ length: n }).fill(false));
    let result = 0;
    for(let i=0;i<m;i++) {
        for(let j=0;j<n;j++) {
            if(grid[i][j] === 1 && !visited[i][j]) {
                result = Math.max(result, getArea(i,j));
            }
        }
    }
    function getArea(i, j) {
        if(i >= 0 && i < m && j < n && j >= 0 && grid[i][j] === 1 && !visited[i][j]) {
            visited[i][j] = true;
            return 1 + getArea(i-1, j) + getArea(i+1, j) + getArea(i, j-1) + getArea(i, j+1);
        }
        return 0;
    }
    return result;
};

assert(maxAreaOfIsland([[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]) === 6);
