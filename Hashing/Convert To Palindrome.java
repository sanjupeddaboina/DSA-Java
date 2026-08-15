/* Convert To Palindrome : 
Given a string S consisting only of lowercase characters. We need to check whether it is possible
to make this string a palindrome after removing exactly one character from this.
If it is possible then print 1 else return 0.*/

class Solution{
    public static int solve(String A) {
        //Write code here and print output
        int i=0, j=A.length()-1;
        int misMatch = 0;
        while(i < j){
            if(A.charAt(i) != A.charAt(j)){
                misMatch++;
                if(misMatch > 1){
                    return 0;
                }
                i++;
                j--;
            }else{
                i++;
                j--;
            }
        }
        return 1;
    }
}
