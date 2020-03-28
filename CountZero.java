package word7;

import java.util.Scanner;
// 输入一个正整数n  求n！末尾有几个0
public class CountZero{
    public static int multiply(int n){
        if(n == 1){
            return 1;
        }
        return n*multiply(n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int a = multiply(n);
            int count = 0;
            while(a%10 == 0){
                count++;
                a = a/10;
            }
            System.out.println(count);
        }
    }
}