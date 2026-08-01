class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(nums, 0, n-1);
            return;
        }
        for(int j=n-1; j > index; j--){
            if(nums[j] > nums[index]){
                swap(nums, j, index);
                break;
            }
        }
        reverse(nums,index+1,n-1);
    }
    static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    static void reverse(int[] nums, int first, int last){
        while(first < last){
            swap(nums,first,last);
            first++;
            last--;
        }
    }
}
