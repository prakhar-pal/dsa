package lc.ArraysAndStrings;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class SE02StrFind {
    public static void main(String[] args) {
        SE02Solution  sol = new SE02SolutionTwo();
        assert sol.strStr("sadbutsad", "sad") == 0;
        assert sol.strStr("ippi", "pi") == 2;
        assert sol.strStr("mississippi", "pi") == 9;
        assert sol.strStr("abdabdabc", "abc") == 6;
        assert sol.strStr("oourfathersb", "ourfathersb") == 1;
        assert sol.strStr("fourscoreandsevenyearsagoourfathersbroughtforthuponthiscontinentanewnation", "ourfathersbroughtforthuponthiscontinentanewnation") == 25;
        assert sol.strStr("aaa", "aaaa") == -1;
        assert sol.strStr("leetcode", "leeto") == -1;
    }
}

interface SE02Solution {
    public int strStr(String haystack, String needle);
}

class SE02SolutionOne implements SE02Solution {
    /** 5%ile */
    public int strStr(String haystack, String needle) {
        int index = -1;
        for(int i=0;i<haystack.length() - needle.length() + 1; i++) {
            boolean didFind = true;
            for(int j=0;j<needle.length();j++) {
                char nChar = needle.charAt(j);
                char hsChar = haystack.charAt(i + j);
                if(nChar != hsChar) { 
                    didFind = false;
                }
            }
            if(didFind) {
                return i;
            }
        }
        return index;        
    }
}

interface RabinKarpHasher {
    public int hashCode(String s);
    public int updateHash(int hash, char removed, char added, int n);
}

class RKHasherOne implements RabinKarpHasher {
    /**
     * naive hashing 
     * 29%ile
     * */
    public int hashCode(String s) {
        char[] chars = s.toCharArray();
        int hashValue = 0;
        for(char ch: chars) {
            hashValue += ch - 'a' + 1;
        }
        return hashValue;
    }
    public int updateHash(int hash, char removed, char added, int n) {
        return hash - (removed - 'a') + (added - 'a');
    }
}
class RKHasherTwo implements RabinKarpHasher {
    /** rolling hash */
    private int p = 7;
    private int m = 23;  // (int) (Math.pow(10, 9) + 9);
    private int toInt(char ch) {
        return ch - 'a' + 1;
    }
    public int hashCode(String s) {
        int value = 0;
        int pp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            value = ((value + toInt(ch) * pp % m)) % m;
            pp = pp * p % m;
        }
        return value;
    }
    public int updateHash(int hash, char removed, char added, int n) {
        // remove previous value from hash
        BigInteger re = new BigInteger(p+"").modPow(new BigInteger(n-1 + ""), new BigInteger(m + ""));
        int reInt = re.intValue();
        double doubleValue = (hash - toInt(removed) * reInt % m ) % m;
        int value = (int) (doubleValue * p % m + toInt(added)) % m;
        while(value < 0) {
            value += m;
        }
        return value;
    }
}

class SE02SolutionTwo implements SE02Solution {
    RabinKarpHasher hasher;
    public SE02SolutionTwo () {
        hasher = new RKHasherTwo();
    }
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }
        // 1. hash the needle
        int needleHash = hasher.hashCode(needle);
        // 2. find hash of the first window of haystack and store it as hash
        int haystackHash = hasher.hashCode(haystack.substring(0, needle.length()));
        // 3. until hash(1) != hash(2) and we can move the window
        if(isSameString(needleHash, haystackHash, haystack.substring(0, needle.length()), needle)) {
            return 0;
        }
        int i = 1;
        boolean foundString = false;
        for(;i < haystack.length() - needle.length() + 1;i++) {
            // 3a. update the hash
            haystackHash = hasher.updateHash(haystackHash, haystack.charAt(i-1), haystack.charAt(i + needle.length() - 1), needle.length());
            if(isSameString(needleHash, haystackHash, haystack.substring(i, i + needle.length()), needle)) {
                foundString = true;
                break;
            }
        }
        // 4. if hash(1) == hash(3a) return found index else return -1
        return !foundString ? -1 : i;
    }

    private boolean isSameString(int hash1, int hash2, String s1, String s2) {
        if(hash1 == hash2) {
            return s1.equals(s2);
        }
        return false;
    }
}
