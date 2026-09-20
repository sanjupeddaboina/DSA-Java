/* Reverse Degree of a String:
Given a string s, calculate its reverse degree.
The reverse degree is calculated as follows:
For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
Sum these products for all characters in the string.
Return the reverse degree of s.
*/

class Solution {
    public int reverseDegree(String s) {
        int sum = 0;

        for(int i = 0; i < s.length(); i++){
            sum += (26 - (s.charAt(i) - 'a')) * (i + 1);
        }

        return sum;
    }
}
