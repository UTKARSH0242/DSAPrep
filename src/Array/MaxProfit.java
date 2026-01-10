package array;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minPrice) {
//                minPrice = prices[i];
//            } else if (prices[i] - minPrice > maxProfit) {
//                maxProfit = prices[i] - minPrice;
//            }
//        }
//        return maxProfit;
        int minPrice = prices[0];
        int maxProfit = 0;
        int n = prices.length;
        for(int i = 1; i < n; i++) {
            int costPrice = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, costPrice);
            minPrice = Math.max(minPrice,prices[i]);
        }
        return maxProfit;
    }
}
