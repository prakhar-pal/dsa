
var Trie = function () {
    this.data = {};
};

/** 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function (word) {
    let trie = this;
    for (let i = 0; i < word.length; i++) {
        const ch = word[i];
        if (!trie.data[ch]) {
            trie.data[ch] = new Trie();
        }
        trie = trie.data[ch];
    }
    trie['$'] = '$'; // signifies end of the word
};

/** 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function (word) {
    const result = this.searchUtil(word);
    return !!result['$'];
};

Trie.prototype.searchUtil = function (word) {
    let trie = this;
    for (let i = 0; i < word.length; i++) {
        const ch = word[i];
        if (trie.data[ch]) {
            trie = trie.data[ch];
        } else {
            return {};
        }
    }
    return trie;
}

/** 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function (prefix) {
    const result = this.searchUtil(prefix);
    return Object.keys(result).length > 0;
};

/** 
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

(() => {
    const trie = new Trie();
    trie.insert("apple");
    console.assert(trie.search("app") == false);
    console.assert(trie.startsWith("app") == true);
    trie.insert("app");
    console.assert(trie.search("app") == true);
    console.assert(trie.search("apples") == false);
    console.assert(trie.startsWith("apples") == false);
    console.assert(trie.startsWith("apple") == true);
    console.assert(trie.search("mango") == false);
    console.assert(trie.startsWith("ape") == false);
})()
