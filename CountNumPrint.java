import java.util.Scanner;

public class CountNumPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            // 输入一行数字 用字符串接收
            String s = sc.nextLine();
            // 将字符串按空格分开存入字符串数组中
            String[] s1 = s.split(" ");
            int[] a = new int[10];
            // 再将数组依次放入int数组中
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.valueOf(s1[i]);
            }
            int k = 0;
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < a.length; i++) {
                // 将找到第一个不为0的数字 作为输入的第一位
                if(a[i] != 0){
                    sb.append(i);
                    k = i;
                    break;
                }
            }
            a[k] -= 1;
            // 依次按顺序加入数字
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i]; j++) {
                    sb.append(i);
                }
            }
            System.out.println(sb);
        }
    }
}
