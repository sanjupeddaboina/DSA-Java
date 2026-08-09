public class Main{
    static void printSubsequence(String s) {
        //Write your code here
        allSubsequences(s,0,"");
    }
    public static void allSubsequences(String s, int idx, String cur){
        if(idx == s.length()){
            if(cur.length()>0) {
                System.out.print(cur+" ");
            }
            return;
        }
        allSubsequences(s,idx+1,cur+s.charAt(idx));
        allSubsequences(s,idx+1,cur);
    }
}
