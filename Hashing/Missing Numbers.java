/* Missing Numbers:
Given two arrays of integers, find which elements in the second array are missing from the first array. 
If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. 
If that is not the case, then it is also a missing number. Return the missing numbers sorted in ascending order. 
Only include a missing number once, even if it is missing multiple times.

Note: 
If there is no element that is to be printed, print -1. */

class Solution {
    static void missingNumbers(int n, int arr[], int m, int brr[]) {
        //Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val1 : brr){
            if(map.containsKey(val1)){
                map.put(val1,map.get(val1)+1);
            }else{
                map.put(val1,1);
            }
        }
        for(int val2 : arr){
            if(map.containsKey(val2)){
                map.put(val2,map.get(val2)-1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) != 0){
                list.add(key);
            }
        }
        Collections.sort(list);
        if(list.isEmpty()){
            list.add(-1);
        }
        for(int key : list){
            System.out.print(key +" ");
        }
    }
}
