package lc.BinarySearch;
// https://leetcode.com/explore/learn/card/binary-search/137/conclusion/977/

class SolutionC01LetterSearchLetterSearch {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        if(letters[0] <= target && letters[len-1] > target){
            int low = 0, high = len - 1;
            while(low<=high){
                int mid = (low+high)/2;
                if(letters[mid] > target && letters[mid-1] <= target){
                    // System.out.println(mid);
                    return letters[mid];
                }else if(letters[mid] <= target) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }else {
            return letters[0];
        }
        return '-';
    }
}

class B11LetterSearch {
    public static void main(String[] args){
        char letters1[] = {'c', 'f', 'j'};
        char target1 = 'a';

        char letters2[] = letters1;
        char target2 = 'c';

        char letters3[] = letters1;
        char target3 = 'd';

        char letters4[] = letters1;
        char target4 = 'g';

        char letters5[] = letters1;
        char target5 = 'j';

        SolutionC01LetterSearchLetterSearch sol = new SolutionC01LetterSearchLetterSearch();
        assert sol.nextGreatestLetter(letters1, target1) == 'c';
        assert sol.nextGreatestLetter(letters2, target2) == 'f';
        assert sol.nextGreatestLetter(letters3, target3) == 'f';
        assert sol.nextGreatestLetter(letters4, target4) == 'j';
        // System.out.println(sol.nextGreatestLetter(letters5, target5));
        assert sol.nextGreatestLetter(letters5, target5) == 'c';
    }
}
