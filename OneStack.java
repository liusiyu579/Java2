import java.util.Scanner;

public class OneStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int left = -1,right = -1;
                int tmp = a[i];
                for (int j = i; j >= 0; j--) {
                    if(tmp > a[j]){
                        left = j;
                        break;
                    }
                }
                for (int j = i; j < n; j++) {
                    if(tmp > a[j]){
                        right = j;
                        break;
                    }
                }
                System.out.println(left+" "+right);
            }
        }
    }
}
