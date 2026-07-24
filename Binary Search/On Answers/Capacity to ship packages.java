class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int num : weights){
            sum += num;
            max = Math.max(max,num);
        }
        int ans = -1;
        int left = max, right = sum;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(Solver(weights,mid) <= days){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public int Solver(int[] weights, int mid){
        int totalDays = 1;
        int totalWeight = 0;
        for(int i=0; i<weights.length; i++){
            if(weights[i] + totalWeight > mid){
                totalDays += 1;
                totalWeight = weights[i];
            }else{
                totalWeight += weights[i];
            }
        }
        return totalDays;
    }
}
