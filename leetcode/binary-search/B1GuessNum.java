class GuessGame {
    private int num;
    public GuessGame(int num){
        this.num = num;
    }
    public int guess(int x) {
        return 0;
    }
}


/**
* Forward declaration of guess API.
* @param  num   your guess
* @return 	     -1 if num is lower than the guess number
*			      1 if num is higher than the guess number
*               otherwise return 0
* int guess(int num);
*/
class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while(true){
            int mid = start + (end-start)/2;
            int result = guess(mid);
            if(result == 0){
                return mid;
            }else if(result == 1) {
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }

    }
}

class B1GuessNum {
    public static void main(String[] args){
        int n = 10, x = 6;
    }
}
