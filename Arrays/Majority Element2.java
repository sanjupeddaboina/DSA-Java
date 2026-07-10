class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[i] == candidate1) {
                count1++;
            }else if(nums[i] == candidate2) {
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        int verifycount1 = 0, verifycount2 = 0;
        for(int num : nums){
            if(num == candidate1) verifycount1++;
            if(num == candidate2) verifycount2++;
        }
        if(verifycount1 > n/3){
            list.add(candidate1);
        }
        if(candidate1 != candidate2 && verifycount2 > n/3){
            list.add(candidate2);
        }
        return list;
    }
}
