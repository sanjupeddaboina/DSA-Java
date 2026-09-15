/* Find all Anagrams in a string: Given two strings s and p, return an array of all the start indices of p's anagrams in s. 
You may return the answer in any order.
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()){
            return ans;
        }
        // pre-inserting target Anagram characters with freq
        int[] pFreq = new int[26];
        // current window freq of characters
        int[] sFreq = new int[26];

        for(int i = 0; i < p.length(); i++){
            pFreq[p.charAt(i) - 'a'] ++;
            sFreq[s.charAt(i) - 'a'] ++;
        }
        // checking both arrays of equal or not
        if(Arrays.equals(pFreq, sFreq)){
            ans.add(0);
        }
        
        for(int right = p.length(); right < s.length(); right++){
            // Updating incoming element freq - Increment
            sFreq[s.charAt(right) - 'a']++;
            // Reducing first inserted char freq to keep the fixed window size - Decrement
            sFreq[s.charAt(right - p.length()) - 'a']--;

            if(Arrays.equals(pFreq, sFreq)){
                ans.add(right - p.length() + 1);
            }
        }

        return ans;
    }
}

/*
Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/
