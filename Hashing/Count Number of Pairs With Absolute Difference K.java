class Solution {
    public long pairDifference(int []A, int n, int k) {
       // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : A){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        long count = 0;
        if(k == 0){
            for(int key : map.keySet()){
                if(map.get(key) > 1){
                    count++;
                }
            }
        }else{
            for(int key : map.keySet()){
                if(map.containsKey(key + k)){
                    count++;
                }
            }
        }
        return count;
    }
}
