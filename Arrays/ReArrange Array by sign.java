class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 1;
        int[] reArrangedArr = new int[n];
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                reArrangedArr[pos] = nums[i];
                pos += 2;
            }else{
                reArrangedArr[neg] = nums[i];
                neg += 2;
            }
        }
        return reArrangedArr;
    }
}
