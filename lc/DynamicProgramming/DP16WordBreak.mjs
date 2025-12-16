import assert from "assert";
// https://leetcode.com/problems/word-break/
// trie, dynamic-programming, dfs
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    // runtime 1ms, 94.19%
    // memory 57.45MB, 34.27%
    const dict = new Dict();
    for(let word of wordDict) {
        dict.addWord(word);
    }
    const visitedIndices = new Set();
    function dfs(start) {
        if(visitedIndices.has(start)) {
            return false;
        }
        const sizes = dict.findWords(s, start);
        for(let size of sizes) {
            const newIndex = start + size;
            if(newIndex === s.length) {
                return true;
            }
            if(newIndex < s.length) {
                if(dfs(newIndex)) {
                    return true;
                }
            }
        }
        visitedIndices.add(start);
        return false;
    }
    return dfs(0);
};


class DictNode {
    constructor() {
        this.next = new Map();
        this.isWord = new Set();
    }
}

class Dict {
    root;
    constructor() {
        this.root = new DictNode();
    }
    addWord(word) {
        let node = this.root;
        for(let i=0;i<word.length;i++) {
            const ch = word[i];
            if(!node.next.has(ch)) {
                node.next.set(ch, new DictNode());
            }
            if(i === word.length -1) {
                node.isWord.add(ch);
            }
            node = node.next.get(ch);
        }
    }

    findWords(word, j) {
        // find all matching words starting from index i for `word`
        let node = this.root;
        const sizes = [];
        for(let i=j;i<word.length && node;i++) {
            const ch = word[i];
            if(node.isWord.has(ch)) {
                sizes.push(i-j + 1);
            }
            if(!node.next.has(ch)) {
                break;
            } else {
                node = node.next.get(ch);
            }
        }
        return sizes;
    }
}

// solution #2
// (non optimal) too slow, takes up too much memory and time to complete
function wordBreakBfs(s, wordDict) {
    const dict = new Dict();
    for(let word of wordDict) {
        dict.addWord(word);
    }
    let indices = [0];
    while(indices.length) {
        let nextIndices = [];
        for(let index of indices) {
            const sizes = dict.findWords(s, index);
            console.log({ length: sizes.length });
            for(let size of sizes) {
                const newIndex = index + size;
                if(newIndex === s.length) {
                    return true;
                }
                if(newIndex < s.length) {
                    nextIndices.push(newIndex);
                }
            }
        }
        indices = nextIndices;
    }
    return false;
}


assert(wordBreak("leetcode", ["leet","code"]));
assert(wordBreak("applepenapple",["apple","pen"]));
assert(!wordBreak("catsandog", ["cats","dog","sand","and","cat"]));
assert(wordBreak("ab", ["a","b"]));

// wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]);
