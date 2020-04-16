
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PukePush {
    public static void swap(List<Integer> a) {
        int len = a.size();
        int mid = len >> 1;
        List<Integer> a2 = new ArrayList<>(mid);
        List<Integer> a3 = new ArrayList<>(mid);
        for (int i = 0; i < mid; i++) {
            a2.add(a.get(i));
            a3.add(a.get(i+mid));
        }
        int i = 0;
        while (i < a.size()) {
            for (int j = 0; j < mid; j++) {
                a.set(i,a2.get(j));
                i++;
                a.set(i,a3.get(j));
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            List<List<Integer>> list = new ArrayList<>(T);
            for (int i = 0; i < T; i++) {
                String s1 = sc.next();
                String s2 = sc.next();
                int n = Integer.valueOf(s1);
                String[] s3 = new String[2 * n];
                for (int j = 0; j < s3.length; j++) {
                    s3[j] = sc.next();
                }
                int k = Integer.valueOf(s2);
                List<Integer> a = new ArrayList<>();
                for (int j = 0; j < 2 * n; j++) {
                    a.add(Integer.valueOf(s3[j]));
                }
                while (k > 0) {
                    swap(a);
                    k--;
                }
                list.add(a);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    System.out.print(list.get(i).get(j) + " ");
                }
                System.out.println();
            }
            for (int i = 0; i < list.get(list.size() - 1).size() - 1; i++) {
                System.out.print(list.get(list.size() - 1).get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1).get(list.get(list.size() - 1).size() - 1));
        }
    }
}
