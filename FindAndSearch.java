import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FindAndSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            List<Person> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                Person p = new Person(sc.next(),sc.nextInt());
                list.add(p);
            }
            if(k == 0) {
                for (int i = 0; i < n - 1; i++) {
                    if (list.get(i).score < list.get(i + 1).score) {
                        swap(list, i, i + 1);
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(list.get(i));
                }
                System.out.println();
            }else if(k == 1){
                for (int i = 0; i < n-1; i++) {
                    if(list.get(i).score > list.get(i+1).score){
                        swap(list,i,i+1);
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.println(list.get(i));
                }
            }
        }
    }
    public static void swap(List<Person> list,int i,int j){
        Person p = list.get(i);
        list.set(i,list.get(j));
        list.set(j,p);
    }
}
//class Person{
//    public String name;
//    public int score;
//
//    public Person(String name, int score) {
//        this.name = name;
//        this.score = score;
//    }
//
//    @Override
//    public String toString() {
//        return name+
//                " " + score;
//    }
//}

