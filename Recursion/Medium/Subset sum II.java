class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subSets(nums,0,new ArrayList<>(),result);
        return result;
    }
    public static void subSets(int[] nums,int i,List<Integer> temp,List<List<Integer>> result){
        result.add(new ArrayList<Integer>(temp));
        for(int j=i; j<nums.length; j++){
            if(j > i && nums[j] == nums[j-1]){
                continue;
            }
            temp.add(nums[j]);
            subSets(nums,j+1,temp,result);
            temp.remove(temp.size()-1);
        }
    }
}
