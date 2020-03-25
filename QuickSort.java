package word8;

import java.util.Arrays;
public class QuickSort {
    public static void quickSort(int[] a){
        quickSort(a,0,a.length);
    }
    private static void quickSort(int[] a,int left,int right) {
        if(left < right){
            // 基准值分左右
            int div = partition(a,left,right);
            // 递归进行[left , div)
            quickSort(a,left,div);
            // 递归进行[div+1 ， right)
            quickSort(a,div+1,right);
        }
    }
    private static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    private static int partition(int[] a,int left,int right){
        int part = a[right-1];
        int i = left;
        int j = right-1;
        while(i<j){
            while (i<j && part >= a[i]){
                i++;
            }
            while (i<j && part <= a[j]){
                j--;
            }
            swap(a,i,j);
        }
        swap(a,i,right-1);
        return i;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,6,8,9,4,1,3,5,7,0};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
