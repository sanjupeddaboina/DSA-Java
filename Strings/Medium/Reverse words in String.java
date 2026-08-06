class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder("");
        String[] arr = s.split(" ");
        int n = arr.length;
        for(int i=n-1; i>=0; i--){
           if(!arr[i].equals("")){
                if(res.length()>0){
                    res.append(" ");
                }
                res.append(arr[i]);
           }
        }
        return res.toString();
    }
}
