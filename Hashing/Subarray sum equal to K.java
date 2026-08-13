class Solution{
        static int SubArrSum(int N, int[] Arr, int K){
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(sum,1);
        for(int i=0; i<Arr.length; i++){
            sum += Arr[i];
            int pair = sum - K;
            if(map.containsKey(pair)){
                count += map.get(pair);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
