class Solution {
    public int maxDepth(String s) {
        int curdepth = 0;
        int maxdepth = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                curdepth++;
            }else if(s.charAt(i) == ')'){
                curdepth--;
            }
            maxdepth = Math.max(maxdepth, curdepth);
        }
        return maxdepth;
    }
}
