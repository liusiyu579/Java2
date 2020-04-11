package word6;

import java.util.Scanner;

/**
 * @ClassName Bread
 * @Description TODO
 * @Author lenovo
 * @Date 2020/4/6 16:07
 * @Version 1.0
 **/
public class Bread {
    public static void func(int[][] a,int h,int w){
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(a[i][j] == 1){
                    count++;
                    if(i+2 < h){
                        a[i+2][j] = 0;
                    }
                    if(j+2 <w){
                        a[i][j+2] = 0;
                    }
                }

            }

        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[][] a = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    a[i][j] = 1;
                }
            }
            func(a,h,w);
        }
    }
}
