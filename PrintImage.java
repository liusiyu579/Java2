
import java.util.Scanner;

public class PrintImage {
    public static void printImage(int n,String s){
	    // 用四舍五入法求列数
        int k = (int)Math.round(n*0.5)-1;
        while(k >=0){
            if(k == 0 || k == Math.round(n*0.5)-1) {
                for (int i = 0; i < n; i++) {
                    System.out.print(s);
                }
                System.out.println();
                k--;
            }
            for (int i = k ; i > 0; i--) {
                for (int j = 0; j < 2; j++) {
                    System.out.print(s);
                    for (int l = 0; l < n-2; l++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
                k--;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        printImage(n,s);
    }
}
