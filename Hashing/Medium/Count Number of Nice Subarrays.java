/* Count Number of Nice Subarrays:
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
*/

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if(k < 0) return 0;
        return helper(nums, k) - helper(nums,k-1);
    }
    public int helper(int[] nums, int k){
        if(k < 0) return 0;
        int i = 0, j = 0;
        int totalSubArr = 0;
        int oddCount = 0;
        while(j < nums.length){
            oddCount += nums[j] % 2;
            while(oddCount > k){
                oddCount -= nums[i] % 2;
                i++;
            }
            totalSubArr += j-i+1;
            j++;
        }
        return totalSubArr;
    }
}

/*
Example 1:
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
*/
