class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n-1];
        StringBuilder res = new StringBuilder();
        for(int i=0; i<Math.min(first.length(), last.length()); i++){
            if(first.charAt(i) != last.charAt(i)){
                return res.toString();
            }
            res.append(first.charAt(i));
        }
        return res.toString();
    }
}
