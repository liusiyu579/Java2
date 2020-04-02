package word6;

import java.util.Scanner;


public class MinMun {
    public static int func(int a,int b){
        int tmp = 0;
        if(a<b){
            tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0){
            tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println((a*b)/func(a,b));
        }
    }
}
