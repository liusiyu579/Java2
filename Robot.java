package word9.Test;

import java.util.Scanner;
// 构建一个X*Y的网格 有一个机器人必须走格点且只能向下走或者向右走
// 由左上角开始到 右下角 一共有多少种方法
public class Robot {
    public static int countWays(int x, int y) {
        // 构建二维数组
        int[][] a = new int[x][y];
        // 初始化首行
        for (int i = 0; i < x; i++) {
            a[i][0] = 1;
        }
        // 初始化首列
        for (int j = 0; j < y; j++) {
            a[0][j] = 1;
        }
        // 从（1,1）开始进行计算
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }
        return a[x - 1][y - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(countWays(x,y));
    }
}
