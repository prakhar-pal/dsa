package lc.Design;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import lc.utils.Clogger;

/**
 * https://leetcode.com/problems/lru-cache/
 * ["LRUCache","put","put","get","put","get","put","get","get","get"]
 * [[2],       [1,1],[2,2], [1], [3,3], [2], [4,4], [1],  [3],  [4]]
 * [null,       null, null,  1,   null,  -1,  null,  -1,   3,    4]
 */

public class DE03LRU {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == 1;
        cache.put(3, 3);
        assert cache.get(2) == -1;
        cache.put(4, 4);
        assert cache.get(1) == -1;
        assert cache.get(3) == 3;
        assert cache.get(4) == 4;
    }
}

class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int capacity = 0;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            return this.map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        this.map.put(key, value);
        if (this.map.size() > this.capacity) {
            Entry<Integer, Integer> e = this.map.firstEntry();
            this.map.remove(e.getKey());
        }
    }
}
