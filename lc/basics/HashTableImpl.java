package basics;

import java.util.*;

public class HashTableImpl {
    class  HashTable {
        /** implements HashTable as an array of LinkedList */
        int bucketSize = 31;
        ArrayList<LinkedList<Integer[]>> buckets;
        public HashTable() {
            buckets = new ArrayList<>(bucketSize);
            for(int i=0;i<bucketSize;i++) {
                buckets.add(new LinkedList<>());
            }
        }
        public void put(int key, int value) {
            int index = hash(key);
            LinkedList<Integer[]> list = buckets.get(index) == null ? new LinkedList<>() : buckets.get(index);
            if(this.containsKey(key)) {
                int foundIndex = this.findIndex(key);
                list.set(foundIndex, new Integer[]{key, value});
            }else {
                list.add(new Integer[] {key, value});
            }
        }
        public void remove(int key) {
            int index = hash(key);
            if(buckets.get(index) == null) {
                return;
            }
            LinkedList<Integer[]> list = buckets.get(index);
            int foundIndex = -1;
            for(int i=0;i<list.size();i++) {
                if(list.get(i)[0] == key) {
                    foundIndex = i;
                    break;
                }
            }
            if(foundIndex!=-1) {
                list.remove(foundIndex);
            }
        }

        public boolean containsKey(int key) {
            int index = hash(key);
            if(buckets.get(index) == null) {
                return false;
            }
            LinkedList<Integer[]> list = buckets.get(index);
            int foundIndex = -1;
            for(int i=0;i<list.size();i++) {
                if(list.get(i)[0] == key) {
                    foundIndex = i;
                    break;
                }
            }
            return foundIndex != -1;
        }

        public Set<Integer> getKeys() {
            Set<Integer> keysSet = new HashSet<>();
            for(int i=0;i<bucketSize;i++) {
                LinkedList<Integer[]> list = buckets.get(i);
                for(Integer[] p: list) {
                    keysSet.add(p[0]);
                }
            }
            return keysSet;
        }
        
        public Set<Integer> getValues() {
            Set<Integer> valuesSet = new HashSet<>();
            for(int i=0;i<bucketSize;i++) {
                LinkedList<Integer[]> list = buckets.get(i);
                for(Integer[] p: list) {
                    valuesSet.add(p[1]);
                }
            }
            return valuesSet;
        }

        public int getValue(int key) {
            int index = hash(key);
            List<Integer[]> list = buckets.get(index);
            for(Integer[] kv: list) {
                if(kv[0] == key) {
                    return kv[1];
                }
            }
            throw new Error("Key Found");
        }

        private int hash(int k) {
            return k % bucketSize;
        }
        private int findIndex(int key) {
            int index = hash(key);
            int foundIndex = -1;
            if(buckets.get(index) != null) {
                LinkedList<Integer[]> list = buckets.get(index);
                for(int i=0;i<list.size();i++) {
                    if(list.get(i)[0] == key) {
                        foundIndex = i;
                        break;
                    }
                }
            }
            return foundIndex;
        }
    }

    public static void main(String[] args) {
        HashTableImpl hti = new HashTableImpl();
        HashTable hashTable = hti.new HashTable();

        hashTable.put(1, 1);
        hashTable.put(2, 2);
        hashTable.put(3, 3);
        
        // keys assertions
        assert hashTable.getKeys().size() == 3;
        hashTable.put(3, 33);
        assert hashTable.getKeys().size() == 3;
        hashTable.remove(3);
        assert hashTable.getKeys().size() == 2;
        Set<Integer> expectedKeys = new HashSet<>();
        expectedKeys.addAll(List.of(1,2));
        Set<Integer> actualKeys = hashTable.getKeys();
        assert actualKeys.equals(expectedKeys);
        hashTable.put(4, 4);
        expectedKeys.add(4);
        Set<Integer> actualKey2 = hashTable.getKeys();
        assert actualKey2.equals(expectedKeys);

        // get/set assertions
        HashTable ht2 = hti.new HashTable();
        ht2.put(1, 1);
        ht2.put(2, 2);
        ht2.put(3, 3);
        assert ht2.getValue(1) == 1;
        assert ht2.getValue(2) == 2;
        assert ht2.getValue(3) == 3;
        assert ht2.getValue(4) == 4;
    }
}
