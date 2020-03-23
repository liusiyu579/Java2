package word9.Test;

import java.util.Arrays;

public class CreateArrayB {
    // 计算A[0] * .....   A[n-1]  越过A[i]
    public static int mul(int[] A,int i){
        int sum = 1;
        int j =0;
        while (j < A.length){
            // 越过A[i]
            if(j == i){
                j++;
            }
            // 防止数组越界
            if(j == A.length){
                break;
            }
            sum *= A[j];
            j++;
        }
		
        return sum;
    }
    // 构建数组B
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = mul(A,i);
        }
        return B;
    }
    public static void main(String[] args) {
        int[] A = new int[]{2,5,4,1,3};
        int[] tmp = multiply(A);
        System.out.println(Arrays.toString(tmp));
    }
}
