class Solution {
    public int totalFruit(int[] fruits) {

        // Method 2: Optimal O(n) & O(3)
        int left = 0, right = 0, maxLen = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        while(right < fruits.length) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            if(basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if(basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;

        // -----------------------------------------

        // //Method 1 : Brute O(n2) - TLE
        // int n = fruits.length;
        // int maxLen = 0;

        // for(int i = 0; i < n; i++) {
        //     HashMap<Integer, Integer> map = new HashMap<>(); // basket
        //     int currCnt = 0;
        //     for(int j = i; j < n; j++) {
        //         map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

        //         if(map.size() > 2) break;

        //         currCnt++;
        //     }
        //     maxLen = Math.max(currCnt, maxLen);
        // }

        // return maxLen;

        // ========================?
        //M1 : Brute force using set
        // int n = fruits.length;
        // int maxLen = 0;

        // for (int i = 0; i < n; i++) {

        //     HashSet<Integer> set = new HashSet<>();

        //     for (int j = i; j < n; j++) {

        //         set.add(fruits[j]);

        //         if (set.size() <= 2) {
        //             maxLen = Math.max(maxLen, j - i + 1);
        //         } else {
        //             break;
        //         }
        //     }
        // }

        // return maxLen;
    }
}