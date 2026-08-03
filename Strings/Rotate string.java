class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String DoubleS = s + s;
        if(DoubleS.contains(goal)){
            return true;
        }
        return false;
    }
}
