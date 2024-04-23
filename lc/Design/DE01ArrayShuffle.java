package lc.Design;

import java.util.Random;

public class DE01ArrayShuffle {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5};
        DE01Solution sol = new DE01Solution(arr1);
        int[] originalArr1 = sol.reset();
        System.out.println("\nOriginal array is");
        for(int n: originalArr1) {
            System.out.print(n+"\t");
        }
        int[] shuffledArr1 = sol.shuffle();
        System.out.println("\nShuffled array is");
        for(int n: shuffledArr1) {
            System.out.print(n+"\t");
        }
        int[] resetArr1 = sol.reset();
        System.out.println("\nArray after reset is");
        for(int n: resetArr1) {
            System.out.print(n+"\t");
        }
    }
}


class DE01Solution {
    private final int[] originalArr;
    private int[] currentArr;
    private int arrLength;
    public DE01Solution(int[] nums) {
        originalArr = nums;
        copyOriginalToCurrrentArray();
        arrLength = nums.length;
    }
    
    public int[] reset() {
        copyOriginalToCurrrentArray();
        return currentArr;
    }
    
    public int[] shuffle() {
        boolean[] isIndexUsed = new boolean[arrLength];
        int addedNums = 0;
        Random random = new Random();
        currentArr = new int[arrLength];
        while(addedNums != arrLength) {
            int newIndex = random.nextInt(arrLength);
            if(isIndexUsed[newIndex]) {
                continue;
            }
            isIndexUsed[newIndex] = true;
            currentArr[addedNums] = originalArr[newIndex];
            addedNums++;
        }
        return currentArr;
    }

    private void copyOriginalToCurrrentArray() {
        currentArr = new int[arrLength];
        for(int i=0;i<arrLength;i++) {
            currentArr[i] = originalArr[i];
        }
    }
}
