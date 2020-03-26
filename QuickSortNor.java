package word8;

import java.util.Arrays;
import java.util.Stack;

public class QuickSortNor {
    public static void quickSort(int[] a){
        Stack<Integer> s = new Stack<>();
        s.push(a.length);
        s.push(0);
        while (!s.empty()) {
            int i = s.pop();
            int j = s.pop();
            if (i < j) {
                int d = partition(a, i, j);
                // [i,d)
                // [d+1,j)
                s.push(j);
                s.push(d + 1);
                s.push(d);
                s.push(i);
            }
        }
    }

    private static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int partition(int[] a,int left,int right){
        int div = a[right-1];
        int i = left;
        int j = right-1;
        while (i<j){
            while (i<j && div >= a[i]){
                i++;
            }
            while (i<j && div <= a[j]){
                j--;
            }
            swap(a,i,j);
        }
        swap(a,i,right-1);
        return i;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,6,8,9,7,4,1,3,0,5};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
