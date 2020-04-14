public class UnusualAdd {
    public static int add(int a,int b){
        if(b == 0){
            return a;
        }
        int n = a^b;
        int sum = (a&b)<<1;
        return add(n,sum);
    }
    public static void main(String[] args) {
        int a = 6;
        int b = 10;
        System.out.println(add(a,b));
    }
}
