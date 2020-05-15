import java.util.Scanner;

public class Calculate {

    public static int calculateMax(int[] prices){
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            int tmp = getMax(prices,0,i-1)+getMax(prices,i,prices.length-1);
            if(tmp > sum){
                sum = tmp;
            }
        }
        return sum;
    }
    public static int getMax(int[] prices,int left,int right){
        if(left == right){
            return 0;
        }
        int min = prices[left];
        int max = 0;
        for (int i = left+1; i <= right; i++) {
            if(prices[i] - min > max){
                max = prices[i] - min;
            }
            if(min > prices[i]){
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] p = new int[]{3,8,5,1,7,8};
        System.out.println(calculateMax(p) );;
    }
}
