package lc.Design;

import java.util.*;

public class DE02MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assert minStack.getMin() == -3; // return -3
        minStack.pop();
        assert minStack.top() == 0;    // return 0
        assert minStack.getMin() == -2; // return -2

        MinStack minStack2 = new MinStack();
        minStack2.push(0);
        minStack2.push(1);
        minStack2.push(0);
        assert minStack2.getMin() == 0; // return -3
        minStack2.pop();
        assert minStack2.getMin() == 0; // return -2

        MinStack minStack3 = new MinStack();
        minStack3.push(46);
        minStack3.push(46);
        minStack3.push(47);
        assert minStack3.top() == 47;
        minStack3.pop();
        assert minStack3.getMin() == 46;
        minStack3.pop();
        assert minStack3.getMin() == 46;
        minStack3.pop();
        minStack3.push(47);
        assert minStack3.top() == 47;
        assert minStack3.getMin() == 47;
        minStack3.push(-48);
        assert minStack3.top() == -48;
        assert minStack3.getMin() == -48;
        minStack3.pop();
        assert minStack3.getMin() == 47;
    }
}

class MinStack {
    private List<Integer> list;
    private List<Integer> minList;
    private Integer currentMin = null;
    private HashMap<Integer, Integer> minCountMap;
    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
        minCountMap = new HashMap<>();
    }
    
    public void push(int val) {
        if(currentMin == null || val < currentMin) {
            currentMin = val;
            minList.add(currentMin);
        }
        if(val == currentMin) {
            minCountMap.put(currentMin, (minCountMap.containsKey(currentMin) ? minCountMap.get(currentMin) : 0) + 1);
        }
        list.add(val);
    }
    
    public void pop() {
        int value = list.remove(list.size()-1);
        if(value == currentMin) {
            int currentMinCount = minCountMap.get(currentMin);
            currentMinCount--;
            if(currentMinCount == 0) {
                minCountMap.remove(currentMin);
                minList.remove(minList.size()-1);
                if(minList.size() > 0) {
                    currentMin = minList.get(minList.size()-1);
                }else {
                    currentMin = null;
                }
            }else {
                minCountMap.put(currentMin, currentMinCount);
            }
        }
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return currentMin;
    }
}

