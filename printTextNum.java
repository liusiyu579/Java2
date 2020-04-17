import java.util.Scanner;

public class printTextNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0){
                break;
            }
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int count = 0;
            for (int i = 0; i < a.length; i++) {
                if(a[i] == k){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
