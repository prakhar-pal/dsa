// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/978/
class SolutionB8PerfectSquarePerfectSquare {
    public boolean isPerfectSquare(int num) {
        int MAX = (int)Math.sqrt(Math.pow(2,31)-1);
        int low = 1, high = Math.min(Math.max(1,num/2), MAX);
        boolean ps = false;
        while(low<=high){
            int mid = low + (high-low)/2;
            int sq = mid*mid;
            if(sq == num){
                ps = true;
                break;
            }
            else if(sq > num) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        System.out.println("low: "+low+" high: "+high);
        return ps;
    }
}

class B8PerfectSquare {
    public static void main(String[] args){
        SolutionB8PerfectSquarePerfectSquare sol = new SolutionB8PerfectSquarePerfectSquare();
        assert sol.isPerfectSquare(4) == true;
        assert sol.isPerfectSquare(1) == true;
        assert sol.isPerfectSquare(2) == false;
        assert sol.isPerfectSquare(4) == true;
        assert sol.isPerfectSquare((int)Math.pow(2,30)+1) == false;
        assert sol.isPerfectSquare(808201) == true;
    }
}
