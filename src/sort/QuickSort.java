package sort;

/**
 * Created by ziljin on 19/11/2017.
 */
public class QuickSort {
    public void quickSort(int[] A) {
        qsR(A, 0, A.length-1);
    }
    public void qs(int[] A, int left, int right) {
        if(left < right) {
            int pivot = A[left];
            int i = left + 1, j = right;
            while(true) {
                while(i < A.length && A[i] < pivot) i++;
                while(j >=0 && A[j] > pivot) j--;
                if(i<j) {
                    swap(A, i, j);
                }else{
                    break;
                }
            }
            swap(A, left, j);
            qs(A, left, j-1);
            qs(A, j+1, right);
        }
    }
    public void qsR(int[] A, int left ,int right) {
        if(left < right) {
            int pivot = A[right];
            int i = left, j = right -1;
            while(true) {
                while(A[i] < pivot) i++;
                while(j >=0 && A[j] > pivot) j--;
                if(i < j) {
                    swap(A, i, j);
                }else{
                    break;
                }
            }
            swap(A, i, right);
            qsR(A, left, i-1);
            qsR(A, i+1, right);
        }
    }
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private int median3(int[] A, int left, int right) {
        int center = (left + right)/2;
        if(A[center] < A[left]){
            swap(A, center, left);
        }
        if(A[left] > A[right]){
            swap(A, left, right);
        }
        if(A[center] > A[right]) {
            swap(A, center, right);
        }
        swap(A, center, right-1);
        return A[right -1];
    }
    public static final int CUTOFF = 5;
    public void qs3(int[] A, int left, int right) {
        if(left + CUTOFF <= right) {
            int pivot = median3(A, left, right);
            int i = left, j = right -1;
            while(true) {
                while(A[i] < pivot) i++;
                while(A[j] > pivot) j--;
                if(i<j){
                    swap(A, i, j);
                }else{
                    break;
                }
            }
            swap(A, i, right -1);
            qs3(A, left, i-1);
            qs3(A, i+1, right);
        }else{
            insertionSort(A, left, right);
        }
    }

    private void insertionSort(int[] A, int left, int right) {
        if(A == null || left >= right) return;
        for(int i=left +1; i<=right; i++) {
            int key = A[i];
            int j = i-1;
            while(j >= left && A[j] > key) {
                A[j+1] = A[j];
                j--;
            }
            A[j+1] = key;
        }
    }

    public static void main(String args[]){
        int[] A = {5,4,3,2,1};
        new QuickSort().insertionSort(A, 0, A.length-1);
        System.out.println();
    }
}
