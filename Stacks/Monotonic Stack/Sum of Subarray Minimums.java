/* Sum of Subarray Minimums:
Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. 
Since the answer may be large, return the answer modulo 109 + 7.

*/

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
      
        Deque<Integer> stack = new ArrayDeque<>();
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        int mod = 1000000007;
      
        for(int i=0; i<n; i++){
          
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
          
            if(stack.isEmpty()){
                leftMin[i] = i + 1;
            }else{
                leftMin[i] = i - stack.peek();
            }
          
            stack.push(i);
        }
      
        stack.clear();
      
        for(int j=n-1; j>=0; j--){
          
            while(!stack.isEmpty() && arr[stack.peek()] > arr[j]){
                stack.pop();
            }
          
            if(stack.isEmpty()){
                rightMin[j] = n - j;
            }else{
                rightMin[j] = stack.peek() - j;
            }
          
            stack.push(j);
        }
      
        long minSum = 0;
      
        for(int i=0; i<n; i++){
            long elementContribution = (long) arr[i] * leftMin[i] * rightMin[i];
            minSum = (minSum + elementContribution) % mod;
        }
      
        return (int) minSum;
    }
}
