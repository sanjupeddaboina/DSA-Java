/* Sliding window maximum : 
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
      
        for(int i=0; i<n; i++){
            // maintaining valid window size (K - size)
            while(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            // removing the peek value if it smaller than curr element
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            // Inserting index values into stack
            dq.offer(i);
            // checking valid window and updating maximum value at each position
            if(i >= k-1){
                ans[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}
