class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
            else if(nums[i] == candidate){
                count ++;
            }else{
                count --;
            }
        }
        int verifycount = 0;
        for(int num : nums){
            if(num == candidate){
                verifycount ++;
            }
        }
        return (verifycount > n/2) ? candidate : -1;
    }
}
