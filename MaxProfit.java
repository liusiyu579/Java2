public class MaxProfit {
    // 买卖股票的最佳时机（1）
    // k == 1
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        // int[][] a = new int[n][2];
        int a_0 = 0;
        int a_1 = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            // if(i == 0){
            //     a[i][0] = 0;
            //     a[i][1] = -prices[i];
            //     continue;
            // }
            // a[i][0] = Math.max(a[i-1][0],a[i-1][1]+prices[i]);
            a_0 = Math.max(a_0,a_1+prices[i]);
            // a[i][1] = Math.max(a[i-1][1],-prices[i]);
            a_1 = Math.max(a_1,-prices[i]);
        }
        return a_0;
    }

    // 买卖股票的最佳时机（2）
    // k == 无穷大
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int a_0 = 0;
        int a_1 = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            int tmp = a_0;
            a_0 = Math.max(a_0,a_1+prices[i]);
            a_1 = Math.max(a_1,tmp-prices[i]);
        }
        return a_0;
    }

    // 买卖股票的最佳时机（3）
    // k == 2
    public static int maxProfit3(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int k = 2;
        int[][][] a = new int[n][k+1][2];
        for(int i = 0;i<n;i++){
            for(int j = k;j >0;j--){
                if(i == 0){
                    a[i][j][0] = 0;
                    a[i][j][1] = -prices[i];
                    continue;
                }
                a[i][j][0] = Math.max(a[i-1][j][0],a[i-1][j][1]+prices[i]);
                a[i][j][1] = Math.max(a[i-1][j][1],a[i-1][j-1][0]-prices[i]);
            }
        }
        return a[n-1][k][0];
    }

    // 买卖股票的最佳时机（4）
    // k == 正整数
    public static int maxProfit4(int k, int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int n = prices.length;
        if(k > n/2){
            return greedy(prices);
        }
        int[][][] a = new int[n][k+1][2];
        for(int i = 0;i<n;i++){
            for(int j = k;j >0;j--){
                if(i == 0){
                    a[i][j][0] = 0;
                    a[i][j][1] = -prices[i];
                    continue;
                }
                a[i][j][0] = Math.max(a[i-1][j][0],a[i-1][j][1]+prices[i]);
                a[i][j][1] = Math.max(a[i-1][j][1],a[i-1][j-1][0]-prices[i]);
            }
        }
        return a[n-1][k][0];
    }
    public static int greedy(int[] prices){
        int n = prices.length;
        int a_0 = 0;
        int a_1 = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++){
            int tmp = a_0;
            a_0 = Math.max(a_0,a_1+prices[i]);
            a_1 = Math.max(a_1,tmp-prices[i]);
        }
        return a_0;
    }

    // 买卖股票的最佳时机（5）
    // 含手续费
    public static int maxProfit5(int[] prices, int fee) {
        int n = prices.length;
        int a_0 = 0;
        int a_1 = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int tmp = a_0;
            a_0 = Math.max(a_0,a_1+prices[i]);
            a_1 = Math.max(a_1,tmp-prices[i]-fee);
        }
        return a_0;
    }

    // 买卖股票的最佳时机（6）
    // 有冷冻期
    // 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)
    public static int maxProfit6(int[] prices) {
        int n = prices.length;
        int a_0 = 0;
        int a_1 = Integer.MIN_VALUE;
        int a_pre = 0;
        for(int i = 0;i<n;i++){
            int tmp = a_0;
            a_0 = Math.max(a_0,a_1+prices[i]);
            a_1 = Math.max(a_1,a_pre-prices[i]);
            a_pre = tmp;
        }
        return a_0;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int k = 1020000;
        int fee = 2;

        int n = maxProfit(prices);
        System.out.println(n);
        int n2 = maxProfit2(prices);
        System.out.println(n2);
        int n3 = maxProfit3(prices);
        System.out.println(n3);
        int n4 = maxProfit4(k,prices);
        System.out.println(n4);
        int n5 = maxProfit5(prices,fee);
        System.out.println(n5);
        int n6 = maxProfit6(prices);
        System.out.println(n6);
    }
}
