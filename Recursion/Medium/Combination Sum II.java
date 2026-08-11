class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generateSubsets(candidates,target,0,0,new ArrayList<>(), result);
        return result;
    }
    public static void generateSubsets(int[] candidates,int target,int i,int sum,List<Integer> temp,List<List<Integer>> result){
        if(sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target || i == candidates.length){
            return;
        }
        for(int j=i; j<candidates.length; j++){
            if(j > i && candidates[j] == candidates[j-1]){
                continue;
            }
            temp.add(candidates[j]);
            generateSubsets(candidates,target,j+1,sum + candidates[j],temp,result);
            temp.remove(temp.size()-1);
        }
    }
}
