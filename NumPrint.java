package word7;

import java.util.Scanner;

//
public class NumPrint {
    public static int num(int n,int i){
        int a = (int)Math.pow(10,i+1);
        return n%a/(int)Math.pow(10,i);
    }
    public static String fun(int n,int count){
        String s = new String();
        for (int i = 0; i < count; i++) {
            s+=num(n,i);
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int b = n;
            int count = 0;
            while(b != 0){
                count++;
                b/=10;
            }
            System.out.println(fun(n,count));
        }
    }
}
