
import java.util.Scanner;

public class ChangeDrink {
    public static int drink(int n){
        int total = 0;  // 喝的总数
        while (n > 2){
            total = n/3 + total;
            n = n/3 + n%3;
        }
        if(n == 2){
            total+=1;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(drink(n));
        }
    }
}
