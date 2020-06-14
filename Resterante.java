import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Resterante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine().trim();
            String[] words = str.split(" ");
            // n是一共有n张桌子
            int n = Integer.valueOf(words[0]);
            // m是一共有m批客人
            int m = Integer.valueOf(words[1]);
            // table放的是每张桌子能坐的最多人数
            int[] table = new int[n];
            str = sc.nextLine().trim();
            String[] words1 = str.split(" ");
            for (int i = 0; i < words1.length; i++) {
                table[i] = Integer.valueOf(words1[i]);
            }
            // 将桌子人数排序
            Arrays.sort(table);
            // lists中放的是客人
            List<List<Integer>> lists = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                // tmp是客人的数量和钱数
                List<Integer> tmp = new LinkedList<>();
                for (int j = 0; j < 2; j++) {
                    tmp.add(sc.nextInt());
                }
                lists.add(tmp);
            }
            // 记录总营业额
            int count = 0;
            for (int i = 0; i < table.length; i++) {
                // 标记哪个客人吃
                int aaa = -1;
                // 标记第i张桌子有没有人
                // true是可以坐人
                // false是不可以
                boolean mark = true;
                for (int j = 0; j < lists.size(); j++) {
                    if(mark && lists.get(j).get(0) <= table[i]){
                        aaa = j;
                        mark = false;
                    // 如果第i张桌子已经坐人了 但是下一个付的饭钱多  就让下一个人坐
                    }else if(lists.get(j).get(0) <= table[i] && lists.get(j).get(0) > lists.get(aaa).get(1)){
                        aaa = j;
                    }
                }
                // 如果这个桌子有人 就算营业额
                if(aaa != -1){
                    List<Integer> temp = lists.get(aaa);
                    lists.remove(aaa);
                    count+=temp.get(1);
                }
            }
            System.out.println(count);
        }
    }
}
