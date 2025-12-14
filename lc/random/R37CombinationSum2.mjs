import assert from "assert";
// https://leetcode.com/problems/combination-sum-ii/
// backtracking
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    let count = 0;
    const getKey = (indices) => {
        return indices.map(index => candidates[index]).join(",");
    }
    function doCount(index, sum, list, indexSet) {
        if(sum === target && !indexSet.has(getKey(list))) {
            indexSet.add(getKey(list));
            // console.log("indices", list);
            count++;
        }
        if(index >= candidates.length) {
            return;
        }
        list.push(index);
        doCount(index+1, sum + candidates[index], list, indexSet);
        list.pop();
        doCount(index+1, sum, list, indexSet);
    }
    candidates.sort((a,b) => a-b);
    doCount(0, 0, [], new Set());
    return count;
};

class SolutionTwo {
    // optimized solution
    /**
     * 
     * @param {Number[]} candidates 
     * @param {Number} target 
     */
    combinationSum2(candidates, target) {
        const combinations = [];
        /**
         * 
         * @param {Number} index 
         * @param {Number} sum 
         * @param {Array<Number>} path 
         * @returns 
         */
        function makeUniqueCombinations(index, sum, path) {
            // console.log({ sum , path});
            if(sum === target) {
                combinations.push([...path]);
                return;
            }
            if(index >= candidates.length || sum > target) {
                return true;
            }
            for(let j = index; j < candidates.length; j++) {
                if(j > index && candidates[j-1] === candidates[j]) {
                    continue;
                }
                path.push(candidates[j]);
                makeUniqueCombinations(j+1, sum + candidates[j], path);
                path.pop();
            }
        }
        candidates.sort((a,b) => a-b);
        makeUniqueCombinations(0, 0, []);
        return combinations;
    }
}

const solution = new SolutionTwo();
const { combinationSum2: combinationSum2Two } = solution;


console.log(combinationSum2Two([10,1,2,7,6,1,5], 8));
console.log(combinationSum2Two([2,5,2,1,2], 5));
