
import java.util.Scanner;

public class StringNumSum {
    public static String add(String s1,String s2){
        StringBuffer sb1 = new StringBuffer(s1);
        StringBuffer sb2 = new StringBuffer(s2);
        StringBuffer ret = new StringBuffer();
		// 将 sb1 逆序
        sb1.reverse();
		// 将 sb2 逆序
        sb2.reverse();
        int lenA = sb1.length();
        int lenB = sb2.length();
        int len = 0;
		// 将两个字符串长度补相等
        if(lenA > lenB){
            len = lenA;
            int count = lenA-lenB;
            while(count-- > 0){
                sb2.append('0');
            }
        }else {
            len = lenB;
            int count = lenB-lenA;
            while(count-- > 0){
                sb1.append('0');
            }
        }
        int num = 0;
        int flg = 0;
        for (int i = 0; i < len; i++) {
			// 字符转数字 -‘0’   数字转字符 + ‘0’
            num = sb1.charAt(i) - '0' + sb2.charAt(i) -'0' +flg;
            if(num >= 10){
                flg = 1;
                num -=10;
            }else {
                flg = 0;
            }
            ret.append(num);
        }
        if(flg == 1){
            ret.append(1);
        }

        return ret.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(add(s1, s2));
        }
    }
}
