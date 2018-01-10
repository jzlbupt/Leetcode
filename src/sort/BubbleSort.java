package sort;

/**
 * Created by ziljin on 19/11/2017.
 */
public class BubbleSort {
    public void bubbleSort(int[] num) {
        boolean flag;
        for(int i=0; i<num.length; i++) {
            flag = false;
            for(int j=num.length -1 ; j>i; j--) {
                if(num[j] < num[j-1]){
                    flag = true;
                    int tmp = num[j];
                    num[j] = num[j-1];
                    num[j-1] = tmp;
                }
            }
            if(!flag) break;
        }
    }

    public static void main(String args[]) {
        int[] num = {3,2,1,4,5};
        new BubbleSort().bubbleSort(num);
        System.out.println();
    }
}
