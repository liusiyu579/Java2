import java.util.HashSet;
import java.util.Set;

public class OneNum {
    public static int singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(!s.add(nums[i])){
                s.remove(nums[i]);
            }
        }
        return (int)s.toArray()[0];
    }
    public static int singleNumber2(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,2,1};
        System.out.println(singleNumber(a));
        System.out.println(singleNumber2(a));
    }
}
