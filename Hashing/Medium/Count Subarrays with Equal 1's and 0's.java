/* Count Subarrays with Equal 1's and 0's
Given an array arr of size n containing 0 and 1 only. Find the count of subarrays having equal number of 0's and 1's.
*/

class Solution {
    static int countEqualSubarray01(int arr[], int n){
        //Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
      
        map.put(sum,1);
      
        for(int num : arr){
            if(num == 0){
                sum += -1;
            }else{
                sum += 1;
            }
          
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
          
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }   
}
