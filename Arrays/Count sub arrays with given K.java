class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(sum,1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int pairVal = sum - k;
            if(map.containsKey(pairVal)){
                count += map.get(pairVal);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
