package lc.random;

/**
 * https://leetcode.com/problems/add-binary/description/
 */
public class R18AddBinaryStr {
    public static void main(String[] args) {
        R18Solution solution = new R18Solution();
        assert solution.addBinary("11", "1").equals("100");
        assert solution.addBinary("1010", "1011").equals("10101");
        assert solution.addBinary("0", "1").equals("1");
        assert solution.addBinary("111", "1010").equals("10001");
    }
}

class R18Solution {
    boolean isCarrying;
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }
        char[] acs = a.toCharArray();
        char[] bcs = b.toCharArray();
        int alen = acs.length;
        int blen = bcs.length;
        this.isCarrying = false;
        StringBuffer resultBuffer  = new StringBuffer();
        for(int i = blen - 1; i >= 0 ; i--) {
            char bc = bcs[i];
            char ac = acs[alen-blen + i];
            updateBuffer(resultBuffer, ac, bc);
        }
        for(int i=alen-blen-1;i>=0;i--) {
            updateBuffer(resultBuffer, acs[i], '0');
        }
        if(isCarrying) {
            resultBuffer.append('1');
        }
        return resultBuffer.reverse().toString();
    }

    private void updateBuffer(StringBuffer stringBufffer, char ac, char bc) {
        if(ac == '0' && bc == '0') {
            if(isCarrying) {
                stringBufffer.append('1');
                isCarrying = false;
            }else {
                stringBufffer.append('0');
            }
        }else if((ac == '1' && bc == '0') || (ac == '0' && bc == '1')) {
            if(isCarrying) {
                stringBufffer.append('0');
                isCarrying = true;
            }else {
                stringBufffer.append('1');
            }
        } else if(ac == '1' && bc == '1') {
            if(isCarrying) {
                stringBufffer.append('1');
            }else {
                stringBufffer.append('0');
                isCarrying = true;
            }
        }
    }
}
