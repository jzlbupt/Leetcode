package bitmanipulation;

/**
 * Created by ziljin on 02/11/2017.
 */

/**
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rst = 0;
        for(int i=0; i<32; i++) {
            rst = (rst << 1)|(n&1);
            n = n>>1;
        }
        return rst;
    }

    public static void main(String args[]) {
        int n = 43261596;
        System.out.println(new ReverseBits().reverseBits(n));
    }
}
