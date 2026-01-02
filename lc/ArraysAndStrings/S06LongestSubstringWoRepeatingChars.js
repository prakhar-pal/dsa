// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// two-pointer
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    const map = {};
    let left = 0, right = 0;
    let result = 0;
    while(right < s.length) {
        if(s[right] in map) {
            console.log("before",{left, right, map });
            result = Math.max(result, right - left);
            while(left <= map[s[right]]) {
                delete map[s[left++]];
            }
            console.log("after",{left, right, map });
        }
        map[s[right]] = right;
        console.log("updated map", map);
        right++;
    }
    // result = Math.max(result, right - left);
    return result;
};

console.log(lengthOfLongestSubstring("abcabcbb"));
