import java.util.Scanner;

public class Cycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int z0 = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();
            double PI = Math.PI;
            double r = Math.sqrt(Math.pow(x1-x0,2)+Math.pow(y1-y0,2)+Math.pow(z1-z0,2));
            double v = 4.0/3*PI*Math.pow(r,3);
            System.out.printf("%.3f %.3f",r,v);
        }
    }
}
