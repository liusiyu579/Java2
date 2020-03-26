package word8;

import java.util.Arrays;


public class QuickSortOpt {
    public static void quickSort(int[] a){
        quickSort(a,0,a.length);
    }

    public static void insertSort(int[] a,int left , int right){
        for (int i = left+1; i < right; i++) {
            int num = a[i];
            int end = i-1;
            while(end >= 0 && num < a[end]){
                a[end+1] = a[end];
                end--;
            }
            a[end+1] = num;
        }
    }
    private static void quickSort(int[] a,int left,int right) {
        if(right - left < 16){
            insertSort(a,left,right);
        } else{
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

    private static int getMiddle(int[] a,int left,int right){
        int mid = left+((right-left)>>1);
        if(a[left] < a[right-1]){
            if(a[left] > a[mid]){
                return left;
            }else {
                if(a[right-1] < a[mid]){
                    return right-1;
                }else{
                    return mid;
                }
            }
        }else{
            if(a[right-1] > a[mid]){
                return right-1;
            }else {
                if(a[left] < a[mid]){
                    return left;
                }else {
                    return mid;
                }
            }
        }
    }

    private static int partition(int[] a,int left,int right){
        int mid = getMiddle(a,left,right);
        swap(a,mid,right-1);
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
