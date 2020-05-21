import java.util.Arrays;

public class Printer {
    public static int[] arrayPrint(int[][] arr, int n) {
        int len = n*n;
        int[] a = new int[len];
        int i = 0,j = 0,m = 0;
        while (m < len) {
            for (int k = n - 1; k >= 0; k--) {
                for (i = 0, j = k; i <= n - 1 - k && j <= n - 1; i++, j++) {
                    a[m] = arr[i][j];
                    m++;
                }
            }
            for (int k = 1; k < n; k++) {
                for (i = k, j = 0; i <= n - 1 && j <= n - 1; i++, j++) {
                    a[m] = arr[i][j];
                    m++;
                }
            }
        }
        return  a;
    }
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n = 4;
        int[] arr = arrayPrint(a,n);
        System.out.println(Arrays.toString(arr));
    }
}
