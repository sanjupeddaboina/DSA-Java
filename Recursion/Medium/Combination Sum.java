class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generate(candidates,target,0,0,temp,result);
        return result;
    }
    public static void generate(int[] candidates,int target,int i,int sum, List<Integer> temp,List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        if(sum > target || i == candidates.length){
            return;
        }
        temp.add(candidates[i]);
        generate(candidates,target,i,sum+candidates[i],temp,result);
        temp.remove(temp.size()-1);
        generate(candidates,target,i+1,sum,temp,result);
    }
}
