/* Next Greater Element-II
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        int i = 2 * n - 1;

        while(i >= 0){
            while(!st.isEmpty() && st.peek() <= nums[i % n]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i % n] = -1;
            }else{
                ans[i % n] = st.peek();
            }

            st.push(nums[i % n]);
            i--;
        }
        
        return ans;
    }
}
