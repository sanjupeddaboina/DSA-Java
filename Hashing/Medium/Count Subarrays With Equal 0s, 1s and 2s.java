/* Count Subarrays With Equal 0s, 1s and 2s:
Given an array arr of size n containing 0,1 and 2 only. Find the count of subarrays having equal number of 0's,1's and 2's.
*/

class Solution {
    static int countEqualSubarray012(int arr[], int n)
    {
        //Write your code here
        Map<String,Integer> map = new HashMap<>();
        int c0 = 0,c1 = 0, c2 = 0;
        int count = 0;
        map.put("0#0",1);
      
        for(int i=0; i<n; i++){
          
            if(arr[i] == 0) c0++;
            else if(arr[i] == 1) c1++;
            else c2++;
          
            int diff1 = c1-c0;
            int diff2 = c2-c1;
            String key = diff1+"#"+diff2;
          
            if(map.containsKey(key)){
                count += map.get(key);
            }
          
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return count;   
    }   

}
