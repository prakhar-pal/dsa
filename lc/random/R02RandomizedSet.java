package lc.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 * Implement the RandomizedSet class:
 
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * 
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class R02RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        assert randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assert randomizedSet.remove(2) == false; // Returns false as 2 does not exist in the set.
        assert randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        int value = randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        assert value == 1 || value == 2;
        assert randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        assert randomizedSet.insert(2) == false; // 2 was already in the set, so return false.
        assert randomizedSet.getRandom() == 2; // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}

class RandomizedSet {
    private HashSet<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }
    
    public boolean insert(int val) {
        boolean isAlreadyIncluded = this.set.contains(val);
        this.set.add(val);
        return !isAlreadyIncluded;
    }

    public boolean remove(int val) {
        boolean isAlreadyIncluded = this.set.contains(val);
        if(isAlreadyIncluded) {
            this.set.remove(val);
        }
        return isAlreadyIncluded;
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(this.set.size());
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer n: set) {
            list.add(n);
        }
        return list.get(index);
    }
}
