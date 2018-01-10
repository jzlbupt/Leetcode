package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ziljin on 19/11/2017.
 */
public class InsertionSort {
    public void insertionSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int key = nums[i];
            int j=i-1;
            while(j>=0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = key;

        }
    }
    public static void main(String args[]) {
        int[] num = {3,2,1,4,5};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Integer[] nn = new Integer[2];
        list.toArray(nn);
        new InsertionSort().insertionSort(num);
        System.out.println();
    }
}
