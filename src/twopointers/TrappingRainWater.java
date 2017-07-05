package twopointers;

/**
 * Created by ziljin on 05/07/2017.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 * See more details on: https://leetcode.com/problems/trapping-rain-water/#/description
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length -1;
        int rst = 0;
        // find left and right edge that can hold water
        while(left<right && height[left] < height[left+1]) left ++;
        while(left< right && height[right] < height[right-1]) right --;

        while(left < right) {
            int leftMax = height[left], rightMax = height[right];
            if(leftMax < rightMax){
                // add water until an edge larger than the left edge
                while(left < right && leftMax > height[++left]){
                    rst += leftMax - height[left];
                }
            } else {
                // add water until an edge larger than the right edge
                while (left < right && rightMax > height[--right]) {
                    rst += rightMax - height[right];
                }
            }
        }
        return rst;
    }
    // find peak elements first . It tunrs out this idea is a wrong solution ...
//    public int trap(int[] height) {
//        if(height == null || height.length<3 ) return 0;
//        int rst = 0, tmp =0;
//        List<Integer> index = new ArrayList<Integer>(); // to store peak elements' index
//        if(height[0] > height[1]) index.add(0);
//        for(int i=1; i<height.length-1; i++){
//            if(height[i] >= height[i-1] && height[i] >= height[i+1]) {
//                index.add(i);
//            }
//        }
//        if(height[height.length-1] > height[height.length-2]) index.add(height.length-1);
//        for(int i=0;i<index.size()-1;i++){
//            int tmpHeight = Math.min(height[index.get(i)], height[index.get(i+1)]);
//            for(int j=index.get(i)+1; j<index.get(i+1); j++){
//                rst += tmpHeight-height[j] > 0 ? tmpHeight-height[j] : 0;
//            }
//        }
//        return rst;
//    }

    // wrong idea: find min elements and peak elements around it.
//    public int trap(int[] height) {
//        if(height == null || height.length<3 ) return 0;
//        int rst = 0;
//        int tmp = 0;
//        int i=1;
//        while(i<height.length-1) {
//            if(i<height.length-1 && height[i-1] >= height [i] && height[i] <= height[i+1]){
//                int j=i-1, k=i+1;
//                int h_j = 0, h_k = 0;
//                while(j>=0 && height[j] >= height[j+1]) {
//                    h_j = height[j];
//                    j--;
//                }
//                while(k<height.length && height[k] >= height[k-1]){
//                    h_k = height[k];
//                    k++;
//                }
//                tmp = Math.min(h_j, h_k);
//                for(int s=j+2; s<k-1; s++){
//                    rst += tmp-height[s] > 0 ? tmp-height[s] : 0;
//                }
//                i=k;
//            }else{
//                i++;
//            }
//        }
//        return rst;
//    }
    public static void main(String args[] ) {
        int[] height = {5,2,1,2,1,5};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
