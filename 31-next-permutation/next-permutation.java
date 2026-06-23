class Solution {
    public void nextPermutation(int[] nums) {
        /* 3 steps..
        1. find the break point from right n-2
        2. find the bigger number  from right n - 1 and swap
        3. reverse from break idx
        */

        int n = nums.length;
        int idx = -1;
        //1. find the break point
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) { // if no break point ex: [3,2,1]
            reverse(nums, 0, n-1);
            return; // imp
        }

        //2. find the bigger number than idx
        for(int i = n - 1; i > 0; i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                break;
            }
        } 

        //3. reverse from break idx
        reverse(nums, idx+1, n-1);
    }

    public void reverse(int nums[], int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}

/*
NEXT PERMUTATION - INTUITION

Example:
1 2 7 4 3 1

Step 1: Find Break Point
--------------------------------
Traverse from right and find first index
where nums[i] < nums[i+1].

1 2 7 4 3 1
  ^
idx = 1 (value = 2)

Why?
Because the right part (7 4 3 1) is already
in decreasing order and cannot generate a
larger permutation by itself.

--------------------------------

Step 2: Find Just Greater Element
--------------------------------
Traverse from right and find first element
greater than nums[idx].

1 2 7 4 3 1
        ^
        3

Swap:

1 3 7 4 2 1

Why?
We want the smallest possible increase.

--------------------------------

Step 3: Reverse the Right Part
--------------------------------
Current array:

1 3 7 4 2 1

Reverse elements after idx.

1 3 | 7 4 2 1
      ↓
1 3 | 1 2 4 7

Result:

1 3 1 2 4 7

This is the next lexicographically
greater permutation.

--------------------------------

Special Case:
--------------------------------
If no breakpoint exists:

3 2 1

Array is already the largest permutation.

Answer:

1 2 3

(reverse entire array)

--------------------------------

Algorithm:
1. Find breakpoint from right.
2. If no breakpoint:
      reverse whole array and return.
3. Find first greater element from right.
4. Swap with breakpoint.
5. Reverse suffix after breakpoint.

Time Complexity  : O(n)
Space Complexity : O(1)
*/