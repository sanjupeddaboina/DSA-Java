class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(n,k,1,new ArrayList<>(),result);
        return result;
    }
    public static void combinations(int sum,int k,int last,List<Integer> temp,List<List<Integer>> result){
        if(sum == 0 && temp.size() == k){
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if(sum <= 0 || temp.size() > k){
            return;
        }
        for(int i=last; i<=9; i++){
            if(i <= sum){
                temp.add(i);
                combinations(sum-i,k,i+1,temp,result);
                temp.remove(temp.size()-1);
            }else{
                break;
            }
        }
    }
}
