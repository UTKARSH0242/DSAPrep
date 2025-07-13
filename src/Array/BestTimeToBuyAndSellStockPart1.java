package array;

public class BestTimeToBuyAndSellStockPart1 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(prices);
        System.out.println("Maximum profit is: " + profit);
    }

//    private static int maxProfit(int[] prices) {
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minPrice) {
//                minPrice = prices[i];
//            } else if (prices[i] - minPrice > maxProfit) {
//                maxProfit = prices[i] - minPrice;
//            }
//        }
//        return maxProfit;
//    }

    private static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 1; i < n ; i++) {
            int cost = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, cost);
            minPrice = Math.min(minPrice, prices[i]);

        }
        return maxProfit;
    }

}
