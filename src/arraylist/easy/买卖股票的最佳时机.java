package arraylist.easy;

/**
 * @author huangchangjun
 * @date 2025-03-25
 */
public class 买卖股票的最佳时机 {

    /**
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
