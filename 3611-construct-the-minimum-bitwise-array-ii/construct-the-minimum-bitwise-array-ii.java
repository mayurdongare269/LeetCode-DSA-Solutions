import java.util.*; // concept clear .. code laggingg

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);

            // Even number → impossible
            if (num % 2 == 0) {
                result[i] = -1;
                continue;
            }

            boolean found = false;

            // Check bits from 0 to 31
            for (int j = 0; j < 32; j++) {
                // If j-th bit is 0
                if ((num & (1 << j)) == 0) {
                    // Flip the previous bit (j-1)
                    int x = num ^ (1 << (j - 1));
                    result[i] = x;
                    found = true;
                    break;
                }
            }

            if (!found) {
                result[i] = -1;
            }
        }

        return result;
    }
}
