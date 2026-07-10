class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            list.add(pascalsRow(i));
        }
        return list;
    }
    public List<Integer> pascalsRow(int row){
        List<Integer> result = new ArrayList<>();
        int res = 1;
        result.add(res);
        for(int i=1; i<row; i++){
            res = res*(row-i);
            res = res/i;
            result.add(res);
        }
        return result;
    }
}
