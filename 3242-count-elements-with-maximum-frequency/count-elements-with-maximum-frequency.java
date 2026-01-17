class Solution {
    public int maxFrequencyElements(int[] nums) {

        //i... 
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for(int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        int cnt = 0;
        for(int freq : map.values()) {
            if(maxFreq == freq) {
                cnt++;
            }
        }

        return cnt * maxFreq;



        //ii... for all types but not for this que
        // i had write for both min/max freq...
        // int n = nums.length;

        // HashMap<Integer, Integer> map = new HashMap<>();

        // //count frequencies
        // for(int i = 0; i < nums.length; i++) {
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }

        // int maxFreq = 0, minFreq = n;
        // int maxElm = 0, minElm = 0;     

        // for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int elm = entry.getKey();
        //     int cnt = entry.getValue();

        //     if(cnt > maxFreq) {
        //         maxFreq = cnt;
        //         maxElm = elm;
        //     }

        //     if(cnt < minFreq) {
        //         minFreq = cnt;
        //         minElm = elm;
        //     }
        // }   

        // return maxFreq;

        //iii.. dont refer this one...

        // int[] freq = new int[101];  // since 1 <= nums[i] <= 100
        // int maxFreq = 0;
        
        // // Count frequency of each number
        // for (int num : nums) {
        //     freq[num]++;
        //     maxFreq = Math.max(maxFreq, freq[num]);
        // }
        
        // // Count total elements that have frequency == maxFreq
        // int result = 0;
        // for (int f : freq) {
        //     if (f == maxFreq) {
        //         result += f;
        //     }
        // }
        
        // return result;
    }
}
