class Solution {
    public int splitArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : nums){
            max = Math.max(max, num);
            sum += num;
        }
        int left = max, right = sum;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            int countSubArr = maxSumSubArrays(nums,mid);
            if(countSubArr <= k){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public int maxSumSubArrays(int[] nums, int maxSum){
        int subArray = 1, curVal = 0;
        for(int i=0; i<nums.length; i++){
            if(curVal + nums[i] <= maxSum){
                curVal += nums[i];
            }else{
                subArray ++;
                curVal = nums[i];
            }
        }
        return subArray;
    }
}
