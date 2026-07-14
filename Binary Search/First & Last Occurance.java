class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lowerBound = LowerBound(nums, target);
        int upperBound = UpperBound(nums, target);
        return new int[] {lowerBound, upperBound};
    }
    public static int LowerBound(int[] arr, int target){
        int ans = -1;
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                ans = mid;
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public static int UpperBound(int[] arr, int target){
        int ans = -1;
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] == target){
                ans = mid;
                left = mid + 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
}
