package bitmanipulation;

import java.util.HashMap;

/**
 * Created by ziljin on 01/11/2017.
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        int rst = 0;

        for(int i=0; i<32; i++) {
            for(int j=0; j<nums.length; j++) {
                bit[i] += (nums[j] >> i) & 1;
                bit[i] %= 3;
            }

            rst |= (bit[i] << i);
        }
        return rst;
    }

    public int singleNumber2(int[] nums) {
        int rst = 0;
        for(int i=0; i<32; i++) {
            int sum = 0;
            for(int j=0;j<nums.length; j++) {
                sum += (nums[j]>>i) & 1;
            }
            rst += (sum%=3) << i;
        }
        return rst;
    }

    public int singleNumber3(int[] nums) {
        int one = 0, two = 0, three = 0;
        for(int i=0; i<nums.length; i++) {
            two |= one&nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }

    public int singleNumber4(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
        }
        return b;
    }

    public static void main(String args[]) {
        int[] nums = {1,1,1,2,2,2,3,3,3,4};
        System.out.println(new SingleNumber2().singleNumber4(nums));
        System.out.println(~0);
        new HashMap<String, String>();
    }
}
