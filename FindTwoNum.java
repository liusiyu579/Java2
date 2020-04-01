import java.util.Scanner;


public class FindTwoNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.valueOf(str[i]);
            }
            int count = 0;
            for (int i = 0; i < a.length-1; i++) {
                for (int j = i+1; j < a.length; j++) {
                    if(a[i] == a[j]){
                        count++;
                        if(count == a.length){
                            System.out.println(a[i]);
                        }
                    }
                }
            }
        }
    }
}
