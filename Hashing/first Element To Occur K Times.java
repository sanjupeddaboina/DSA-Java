/* first Element To Occur K Times:
Given an array of 'n' integers. Print the first element that occurs k number of times. 
If there is no element that occurs for at least k number of times print -1.*/

class Solution {
    public void firstElementToOccurKTimes(int[] nums, int n, int k) {
        // Your code here
        if(k == 1){
            System.out.println(nums[0]);
            return;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num) == k){
                ans = num;
                break;
            }
        }
        System.out.println(ans);
    }
}
