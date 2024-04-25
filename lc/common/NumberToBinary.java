package lc.common;

public class NumberToBinary {
    int[] powerOfTwos;
    int MAX_BITS = 31;
    public NumberToBinary() {
        powerOfTwos = new int[MAX_BITS+1];
        for(int i=0;i<MAX_BITS;i++) {
            powerOfTwos[i] = (int)Math.pow(2, i);
        }
    }
    public int[] convert(int n) {
        int[] bits = new int[MAX_BITS];
        for(int i=MAX_BITS-1;i>=0;i--) {
            if(powerOfTwos[i]<=n) {
                n -= powerOfTwos[i];
                bits[i] = 1;
            }
        }
        return bits;
    }
}
