class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int ans = -1;
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num, max);
        }
        int left = 1, right = max;
        while(left <= right){
            int mid = left + (right - left)/2;
            int sum = 0;
            for(int i=0; i<n; i++){
                sum += (nums[i] + mid - 1)/mid;
                if(sum > threshold) break;
            }
            if(sum <= threshold){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
