import java.util.*;

public class DNAPrint {
    // 算GC比例
    public static double numberHigh(String s){
        int n = s.length();
        double count = 0.0;
        for (int i = 0; i < n; i++) {
            String ch = s.charAt(i)+"";
            if(ch.equals("G") || ch.equals("C")){
                count++;
            }
        }
        return count/n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            int n = sc.nextInt();
            // 将GC比例值和字符串添加到TreeMap
            TreeMap<Double,String> t = new TreeMap<>();
            for (int i = s.length()-n; i > 0 ; i--) {
                String s1 = s.substring(i, i + n);
                t.put(numberHigh(s1), s1);
            }
            // 再将键值对加入栈中
            Stack<Map.Entry<Double,String>> st = new Stack<>();
            for (Map.Entry<Double,String> e:t.entrySet()) {
                st.push(e);
            }
            System.out.println(st.pop().getValue());
        }
    }
}
