class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int temp = n;

        while(temp > 0) {
            int last = temp % 10;
            map.put(last, map.getOrDefault(last, 0) + 1);
            temp /= 10;
        }

        int score = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            score += key * val;
        }

        return score;
    }
}