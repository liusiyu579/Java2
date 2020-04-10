import java.util.Scanner;

public class GetSequeOddNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            StringBuffer sb = new StringBuffer();
            int k = n*(n-1)+1;
            sb.append(k);
            int count = n;
            while(count>1){
                sb.append("+");
                sb.append(k+=2);
                count--;
            }
            System.out.println(sb);
        }
    }
}
