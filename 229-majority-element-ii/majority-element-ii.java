import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1};
        int[] nums3 = {1, 2};
        int[] nums4 = {1, 2, 3, 1, 2, 1, 1};

        System.out.println("Output 1: " + sol.majorityElement(nums1));
        System.out.println("Output 2: " + sol.majorityElement(nums2));
        System.out.println("Output 3: " + sol.majorityElement(nums3));
        System.out.println("Output 4: " + sol.majorityElement(nums4));
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //using HashMap

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) { // already exists so increase freq by one
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1); // add new key with freq 1...
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > n/3) {
                ans.add(entry.getKey());
            }
        }

        return ans;




    //     int count1 = 0, count2 = 0;
    //     int candidate1 = 0, candidate2 = 0;

    //     // Step 1: Find candidates
    //     for (int num : nums) {
    //         if (num == candidate1) {
    //             count1++;
    //         } else if (num == candidate2) {
    //             count2++;
    //         } else if (count1 == 0) {
    //             candidate1 = num;
    //             count1 = 1;
    //         } else if (count2 == 0) {
    //             candidate2 = num;
    //             count2 = 1;
    //         } else {
    //             count1--;
    //             count2--;
    //         }
    //     }

    //     // Step 2: Validate the candidates
    //     count1 = 0;
    //     count2 = 0;
    //     for (int num : nums) {
    //         if (num == candidate1) count1++;
    //         else if (num == candidate2) count2++;
    //     }

    //     List<Integer> result = new ArrayList<>();
    //     int n = nums.length;
    //     if (count1 > n / 3) result.add(candidate1);
    //     if (count2 > n / 3) result.add(candidate2);

    //     return result;
    }
}
