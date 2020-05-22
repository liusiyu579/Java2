import java.util.Scanner;

public class AddCharToString {
    public static int loc(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] d = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            d[0][i] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            d[i][0] = 0;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1]+1;
                }else {
                    d[i][j] = Math.max(d[i-1][j],d[i][j-1]);
                }
            }
        }
        return d[m][n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = new StringBuilder(s1).reverse().toString();
            int len = loc(s1,s2);
            if(s1.length() - len <= 1){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
