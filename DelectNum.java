package word7;

import java.util.Scanner;


public class DelectNum {
    public static int delect(int n){
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        int i = 0;       //遍历数组
        int count = 0;   // 计数 到3时删除
        int d = -1;      // 占位
        int delectNum = 0; // 删除的数
        while(true){
            if(delectNum == n){
                return i-1;
            }
            if(i == n){
                i = 0;
            }
            if(a[i] != d) {
                count++;
            }
            if(count == 3){
                a[i] = d;
                delectNum++;
                count = 0;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(delect(n));
        }
    }
}
