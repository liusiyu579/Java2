import java.util.Scanner;

public class DeleteSimChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            String s2 = sc.nextLine();
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s2.length(); i++) {
                for (int j = 0; j < sb.length(); j++) {
                    if(s2.charAt(i) == sb.charAt(j)){
                        sb.deleteCharAt(j);
                    }
                }
            }
            System.out.println(sb.toString());
        }
    }
}
