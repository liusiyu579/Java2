import java.util.Scanner;

public class FindThings {
    public static int findNum(int n){
        if (n == 1000000007){
            return 0;
        }
        int count = 0;
        // 计算一共走了多少步
        while (n != 0 && count <= 300000){
            // 4*n+3 是2次 2*n+1
            // 8*n+7 是3次 2*n+1
            n = ((n<<1)+1) % 1000000007;
            count++;
        }
        // 算出至少走多少步
        int ret = (count+2)/3;
        return ret>100000?-1:ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(findNum(n));
        }
    }
}
