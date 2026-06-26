class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || k==0) return;
        k = (k % n + n) % n;
        rotateElements(nums,0,n-k-1);
        rotateElements(nums,n-k,n-1);
        rotateElements(nums,0,n-1);
    }
    public static void rotateElements(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
