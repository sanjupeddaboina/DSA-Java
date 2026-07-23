class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int pile : piles){
            min = Math.min(min, pile);
            max = Math.max(max, pile);
        }
        int left = 1, right = max;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            long totalHrs = 0;
            for(int i=0; i<piles.length; i++){
                totalHrs +=(long) Math.ceil((double)piles[i]/mid);
                if(totalHrs > h){
                    break;
                }
            }
            if(totalHrs <= h){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
}
