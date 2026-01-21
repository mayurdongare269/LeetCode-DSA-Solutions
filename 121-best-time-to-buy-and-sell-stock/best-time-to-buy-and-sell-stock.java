class Solution {
    public int maxProfit(int[] prices) { // other approch usiing loop but n^2
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) { // O(n)
            if(price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit;
    }
}