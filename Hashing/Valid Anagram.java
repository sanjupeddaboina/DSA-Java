/* Valid Anagram:
Given an string str1 and str2, check if they both are anagrams or not.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

class Solution {
   static boolean areAnagram(String c1, String c2) {
       //Write your code here
       int[] freq = new int[26];
       for(int i=0; i<c1.length(); i++){
        char ch = c1.charAt(i);
        freq[ch-'a']++;
       }
       for(int i=0; i<c2.length(); i++){
        char ch2 = c2.charAt(i);
        freq[ch2-'a']--;
       }
       for(int i=0; i<freq.length; i++){
        if(freq[i] != 0){
            return false;
        }
       }
       return true;
    }
}
