package asked;
import java.util.*;

/**
 *  A number is considered a magic number, if the number obtained after rotating it 180 degrees is the same as the original number
 * e.g. The following are magic numbers
 * 88,
 * 181
 * The following aren't magic numbers
 * 66
 * 182
 * 9006
 */

public class A01RotatedMagicNumber {
    public static void main(String[] args) {
        RMNSolution solution = new RMNSolution();

        // part 1
        assert solution.isMagicNumber("181");
        assert solution.isMagicNumber("1");
        assert solution.isMagicNumber("88");
        assert solution.isMagicNumber("9006");
        assert !solution.isMagicNumber("66");
        assert !solution.isMagicNumber("9");
        assert !solution.isMagicNumber("182");
        assert !solution.isMagicNumber("1abc");
        assert !solution.isMagicNumber("");

        // part 2
        Set<Integer> result = solution.generateMagicNumbers(3);
        for(int r: result) {
            System.out.println(r);
        }
    }
}

class RMNSolution {
    public final HashSet<Integer> allowedNumbers;
    public RMNSolution() {
        int[] allowedNumsArr = new int[]{0,1,6,8,9};
        allowedNumbers = new HashSet<Integer>();
        for(int num: allowedNumsArr) {
            allowedNumbers.add(num);
        }
    }
    public boolean isMagicNumber(String numberStr) {
        int number = 0;
        try {
            number = Integer.parseInt(numberStr);
        } catch (Exception e) {
            return false;
        }
        int copy = number;
        int rotated = 0;
        while(copy != 0) {
            int mod = copy % 10;
            mod = mod == 6 ? 9 : mod == 9 ? 6 : mod; 
            rotated = rotated * 10 + mod;
            copy/=10;
        }
        return rotated == number;
    }
    /**
     * @apiNote generate magic numbers of size n
     * @param n - size of the magic number
     * @return Set<Integer>
     */
    public Set<Integer> generateMagicNumbers(int n) {
        Set<Integer> resultSet = new HashSet<>();
        int[] numberSlot = new int[n];
        generateMagicNumbersUtil(numberSlot, resultSet, 0);
        return resultSet;
    }

    private void generateMagicNumbersUtil(int[] numberSlot, Set<Integer> resultSet, int i) {
        if(i > numberSlot.length/2) {
            int currentNumber = 0;
            for(int slot: numberSlot) {
                currentNumber = currentNumber * 10 + slot;
            }
            resultSet.add(currentNumber);
            return;
        }
        for(int num: allowedNumbers) {
            numberSlot[i] = num;
            numberSlot[numberSlot.length - 1 - i] = num;
            generateMagicNumbersUtil(numberSlot, resultSet, i+1);
        }
    }
}
