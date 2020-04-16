import java.util.Map;

public class MoneyNum {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int count = 30;
        int sum = 0;
        while (count>0){
            a+=10;
            b = (int)Math.pow(2,count-1);
            sum+=b;
            count--;
        }
        System.out.println(a + " "+sum);
    }
}
