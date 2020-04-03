package word6;

import java.util.Scanner;


public class Sweet {
    public static void main(String[] args) {
        int a,b,c,d;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        double m,n,f;
        m = (a+c)>>1;
        n = (c-a)>>1;
        f = (d-b)>>1;
        if(m-((a+c)>>1) == 0 && n-((c-a)>>1) == 0 || n !=((b+d)>>1) && f-((d-b)>>1) == 0){
            System.out.println((int)m + " " + (int)n + " " + (int)f);
        }
    }
}
