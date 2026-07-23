class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int day : bloomDay){
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        int ans = -1;
        int left = min, right = max;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(Possible(bloomDay, mid, m, k) == true){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public boolean Possible(int[] arr, int mid, int m , int k){
        int count = 0;
        int totalBokets = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= mid){
                count ++;
            }else{
                totalBokets += count / k;
                count = 0;
            }
        }
        totalBokets += count / k;
        if(totalBokets >= m){
            return true;
        }
        return false;
    }
}
