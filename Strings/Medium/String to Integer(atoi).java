class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0, sign = 1;
        long resultNum = 0;
        while(i < n && s.charAt(i) == ' ') i++;
        if(i == n) return 0;
        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(i) == '+'){
            i++;
        }
        while(i < n && Character.isDigit(s.charAt(i))){
            resultNum = resultNum * 10 + (s.charAt(i) - '0');
            if(sign * resultNum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * resultNum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(resultNum * sign);
    }
}
