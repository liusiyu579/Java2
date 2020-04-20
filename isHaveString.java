import java.util.Arrays;

public class isHaveString {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(s.contains(p[i])){
                b[i] = true;
            }else {
                b[i] = false;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"a","b","c","d"};
        int n = s.length;
        String str = "abc";
        System.out.println(Arrays.toString(chkSubStr(s,n,str)));
    }
}
