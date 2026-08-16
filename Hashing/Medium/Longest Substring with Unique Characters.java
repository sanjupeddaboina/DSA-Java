/* Longest Substring with Unique Characters:
You are given a string s. Your task is to find the length of the longest substring that contains each character at most once.
A substring is a contiguous sequence of characters within a string.
*/

class Solution {
    public int longestSubstring(String s) {
        //Write your code here
        int left = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
