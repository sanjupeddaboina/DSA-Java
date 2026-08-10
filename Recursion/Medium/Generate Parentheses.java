class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        validParanthesis(n,"",0,0,res);
        return res;
    }
    public static void validParanthesis(int n,String curString,int openCount,int closeCount,List<String> res){
        if(curString.length() == 2*n){
            res.add(curString);
            return;
        }

        if(openCount < n){
            validParanthesis(n, curString + "(",openCount + 1, closeCount, res);
        }
        if(closeCount < openCount){
            validParanthesis(n, curString + ")", openCount, closeCount + 1, res);
        }
    }
}
