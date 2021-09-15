package 数组和字符串;

import java.util.Map;

public class leetcoad121买股票的最佳时机 {
    /*
    给定一个数组prices ，它的第i个元素prices[i]表示一支给定股票第i天的价格。
    你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
    设计一个算法来计算你所能获取的最大利润。
    返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

    示例 1：
    输入：[7,1,5,3,6,4]
    输出：5
    解释：在第2天（股票价格 = 1）的时候买入，在第5天（股票价格=6）的时候卖出，
         最大利润 = 6-1 = 5 。
         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；
         同时，你不能在买入前卖出股票。

    示例 2：
    输入：prices = [7,6,4,3,1]
    输出：0
    解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

    */

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int x = maxProfit(prices);
        System.out.println(x);
    }

    //解法1：暴力，两次遍历，会超时
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
            int ans = price(i,prices);
            max = Math.max(ans,max);
        }
        return max;
    }
    private static int price(int index,int[] prices){
        int max = 0;
        int in = prices[index];
        for(int i=index+1;i<prices.length;i++){
            int out = prices[i] - in;
            max = Math.max(out,max);
        }
        return max;
    }

    //解法2：一次遍历，求差

    public int maxProfit2(int prices[]){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else if(maxProfit < prices[i] - minPrice){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
