package lc.ArraysAndStrings;

public class A22ShipWithinDays {
    public static void main(String[] args) {
        A22Solution solution = new A22Solution();
        assert solution.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5) == 15;
        assert solution.shipWithinDays(new int[] {3,2,2,4,1,4}, 3) == 6;
        assert solution.shipWithinDays(new int[] {1,2,3,1,1}, 4) == 3;
    }
}

class A22Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = Integer.MIN_VALUE;
        int weightSum = 0;
        for(int w: weights) {
            maxWeight = Math.max(w, maxWeight);
            weightSum += w;
        }
        int minCapacity = maxWeight, maxCapacity = weightSum;
        while(minCapacity != maxCapacity) {
            int mid = (minCapacity + maxCapacity)/2;
            int requiredDays = getRequiredDays(weights, mid);
            if(requiredDays > days) {
                minCapacity = mid + 1;
            }else {
                maxCapacity = mid;
            }
        }
        return minCapacity;
    }
    private int getRequiredDays(int[] weights, int capacity) {
        int bucketSize = 0;
        int days = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<weights.length;i++) {
            int newBucketSize = weights[i] + bucketSize;
            if(newBucketSize > capacity) {
                bucketSize = weights[i];
                minDiff = Math.min(minDiff, newBucketSize - capacity);
                days++;
            }else if(newBucketSize == capacity) {
                bucketSize = 0;
                days++;
            }else {
                bucketSize = newBucketSize;
            }
        }
        if(bucketSize != 0) {
            days++;
        }
        return days;
    }
}
