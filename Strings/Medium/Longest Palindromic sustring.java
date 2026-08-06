class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            int OddLen = checkPalindrome(s,i,i);
            int EvenLen = checkPalindrome(s,i,i+1);
            int maxLen = Math.max(OddLen, EvenLen);
            if(maxLen > end - start+1){
                start = i - (maxLen - 1)/2;
                end = i + maxLen/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int checkPalindrome(String s, int left, int right){
        while(left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
