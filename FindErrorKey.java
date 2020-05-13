import java.util.*;

public class FindErrorKey {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String  s1 = sc.nextLine().toUpperCase();
            String s2 = sc.nextLine().toUpperCase();
            List<Character> list = new LinkedList<>();
            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                if(!s2.contains(ch+"")){
                    if(!list.contains(ch)) {
                        list.add(ch);
                        s2+=ch+"";
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
    }
}
