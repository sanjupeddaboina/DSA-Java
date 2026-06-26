class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        int maxCount = 0;
        while(j < n){
            if(nums[j] == 1){
                maxCount = Math.max(maxCount, j-i+1);
                j++;
            }else{
                i = j;
                i++;
                j++;
            }
        }
        return maxCount;
    }
}
