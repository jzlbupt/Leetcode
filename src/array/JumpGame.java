package array;

/**
 * Created by JZL on 17/4/11.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null) return false;
        if(nums.length == 1) return true;
        int i=0, j=0, range = 0;
        while(i < nums.length && j <= range) {
            if(range == nums.length - 1) return true;
            if(nums[i] > 0) {
                i = i + nums[i];
                range = Math.max(i, range);
            }else if(++j <= range){
                i = j;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean canJump2(int[] nums) {
        if(nums.length == 0) return true;
        int remain = nums.length -1;
        for(int i=nums.length -1; i>0 ;i--) {
            if( i + nums[i] >= remain) {
                remain = i;
            }
        }
        return remain == 0 ;

    }
    public static void main(String args[]) {
        int[] nums = {2, 0, 0};
        System.out.println(new JumpGame().canJump(nums));
    }
}
