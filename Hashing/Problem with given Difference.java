/* Problem With Given Difference :
Given an one-dimensional unsorted array A containing N integers.
You are also given an integer B. Find if there exists a pair of elements in the array whose difference is B.
Print 1 if any such pair exists else print 0. */

class Solution {
    public int givenDifference(int []A, int n, int B) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();
        for(int num : A){
            if(set.contains(num + B) || set.contains(num - B)){
                return 1;
            }
            set.add(num);
        }
        return 0;
    }
}
