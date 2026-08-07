public class Solution{
  public static boolean isPalindrome(int[] arr, int n) {
           return checkPalindrome(arr,0,n-1);
    }
    public static boolean checkPalindrome(int[] arr, int start, int end){
        if(start >= end) return true;
        if(arr[start] != arr[end]) return false;
        return checkPalindrome(arr,start+1,end-1);
    }
}
