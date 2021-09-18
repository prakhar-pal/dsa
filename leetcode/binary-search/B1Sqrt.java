class Cholution {
    private int getDigitCount(int num){
        if(num == 0) return 1;
        int count = 0;
        while(num!=0){
            count++;
            num/=10;
        }
        return count;
    }
    public int mySqrt(int x) {
        System.out.print("x:"+x);
        if(x < 2) return x;
        int left = 1, right = (int)Math.pow(10, getDigitCount(x));
        int result = -1;
        int whileCount = 0;
        while(left <= right && whileCount <=31){
            whileCount++;
            System.out.print("left:"+left+", right:"+right + "\t");
            int mid = left + (right-left)/2;
            long midSq = mid* mid;
            long rightSq = (mid*1)*(mid+1);
            // System.out.println("midSq:" + midSq + ", rightSq:" + rightSq);
            if(midSq >= x  && x < rightSq) {
                result = mid;
                break;
            }
            else {
                if(midSq < x){
                  left = mid + 1;
                }else {
                    right = mid;
                }
            }
        }
        System.out.println(" "+result);
        return result;
    }
}

class Solution {
    public int mySqrt(int x){
        if(x<2) return x;
        int left = 1, right =x;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(x/mid < mid){
                right = mid-1;
            }else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}

class B1Sqrt {
    public static void main(String[] args){
        Solution sol = new Solution();
        assert sol.mySqrt(4) == 2;
        assert sol.mySqrt(8) == 2;
        assert sol.mySqrt(9) == 3;
        assert sol.mySqrt(100) == 10;
        assert sol.mySqrt(0) == 0;
        assert sol.mySqrt(1) == 1;
        assert sol.mySqrt(2) == 1;
        assert sol.mySqrt(2147395599) == 46339;
    }
}
