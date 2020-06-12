import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PrintNumToNo2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Map<Integer,Integer> m = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                m.put(a[i],m.getOrDefault(a[i],0)+1);
            }
            int count = 0;
            for(Map.Entry<Integer,Integer> e:m.entrySet()){
                count++;
                if(count != m.size() && e.getValue()%2 != 0){
                    System.out.print(e.getKey()+" ");
                }
                if(count == m.size() && e.getValue()%2 != 0){
                    System.out.print(e.getKey());
                }
            }
        }
    }
}
